package fixjava;

import java.util.Collection;
import java.util.Comparator;

/**
 * Typed 3-tuple
 */
public class Tuple4<A, B, C, D> {

	private final A field0;
	private final B field1;
	private final C field2;
	private final D field3;

	public A getField0() {
		return field0;
	}

	public B getField1() {
		return field1;
	}

	public C getField2() {
		return field2;
	}

	public D getField3() {
		return field3;
	}

	public Tuple4(final A field0, final B field1, final C field2, final D field3) {
		this.field0 = field0;
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
	}

	/** Convenience method so type params of pair don't have to be specified: just do Tuple4.make(a, b, c, d) */
	public static <A, B, C, D> Tuple4<A, B, C, D> make(A field0, B field1, C field2, D field3) {
		return new Tuple4<A, B, C, D>(field0, field1, field2, field3);
	}

	// ---------------------------------------------------------------------------------------------------

	private static final boolean objEquals(Object p1, Object p2) {
		if (p1 == null)
			return p2 == null;
		return p1.equals(p2);
	}

	@Override
	public final boolean equals(Object o) {
		if (!(o instanceof Tuple4<?, ?, ?, ?>)) {
			return false;
		} else {
			final Tuple4<?, ?, ?, ?> other = (Tuple4<?, ?, ?, ?>) o;
			return objEquals(getField0(), other.getField0()) && objEquals(getField1(), other.getField1())
					&& objEquals(getField2(), other.getField2()) && objEquals(getField3(), other.getField3());
		}
	}

	@Override
	public int hashCode() {
		int h0 = getField0() == null ? 0 : getField0().hashCode();
		int h1 = getField1() == null ? 0 : getField1().hashCode();
		int h2 = getField2() == null ? 0 : getField2().hashCode();
		int h3 = getField3() == null ? 0 : getField3().hashCode();
		return h0 + 53 * h1 + 97 * h2 + 131 * h3;
	}

	// ---------------------------------------------------------------------------------------------------

	public static <A extends Comparable<A>, B, C, D> Comparator<Tuple4<A, B, C, D>> comparatorOnField0(Collection<Tuple4<A, B, C, D>> tupleCollection) {
		return new Comparator<Tuple4<A, B, C, D>>() {
			@Override
			public int compare(Tuple4<A, B, C, D> o1, Tuple4<A, B, C, D> o2) {
				return o1.getField0().compareTo(o2.getField0());
			}
		};
	}

	public static <A, B extends Comparable<B>, C, D> Comparator<Tuple4<A, B, C, D>> comparatorOnField1(Collection<Tuple4<A, B, C, D>> tupleCollection) {
		return new Comparator<Tuple4<A, B, C, D>>() {
			@Override
			public int compare(Tuple4<A, B, C, D> o1, Tuple4<A, B, C, D> o2) {
				return o1.getField1().compareTo(o2.getField1());
			}
		};
	}

	public static <A, B, C extends Comparable<C>, D> Comparator<Tuple4<A, B, C, D>> comparatorOnField2(Collection<Tuple4<A, B, C, D>> tupleCollection) {
		return new Comparator<Tuple4<A, B, C, D>>() {
			@Override
			public int compare(Tuple4<A, B, C, D> o1, Tuple4<A, B, C, D> o2) {
				return o1.getField2().compareTo(o2.getField2());
			}
		};
	}

	public static <A, B, C, D extends Comparable<D>> Comparator<Tuple4<A, B, C, D>> comparatorOnField3(Collection<Tuple4<A, B, C, D>> tupleCollection) {
		return new Comparator<Tuple4<A, B, C, D>>() {
			@Override
			public int compare(Tuple4<A, B, C, D> o1, Tuple4<A, B, C, D> o2) {
				return o1.getField3().compareTo(o2.getField3());
			}
		};
	}

	// ---------------------------------------------------------------------------------------------------

	@Override
	public String toString() {
		return "(" + getField0() + ", " + getField1() + ", " + getField2() + ", " + getField3() + ")";
	}
}
