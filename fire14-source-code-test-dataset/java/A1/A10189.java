import java.io.*;
import java.util.*;

public class surprise
{

	public static StringTokenizer st;

	public static void main(String[] args)
	{
		try
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("B-small-attempt0.in")));
			PrintWriter pw = new PrintWriter(new FileWriter("output.out"));
			int T = Integer.parseInt(br.readLine());
			int t = 1;
			while (t <= T)
			{
				st = new StringTokenizer(br.readLine(), " ", false);
				int N = Integer.parseInt(st.nextToken());
				int S = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				
				int tot = 0;
				if (p == 0) tot = N;
				else
				{
					for (int i = 0; i < N; i++)
					{
						int s = Integer.parseInt(st.nextToken());
						if (s >= p+2*(p-1)) tot++;
						else if (S > 0 && p >= 2 && s >= p+2*(p-2))
						{
							tot++;
							S--;
						}
					}
				}
				
				pw.println("Case #"+t+": "+tot);
				t++;
			}
			pw.flush();
			pw.close();
			br.close();
		}
		catch (IOException ie)
		{
			ie.printStackTrace();
		}
	}

}