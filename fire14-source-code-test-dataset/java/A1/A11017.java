package fixjava;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map.Entry;

public class HashMapDualKey<K1, K2, V> extends HashMap<K1, HashMap<K2, V>> {
	private static final long serialVersionUID = 1L;

	/** Returns whether the dual map contains the given key in the K1 space */
	@Override
	public boolean containsKey(Object key) {
		return this.containsKey(key);
	}

	public boolean containsKey(K1 key1, K2 key2) {
		HashMap<K2, V> map2 = this.get(key1);
		if (map2 == null)
			return false;
		else
			return map2.containsKey(key2);
	}

	/** Searches all (K1, K2) pairs to see if any of them map to the value. Runs in O(K1) time. */
	public boolean containsValueAll(Object value) {
		for (HashMap<K2, V> map2 : this.values())
			if (map2 != null && map2.containsValue(value))
				return true;
		return false;
	}

	public V get(K1 key1, K2 key2) {
		HashMap<K2, V> map2 = this.get(key1);
		if (map2 == null)
			return null;
		else
			return map2.get(key2);
	}

	public Set<K2> keySet(K1 key1) {
		HashMap<K2, V> map2 = this.get(key1);
		if (map2 == null)
			return null;
		else
			return map2.keySet();
	}

	public V put(K1 key1, K2 key2, V value) {
		HashMap<K2, V> map2 = this.get(key1);
		if (map2 == null)
			this.put(key1, map2 = new HashMap<K2, V>());
		return map2.put(key2, value);
	}

	public void putAll(ArrayList<Tuple3<? extends K1, ? extends K2, V>> items) {
		for (Tuple3<? extends K1, ? extends K2, V> item : items)
			put(item.getField0(), item.getField1(), item.getField2());
	}

	public void putAllListOfLists(ArrayList<Pair<? extends K1, ArrayList<Pair<? extends K2, V>>>> listOfLists) {
		for (Pair<? extends K1, ArrayList<Pair<? extends K2, V>>> pair1 : listOfLists) {
			K1 k1 = pair1.getLeft();
			for (Pair<? extends K2, V> pair2 : pair1.getRight())
				put(k1, pair2.getLeft(), pair2.getRight());
		}
	}

	@Override
	public HashMap<K2, V> remove(Object key1) {
		return this.remove(key1);
	}

	public V remove(K1 key1, K2 key2) {
		HashMap<K2, V> map2 = this.get(key1);
		if (map2 == null)
			return null;
		V ret = map2.remove(key2);
		if (map2.isEmpty())
			this.remove(key1);
		return ret;
	}

	/** Returns size across all (K1, K2) pairs. Runs in O(K1) time. */
	public int sizeAll() {
		int size = 0;
		for (HashMap<K2, V> map2 : this.values())
			if (map2 != null)
				size += map2.size();
		return size;
	}

	/** Returns union of values across all (K1, K2) pairs. Runs in O(N) time. */
	public HashSet<V> valuesAll() {
		HashSet<V> values = new HashSet<V>();
		for (HashMap<K2, V> map2 : this.values())
			if (map2 != null)
				values.addAll(map2.values());
		return values;
	}

	/** Returns the map as a list of Tuple3<K1, K2, V>. Runs in O(N) time. */
	public ArrayList<Tuple3<K1, K2, V>> getAsList() {
		ArrayList<Tuple3<K1, K2, V>> result = new ArrayList<Tuple3<K1,K2,V>>();
		for (Entry<K1, HashMap<K2, V>> ent1 : this.entrySet()) {
			K1 k1 = ent1.getKey();
			HashMap<K2, V> map2 = ent1.getValue();
			if (map2 != null) {
				for (Entry<K2, V> ent2 : map2.entrySet()) {
					K2 k2 = ent2.getKey();
					V v = ent2.getValue();
					result.add(Tuple3.make(k1, k2, v));
				}
			}
		}
		return result;
	}	

	/** Returns the map as a list of Pair<K1, ArrayList<Pair<K2, V>>>. Runs in O(N) time. */
	public ArrayList<Pair<K1, ArrayList<Pair<K2, V>>>> getAsListOfLists() {
		ArrayList<Pair<K1, ArrayList<Pair<K2, V>>>> result = new ArrayList<Pair<K1, ArrayList<Pair<K2, V>>>>(this.size());
		for (Entry<K1, HashMap<K2, V>> ent1 : this.entrySet()) {
			K1 k1 = ent1.getKey();
			HashMap<K2, V> map2 = ent1.getValue();
			if (map2 != null) {
				ArrayList<Pair<K2, V>> listOfK2VPairs = new ArrayList<Pair<K2,V>>(map2.size());
				for (Entry<K2, V> ent2 : map2.entrySet()) {
					K2 k2 = ent2.getKey();
					V v = ent2.getValue();
					listOfK2VPairs.add(Pair.make(k2, v));
				}
				result.add(Pair.make(k1, listOfK2VPairs));
			}
		}
		return result;
	}	
}
