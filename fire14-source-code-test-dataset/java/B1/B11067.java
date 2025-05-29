package fixjava;

public class IntegerMutable {

	int value;

	public IntegerMutable(int value) {
		this.value = value;
	}

	public IntegerMutable() {
		this(0);
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	/** Inc and return new value (threadsafe) */
	public synchronized int increment() {
		return ++value;
	}
	
	/** Dec and return new value (threadsafe) */
	public synchronized int decrement() {
		return --value;
	}
	
	/** Subtract amount and return new value (threadsafe) */
	public synchronized int subtract(int amount) {
		return value -= amount;
	}
	
	/** Add amount and return new value (threadsafe) */
	public synchronized int add(int amount) {
		return value += amount;
	}
}
