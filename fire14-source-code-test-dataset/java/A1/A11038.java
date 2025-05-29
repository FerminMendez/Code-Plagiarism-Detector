/**
 * 
 */
package fixjava;

public class ConcurrentCounter {
	private int count = 0;

	public synchronized int getAndIncrement() {
		return count++;
	}
}