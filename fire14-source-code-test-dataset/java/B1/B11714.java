import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Counter {
	
	private int T;
	private Lock lock;
	private ICounterZeroEvent e;
	
	
	public Counter(int T, ICounterZeroEvent e)
	{
		this.T = T;
		this.e = e;
		lock = new ReentrantLock();
	}
	
	public void increase() {
		lock.lock();
		T--;
		if (T==0)
			e.fireEvent();
		lock.unlock();
		System.out.println(T);
		
	}
	
}
