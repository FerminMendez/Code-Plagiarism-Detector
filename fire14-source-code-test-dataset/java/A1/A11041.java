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
  
  		MultiMap<String, String> map = MultiMapKeyToList.make();
		map.put("a", "x");
		map.put("a", "x");
		map.put("a", "y");
		map.put("b", "z");
		System.out.println(Join.joinRecursive(map.entrySet(), ", ", "[", "]"));
		
  </code>
 * 
 * @author luke
 */
public class MultiMapKeyToList<S, T> {

	HashMap<S, ArrayList<T>> map = new HashMap<S, ArrayList<T>>();

	public static <K, V> MultiMapKeyToList<K, V> make() {
		return new MultiMapKeyToList<K, V>();
	}

	public void put(S key, T value) {
		ArrayList<T> list = map.get(key);
		if (list == null) {
			list = new ArrayList<T>();
			map.put(key, list);
		}
		list.add(value);
	}

	public ArrayList<T> get(S key) {
		return map.get(key);
	}

	public boolean containsKey(S key) {
		return map.containsKey(key);
	}

	public int sizeKeys() {
		return map.size();
	}

	public HashSet<T> valuesUnion() {
		HashSet<T> result = new HashSet<>();
		for (Entry<S, ArrayList<T>> ent : map.entrySet())
			for (T val : ent.getValue())
				result.add(val);
		return result;
	}

	public Set<Entry<S, ArrayList<T>>> entrySet() {
		return map.entrySet();
	}

	public HashMap<S, ArrayList<T>> getRawMap() {
		return map;
	}

	public ArrayList<Pair<S, ArrayList<T>>> getRawMapAsList() {
		ArrayList<Pair<S, ArrayList<T>>> result = new ArrayList<Pair<S, ArrayList<T>>>();
		for (Entry<S, ArrayList<T>> ent : map.entrySet())
			result.add(Pair.make(ent.getKey(), ent.getValue()));
		return result;
	}

	public void putAll(S key, Iterable<T> values) {
		boolean putSomething = false;
		for (T val : values) {
			put(key, val);
			putSomething = true;
		}
		if (!putSomething && !map.containsKey(key))
			// If putting an empty collection, need to create an empty set at the key 
			map.put(key, new ArrayList<T>());
	}

	public void putAll(S key, T[] values) {
		if (values.length == 0 && !map.containsKey(key))
			// If putting an empty collection, need to create an empty set at the key 
			map.put(key, new ArrayList<T>());
		else
			for (T val : values)
				put(key, val);
	}

	/** Invert the mapping */
	public MultiMapKeyToList<T, S> invert() {
		MultiMapKeyToList<T, S> inv = new MultiMapKeyToList<T, S>();
		for (Entry<S, ArrayList<T>> ent : map.entrySet()) {
			S s = ent.getKey();
			for (T t : ent.getValue())
				inv.put(t, s);
		}
		return inv;
	}

	public ArrayList<Pair<S, ArrayList<T>>> toList() {
		ArrayList<Pair<S, ArrayList<T>>> result = new ArrayList<Pair<S, ArrayList<T>>>();
		for (Entry<S, ArrayList<T>> ent : map.entrySet())
			result.add(Pair.make(ent.getKey(), ent.getValue()));
		return result;
	}

	/** Write out to a TSV file */
	public void writeOutToFile(String tsvFile) throws IOException {
		PrintWriter writer = new PrintWriter(tsvFile);
		for (Entry<S, ArrayList<T>> ent : map.entrySet()) {
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
	public static MultiMapKeyToList<String, String> readFromFile(String tsvFile) throws IOException {
		MultiMapKeyToList<String, String> map = new MultiMapKeyToList<String, String>();
		for (String line : new FileLineIterator(tsvFile)) {
			String[] parts = Split.split(line, "\t");
			String key = parts[0];
			for (int i = 1; i < parts.length; i++)
				map.put(key, parts[i]);
		}
		return map;
	}

}
