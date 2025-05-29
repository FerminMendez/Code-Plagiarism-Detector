import java.io.File;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

public class C {

	final static String PREFIX = "C:\\codejam\\C";
//	final static String FILE_NAME = PREFIX + "-test";
	 final static String FILE_NAME = PREFIX + "-small-attempt0";
	// final static String FILE_NAME = PREFIX + "-large";

	private Scanner in;
	private PrintWriter out;

	public static void main(String[] args) throws Exception {
		Locale.setDefault(Locale.US);
		new C().solveAll();
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
		int a = in.nextInt();
		int b = in.nextInt();

		long res = 0;
		for (int i = a; i <= b; i++) {
			String is = String.valueOf(i);
			Set<Integer> set = new HashSet<Integer>();
			for (int j = 1; j < is.length(); j++) {
				String x = is.substring(j) + is.substring(0, j);
				if (x.startsWith("0")) {
					continue;
				}
				int c = Integer.parseInt(x);
				if (c > i && c <= b) {
					set.add(c);
				}
			}
			res += set.size();
		}

		out.format("Case #%d: %s\n", tc, res);
		System.out.format("Case #%d: %s\n", tc, res);
	}
}
