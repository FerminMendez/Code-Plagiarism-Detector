package MyAllgoritmicLib;

public class NOK {
	public static int lcm (int a, int b)
	{
		return a * b / NOD.gcd (a, b);
	}
	
	public static long lcm (long a, long b)
	{
		return a * b / NOD.gcd (a, b);
	}
	
	public static double lcm (double a, double b)
	{
		return a * b / NOD.gcd (a, b);
	}
}
