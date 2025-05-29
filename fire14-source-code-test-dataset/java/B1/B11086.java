package fixjava;

import java.util.Collection;
import java.util.Comparator;


/**
 * Typed 3-tuple
 */
public class Tuple3<A, B, C> {

	private final A field0;
	private final B field1;
	private final C field2;

	public A getField0() {
		return field0;
	}

	public B getField1() {
		return field1;
	}

	public C getField2() {
		return field2;
	}

	public Tuple3(final A field0, final B field1, final C field2) {
		this.field0 = field0;
		this.field1 = field1;
		this.field2 = field2;
	}

	/** Convenience method so type params of pair don't have to be specified: just do Tuple3.make(a, b, c) */
	public static <A, B, C> Tuple3<A, B, C> make(A field0, B field1, C field2) {
		return new Tuple3<A, B, C>(field0, field1, field2);
	}

	// ---------------------------------------------------------------------------------------------------

	private static final boolean objEquals(Object p1, Object p2) {
		if (p1 == null)
			return p2 == null;
		return p1.equals(p2);
	}

	@Override
	public final boolean equals(Object o) {
		if (!(o instanceof Tuple3<?, ?, ?>)) {
			return false;
		} else {
			final Tuple3<?, ?, ?> other = (Tuple3<?, ?, ?>) o;
			return objEquals(getField0(), other.getField0()) && objEquals(getField1(), other.getField1())
					&& objEquals(getField2(), other.getField2());
		}
	}

	@Override
	public int hashCode() {
		int h0 = getField0() == null ? 0 : getField0().hashCode();
		int h1 = getField1() == null ? 0 : getField1().hashCode();
		int h2 = getField2() == null ? 0 : getField2().hashCode();
		return h0 + 53 * h1 + 97 * h2;
	}

	// ---------------------------------------------------------------------------------------------------

	public static <A extends Comparable<A>, B, C> Comparator<Tuple3<A, B, C>> comparatorOnField0(Collection<Tuple3<A, B, C>> tupleCollection) {
		return new Comparator<Tuple3<A, B, C>>() {
			@Override
			public int compare(Tuple3<A, B, C> o1, Tuple3<A, B, C> o2) {
				return o1.getField0().compareTo(o2.getField0());
			}
		};
	}

	public static <A extends Comparable<A>, B, C> Comparator<Tuple3<A, B, C>> comparatorOnField0Rev(Collection<Tuple3<A, B, C>> tupleCollection) {
		return new Comparator<Tuple3<A, B, C>>() {
			@Override
			public int compare(Tuple3<A, B, C> o1, Tuple3<A, B, C> o2) {
				return -o1.getField0().compareTo(o2.getField0());
			}
		};
	}

	public static <A, B extends Comparable<B>, C> Comparator<Tuple3<A, B, C>> comparatorOnField1(Collection<Tuple3<A, B, C>> tupleCollection) {
		return new Comparator<Tuple3<A, B, C>>() {
			@Override
			public int compare(Tuple3<A, B, C> o1, Tuple3<A, B, C> o2) {
				return o1.getField1().compareTo(o2.getField1());
			}
		};
	}

	public static <A, B extends Comparable<B>, C> Comparator<Tuple3<A, B, C>> comparatorOnField1Rev(Collection<Tuple3<A, B, C>> tupleCollection) {
		return new Comparator<Tuple3<A, B, C>>() {
			@Override
			public int compare(Tuple3<A, B, C> o1, Tuple3<A, B, C> o2) {
				return -o1.getField1().compareTo(o2.getField1());
			}
		};
	}

	public static <A, B, C extends Comparable<C>> Comparator<Tuple3<A, B, C>> comparatorOnField2(Collection<Tuple3<A, B, C>> tupleCollection) {
		return new Comparator<Tuple3<A, B, C>>() {
			@Override
			public int compare(Tuple3<A, B, C> o1, Tuple3<A, B, C> o2) {
				return o1.getField2().compareTo(o2.getField2());
			}
		};
	}

	public static <A, B, C extends Comparable<C>> Comparator<Tuple3<A, B, C>> comparatorOnField2Rev(Collection<Tuple3<A, B, C>> tupleCollection) {
		return new Comparator<Tuple3<A, B, C>>() {
			@Override
			public int compare(Tuple3<A, B, C> o1, Tuple3<A, B, C> o2) {
				return -o1.getField2().compareTo(o2.getField2());
			}
		};
	}
	
	// ---------------------------------------------------------------------------------------------------

	@Override
	public String toString() {
		return "(" + getField0() + ", " + getField1() + ", " + getField2() + ")";
	}
}
