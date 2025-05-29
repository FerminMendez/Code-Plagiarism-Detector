import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class B
{
	// non-surprising
	public static int best1(int x)
	{
		if (x%3 == 0) return x/3;
		else return x/3+1;
	}
	// surprising
	public static int best2(int x)
	{
		if (x == 0) return 0;
		return (x+1)/3+1;
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(in);
		int t = sc.nextInt();
		for (int c = 1; c <= t; c++)
		{
			int n = sc.nextInt();
			int s = sc.nextInt();
			int p = sc.nextInt();
			int[] arr = new int[31];
			for (int i = 0; i < n; i++) arr[sc.nextInt()]++;
			int ctr = 0;
			for (int i = 30; i >= 0; i--)
			{
				if (best1(i) >= p)
				{
					ctr += arr[i];
				}
				else
				{
					if (i > 1 && best2(i) >= p)
					{
						ctr += Math.min(s, arr[i]);
						if (s > arr[i]) s -= arr[i];
						else s = 0;
					}
				}
			}
			out.printf("Case #%d: %d\n", c, ctr);
		}
	}
}
