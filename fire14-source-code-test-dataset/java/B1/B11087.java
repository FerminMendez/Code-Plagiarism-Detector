package fixjava;

import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;

public class ParallelWorkQueue<I, O> implements Iterable<Future<O>> {

	public interface CallableFactory<I, O> {
		public Callable<O> newInstance(I input);
	}

	private ExecutorService threadPool;
	private LinkedBlockingQueue<Future<O>> workQueue;
	private Future<O> poisonPill = null;

	public ParallelWorkQueue(final int numThreads, final Iterable<I> inputs, final CallableFactory<I, O> callableFactory) {
		threadPool = Executors.newFixedThreadPool(numThreads);

		// Keep a max of (100x the number of threads) items in the work queue at a time 
		workQueue = new LinkedBlockingQueue<>(numThreads * 100);

		// Create work-producer thread
		new Thread() {
			public void run() {
				try {
					for (final I input : inputs)
						workQueue.put(threadPool.submit(callableFactory.newInstance(input)));

					// poisonPill was null until now, and null can never be put in the queue, so
					// the barrier can't be triggered. Now set poisonPill to another value that it
					// can only attain once, a NOP work unit.
					workQueue.put(poisonPill = threadPool.submit(new Callable<O>() {
						@Override
						public O call() throws Exception {
							return null;
						}
					}));

					// Shut down threads after last callable invoked
					threadPool.shutdown();

				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			};
		}.start();

	}

	@Override
	public Iterator<Future<O>> iterator() {
		return new Iterator<Future<O>>() {
			Future<O> next = null;
			boolean nextConsumed = true;

			@Override
			public boolean hasNext() {
				if (nextConsumed) {
					try {
						next = workQueue.take();
					} catch (InterruptedException e) {
						throw new RuntimeException(e);
					}
					nextConsumed = false;
				}
				// Check for poison pill
				if (next == poisonPill) {
					try {
						// Get result of poison pill Future so thread exits
						next.get();
					} catch (Exception e) {
						throw new RuntimeException(e);
					}
					return false; // at end
				} else {
					return true;
				}
			}

			@Override
			public Future<O> next() {
				if (nextConsumed)
					throw new RuntimeException("Can't call next() twice without calling hasNext()");
				nextConsumed = true;
				return next;
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}

	/**
	 * Return an Iterable<Integer> that iterates from 0 to n-1 inclusive. Can be
	 * passed into the "inputs" parameter of ParallelWorkQueue.
	 */
	public static Iterable<Integer> makeIntRangeIterable(final int n) {
		return new Iterable<Integer>() {
			private final int max = n;

			@Override
			public Iterator<Integer> iterator() {
				return new Iterator<Integer>() {
					int num = 0;

					@Override
					public boolean hasNext() {
						return num < max;
					}

					@Override
					public Integer next() {
						return num++;
					}

					@Override
					public void remove() {
						throw new UnsupportedOperationException();
					}
				};
			}
		};
	}
}

