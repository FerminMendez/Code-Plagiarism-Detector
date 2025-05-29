import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class C
{
	// small input version
	public static String next(String x)
	{
		return x.substring(1)+x.charAt(0);
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(in);
		int t = sc.nextInt();
		boolean[][] match = new boolean[1001][1001];
		for (int i = 1; i <= 1000; i++)
		{
			String str = Integer.toString(i);
			for (int j = 0; j < 4; j++)
			{
				str = next(str);
				int k = Integer.parseInt(str);
				match[Math.min(i,k)][Math.max(i,k)] = true;
			}
		}
		for (int c = 1; c <= t; c++)
		{
			int u = sc.nextInt();
			int v = sc.nextInt();
			int ctr = 0;
			for (int i = u; i <= v; i++)
			{
				for (int j = i+1; j <= v; j++)
				{
					if (match[i][j])
					{
						ctr++;
					}
				}
			}
			out.printf("Case #%d: %d\n", c, ctr);
		}
	}
}

