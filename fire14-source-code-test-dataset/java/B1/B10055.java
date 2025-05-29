package code_jam_2012_qualification_round;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class C {
	
	public static void main(String[] args) throws IOException 
	{
		long startTime = System.currentTimeMillis();
		BufferedReader f = new BufferedReader(new FileReader("C-small-attempt0.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C-small-attempt0.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		for(int t = 1; t <= T; t++)
		{
			st = new StringTokenizer(f.readLine());
			int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken());
			boolean[] used = new boolean[B+1];
			int sum = 0;
			for(int i = A; i <= B; i++)
			{
				if (used[i]) continue;
				String s = "" + i;
				int c = 1;
				used[i] = true;
				for(int j = 1; j < s.length(); j++)
				{
					int a = Integer.parseInt(s.substring(j) + s.substring(0, j));
					if (a <= B && a >= A && !used[a])
					{
						c++;
						//out.println(i + " and " + a);
						used[a] = true;
					}
				}
				sum += c*(c-1)/2;
			}
			out.println("Case #" + t + ": " + sum);
			System.out.println("Case #" + t + ": " + sum);
		}
		out.close();
	}
}
