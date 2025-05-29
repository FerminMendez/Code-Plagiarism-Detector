package MyAllgoritmicLib;

public class BinaryPower {
	public static int binpow (int a, int n)
	{
		int r = 1;
		while (n > 0)
			if (n % 2 == 0)
			{
				a *= a;
				n /= 2;
			}
			else
			{
				r *= a;
				--n;
			}
		return r;
	}
	
	public static long binpow (long a, int n)
	{
		long r = 1;
		while (n > 0)
			if (n % 2 == 0)
			{
				a *= a;
				n /= 2;
			}
			else
			{
				r *= a;
				--n;
			}
		return r;
	}
	
	public static double binpow (double a, int n)
	{
		double r = 1;
		while (n > 0)
			if (n % 2 == 0)
			{
				a *= a;
				n /= 2;
			}
			else
			{
				r *= a;
				--n;
			}
		return r;
	}
}
