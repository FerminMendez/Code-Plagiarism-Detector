package fixjava;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public abstract class Filter<T> {

	abstract boolean accept(T item);

	public static <U> ArrayList<U> list(Iterable<U> collection, Filter<U> filter) {
		ArrayList<U> filtered = new ArrayList<U>();
		for (U item : collection)
			if (filter.accept(item))
				filtered.add(item);
		return filtered;
	}

	public static <U> HashSet<U> set(Set<U> set, Filter<U> filter) {
		HashSet<U> filtered = new HashSet<U>();
		for (U item : set)
			if (filter.accept(item))
				filtered.add(item);
		return filtered;
	}

	public static <K, V> HashMap<K, V> mapKeys(Map<K, V> map, Filter<K> keyFilter) {
		HashMap<K, V> filtered = new HashMap<K, V>();
		for (Entry<K, V> ent : map.entrySet())
			if (keyFilter.accept(ent.getKey()))
				filtered.put(ent.getKey(), ent.getValue());
		return filtered;
	}

	public static <K, V> HashMap<K, V> mapValues(Map<K, V> map, Filter<V> valueFilter) {
		HashMap<K, V> filtered = new HashMap<K, V>();
		for (Entry<K, V> ent : map.entrySet())
			if (valueFilter.accept(ent.getValue()))
				filtered.put(ent.getKey(), ent.getValue());
		return filtered;
	}
}
