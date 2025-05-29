import java.io.*;
import java.util.*;

public class C {

	public static void main(String[] args) {
		new C().run();
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

	String FNAME = "c";

	private void solve() throws IOException {
		long time = System.currentTimeMillis();
		int tests = nextInt();
		for (int test = 1; test <= tests; test++) {
			System.out.println(test + " " + (System.currentTimeMillis() - time) / 1000.0);
			out.print("Case #" + test + ": ");
			int a = nextInt();
			int b = nextInt();
			long ans = 0;
			boolean[] q = new boolean[b + 1];
			for (int i = a; i <= b; i++) {
				if (q[i]) {
					continue;
				}
				long cnt = 0;
				String s = "" + i;
				for (int j = 0; j < s.length(); j++) {
					int x = Integer.parseInt(s);
					if (a <= x && x <= b && !q[x] && !s.startsWith("0")) {
						q[x] = true;
						cnt++;
					}
					s = s.substring(1) + s.charAt(0);
				}
				ans += cnt * (cnt - 1) / 2;
			}
			out.println(ans);
		}
	}

}
