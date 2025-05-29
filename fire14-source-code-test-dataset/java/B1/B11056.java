package fixjava;

import java.util.Map;
import java.util.Map.Entry;

public class Join {

	// TODO: write a join-of-joins (2D join) that joins lists-of-lists without the complexity of using a lambda. 
	
	public static <T> String join(Iterable<T> list, String delim) {
		if (list == null)
			return null;
		StringBuilder buf = new StringBuilder();
		int idx = 0;
		for (T item : list) {
			if (idx++ > 0)
				buf.append(delim);
			buf.append(item.toString());
		}
		return buf.toString();
	}

	public static <T> String join(Iterable<T> list, String delim, Lambda<T, String> customToString) {
		if (list == null)
			return null;
		StringBuilder buf = new StringBuilder();
		int idx = 0;
		for (T item : list) {
			if (idx++ > 0)
				buf.append(delim);
			buf.append(customToString.apply(item));
		}
		return buf.toString();
	}

	public static <T> String join(T[] array, String delim) {
		if (array == null)
			return null;
		StringBuilder buf = new StringBuilder();
		for (int i = 0, n = array.length; i < n; i++) {
			if (i > 0)
				buf.append(delim);
			buf.append(array[i].toString());
		}
		return buf.toString();
	}

	public static <T> String join(int[] array, String delim) {
		if (array == null)
			return null;
		StringBuilder buf = new StringBuilder();
		for (int i = 0, n = array.length; i < n; i++) {
			if (i > 0)
				buf.append(delim);
			buf.append(array[i]);
		}
		return buf.toString();
	}

	public static <T> String join(float[] array, String delim) {
		if (array == null)
			return null;
		StringBuilder buf = new StringBuilder();
		for (int i = 0, n = array.length; i < n; i++) {
			if (i > 0)
				buf.append(delim);
			buf.append(array[i]);
		}
		return buf.toString();
	}

	public static <T> String join(double[] array, String delim) {
		if (array == null)
			return null;
		StringBuilder buf = new StringBuilder();
		for (int i = 0, n = array.length; i < n; i++) {
			if (i > 0)
				buf.append(delim);
			buf.append(array[i]);
		}
		return buf.toString();
	}

	public static <T> String join(char[] array, String delim) {
		if (array == null)
			return null;
		StringBuilder buf = new StringBuilder();
		for (int i = 0, n = array.length; i < n; i++) {
			if (i > 0)
				buf.append(delim);
			buf.append(array[i]);
		}
		return buf.toString();
	}

	public static <T> String join(Iterable<T> list) {
		return join(list, "");
	}

	public static <T> String join(T[] array) {
		return join(array, "");
	}

	public static <T> String join(Iterable<T> list, String delim, String prefix, String suffix) {
		return prefix + join(list, "") + suffix;
	}

	public static <T> String join(T[] array, String prefix, String suffix) {
		return prefix + join(array, "") + suffix;
	}

	/** Recursively join an Iterable that may optionally consist of Iterables.  If the items within the Iterable are of type Entry, they are joined as "key : value".  If value is an Iterable, it is recursed upon. */ 
	@SuppressWarnings("rawtypes")
	public static String joinRecursive(Iterable iterable, String delim, String prefix, String suffix) {
		if (iterable == null)
			return null;
		StringBuilder buf = new StringBuilder();
		buf.append(prefix);
		int idx = 0;
		for (Object item : iterable) {
			if (idx++ > 0)
				buf.append(delim);
			if (item instanceof Iterable) {
				buf.append(joinRecursive((Iterable) item, delim, prefix, suffix));
			} else if (item instanceof Entry) {
				Entry ent = (Entry) item;
				buf.append(ent.getKey().toString());
				buf.append(" : ");
				Object val = ent.getValue();
				if (val instanceof Iterable)
					buf.append(joinRecursive((Iterable) val, delim, prefix, suffix));
				else
					buf.append(val.toString());
			} else {
				buf.append(item.toString());
			}
		}
		buf.append(suffix);
		return buf.toString();
	}

	/** Join a map and recursively join values in the map */
	public static <K, V> String joinRecursive(Map<K, V> map, String delim, String prefix, String suffix) {
		return joinRecursive(map.entrySet(), delim, prefix, suffix);
	}
}
