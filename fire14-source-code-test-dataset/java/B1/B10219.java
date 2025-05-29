import static java.util.Arrays.deepToString;

import java.io.*;
import java.math.*;
import java.util.*;

public class C {

	static int solve() {
		int A = nextInt(), B = nextInt();
		int res = 0;
		HashSet<Long> set = new HashSet<>();
		for (int m = A; m <= B; m++) {
			String w = m + "";
			for (int i = 0; i < w.length() - 1; i++) {
				int x = Integer.parseInt(w.substring(i + 1) + w.substring(0, i + 1));
				if (m < x && x <= B) {
					set.add(((long) x << 30) | m);
				}
			}
		}
		return set.size();
	}

	public static void main(String[] args) throws Exception {
		reader = new BufferedReader(new FileReader("c.in"));
		writer = new PrintWriter("c.out");

		int T = nextInt();
		for (int i = 0; i < T; i++) {
			setTime();
			int res = solve();
			writer.printf("Case #%d: %s\n", i + 1, res);
			printTime();
		}
		printMemory();

		writer.close();
	}

	static BufferedReader reader;
	static PrintWriter writer;
	static StringTokenizer tok = new StringTokenizer("");
	static long systemTime;

	static void debug(Object... o) {
		System.err.println(deepToString(o));
	}

	static void setTime() {
		systemTime = System.currentTimeMillis();
	}

	static void printTime() {
		System.err.println("Time consumed: " + (System.currentTimeMillis() - systemTime));
	}

	static void printMemory() {
		System.err.println("Memory consumed: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1000 + "kb");
	}

	static String next() {
		while (!tok.hasMoreTokens()) {
			String w = null;
			try {
				w = reader.readLine();
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (w == null)
				return null;
			tok = new StringTokenizer(w);
		}
		return tok.nextToken();
	}

	static int nextInt() {
		return Integer.parseInt(next());
	}

	static long nextLong() {
		return Long.parseLong(next());
	}

	static double nextDouble() {
		return Double.parseDouble(next());
	}

	static BigInteger nextBigInteger() {
		return new BigInteger(next());
	}
}