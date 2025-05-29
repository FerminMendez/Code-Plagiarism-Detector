package fixjava;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Simple multimap class. <code>
  
  		MultiMap<String, String> map = MultiMapKeyToSet.make();
		map.put("a", "x");
		map.put("a", "x");
		map.put("a", "y");
		map.put("b", "z");
		System.out.println(Join.joinRecursive(map.entrySet(), ", ", "[", "]"));
		
  </code>
 * 
 * @author luke
 */
public class MultiMapKeyToSet<S, T> {

	HashMap<S, HashSet<T>> map = new HashMap<S, HashSet<T>>();

	public static <K, V> MultiMapKeyToSet<K, V> make() {
		return new MultiMapKeyToSet<K, V>();
	}

	/** Return true if this multimap did not already contain the specified value at the specified key. */  
	public boolean put(S key, T value) {
		HashSet<T> set = map.get(key);
		if (set == null) {
			set = new HashSet<T>();
			map.put(key, set);
		}
		return set.add(value);
	}

	public void putAll(S key, Iterable<T> values) {
		boolean putSomething = false;
		for (T val : values) {
			put(key, val);
			putSomething = true;
		}
		if (!putSomething && !map.containsKey(key))
			// If putting an empty collection, need to create an empty set at the key 
			map.put(key, new HashSet<T>());
	}

	public void putAll(S key, T[] values) {
		if (values.length == 0 && !map.containsKey(key))
			// If putting an empty collection, need to create an empty set at the key 
			map.put(key, new HashSet<T>());
		else
			for (T val : values)
				put(key, val);
	}

	public HashSet<T> get(S key) {
		return map.get(key);
	}

	/**
	 * Get the single value mapped to by the key, or null if no value mapped to for this key.
	 * 
	 * @throws IllegalRuntimeException
	 *             if there is more than one value mapped to by this key.
	 */
	public T getSingleVal(S key) {
		HashSet<T> set = map.get(key);
		return CollectionUtils.getSingleVal(set);
	}

	public boolean containsKey(S key) {
		return map.containsKey(key);
	}

	public int sizeKeys() {
		return map.size();
	}

	public Set<Entry<S, HashSet<T>>> entrySet() {
		return map.entrySet();
	}

	/**
	 * Return the union of all values in all mapped sets (i.e. the union of all values mapped to by some key in this MultiMap).
	 * NOTE: creates a new HashSet with the current union on every invocation, so if you modify the contents of the returned
	 * HashSet, it won't affect the map.
	 */
	public HashSet<T> valuesUnion() {
		return CollectionUtils.union(map.values());
	}

	public HashMap<S, HashSet<T>> getRawMap() {
		return map;
	}

	public Set<S> keySet() {
		return map.keySet();
	}

	/** Invert the mapping */
	public MultiMapKeyToSet<T, S> invert() {
		MultiMapKeyToSet<T, S> inv = new MultiMapKeyToSet<T, S>();
		for (Entry<S, HashSet<T>> ent : map.entrySet()) {
			S key = ent.getKey();
			for (T val : ent.getValue())
				inv.put(val, key);
		}
		return inv;
	}

	public ArrayList<Pair<S, HashSet<T>>> toList() {
		ArrayList<Pair<S, HashSet<T>>> result = new ArrayList<Pair<S,HashSet<T>>>();
		for (Entry<S, HashSet<T>> ent : map.entrySet())
			result.add(Pair.make(ent.getKey(), ent.getValue()));
		return result;
	}
	
	/** Write out to a TSV file */
	public void writeOutToFile(String tsvFile) throws IOException {
		PrintWriter writer = new PrintWriter(tsvFile);
		for (Entry<S, HashSet<T>> ent : map.entrySet()) {
			S key = ent.getKey();
			StringBuilder buf = new StringBuilder();
			buf.append(key);
			for (T val : ent.getValue())
				buf.append("\t" + val);
			writer.println(buf.toString());
		}
		writer.close();
	}
	
	/** Read in a String->String map from a TSV file */
	public static MultiMapKeyToSet<String, String> readFromFile(String tsvFile) throws IOException {
		MultiMapKeyToSet<String, String> map = new MultiMapKeyToSet<String, String>();
		for (String line : new FileLineIterator(tsvFile)) {
			String[] parts = Split.split(line, "\t");
			String key = parts[0];
			for (int i = 1; i < parts.length; i++)
				map.put(key, parts[i]);
		}
		return map;
	}
}
