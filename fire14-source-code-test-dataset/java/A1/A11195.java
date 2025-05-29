import java.io.*;
import java.util.*;

public class B {

	public static void main(String[] args) {
		new B().run();
	}

	BufferedReader br;
	StringTokenizer st;
	PrintWriter out;
	boolean eof = false;
	Random rand = new Random(1235446);

	private void run() {
		try {
			br = new BufferedReader(new FileReader(FNAME + ".in"));
			out = new PrintWriter(FNAME + ".out");
			solve();
			out.close();
		} catch (Throwable e) {
			e.printStackTrace();
			System.exit(566);
		}
	}

	String nextToken() {
		while (st == null || !st.hasMoreTokens()) {
			try {
				st = new StringTokenizer(br.readLine());
			} catch (Exception e) {
				eof = true;
				return "0";
			}
		}
		return st.nextToken();
	}

	int nextInt() {
		return Integer.parseInt(nextToken());
	}

	long nextLong() {
		return Long.parseLong(nextToken());
	}

	double nextDouble() {
		return Double.parseDouble(nextToken());
	}

	String FNAME = "b";

	private void solve() throws IOException {
		int tests = nextInt();
		for (int test = 1; test <= tests; test++) {
			out.print("Case #" + test + ": ");
			int n = nextInt();
			int s = nextInt();
			int p = nextInt();
			int[] a = new int[n];
			for (int i = 0; i < a.length; i++) {
				a[i] = nextInt();
			}
			int good = 0;
			int almost = 0;
			int b1 = p + 2 * Math.max(p - 1, 0);
			int b2 = p + 2 * Math.max(p - 2, 0);
			for (int i = 0; i < a.length; i++) {
				if (a[i] >= b1) {
					good++;
				} else if (a[i] >= b2) {
					almost++;
				}
			}
			int ans = good + Math.min(almost, s);
			out.println(ans);
		}
	}

}
