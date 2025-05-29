
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class B {

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner scan = new Scanner(new File("B-small-attempt0.in"));
		PrintWriter out = new PrintWriter(new File("out.txt"));

		int cases = scan.nextInt();
		for (int r = 1; r <= cases; r++)
		{
			int n = scan.nextInt();
			int s = scan.nextInt();
			int p = scan.nextInt();

			int ok = 3 * p - 2;
			int sur = Math.max(3 * p - 4, 1);

			int ret = 0;
			int ss = 0;
			for (int i = 0; i < n; i++)
			{
				int a = scan.nextInt();
				if (a >= ok)
					ret++;
				else if (a >= sur)
					ss++;
			}

			out.println("Case #" + r + ": " + (ret + Math.min(s, ss)));
		}

		out.close();
		scan.close();
	}

}
