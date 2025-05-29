import java.io.*;
import java.util.*;

public class Main {
//	static Scanner in; static int next() throws Exception {return in.nextInt();};
	static StreamTokenizer in; static int next() throws Exception {in.nextToken(); return (int) in.nval;}
	static PrintWriter out;
	static String NAME = "b";

	public static void main(String[] args) throws Exception {
//		in = new Scanner(new File(NAME + ".in"));
		out = new PrintWriter(new File(NAME + ".out"));
		in = new StreamTokenizer(new BufferedReader(new FileReader(new File(NAME + ".in"))));

		int tests = next();
		int inf = 1000000;

		for (int test = 1; test <= tests; test++) {
			int n = next();
			int s = next();
			int p = next();
			int[] t = new int[n];
			for (int i = 0; i < n; i++) t[i] = next();

			int[][] max = new int[n + 1][n + 1];
			for (int[] mm : max) Arrays.fill(mm, -inf);
			max[0][0] = 0;

            for (int i = 0; i < n; i++)
            	for (int j = 0; j < n; j++) {
            		if (t[i] <= (p - 1) * 3) max[i + 1][j] = Math.max(max[i + 1][j], max[i][j]);
            		if (2 <= t[i] && t[i] <= (p - 1) * 3 - 2) max[i + 1][j + 1] = Math.max(max[i + 1][j + 1], max[i][j]);
            		if (p + 2*Math.max(p - 2, 0) <= t[i] && t[i] <= 28) max[i + 1][j + 1] = Math.max(max[i + 1][j + 1], max[i][j] + 1);
            		if (3*p - 2 <= t[i]) max[i + 1][j] = Math.max(max[i + 1][j], max[i][j] + 1);
            	}

			out.print("Case #" + test + ": ");
			out.println(max[n][s]);

		}
		
		out.close();
	}
}