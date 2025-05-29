import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.StringTokenizer;

public class Main {
	private static final String TASKNAME = "a";

	private void solve() throws Exception {
		int tests = nextInt();
		for (int test = 1; test <= tests; ++test) {
			printf("Case #%d: ", test);
			
			int a = nextInt();
			int b = nextInt();
			
			HashSet<String> set = new HashSet<String>();
			for (int i = a; i <= b; ++i) {
				set.add("" + i);
			}
			HashSet<Long> ans = new HashSet<Long>();
			for (int i = a; i <= b; ++i) {
				String s = "" + i;
				for (int pref = 1; pref < s.length(); ++pref) {
					String t = s.substring(pref) + s.substring(0, pref);
					if (t.charAt(0) == '0') {
						continue;
					}
					if (set.contains(t) && !s.equals(t)) {
						long aa = i;
						long bb = Integer.parseInt(t);
						if (aa > bb) {
							long tt = aa;
							aa = bb;
							bb = tt;
						}
						long key = (aa << 30) + bb;
						if (ans.add(key)) {
//							System.err.println(s + " " + t);
						}
					}
				}
			}
			
			println(ans.size());
		}
		// char[] map = new char[26];
		// Arrays.fill(map, '#');
		// for (int i = 0; i < 3; ++i) {
		// String a = reader.readLine();
		// String b = reader.readLine();
		// for (int j = 0; j < a.length(); ++j) {
		// if (a.charAt(j) == ' ') {
		// continue;
		// }
		// int c = a.charAt(j) - 'a';
		// char d = b.charAt(j);
		// if (map[c] != '#' && map[c] != d) {
		// throw new AssertionError();
		// }
		// map[c] = d;
		// }
		// }
		// map['z' - 'a'] = 'q';
		// map['q' - 'a'] = 'z';
		// System.err.println(new String(map));
	}

	private void run() {
		try {
			reader = new BufferedReader(new InputStreamReader(System.in));
			writer = new PrintWriter(new OutputStreamWriter(System.out));
			reader = new BufferedReader(new FileReader(TASKNAME + ".in"));
			writer = new PrintWriter(TASKNAME + ".out");

			solve();

			reader.close();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(13);
		}
	}

	public static void main(String[] args) {
		long time = System.currentTimeMillis();
		Locale.setDefault(Locale.US);
		new Main().run();
		System.err.printf("%.3f\n", (System.currentTimeMillis() - time) * 1e-3);
	}

	private StringTokenizer tokenizer;
	private PrintWriter writer;
	private BufferedReader reader;

	private String nextToken() throws IOException {
		while (tokenizer == null || !tokenizer.hasMoreTokens()) {
			tokenizer = new StringTokenizer(reader.readLine());
		}
		return tokenizer.nextToken();
	}

	private int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	private long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}

	private double nextDouble() throws IOException {
		return Double.parseDouble(nextToken());
	}

	private void print(Object o) {
		writer.print(o);
	}

	private void println(Object o) {
		writer.println(o);
	}

	private void printf(String format, Object... args) {
		writer.printf(format, args);
	}
}
