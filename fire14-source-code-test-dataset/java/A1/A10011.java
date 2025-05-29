import static java.lang.Math.*;
import static java.lang.System.currentTimeMillis;
import static java.lang.System.exit;
import static java.lang.System.arraycopy;
import static java.util.Arrays.sort;
import static java.util.Arrays.binarySearch;
import static java.util.Arrays.fill;
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		new Main().run();
	}

	BufferedReader in;
	PrintWriter out;
	StringTokenizer st = new StringTokenizer("");

	private void run() throws IOException {
		in = new BufferedReader(new FileReader("input.txt"));
		out = new PrintWriter("output.txt");

		int T = nextInt();
		for (int t = 0; t < T; t++) {
			out.print("Case #" + (t + 1) + ": ");
			int n = nextInt();
			int s = nextInt();
			int p = nextInt();
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
			int ans = 0;
			for (int i = 0; i < n; i++) {
				if (a[i] == 0) {
					if (p == 0)
						ans++;
					continue;
				}
				if (a[i] % 3 == 0) {
					if (a[i] / 3 >= p) {
						ans++;
						continue;
					}
					if (a[i] / 3 + 1 >= p && s > 0) {
						ans++;
						s--;
					}
				}
				if (a[i] % 3 == 1)
					if (a[i] / 3 + 1 >= p) {
						ans++;
					}
				if (a[i] % 3 == 2) {
					if (a[i] / 3 + 1 >= p) {
						ans++;
						continue;
					}
					if (a[i] / 3 + 2 >= p && s > 0) {
						ans++;
						s--;
					}
				}
			}
			out.println(ans);
		}
		
		in.close();
		out.close();
	}

	void chk(boolean b) {
		if (b)
			return;
		System.out.println(new Error().getStackTrace()[1]);
		exit(999);
	}
	void deb(String fmt, Object... args) {
		System.out.printf(Locale.US, fmt + "%n", args);
	}
	String nextToken() throws IOException {
		while (!st.hasMoreTokens())
			st = new StringTokenizer(in.readLine());
		return st.nextToken();
	}
	int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}
	long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}
	double nextDouble() throws IOException {
		return Double.parseDouble(nextToken());
	}
	String nextLine() throws IOException {
		st = new StringTokenizer("");
		return in.readLine();
	}
	boolean EOF() throws IOException {
		while (!st.hasMoreTokens()) {
			String s = in.readLine();
			if (s == null)
				return true;
			st = new StringTokenizer(s);
		}
		return false;
	}
}
