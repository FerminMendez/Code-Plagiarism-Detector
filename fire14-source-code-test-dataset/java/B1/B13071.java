
public class Couple {

	int a;
	int b;
	String s;
	
	public Couple(int a, int b) {
		super();
		this.a = a;
		this.b = b;
		s = String.valueOf(a) + String.valueOf(b);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Couple other = (Couple) obj;
		if (a == other.a && b == other.b)
			return true;
		if (a == other.b && b == other.a)
			return true;
		return false;
	}
	
	
}
