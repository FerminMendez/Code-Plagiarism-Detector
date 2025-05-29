package codejam2012;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintStream;

public class ProblemC
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader in = new BufferedReader(new FileReader("in.txt"));
		PrintStream out = System.out;
		out = new PrintStream("out.txt");
		
		int T = Integer.parseInt(in.readLine());
		
		for (int t = 0; t < T; t++)
		{
			String[] tok = in.readLine().split(" ");
			int A = Integer.parseInt(tok[0]);
			int B = Integer.parseInt(tok[1]);
			long ans = 0;
			boolean[] used = new boolean[10000000];
			int f = 1;
			while (10*f <= A) f *= 10;
			
			for (int n = A; n <= B; n++)
			{
				if (used[n]) continue;
				long k = 1;
				int m = n;
				while (!used[m])
				{
					used[m] = true;
					m = f*(m%10) + (m/10);
					if (!used[m] && m >= A && m <= B) k++;
				}
				
				ans += k * (k-1) / 2;
			}
			
			out.printf("Case #%d: %d\n", t+1, ans);
		}
		
		if (out != System.out) out.close();
	}
}
