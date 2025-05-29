package MyAllgoritmicLib;

public class NOD {
	public static int gcd (int a, int b)
	{
		if (b == 0)
			return a;
		else
			return gcd (b, a % b);
	}
	
	public static long gcd (long a, long b)
	{
		if (b == 0)
			return a;
		else
			return gcd (b, a % b);
	}
	
	public static double gcd (double a, double b)
	{
		if (b == 0)
			return a;
		else
			return gcd (b, a % b);
	}
}
