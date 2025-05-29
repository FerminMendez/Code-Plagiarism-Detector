package qualification;

public class Pair implements Comparable{
	int n;

	int m;

	public Pair(int n, int m){
		this.n = n;
		this.m = m;
	}

	@Override
	public boolean equals(Object obj){
		if(n == 1212)
			System.out.println("1");

		if(obj == null)return false;

		Pair other = (Pair)obj;
		if(n == other.n && m == other.m){
			return true;
		}
		return false;
	}

	public int hashCode() {
		int hash = 1;
	    hash = hash * 31 + new Integer(n).hashCode();
	    hash = hash * 31 + new Integer(m).hashCode();
		return  hash;
	}

	@Override
	public String toString(){
		return "(" + n + ", " + m + ")";
	}

	@Override
	public int compareTo(Object other){
		Pair p = (Pair)other;
		if(this.n == p.n)
			return new Integer(m).compareTo(new Integer(p.m));
		else
			return new Integer(n).compareTo(new Integer(p.m));
	}
}
