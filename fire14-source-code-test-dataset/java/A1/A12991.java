import java.io.*;
import java.util.*;

public class DancingWithGooglers {

	void solve() throws Exception {
		int n = nextInt();
		int s = nextInt();
		int p = nextInt();
		int[] t = new int[n];
		for (int i = 0; i < n; i++) {
			t[i] = nextInt();
		}

		if (p == 0) {
			out.println(n);
			return;
		}

		int cutOff1 = p + 2 * (p - 1);
		int cutOff2 = p + 2 * Math.max(0, p - 2);
		int count1 = 0, count2 = 0;
		for (int i = 0; i < n; i++) {
			if (t[i] >= cutOff1) {
				count1++;
			} else if (t[i] >= cutOff2) {
				count2++;
			}
		}
		int ans = count1 + Math.min(count2, s);
		out.println(ans);
	}

	void run() {
		try {
			in = new BufferedReader(new FileReader("input.txt"));
			out = new PrintWriter("output.txt");
			int tests = nextInt();
			for (int i = 0; i < tests; i++) {
				out.print("Case #" + (i + 1) + ": ");
				solve();
			}
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	BufferedReader in;
	StringTokenizer st;
	PrintWriter out;
	final String filename = new String("DancingWithGooglers").toLowerCase();

	String nextToken() throws Exception {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(in.readLine());
		return st.nextToken();
	}

	int nextInt() throws Exception {
		return Integer.parseInt(nextToken());
	}

	long nextLong() throws Exception {
		return Long.parseLong(nextToken());
	}

	double nextDouble() throws Exception {
		return Double.parseDouble(nextToken());
	}

	public static void main(String[] args) {
		new DancingWithGooglers().run();
	}

}
