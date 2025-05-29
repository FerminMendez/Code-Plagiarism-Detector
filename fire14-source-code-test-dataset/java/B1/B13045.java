
public class Par {

	Integer A,B;
	
	public Par(Integer a,Integer b)
	{
		A=a;
		B=b;
	}
	
	public boolean equals(Object o) {
		boolean res=false;
		Par P=(Par) o;
		if ((P.A.equals(A) && P.B.equals(B))||(P.A.equals(B) && P.B.equals(A)))
		{
			res=true;
		}
		return res;
	}

	public int hashCode() {
		return (A*B+A.hashCode()+B.hashCode());
	}
	
	public String toString()
	{
		return "("+A+", "+B+")";
	}

}
