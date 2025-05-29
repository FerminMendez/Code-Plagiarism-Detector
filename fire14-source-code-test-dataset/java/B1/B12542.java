import java.util.*;
import java.io.*;

//import java.math.*;

public class SolC implements Runnable {
	public static void main(String[] args) {
		new Thread(new SolC()).start();
	}

	@Override
	public void run() {
		try {
			br = new BufferedReader(new FileReader(FNAME + ".in"));
			out = new PrintWriter(FNAME + ".out");
			solve();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	BufferedReader br;
	StringTokenizer st;
	PrintWriter out;
	boolean eof = false;

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

	double nextDouble() {
		return Double.parseDouble(nextToken());
	}

	long nextLong() {
		return Long.parseLong(nextToken());
	}

	private final String FNAME = "C-small";
	
	boolean good(int x, int y) {
		String sx = Integer.toString(x);
		String sy = Integer.toString(y);
		if (sx.length() != sy.length()) return false;
		for (int i = 1; i < sx.length(); i++) {
			String ts = sx.substring(i, sx.length()) + sx.substring(0, i);
			if (ts.equals(sy)) return true;
		}
		return false;
	}

	void solve() {
		int tests = nextInt();
		for (int test = 1; test <= tests; test++) {
			System.err.println("Test: " + test);
			int a = nextInt();
			int b = nextInt();
			int ans = 0;
			for (int i = a; i <= b; i++) {
				for (int j = i + 1; j <= b; j++) {
					if (good(i, j)) {
//						System.err.println(i + " " + j);
						ans++;
					}
				}
			}
			out.println("Case #" + test + ": " + ans);
		}
	}
}
