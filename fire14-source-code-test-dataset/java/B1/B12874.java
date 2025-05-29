import java.io.*;
import java.util.*;

public class C {
	public static void main(String[] args) {
		new C().run();
	}

	BufferedReader br;
	StringTokenizer st;
	PrintWriter out;
	boolean eof;

	public void run() {
		try {
//			br = new BufferedReader(new InputStreamReader(System.in));
//			out = new PrintWriter(System.out);
			br = new BufferedReader(new FileReader("C-small-attempt0.in"));
			out = new PrintWriter("C-small-attempt0.out");
			solve();
		} catch (Throwable e) {
			e.printStackTrace();
			System.exit(-1);
		} finally {
			out.close();
		}
	}

	String nextToken() {
		while (st == null || !st.hasMoreElements()) {
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

	final int MAX = 2000000;
	
	void solve() throws IOException {
		int n = nextInt();
		for (int test = 1; test <= n; ++test) {
			int l = nextInt();
			int r = nextInt();
			int ans = 0;
			for (int i = l; i <= r; ++i) {
				int t = 1;
				while (t <= i) t *= 10;
				t /= 10;
				int j = i;
				while (true) {
					j = (j % 10) * t + j / 10;
					if (i < j && j <= r) {
						++ans;
					}
					if (j == i) {
						break;
					}
				}
			}
			out.println("Case #" + test + ": " + ans);
		}
	}
}
