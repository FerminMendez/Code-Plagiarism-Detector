import static java.util.Arrays.deepToString;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
public class Solution {
	private static void debug(final Object...objs) {
		System.out.println(deepToString(objs));
	}

	private String solveCase() throws IOException {
		final int N = nextInt();
		int S = nextInt();
		final int p = nextInt();
		int res = 0;
		for (int i = 0; i < N; i++) {
			final int t = nextInt();
			final int avg = t / 3;
			if (avg >= p) {
				res++;
				continue;
			}
			if (avg + 2 < p) {
				continue;
			}
			final int mod = t % 3;
			if (mod == 0) {
				if (S > 0 && avg > 0 && avg + 1 == p) {
					res++; 
					S--;
				}
			}
			else if (mod == 1) {
				if (avg + 1 == p) res++;
			}
			else {
				if (avg + 1 == p) res++;
				else if (S > 0 && avg + 2 == p) {
					res++;
					S--;
				}
			}
		}
		return String.valueOf(res);
	}

	private void solve() throws IOException {
		final int T = nextInt();
		for (int test = 0; test < T; test++) {
			final String result = "Case #" + (test + 1) + ": " + solveCase();
			pw.println(result);
			System.out.println(result);
		}
	}

	private BufferedReader br;
	private PrintWriter pw;
	private StringTokenizer st;

	int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	String next() throws IOException {
		while (st == null || !st.hasMoreTokens()) {
			st = new StringTokenizer(br.readLine());
		}
		return st.nextToken();
	}

	public static void main(final String[] args) throws IOException {
		new Solution().run();
	}

	private void run() throws IOException {
		br = new BufferedReader(new FileReader("input.txt"));
		pw = new PrintWriter("output.txt");
		solve();
		br.close();
		pw.flush();
		pw.close();
	}
}