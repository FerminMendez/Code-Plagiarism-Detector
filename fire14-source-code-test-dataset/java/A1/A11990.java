package codejam2012;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintStream;

public class ProblemB
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
			int N = Integer.parseInt(tok[0]);
			int S = Integer.parseInt(tok[1]);
			int p = Integer.parseInt(tok[2]);
			
			// BRUTE FORCE
			int ans = 0;
			
			for (int s1 = 0; s1 <= 10; s1++)
			for (int s2 = s1; s2 <= s1+2; s2++)
			for (int s3 = s2; s3 <= s1+2; s3++)
			for (int s4 = 0; s4 <= 10; s4++)
			for (int s5 = s4; s5 <= s4+2; s5++)
			for (int s6 = s5; s6 <= s4+2; s6++)
			for (int s7 = 0; s7 <= 10; s7++)
			for (int s8 = s7; s8 <= s7+2; s8++)
			for (int s9 = s8; s9 <= s7+2; s9++)
			{
				int p1 = Integer.parseInt(tok[3]);
				int p1s = (s1+2 == s3) ? 1 : 0;
				int p1t = (s3 >= p) ? 1 : 0;
				if (s1+s2+s3 != p1) continue;
				
				if (N > 1)
				{
					int p2 = Integer.parseInt(tok[4]);
					int p2s = (s4+2 == s6) ? 1 : 0;
					int p2t = (s6 >= p) ? 1 : 0;
					if (s4+s5+s6 != p2) continue;
					
					if (N > 2)
					{
						int p3 = Integer.parseInt(tok[5]);
						int p3s = (s7+2 == s9) ? 1 : 0;
						int p3t = (s9 >= p) ? 1 : 0;
						if (s7+s8+s9 != p3) continue;
						if (p1s+p2s+p3s != S) continue;
						if (p1t+p2t+p3t > ans) ans = p1t+p2t+p3t;
					}
					else
					{
						if (p1s+p2s != S) continue;
						if (p1t+p2t > ans) ans = p1t+p2t;
					}
				}
				else
				{
					if (p1s != S) continue;
					if (p1t > ans) ans = p1t;
				}
			}
//			int with = 0, without = 0, either = 0;
//			for (int i = 3; i < tok.length; i++)
//			{
//				int total = Integer.parseInt(tok[i]);
//				
//				if (total == 0)
//				{
//					if (p == 0) without++;
//				}
//				else if (total == 1)
//				{
//					if (p <= 1) without++;
//				}
//				else if (total < 29)
//				{
//					if (total >= 3*p-2) either++;
//					else if (total >= 3*p-4) with++;
//				}
//				else without++;
//			}
//			int ans = with + without + either;
//			if (with > S) ans = S + without + either;
//			else if (S > with + either) ans = 0;
			out.printf("Case #%d: %d\n", t+1, ans);
		}
		if (out != System.out) out.close();
	}
}
