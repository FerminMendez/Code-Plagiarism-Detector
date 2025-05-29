import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;

public class C implements Runnable {

	private StringTokenizer st;
	private BufferedReader in;
	private PrintWriter out;

	final String file = "C-small";

	Map<Character, Character> cache = new HashMap<Character, Character>();

	public void solve(int test) throws IOException {
		out.print("Case #" + (test + 1) + ": ");
		if (test == 52) {
			System.out.println();
		}
		// =======================================================================
		int totalEmp = nextInt();
		int surprise = nextInt();
		int threshold = nextInt();

		int ans = 0;
		List<Integer> scores = new ArrayList<Integer>();

		for (int i = 0; i < totalEmp; i++)
			scores.add(nextInt());
		if (threshold == 0) {
			out.println(String.valueOf(totalEmp));
			return;
		}
		Collections.sort(scores);
		int min = (threshold * 3) - 4;
		min = Math.max(min, 0);
		for (int i : scores) {
			if(threshold > i)
				continue;
			if (i >= (threshold) * 3 - 2) {
				ans++;
				continue;
			}
			if ((i == 1) && threshold <= i) {
				ans++;
				continue;
			}
			if (surprise > 0 && i >= (threshold * 3) - 4) {
				surprise--;
				ans++;
				continue;
			}
		}
		// =======================================================================

		out.println(String.valueOf(ans));
	}

	public void run() {
		try {
			//in = new BufferedReader(new FileReader(
				//	"C:\\Vinay\\gcj\\GCJ\\src\\C-small.in"));
			//out = new PrintWriter("C:\\Vinay\\gcj\\GCJ\\src\\C-small.out");

			 in = new BufferedReader(new FileReader(file + ".in")); out = new
	PrintWriter(file + ".out");
			 eat("");
			int tests = nextInt();
			for (int test = 0; test < tests; ++test) {
				solve(test);
			}

			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			failed = true;
		}
	}

	void eat(String s) {
		st = new StringTokenizer(s);
	}

	String next() throws IOException {
		while (!st.hasMoreTokens()) {
			String line = in.readLine();
			if (line == null) {
				return null;
			}
			eat(line);
		}
		return st.nextToken();
	}

	int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	long nextLong() throws IOException {
		return Long.parseLong(next());
	}

	double nextDouble() throws IOException {
		return Double.parseDouble(next());
	}

	static boolean failed = false;

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Thread th = new Thread(new C());
		th.start();
		try {
			th.join();
		} catch (InterruptedException iex) {
		}
		if (failed) {
			throw new RuntimeException();
		}
	}

}