package fixjava;

import java.util.ArrayList;
import java.util.concurrent.Callable;

/** Parallel quicksort (inefficient initially, doubles the number of threads at each pivot) */
public class ParallelQuicksort<T extends Comparable<T>> implements Callable<Void> {

	private ArrayList<T> list;
	private ParallelWorkQueueDynamic workQueue;

	// Have to create own stack because otherwise we can get stack overflow using normal recursion 
	private ArrayList<Integer> loStack = new ArrayList<Integer>();
	private ArrayList<Integer> hiStack = new ArrayList<Integer>();

	private ParallelQuicksort(ArrayList<T> list, int lo, int hi, ParallelWorkQueueDynamic workQueue) {
		this.list = list;
		this.workQueue = workQueue;
		push(lo, hi);
	}

	private void push(int lo, int hi) {
		loStack.add(lo);
		hiStack.add(hi);
	}

	private void exch(int i, int j) {
		T tmp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, tmp);
	}

	private int partition(int lo, int hi) {
		exch(lo, lo + (hi - lo) / 2);
		int i = lo;
		int j = hi + 1;
		while (true) {
			for (int idxLo = lo; list.get(++i).compareTo(list.get(idxLo)) < 0 && i != hi;)
				;
			for (int idxLo = lo; list.get(idxLo).compareTo(list.get(--j)) < 0 && j != lo;)
				;
			if (i >= j)
				break;
			exch(i, j);
		}
		exch(lo, j);
		return j;
	}

	@Override
	public Void call() {
		int stackSize = 1;
		while ((stackSize = loStack.size()) > 0) {
			// Pop top of stack
			int lo = loStack.get(stackSize - 1);
			int hi = hiStack.get(stackSize - 1);
			loStack.remove(stackSize - 1);
			hiStack.remove(stackSize - 1);

			// Go up a stack frame when hi <= lo
			if (hi > lo) {

				// Partition
				final int j = partition(lo, hi);

				if (j - lo > 1000 && workQueue.hasIdleWorkers()) {
					// If there is enough work to do to justify multithreading and if there are idle threads,
					// fork and recurse on one one side of partition on a different thread
					workQueue.enqueueWork(new ParallelQuicksort<T>(list, lo, j - 1, workQueue));

					// Execute other half of subdivision in this thread
					push(j + 1, hi);

				} else {
					// Not worth forking another thread (not enough work to do), or not enough free workers

					push(lo, j - 1);
					push(j + 1, hi);
				}
			}
		}
		return null;
	}

	// ---------------------------------------------------------

	public static <T extends Comparable<T>> void sortInPlace(ArrayList<T> list, int numThreads) {
		ParallelWorkQueueDynamic workQueue = new ParallelWorkQueueDynamic(numThreads);
		workQueue.enqueueWork(new ParallelQuicksort<T>(list, 0, list.size() - 1, workQueue));
		workQueue.waitForAllWorkersToQuit();
		workQueue.shutdown();
	}
}
