import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C {
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

	String make(int j) {
		String a = j + "";
		String res = a;
		for (int i = 0; i < a.length(); i++) {
			if (a.compareTo(res) < 0) {
				res = a;
			}
			char c = a.charAt(0);
			a = a.substring(1, a.length()) + "" + c;
		}
		return res;
	}

	void solve() throws IOException {
		int a = nextInt();
		int b = nextInt();
		int res = 0;
		for (int i = a; i <= b; i++) {
			for (int j = i + 1; j <= b; j++) {
				if (make(i).equals(make(j))) {
					res++;
				}
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
		new C().run();
	}

}