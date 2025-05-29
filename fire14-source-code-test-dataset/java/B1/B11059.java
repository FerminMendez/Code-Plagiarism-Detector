package fixjava;

import java.util.ArrayList;

/**
 * An ArrayList that allows values to be set at positions greater than or equal to size(), which causes the end of the list to be padded with an
 * identity element before the value is set
 */
public class ArrayListAutoPadded<T> extends ArrayList<T> {

	private T identity;

	public ArrayListAutoPadded(T identity) {
		super();
		this.identity = identity;
	}

	public ArrayListAutoPadded(T identity, int initialCapacity) {
		super(initialCapacity);
		this.identity = identity;
	}

	/**
	 * Set the value at the given location to the specified value, padding the list to the desired length if necessary. Returns the old value at the
	 * location, if there was one, otherwise the identity value that was passed in the constructor.
	 */
	public T set(int index, T element) {
		if (size() > index) {
			return super.set(index, element);
		} else {
			while (size() < index)
				add(identity);
			add(element);
			return identity;
		}
	};

	/**
	 * Combine the value at the given location with the new value, by calling labmda.apply(oldValue, newValue). The identity value that was passed in
	 * the constructor is used if the index >= size(). Returns the *old* value that was stored at the index before combining, or identity if there was
	 * no old value.
	 */
	public T combineAndSet(int index, Lambda2<T, T, T> combineFunc, T newValue) {
		T oldValue;
		if (size() > index) {
			oldValue = get(index);
		} else {
			while (size() <= index)
				add(identity);
			oldValue = identity;
		}
		return super.set(index, combineFunc.apply(oldValue, newValue));
	}

	private static final long serialVersionUID = 1L;
}
