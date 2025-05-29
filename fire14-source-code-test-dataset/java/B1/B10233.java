import java.io.*;
import java.util.*;

public class PracticeC
{
	/* ここから編集 */
	private static final String fname = "C-small-attempt3.in"; // 入力用のファイル名
//	private static final int N = 10000;

	// private static void search(int v)
	// {
	// if (v < 21)
	// return;
	// String in = Integer.toString(v);
	// for (int i = 0; i < in.length(); i++)
	// {
	// String vs = "";
	// for (int j = 0; j < in.length(); j++)
	// {
	// char n = in.charAt((i + j + 1) % in.length());
	// if (vs.equals("") && n == '0')
	// break;
	// vs += n;
	// }
	// // System.out.println(v2);
	// if (vs.equals(""))
	// continue;
	// int v2 = Integer.valueOf(vs);
	// if (v > v2) val[v]++;
	// }
	// }

	private static void search(int v, int A, int B)
	{
		use = new boolean[B+1];
		String in = Integer.toString(v);
		for (int i = 0; i < in.length(); i++)
		{
			String vs = "";
			for (int j = 0; j < in.length(); j++)
			{
				char n = in.charAt((i + j + 1) % in.length());
				if (vs.equals("") && n == '0')
					break;
				vs += n;
			}
			// System.out.println(v2);
			if (vs.equals(""))
				continue;
			int v2 = Integer.valueOf(vs);
			if (v2 >= A && v > v2 && !use[v2])
			{
				use[v2] = true;
				val[v]++;
			}
		}
	}
	public static int val[];
	public static boolean use[];

	public static void solve()
	{
		int T = sc.nextInt();
		// for (int i = 21; i < val.length; i++) search(i);
		// for (int i = 0; i < 100; i++) if(val[i] != 0)
		// System.out.println(i+":"+val[i]);
		for (int i = 1; i <= T; i++)
		{
			int A = sc.nextInt();
			int B = sc.nextInt();
			val = new int[B+1];
			for (int j = A; j <= B; j++)
				search(j, A, B);
			int cnt = 0;
			for (int j = A; j <= B; j++)
			{
//				if(val[j] != 0) System.out.println(j+":"+val[j]);
				cnt += val[j];
			}
//			System.
			out.println("Case #" + i + ": " + (cnt));
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
