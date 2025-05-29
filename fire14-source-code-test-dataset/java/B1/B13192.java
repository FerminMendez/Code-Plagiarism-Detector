import java.io.*;
import java.util.*;

public class RecycledNumbers {

	BufferedReader in;
	StringTokenizer st;
	PrintWriter out;

	String next() throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(in.readLine());
		return st.nextToken();
	}

	int nextInt() throws Exception {
		return Integer.parseInt(next());
	}

	long nextLong() throws Exception {
		return Long.parseLong(next());
	}

	double nextDouble() throws Exception {
		return Double.parseDouble(next());
	}

	void solve() throws Exception {
		int l = nextInt(), r = nextInt();

		HashMap<Integer, Integer> c = new HashMap<Integer, Integer>();

		for (int i = l; i <= r; i++) {
			HashSet<Integer> alr = new HashSet<Integer>();
			alr.add(i);
			for (int j = 10; j <= i; j *= 10) {
				int rot = Integer.parseInt((i % j) + "" + (i / j));
				if (!alr.contains(rot)) {
					alr.add(rot);
					if (c.containsKey(rot)) {
						int curr = c.get(rot) + 1;
						c.put(rot, curr);
					} else
						c.put(rot, 1);
				}
			}
		}

		long ans = 0;
		for (int i = l; i <= r; i++) {
			ans += c.get(i) == null ? 0 : c.get(i);
		}

		out.print(ans / 2);
	}

	void run() {
		try {
			Locale.setDefault(Locale.US);
			in = new BufferedReader(new FileReader("input.txt"));
			out = new PrintWriter(new FileWriter("output.txt"));
			int t = nextInt();
			for (int tc = 1; tc <= t; tc++) {
				out.print("Case #" + tc + ": ");
				solve();
				out.println();
			}
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public static void main(String[] args) {
		new RecycledNumbers().run();

	}

}
