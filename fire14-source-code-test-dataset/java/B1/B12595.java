import static java.util.Arrays.deepToString;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
public class Solution {
	private static void debug(final Object...objs) {
		System.out.println(deepToString(objs));
	}

	int rotate(int n, int d) {
		int f = n / d;
		return (n - f * d) * 10 + f;
	}

	class Pair{
		Set<Integer> elems = new HashSet<Integer>();
		Pair(final int first, final int second) {
			elems.add(first);
			elems.add(second);
		}
		@Override
		public int hashCode() {
			return elems.hashCode();
		}
		@Override
		public boolean equals(final Object obj) {
			if (this == obj) return true;
			if (!(obj instanceof Pair)) return false;
			final Pair other = (Pair) obj;
			return elems.equals(other.elems);
		}
	}


	private String solveCase() throws IOException {
		final int A = nextInt();
		final int B = nextInt();
		int d = 1;
		int N = 1;
		while (d * 10 <= A) {
			d *= 10;
			N++;
		}
		int res = 0;
		Set<Pair> all = new HashSet<Pair>();
		for (int j = A; j <= B; j++) {
			Set<Integer> ns = new HashSet<Integer>();
			int x = rotate(j, d);
			for (int i = 0; i < N; i++) {
				if (A <= x && x <= B) ns.add(x);
				x = rotate(x, d);
			}
			int[] as = new int[ns.size()];
			int i = 0;
			for (Integer it : ns) {
				as[i++] = it;
			}
			for (int m = 0; m < as.length - 1; m++) {
				for (int n = m + 1; n < as.length; n++) {
					all.add(new Pair(as[m], as[n]));
				}
			}
		}
		return String.valueOf(all.size());
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