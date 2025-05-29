
public class RecycledPair {
	private int lower;
	private int higher;
	
	RecycledPair() {
		lower = 0;
		higher = 0;
	}
	
	RecycledPair(RecycledPair other) {
		lower = other.lower;
		higher = other.higher;
	}
	
	public void set(int left, int right) {
		this.lower = Math.min(left, right);
		this.higher = Math.max(left, right);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + lower;
		result = prime * result + higher;
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
		if (lower != other.lower)
			return false;
		if (higher != other.higher)
			return false;
		return true;
	}
	
	
}
