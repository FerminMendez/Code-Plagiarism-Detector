import java.util.Scanner;

public class DWG
{
	public static int[] SuspA = null;
	public static int[] nonSuspA = null;

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{

		Scanner scnr = new Scanner(System.in);
		int T = scnr.nextInt();
		for (int t = 1; t <= T; t++)
		{

			int N = scnr.nextInt();
			int S = scnr.nextInt();
			int p = scnr.nextInt();

			SuspA = new int[N];
			nonSuspA = new int[N];

			int ans = 0;
			int suspCount = 0;

			for (int n = 0; n < N; n++)
			{
				int x = scnr.nextInt();
				calcCombs(x, p, n);
				 //System.out.printf ( "a (%d) b (%d) \n" , SuspA[n], nonSuspA[n]);

				if (nonSuspA[n] > 0)
				{
					ans++;
				} else
				{
					if (SuspA[n] > 0 && suspCount < S)
					{
						ans++;
						suspCount++;
					}
				}
			}
			System.out.println("Case #" + t + ": " + ans);
			// System.out.printf("Case #%d: %d\n", t, ans);
		}
	}

	private static void calcCombs(int n, int p, int index)
	{
		int sum = n;
		int minP = p;
		int susp = 0;
		int nonSusp = 0;
		for (int i = 0; i <= 10; i++)
		{
			for (int j = 0; j <= 10; j++)
			{
				for (int k = 0; k <= 10; k++)
				{
					if (i + j + k == sum)
					{
						if (i >= minP || j >= minP || k >= minP)
						{
							if (Math.abs(i - j) > 2 || Math.abs(j - k) > 2  || Math.abs(i - k) > 2 )
							{
								continue;
							}
							if (Math.abs(i - j) == 2 || Math.abs(j - k) == 2  || Math.abs(i - k) == 2 )
							{
								if (i == j && j == k)
								{
									susp = susp + 3;
								} else
								{
									susp++;
								}
								//System.out.printf(" susp (%d)(%d)(%d) \n ", i , j, k);
							} else
							{
								if (i == j && j == k)
								{
									nonSusp = nonSusp + 3;
								} else
								{
									nonSusp++;
								}
								nonSusp++;
								//System.out.printf(" nonsusp (%d)(%d)(%d) \n ", i , j, k);
							}
						}
					}
				}
			}
		}
		 //System.out.printf("susp: %d nonsusp: %d", susp/3, nonSusp/3);
		SuspA[index] = susp / 3;
		nonSuspA[index] = nonSusp / 3;
	}

}
