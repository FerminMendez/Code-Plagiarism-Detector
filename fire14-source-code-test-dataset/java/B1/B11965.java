import java.util.*;
import java.io.*;

import static java.lang.Math.*;

public class Main {

	BufferedReader in;
	StringTokenizer st;
	PrintWriter out;

	private String inFilename = "in.txt";
	private String outFilename = "out.txt";

	boolean can(int a, int b) {
		String s1 = String.valueOf(a);
		String s2 = String.valueOf(b);
		if (s1.length() != s2.length())
			return false;
		for (int i = 1; i < s1.length(); ++i) {
			String q = s1.substring(i) + s1.substring(0, i);
			if (q.equals(s2))
				return true;
		}
		return false;
	}

	void solve() throws IOException {
		int n = ni();
		for (int t = 1; t <= n; ++t) {
			int a = ni();
			int b = ni();
			int ret = 0;
			for (int i = a; i <= b; ++i)
				for (int j = i + 1; j <= b; ++j) {
					if (can(i, j))
						++ret;
				}
			out.println("Case #" + t + ": " + ret);
		}
	}

	public Main() throws IOException {
		Locale.setDefault(Locale.US);
		in = new BufferedReader(new FileReader(inFilename));
		out = new PrintWriter(outFilename);
		solve();
		in.close();
		out.close();
	}

	String ns() throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(in.readLine());
		return st.nextToken();
	}

	int ni() throws IOException {
		return Integer.valueOf(ns());
	}

	double nd() throws IOException {
		return Double.valueOf(ns());
	}

	long nl() throws IOException {
		return Long.valueOf(ns());
	}

	public static void main(String[] args) throws IOException {
		new Main();
	}
}
