import java.io.File;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

public class B {

	final static String PREFIX = "C:\\codejam\\B";
	// final static String FILE_NAME = PREFIX + "-test";
	final static String FILE_NAME = PREFIX + "-small-attempt0";
	// final static String FILE_NAME = PREFIX + "-large";

	private Scanner in;
	private PrintWriter out;

	public static void main(String[] args) throws Exception {
		Locale.setDefault(Locale.US);
		new B().solveAll();
	}

	private void solveAll() throws Exception {
		in = new Scanner(new File(FILE_NAME + ".in"));
		out = new PrintWriter(new File(FILE_NAME + ".out"));
		int tcn = in.nextInt();
		for (int tc = 1; tc <= tcn; tc++) {
			solve(tc);
		}
		out.close();
	}

	private void solve(int tc) {
		int n = in.nextInt();
		int s = in.nextInt();
		int p = in.nextInt();
		int[] t = new int[n];
		for (int i = 0; i < n; i++) {
			t[i] = in.nextInt();
		}

		int res = 0;
		for (int i = 0; i < n; i++) {
			int max = t[i] / 3;
			int x = t[i] - max * 3;
			if (x > 0) {
				max++;
			}
			if (max >= p) {
				res++;
			} else if (s > 0) {
				if (x == 2 || (x == 0 && t[i] != 0)) {
					max++;
				}
				if (max >= p) {
					res++;
					s--;
				}
			}
		}
		out.format("Case #%d: %s\n", tc, res);
		System.out.format("Case #%d: %s\n", tc, res);
	}
}
