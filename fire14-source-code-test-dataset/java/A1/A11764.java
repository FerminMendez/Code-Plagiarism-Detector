import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.exit;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class Dancing {

	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer tok;

	static int nextInt() throws IOException {
		return parseInt(next());
	}

	static long nextLong() throws IOException {
		return parseLong(next());
	}

	static double nextDouble() throws IOException {
		return parseDouble(next());
	}

	static String next() throws IOException {
		while (tok == null || !tok.hasMoreTokens()) {
			tok = new StringTokenizer(in.readLine());
		}
		return tok.nextToken();
	}
	
	static String nextLine() throws IOException {
		return in.readLine();
	}
	
	static char at(String s, int i) {
		return s.charAt(i);
	}

	public static void main(String[] args) {
		try {
			in = new BufferedReader(new InputStreamReader(new FileInputStream("B-small-attempt0.in")));
			out = new PrintWriter(new OutputStreamWriter(new FileOutputStream("B-out")));
//			in = new BufferedReader(new InputStreamReader(System.in));
//			out = new PrintWriter(new OutputStreamWriter(System.out));
			solve();
			in.close();
			out.close();
		} catch (Throwable e) {
			e.printStackTrace();
			exit(1);
		}
	}

	private static void solve() throws IOException {
		int t = nextInt();
		for (int i = 0; i < t; i ++) {
			int id = i+1;
			int n = nextInt();
			int s = nextInt();
			int p = nextInt();
			int[] g = new int[n];
			for (int j = 0; j < n; j ++) {g[j] = nextInt();}
			if (p == 0) {
				out.println("Case #" + id + ": " + n);
				continue;
			}
			if (p == 1) {
				int res = 0;
				for (int j = 0; j < n; j ++) {
					if (g[j] > 0) res ++;
				}
				out.println("Case #" + id + ": " + res);
				continue;
			}
			int low = p * 3 - 4;
			int high = low + 1;
			int sup = 0;
			int qual = 0;
			for (int j = 0; j < n; j ++) {
				if (g[j] == 0) continue;
				if (g[j] < low) continue;
				if (g[j] > high) qual ++;
				else sup ++;
			}
			sup = Math.min(sup, s);
			out.println("Case #" + id + ": " + (sup + qual));
		}
	}
}