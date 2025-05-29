package recycledNumbers;

public class RecycledPair {

	private int n;
	private int m;

	public RecycledPair(int n, int m) {
		this.n = n;
		this.m = m;
	}

	/**
	 * @return the n
	 */
	public int getN() {
		return n;
	}

	/**
	 * @return the m
	 */
	public int getM() {
		return m;
	}

	@Override
	public boolean equals(Object o) {

		if (!(o instanceof RecycledPair)) {
			throw new ClassCastException("Invalid object");
		}

		RecycledPair rp = (RecycledPair) o;

		if ((this.getM() == rp.getM() && this.getN() == rp.getN())
				|| (this.getM() == rp.getN() && this.getN() == rp.getM())) {
			return true;
		}

		return false;

	}

	@Override
	public int hashCode() {
		if (this.getM() < this.getN()) {
			return this.getM() + 13 * this.getN();
		} else {
			return this.getN() + 13 * this.getM();
		}
	}

}
