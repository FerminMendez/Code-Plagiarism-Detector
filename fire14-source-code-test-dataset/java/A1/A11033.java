package fixjava;

import java.util.HashMap;

public class MapDualKeyToValue<K1, K2, V> extends HashMap<Pair<K1, K2>, V> {

	private static final long serialVersionUID = 1L;

	public V put(K1 key1, K2 key2, V value) {
		return put(Pair.make(key1, key2), value);
	};

	public MultiMapKeyToList<K2, V> getValuesGroupedByKey2() {
		MultiMapKeyToList<K2, V> key2ToValues = new MultiMapKeyToList<K2, V>();
		for (java.util.Map.Entry<Pair<K1, K2>, V> ent : entrySet())
			key2ToValues.put(ent.getKey().getRight(), ent.getValue());
		return key2ToValues;
	}

	public MultiMapKeyToList<K1, V> getValuesGroupedByKey1() {
		MultiMapKeyToList<K1, V> key1ToValues = new MultiMapKeyToList<K1, V>();
		for (java.util.Map.Entry<Pair<K1, K2>, V> ent : entrySet())
			key1ToValues.put(ent.getKey().getLeft(), ent.getValue());
		return key1ToValues;
	}
}
