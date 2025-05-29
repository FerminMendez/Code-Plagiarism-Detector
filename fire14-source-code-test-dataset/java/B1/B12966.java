package qualification.recycled.numbers;

public class RecycledPair {
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + m;
		result = prime * result + n;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RecycledPair other = (RecycledPair) obj;
		if (m != other.m)
			return false;
		if (n != other.n)
			return false;
		return true;
	}

	private int n;
	private int m;
	
	public RecycledPair(int n, int m) {
		if (m > n) {
			int temp = n;
			n = m;
			m = temp;
		}
		this.n = n;
		this.m = m;
	}
	
}
