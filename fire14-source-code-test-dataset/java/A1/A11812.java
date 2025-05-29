import java.io.*;
import java.util.*;

public class Second2
{
	public static void main(String[]args)throws Exception
	{
		BufferedReader br = new BufferedReader(new FileReader("B-small-attempt3.in"));
		PrintWriter pw = new PrintWriter(new File("B-small-attempt3.out"));
		StringTokenizer st;
		int cases = Integer.parseInt(br.readLine());
		for(int c = 0; c < cases; c++)
		{
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int [] totals = new int[n];
			int s = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			for(int i = 0; i < n; i++)
				totals[i] = Integer.parseInt(st.nextToken());
			Arrays.sort(totals);
			int res = 0;
				
			for(int i = 0; i < n; i++)
			{
				outer:for(int j = p; j <= totals[i]; j++)
				{
					for(int k = j-2; k <= j; k++)
					{
						if(k < 0)
							continue;
						for(int l = j-2; l <= j; l++)
						{
							if(l < 0)
								continue;
							//System.out.println(j + " " + k + " " + l);
							//if(j+k+l > totals[i])
								//break outer;
							if(j+k+l == totals[i])
							{
								if(j-k == 2 || j-l == 2)
								{
									
									if(s > 0)
										s--;
									else
										continue;
								}
								//System.out.println(j + " " + k + " " + l);
								res++;
								break outer;
							}
						}
					}
				}
			}
			pw.printf("Case #%d: %d\n", c+1, res);
		}
		pw.close();
		pw.flush();
		/*
		for(int i = 0; i < totals.length; i++)
		{
			for(int j = 0; j <= s; j++)
				System.out.println(dp[i][j]);
		}*/
		//System.out.println(dp[totals.length-1][s]);
	}
}