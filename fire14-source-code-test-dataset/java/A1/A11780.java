import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

public class Solution {

	void solve() throws Exception {
		int n = nextInt();
		int s = nextInt();
		int p = nextInt();
		int coolany = 0, coolpp = 0;
		for (int i = 0; i < n; i++) {
			int t = nextInt();
			if (t >= p + Math.max(0, p - 1) + Math.max(0, p - 1)) coolany++; else
				if (t >= p + Math.max(0, p - 2) + Math.max(0, p - 2)) coolpp++;
		}
		out.println(coolany + Math.min(s, coolpp));
	}
	
	public static void main(String[] args) {
		new Solution().run();
	}
	
	public void run() {
		try {
//			in = new BufferedReader(new InputStreamReader(System.in));
//			out = new PrintWriter(System.out);
			in = new BufferedReader(new FileReader(new File("input.txt")));
			out = new PrintWriter("output.txt");
			int t = nextInt();
			for (int q = 1; q <= t; q++) {
				out.print("Case #" + q + ": "); solve();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		} finally {
			out.close();
		}
	}
	
	String nextToken() throws Exception {
		while (st == null || !st.hasMoreTokens()) {
			String s = in.readLine();
			if (s == null) return null;
			st = new StringTokenizer(s);
		}
		return st.nextToken();
	}
	
	int nextInt() throws Exception {
		return Integer.parseInt(nextToken());
	}
	
	BufferedReader in;
	PrintWriter out;
	StringTokenizer st;

}