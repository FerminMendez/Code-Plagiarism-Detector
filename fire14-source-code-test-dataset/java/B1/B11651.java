import java.util.*;
import java.io.*;
import java.math.BigInteger;
import static java.lang.Math.*;

public class B implements Runnable {
	final String fileName = "C-small-attempt0";

	private void solution() throws IOException {
		if (!fileName.isEmpty()) {
			in = new Scanner(new FileReader(fileName + ".in"));
			out = new PrintWriter(fileName + ".out");
		}
		int n = in.nextInt();
		for (int cas = 1; cas <= n; ++cas) {
			out.printf("Case #%d: %s\n", cas, solve(in.nextInt(), in.nextInt()));
		}
	}

	private long solve(int left, int right) {
		int length = ("" + left).length();
		int p10 = (int) (Math.pow(10, length - 1) + 0.5);
		int res = 0;
		int[] used = new int[right + 1];
		for (int cur = left; cur <= right; ++cur) {
			int value = cur;
			for (int step = 0; step < length - 1; ++step) {
				value = (value % 10) * p10 + (value / 10);
				if (left <= value && value <= right && value != cur) {
					if (used[value] != cur) {
						used[value] = cur;
						++res;
					}
				}
			}
		}
		return res / 2;
	}

	public void run() {
		try {
			solution();
			in.reader.close();
			out.close();
		} catch (Throwable e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	private void debug(Object... objects) {
		System.out.println(Arrays.toString(objects));
	}

	private static class Scanner {
		private BufferedReader reader;
		private StringTokenizer tokenizer;

		public Scanner(Reader reader) {
			this.reader = new BufferedReader(reader);
			this.tokenizer = new StringTokenizer("");
		}

		public boolean hasNext() throws IOException {
			while (!tokenizer.hasMoreTokens()) {
				String line = reader.readLine();
				if (line == null) {
					return false;
				}
				tokenizer = new StringTokenizer(line);
			}
			return true;
		}

		public String next() throws IOException {
			hasNext();
			return tokenizer.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException {
			tokenizer = new StringTokenizer("");
			return reader.readLine();
		}

		public int[] nextInts(int n) throws IOException {
			int[] res = new int[n];
			for (int i = 0; i < n; ++i) {
				res[i] = nextInt();
			}
			return res;
		}

		public long[] nextLongs(int n) throws IOException {
			long[] res = new long[n];
			for (int i = 0; i < n; ++i) {
				res[i] = nextLong();
			}
			return res;
		}

		public double[] nextDoubles(int n) throws IOException {
			double[] res = new double[n];
			for (int i = 0; i < n; ++i) {
				res[i] = nextDouble();
			}
			return res;
		}

		public String[] nextStrings(int n) throws IOException {
			String[] res = new String[n];
			for (int i = 0; i < n; ++i) {
				res[i] = next();
			}
			return res;
		}
	}

	public static void main(String[] args) throws Exception {
		new Thread(null, new B(), "Main", 1 << 28).start();
	}

	private Scanner in = new Scanner(new InputStreamReader(System.in));
	private PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
}
