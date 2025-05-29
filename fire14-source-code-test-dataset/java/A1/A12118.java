import java.io.*;
import java.util.StringTokenizer;

public class B {
	BufferedReader in;
	StringTokenizer str;
	PrintWriter out;
	String SK;

	String next() throws IOException {
		while ((str == null) || (!str.hasMoreTokens())) {
			SK = in.readLine();
			if (SK == null)
				return null;
			str = new StringTokenizer(SK);
		}
		return str.nextToken();
	}

	int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	double nextDouble() throws IOException {
		return Double.parseDouble(next());
	}

	long nextLong() throws IOException {
		return Long.parseLong(next());
	}

	void solve() throws IOException {
		int n = nextInt();
		int s = nextInt();
		int p = nextInt();
		int res = 0;
		for (int i = 0; i < n; i++) {
			int a = nextInt();
			int lf = (a + 2) / 3;
			if (lf >= p) {
				res++;
				continue;
			}
			int t1 = lf + 1;
			int t2 = lf - 1;
			int t3 = a - t1 - t2;
			if (t3 >= t2 && t1 >= p && s > 0 && t2 >= 0 && t3 >= 0) {
				res++;
				s--;
			}
		}
		out.println(res);
	}

	void run() throws IOException {
		in = new BufferedReader(new FileReader("fn.in"));
		out = new PrintWriter("fn.out");
		int n = nextInt();
		for (int i = 0; i < n; i++) {
			out.print("Case #" + (i + 1) + ": ");
			solve();
		}
		out.close();
	}

	public static void main(String[] args) throws IOException {
		new B().run();
	}

}