package fixjava;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

public class CountedSet<T> implements Set<T> {

	HashMap<T, Integer> map = new HashMap<T, Integer>();
	private static final Integer ONE = new Integer(1);

	public CountedSet(Iterable<T> collection) {
		for (T t : collection)
			add(t);
	}

	@Override
	public boolean add(T item) {
		Integer count = map.get(item);
		if (count == null) {
			map.put(item, ONE);
			return true;
		} else {
			map.put(item, count + 1);
			return false;
		}
	}

	/** New method to fetch count, not in normal Sets.  Returns null if key is not in set. */
	public Integer get(String key) {
		return map.get(key);
	}

	/** New method to fetch count, not in normal Sets.  Returns zero if key is not in set. */
	public int getCount(String key) {
		Integer count = map.get(key);
		return count == null ? 0 : count;
	}

	/** Extra method to iterate over entries consisting of both items and counts */
	public Iterator<Entry<T, Integer>> iteratorWithCounts() {
		return map.entrySet().iterator();
	}

	/** Extra method to iterate over entries consisting of both items and counts */
	public Iterable<Entry<T, Integer>> iteratableWithCounts() {
		return map.entrySet();
	}

	/** Convert into sorted list of <item, count> pairs */
	public ArrayList<Pair<T, Integer>> toListSortedByCount(boolean ascending) {
		ArrayList<Pair<T, Integer>> list = Pair.mapToList(map);
        Pair.sortPairsByRight(list, ascending);
		return list;
	}

	// ----- boilerplate stuff: -----

	@Override
	public boolean addAll(Collection<? extends T> collection) {
		boolean changed = false;
		for (T item : collection) {
			add(item);
			changed = true;
		}
		return changed;
	}

	@Override
	public void clear() {
		map.clear();
	}

	@Override
	public boolean contains(Object item) {
		return map.containsKey(item);
	}

	@Override
	public boolean containsAll(Collection<?> collection) {
		boolean containsAll = true;
		for (Object item : collection) {
			if (!contains(item)) {
				containsAll = false;
				break;
			}
		}
		return containsAll;
	}

	@Override
	public boolean isEmpty() {
		return map.isEmpty();
	}

	/** Just iterates over keys, not counts */
	@Override
	public Iterator<T> iterator() {
		return map.keySet().iterator();
	}

	@Override
	public boolean remove(Object item) {
		return map.remove(item) != null;
	}

	@Override
	public boolean removeAll(Collection<?> collection) {
		boolean changed = false;
		for (Object item : collection) {
			if (remove(item)) {
				changed = true;
				break;
			}
		}
		return changed;
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		throw new RuntimeException("Not implemented");
	}

	@Override
	public int size() {
		return map.size();
	}

	/** Just returns keys in array, not counts */
	@Override
	public Object[] toArray() {
		return map.keySet().toArray();
	}

	/** Just returns keys in array, not counts */
	@Override
	public <U> U[] toArray(U[] arr) {
		return map.keySet().toArray(arr);
	}
}
