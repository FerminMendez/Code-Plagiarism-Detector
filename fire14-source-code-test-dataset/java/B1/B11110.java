package recycled;

public class Pair {

	private final int n;

	private final int m;

	public Pair(int n, int m) {
		this.n = n;
		this.m = m;
	}

	public int getN() {
		return n;
	}

	public int getM() {
		return m;
	}

	public int hashCode() {
		return n + m;
	}

	public boolean equals(Object o) {
		boolean result = false;
		if (o != null && o instanceof Pair) {
			Pair pair = (Pair) o;
			if (n == pair.getN() && m == pair.getM()) {
				result = true;
			}
		}
		return result;
	}

}
