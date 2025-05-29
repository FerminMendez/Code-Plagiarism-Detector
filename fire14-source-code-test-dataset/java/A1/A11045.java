package fixjava;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import fixjava.ParallelWorkQueue.CallableFactory;



public class ParallelWorkQueueTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Integer> inputs = new ArrayList<Integer>();
		for (int i = 100; i < 120; i++)
			inputs.add(i);

		ParallelWorkQueue.CallableFactory<Integer, String> callableFactory = new CallableFactory<Integer, String>() {
			@Override
			public Callable<String> newInstance(final Integer input) {
				return new Callable<String>() {
					@Override
					public String call() throws Exception {
						Thread.sleep((int) (Math.random() * 4000));
						System.out.println("  Input: " + input);
						return "***" + (input + 1);
					}
				};
			}
		};

		try {
			for (Future<String> result : new ParallelWorkQueue<Integer, String>(4, inputs, callableFactory))
				System.out.println("Got : " + result.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}
