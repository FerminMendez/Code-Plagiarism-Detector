package mgg.utils;

public class Triplet {

	public int first;
	public int second;
	public int third;

	public Triplet(int first, int second, int third){
		this.first = Math.max(Math.max(first, second), third);
		if (first == this.first){
			this.second = Math.max(second, third);
			this.third = Math.min(second, third);
		}
		else if (second == this.first){
			this.second = Math.max(first, third);
			this.third = Math.min(first, third);
		}
		else{
			this.second = Math.max(first, second);
			this.third = Math.min(first, second);
		}
	}

	@Override
	public String toString() {
		return "(" + first + ", " + second + ", " + third + ") " + (isSurprising()?"(*)":"");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + first;
		result = prime * result + second;
		result = prime * result + third;
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
		Triplet other = (Triplet) obj;
		if (first != other.first)
			return false;
		if (second != other.second)
			return false;
		if (third != other.third)
			return false;
		return true;
	}

	public int sum() {
		return first + second + third;
	}
	
	public int max() {
		return first;
	}

	public boolean isSurprising() {
		return ((Math.abs(first-second) == 2) ||
				(Math.abs(first-third) == 2) ||
				(Math.abs(second-third) == 2));
	}

}
