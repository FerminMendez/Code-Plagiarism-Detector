import java.io.*;
import java.util.*;

public class C {

	private static void solve() throws IOException {
		int testCases = nextInt();
		for (int test = 1; test <= testCases; test++) {
			out.print("Case #" + test + ": ");
			solveOneTest();
		}
	}

	private static void solveOneTest() throws IOException {
		out.println(recycledPairs(nextInt(), nextInt()));
	}
	
	static int recycledPairs(int a, int b) {
		int answer = 0;
		for (int n = a; n <= b; n++) {
			String s = Integer.toString(n);
			Set<Integer> set = new HashSet<Integer>();
			for (int move = 1; move < s.length(); move++) {
				String s1 = s.substring(0, move);
				String s2 = s.substring(move);
				if (s2.startsWith("0")) {
					continue;
				}
				int m = Integer.parseInt(s2+s1);
				if (m > n && m <= b) {
					set.add(m);
				}
			}
			answer += set.size();
		}
		return answer;
	}

	public static void main(String[] args) {
		try {
			br = new BufferedReader(new FileReader("C.in"));
			out = new PrintWriter("C.out");
			solve();
			out.close();
		} catch (Throwable e) {
			e.printStackTrace();
			System.exit(239);
		}
	}

	static BufferedReader br;
	static StringTokenizer st;
	static PrintWriter out;

	static String nextToken() throws IOException {
		while (st == null || !st.hasMoreTokens()) {
			String line = br.readLine();
			if (line == null)
				return null;
			st = new StringTokenizer(line);
		}
		return st.nextToken();
	}

	static int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	static long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}

	static double nextDouble() throws IOException {
		return Double.parseDouble(nextToken());
	}
}