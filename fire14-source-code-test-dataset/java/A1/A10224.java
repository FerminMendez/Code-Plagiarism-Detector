import java.io.*;
import java.util.*;

public class PracticeB
{
	/* ここから編集 */
	private static final String fname = "B-small-attempt0.in"; // 入力用のファイル名
	public static void solve()
	{
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++)
		{
			int N = sc.nextInt();
			int S = sc.nextInt();
			int p = sc.nextInt();
			
			int tp[] = new int[N];
			int cnt = 0;
			
			for (int j = 0; j < N; j++)tp[j] = sc.nextInt();
			Arrays.sort(tp);
			int[][] ti = new int[N][3];
			for (int j = ti.length - 1; j >= 0; j--)
			{
				int tv = tp[j] / 3;
				double val = tp[j] / 3.0;
				if(val - tv < 0.5)
				{
					ti[j][0] = tv;
					ti[j][1] = tv;
					ti[j][2] = tv + 1;
				}if(val - tv > 0.5)
				{
					ti[j][0] = tv;
					ti[j][1] = tv + 1;
					ti[j][2] = tv + 1;
				}if(val - tv == 0)
				{
					ti[j][0] = tv;
					ti[j][1] = tv;
					ti[j][2] = tv;
				}
//				for (int k = 0; k < 3; k++) System.out.print(ti[j][k] + " ");
//				System.out.println();
				if(ti[j][2] >= p)
				{
					cnt++;
					continue;
				}
				if(val - tv < 0.5)
				{
					ti[j][0] = tv - 1;
					ti[j][1] = tv + 1;
					ti[j][2] = tv + 1;
					if(ti[j][2] > 10 || ti[j][0] < 0)
					{
						ti[j][0]++;
						ti[j][2]--;
					}
				}if(val - tv > 0.5)
				{
					ti[j][0] = tv;
					ti[j][1] = tv;
					ti[j][2] = tv + 2;
					while(ti[j][2] > 10 || ti[j][0] < 0)
					{
						ti[j][0] = tv++;
						ti[j][2] = tv--;
					}
				}if(val - tv == 0)
				{
					ti[j][0] = tv - 1;
					ti[j][1] = tv;
					ti[j][2] = tv + 1;
					if(ti[j][2] > 10 || ti[j][0] < 0)
					{
						ti[j][0]++;
						ti[j][2]--;
					}
				}
				if(S > 0 && ti[j][2] >= p)
				{
					cnt++;
					S--;
				}
			}
//			System.
			out.println("Case #" + i + ": " + cnt);
		}
	}
	/* ここまで */

	private static Scanner sc;
	private static PrintWriter out;
	public static void main(String args[])
	{
		try
		{
			sc = new Scanner(new File(fname));
//			sc = new Scanner(System.in);
			out = new PrintWriter(new BufferedWriter(new FileWriter(new File(fname + "_out.dat"))));
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		solve();
		out.close();
	}

}
