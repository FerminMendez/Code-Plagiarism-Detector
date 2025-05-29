package qual2012;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.StringTokenizer;

public class B {
	private static final String TASKNAME = "input";

	private void solve() throws IOException {
		int Case = 0;
		for (int t = nextInt(); t > 0; t--) {
			int n = nextInt();
			int s = nextInt();
			int p = nextInt();
			
			int res = 0;
			for (int i = 0; i < n; i++) {
				int r = nextInt();
				if (r < p || (r - p) / 2 < p - 2) {
					continue;
				}

				if ((r - p) / 2 == p - 2 && s > 0) {
					s--;
					res++;
				} else if ((r - p) / 2 > p - 2) {
					res++;
				}
			}
			
			Case++;
			println("Case #" + Case + ": " + res);
		}
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
		new B().run();
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
