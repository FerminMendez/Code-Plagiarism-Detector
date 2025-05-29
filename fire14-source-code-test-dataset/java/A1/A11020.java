package fixjava;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * A work queue that allows the work queue to continue to increase in size if it is discovered that subdivision of work is
 * necessary. Call hasIdleWorkers() to see if there are idle workers, and have the worker subdivide their work further by calling
 * enqueueWork().
 */
public class ParallelWorkQueueDynamic {

	private int numThreads;
	private ExecutorService threadPool;
	private CompletionService<Void> completionService;

	private int numWorkUnitsEnqueued = 0;
	private Object lock = new Object();

	public ParallelWorkQueueDynamic(int numThreads) {
		this.numThreads = numThreads;
		threadPool = Executors.newFixedThreadPool(numThreads);
		completionService = new ExecutorCompletionService<Void>(threadPool);
	}

	/**
	 * Enqueue work. Called by the main thread to start processing, and can also be called by workers to subdivide their work.
	 */
	public void enqueueWork(Callable<Void> workUnit) {
		synchronized (lock) {
			numWorkUnitsEnqueued++;
		}
		completionService.submit(workUnit);
	}

	/**
	 * Test if there are any idle workers. Should only be called from within a worker so that the total number of workers is greater
	 * than zero (to avoid a race).
	 */
	public boolean hasIdleWorkers() {
		return numWorkUnitsEnqueued < numThreads;
	}

	/**
	 * Wait for all work submitted by workers to be completed. Throws IllegalArgumentException if any of the worker threads throw an
	 * exception (this causes an ExecutionException).
	 */
	public void waitForAllWorkersToQuit() {
		try {
			while (numWorkUnitsEnqueued > 0) {
				// .take() waits for completion of next task and returns a Future for it
				completionService.take().get();
				synchronized (lock) {
					numWorkUnitsEnqueued--;
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
			throw new IllegalArgumentException("waitForAllWorkersToQuit() failed with " + e.getMessage(), e);
		} catch (ExecutionException e) {
			e.printStackTrace();
			throw new IllegalArgumentException("waitForAllWorkersToQuit() failed with " + e.getMessage(), e);
		}
	}

	public void shutdown() {
		threadPool.shutdown();
	}
}
