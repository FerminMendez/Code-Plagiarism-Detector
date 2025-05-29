package Round1;

/*
 ID: kevinle7
 LANG: JAVA
 TASK: dancing
 */
import java.io.*;
import java.util.*;

class dancing
{	
	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("dancing.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("dancing.out")));
		int t = Integer.parseInt(f.readLine());
		for (int i = 0 ; i < t; i++)
		{
			StringTokenizer st = new StringTokenizer(f.readLine());
			int n = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			int ans = 0;
			int poss = 0;
			int goodscore = 3*p - 2;
			int okayscore = 3*p - 4;
			if (p == 1)
				okayscore = 1;
			for (int j = 0; j < n; j++)
			{
				int score = Integer.parseInt(st.nextToken());
				if (score >= goodscore)
					ans++;
				else if (score >= okayscore)
					poss++;
			}
			if (poss < s)
				ans += poss;
			else
				ans += s;
			out.println("Case #" + (i+1) + ": "  + ans);
		}
		out.close();
		System.exit(0);
	}
	
}