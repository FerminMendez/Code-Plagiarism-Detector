package Television;

public class Pair{
	public int a, b;
	public Pair(int a, int b)throws Exception
	{
		if(a>=b)
			throw new Exception("invalid input for pair");
		this.a=a;
		this.b=b;
	}
	
	public boolean equls(Object po)
	{
		Pair p = (Pair)po;
		if(p.a == this.a && p.b==this.b)
			return true;
		return false;
	}
	public boolean equls(Pair p)
	{		
		if(p.a == this.a && p.b==this.b)
			return true;
		return false;
	}
}
