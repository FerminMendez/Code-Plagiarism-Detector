package fixjava;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Get the index of the given key if this key has been assigned an index before, and if not, allocate a new index for it by
 * incrementing a counter that starts at zero, and return the new index.
 */
public class UniqueIndexAllocator<T> {

	private HashMap<T, Integer> map = new HashMap<T, Integer>();
	private ArrayList<T> orderedKeys = new ArrayList<T>();

	public UniqueIndexAllocator() {
	}

	/** Allocate unique indices for each item in the given collection. Read back the indices using the other methods. */
	public UniqueIndexAllocator(Iterable<T> collection) {
		for (T it : collection)
			getOrAllocateIndex(it);
	}

	/** Get the assigned index for a key, or assign it a new unique index if this key has not previously been assigned an index */
	public int getOrAllocateIndex(T key) {
		Integer currIdx = map.get(key);
		if (currIdx == null) {
			map.put(key, currIdx = orderedKeys.size());
			orderedKeys.add(key);
		}
		return currIdx;
	}

	/** Get all the keys as a list in their index order */
	public ArrayList<T> getOrderedKeys() {
		return orderedKeys;
	}

	/** Get all the keys as an array in their index order */
	@SuppressWarnings("unchecked")
	public T[] getOrderedKeysAsArray() {
		return (T[]) orderedKeys.toArray();
	}

	/** Get the mapping from key to index */
	public HashMap<T, Integer> getKeyToIndexMap() {
		return map;
	}

	/** Return the number of allocated indices, i.e. the number of unique keys */
	public int numIndices() {
		return orderedKeys.size();
	}
}
