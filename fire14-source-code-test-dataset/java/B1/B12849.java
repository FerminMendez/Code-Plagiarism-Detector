
public class RecycledPair {
	
	public int num1;
	public int num2;
	
	public RecycledPair(int n1, int n2) {
		this.num1 = n1;
		this.num2 = n2;
	}
	
	@Override
	public String toString() {
		return "(" + num1 + ", " + num2 + ")";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof RecycledPair) {
			RecycledPair other = (RecycledPair) obj;
			if((other.num1 == this.num1 && other.num2 == this.num2) || (other.num2 == this.num1 && other.num1 == this.num2)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		int prime = 31;
		return (num1 * prime) + (num2 * prime);
	}
}
