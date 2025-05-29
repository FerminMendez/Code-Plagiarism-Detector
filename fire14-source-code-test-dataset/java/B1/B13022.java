import java.io.*;
import java.util.*;

public class RecycledNumbers {
	
	String shift(String a) {
		return a.substring(1) + a.charAt(0);
	}
	
	void solve() throws Exception {
		int a = nextInt();
		int b = nextInt();
		int length = (b + "").length();
		Set<Integer> set = new HashSet<Integer>();
		int ans = 0, eq = 0;
		for (int i = a; i <= b; i++) {
			String s = i + "";
			set.clear();
			for (int j = 0; j < length; j++) {
				int t = Integer.parseInt(s);
				if (t >= a && t <= b && t != i) {
					set.add(t);
				}
				s = shift(s);
			}
			ans += set.size();
		}
		out.println(ans / 2);
	}

	void run() {
		try {
			in = new BufferedReader(new FileReader("input.txt"));
			out = new PrintWriter("output.txt");
			int tests = nextInt();
			for (int i = 0; i < tests; i++) {
				out.print("Case #" + (i + 1) + ": ");
				solve();
				System.err.println("test " + (i + 1));
			}
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	BufferedReader in;
	StringTokenizer st;
	PrintWriter out;
	final String filename = new String("RecycledNumbers").toLowerCase();

	String nextToken() throws Exception {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(in.readLine());
		return st.nextToken();
	}

	int nextInt() throws Exception {
		return Integer.parseInt(nextToken());
	}

	long nextLong() throws Exception {
		return Long.parseLong(nextToken());
	}

	double nextDouble() throws Exception {
		return Double.parseDouble(nextToken());
	}

	public static void main(String[] args) {
		new RecycledNumbers().run();
	}

}
