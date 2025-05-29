
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Vector;

public class C {

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner scan = new Scanner(new File("C-small-attempt0.in"));
		PrintWriter out = new PrintWriter(new File("out.txt"));
		int cases = scan.nextInt();
		for (int r = 1; r <= cases; r++)
		{
			int a = scan.nextInt();
			int b = scan.nextInt();

			Vector<Integer>[] v = new Vector[b + 1];
			for (int i = 0; i < v.length; i++)
				v[i] = new Vector<Integer>();

			long ret = 0;
			for (int n = a; n <= b; n++)
			{
				String sn = n + "";
				for (int j = sn.length()-1; j > 0; j--)
				{
					String sm = sn.substring(j) + sn.substring(0, j);
					int m = Integer.parseInt(sm);
					sm = m + "";
					if (sm.length() == sn.length() && m <= b && m > n)
					{
						if (!v[n].contains(m))
						{
							v[n].add(m);
							v[m].add(n);
							ret++;
						}
					}
				}
			}
			out.println("Case #" + r + ": " + ret);
		}

		out.close();
		scan.close();
	}

}
