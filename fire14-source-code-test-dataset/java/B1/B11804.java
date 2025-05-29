package qual2012;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.StringTokenizer;

public class C {
	private static final String TASKNAME = "input";

	private void solve() throws IOException {
		int t = nextInt();
		for (int i = 1; i <= t; i++) {
			int a = nextInt();
			int b = nextInt();
			
			int res = 0;
			for (int j = a; j < b; j++) {
				res += f(j, b);
			}
			
			println("Case #" + i + ": " + res);
		}
	}
	
	private int f(int n, int b) {
		Set<Integer> set = new HashSet<Integer>();
		int res = 0;
		int l = Integer.toString(n).length();
		int p = 1;
		while (p <= n) {
			p *= 10;
		}
		p /= 10;
		int m = n;
		for (int i = 1; i < l; i++) {
			int x = m / 10 + (m % 10) * p;
			if (x > n && x <= b) {
				set.add(x);
//				res++;
//				System.err.println(n + " " + x);
			}
			m = x;
		}
		
//		return res;
		return set.size();
	}

	private String nextToken() throws IOException {
		while (tokenizer == null || !tokenizer.hasMoreTokens()) {
			tokenizer = new StringTokenizer(reader.readLine());
		}
		return tokenizer.nextToken();
	}

	private int nextInt() throws NumberFormatException, IOException {
		return Integer.parseInt(nextToken());
	}

	private double nextDouble() throws NumberFormatException, IOException {
		return Double.parseDouble(nextToken());
	}

	private long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}

	private void print(Object o) {
		writer.print(o);
	}

	private void println(Object o) {
		writer.println(o);
	}

	private void printf(String format, Object... o) {
		writer.printf(format, o);
	}

	public static void main(String[] args) {
		long time = System.currentTimeMillis();
		Locale.setDefault(Locale.US);
		new C().run();
		System.err.printf("%.3f\n", 1e-3 * (System.currentTimeMillis() - time));
	}

	BufferedReader reader;
	StringTokenizer tokenizer;
	PrintWriter writer;

	private void run() {
		try {
			reader = new BufferedReader(new InputStreamReader(System.in));
			writer = new PrintWriter(System.out);
			reader = new BufferedReader(new FileReader(TASKNAME + ".in"));
			writer = new PrintWriter(TASKNAME + ".out");
			solve();
			reader.close();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(13);
		}
	}
}