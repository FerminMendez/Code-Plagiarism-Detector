package fixjava;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

/**
 * Pair: typed 2-tuple
 */
public class Pair<L, R> {

	private final L left;
	private final R right;

	public R getRight() {
		return right;
	}

	public L getLeft() {
		return left;
	}

	public Pair(final L left, final R right) {
		this.left = left;
		this.right = right;
	}

	/** Convenience method so type params of pair don't have to be specified: just do Pair.make(l, r) */
	public static <L, R> Pair<L, R> make(L left, R right) {
		return new Pair<L, R>(left, right);
	}

	// ---------------------------------------------------------------------------------------------------

	private static final boolean objEquals(Object p1, Object p2) {
		if (p1 == null)
			return p2 == null;
		return p1.equals(p2);
	}

	@Override
	public final boolean equals(Object o) {
		if (!(o instanceof Pair<?, ?>)) {
			return false;
		} else {
			final Pair<?, ?> other = (Pair<?, ?>) o;
			return objEquals(getLeft(), other.getLeft()) && objEquals(getRight(), other.getRight());
		}
	}

	@Override
	public int hashCode() {
		int hl = getLeft() == null ? 0 : getLeft().hashCode();
		int hr = getRight() == null ? 0 : getRight().hashCode();
		return (hl + (127 * hr)) ^ (hr << 1);
	}

	// ---------------------------------------------------------------------------------------------------

	@Override
	public String toString() {
		return "(" + getLeft() + ", " + getRight() + ")";
	}

	// ---------------------------------------------------------------------------------------------------

	public static <K, V> ArrayList<K> getAllLefts(Iterable<Pair<K, V>> list) {
		ArrayList<K> result = new ArrayList<K>();
		for (Pair<K, V> pair : list)
			result.add(pair.getLeft());
		return result;
	}

	public static <K, V> ArrayList<V> getAllRights(Iterable<Pair<K, V>> list) {
		ArrayList<V> result = new ArrayList<V>();
		for (Pair<K, V> pair : list)
			result.add(pair.getRight());
		return result;
	}

	// ---------------------------------------------------------------------------------------------------

	public static <A extends Comparable<A>, B> Comparator<Pair<A, B>> comparatorOnLeft(Collection<Pair<A, B>> tupleCollection) {
		return new Comparator<Pair<A, B>>() {
			@Override
			public int compare(Pair<A, B> o1, Pair<A, B> o2) {
				return o1.getLeft().compareTo(o2.getLeft());
			}
		};
	}

	public static <A extends Comparable<A>, B> Comparator<Pair<A, B>> comparatorOnLeftRev(Collection<Pair<A, B>> tupleCollection) {
		return new Comparator<Pair<A, B>>() {
			@Override
			public int compare(Pair<A, B> o1, Pair<A, B> o2) {
				return -o1.getLeft().compareTo(o2.getLeft());
			}
		};
	}

	public static <A, B extends Comparable<B>> Comparator<Pair<A, B>> comparatorOnRight(Collection<Pair<A, B>> tupleCollection) {
		return new Comparator<Pair<A, B>>() {
			@Override
			public int compare(Pair<A, B> o1, Pair<A, B> o2) {
				return o1.getRight().compareTo(o2.getRight());
			}
		};
	}

	public static <A, B extends Comparable<B>> Comparator<Pair<A, B>> comparatorOnRightRev(Collection<Pair<A, B>> tupleCollection) {
		return new Comparator<Pair<A, B>>() {
			@Override
			public int compare(Pair<A, B> o1, Pair<A, B> o2) {
				return -o1.getRight().compareTo(o2.getRight());
			}
		};
	}

	static <A extends Comparable<A>, B> Comparator<Pair<A, B>> comparatorOnLeft(Collection<Pair<A, B>> tupleCollection,
			final boolean ascending) {
		return new Comparator<Pair<A, B>>() {
			final int weight = ascending ? 1 : -1;

			@Override
			public int compare(Pair<A, B> o1, Pair<A, B> o2) {
				return o1.getLeft().compareTo(o2.getLeft()) * weight;
			}
		};
	}

	static <A, B extends Comparable<B>> Comparator<Pair<A, B>> comparatorOnRight(Collection<Pair<A, B>> tupleCollection,
			final boolean ascending) {
		return new Comparator<Pair<A, B>>() {
			final int weight = ascending ? 1 : -1;

			@Override
			public int compare(Pair<A, B> o1, Pair<A, B> o2) {
				return o1.getRight().compareTo(o2.getRight()) * weight;
			}
		};
	}

	// ---------------------------------------------------------------------------------------------------

	/** Sort a List<Pair<K, V>> in-place into order of increasing or decreasing K */
	public static <K extends Comparable<K>, V> void sortPairsByLeft(List<Pair<K, V>> list, boolean ascending) {
		Collections.sort(list, comparatorOnLeft(list, ascending));
	}

	/** Sort a List<Pair<K, V>> in-place into order of increasing K */
	public static <K extends Comparable<K>, V> void sortPairsByLeft(List<Pair<K, V>> list) {
		Collections.sort(list, comparatorOnLeft(list, true));
	}

	/** Sort a List<Pair<K, V>> in-place into order of increasing or decreasing V */
	public static <K, V extends Comparable<V>> void sortPairsByRight(List<Pair<K, V>> list, boolean ascending) {
		Collections.sort(list, comparatorOnRight(list, ascending));
	}

	/** Sort a List<Pair<K, V>> in-place into order of increasing V */
	public static <K, V extends Comparable<V>> void sortPairsByRight(List<Pair<K, V>> list) {
		Collections.sort(list, comparatorOnRight(list));
	}

	/** Convert a <K, V> map into a list of Pair<K, V>, final order unspecified */
	public static <K, V> ArrayList<Pair<K, V>> mapToList(HashMap<K, V> map) {
		ArrayList<Pair<K, V>> list = new ArrayList<Pair<K, V>>();
		for (Entry<K, V> ent : map.entrySet())
			list.add(new Pair<K, V>(ent.getKey(), ent.getValue()));
		return list;
	}
}
