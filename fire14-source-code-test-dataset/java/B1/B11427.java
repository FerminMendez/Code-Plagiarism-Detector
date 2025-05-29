import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;
import java.io.*;
import java.math.*;
import java.util.*;

@SuppressWarnings("unused")
public class C_RecycledNumbers {
	public static void main(String[] args) throws Exception {
		// Scanner in = new Scanner(System.in);
		// PrintStream out = System.out;
		Scanner in = new Scanner(new File("C-small.in"));
		PrintStream out = new PrintStream("C-small.out");
		// Scanner in = new Scanner(new File("C-large.in"));
		// PrintStream out = new PrintStream("C-large.out");
		int T = in.nextInt();
		for (int i = 1; i <= T; i++) {
			int A = in.nextInt();
			int B = in.nextInt();
			TreeSet<pair> set = new TreeSet<pair>();
			for (int n = A; n <= B; n++) {
				String s = Integer.toString(n);
				for (int j = 0; j <= s.length(); j++) {
					int m = Integer.parseInt(s.substring(j) + s.substring(0, j));
					if (A <= n && n < m && m <= B) {
						set.add(new pair(n, m));
					}
				}
			}
			out.println("Case #" + i + ": " + set.size());
		}
	}

	static class pair implements Comparable<pair> {
		int a, b;

		public pair(int a, int b) {
			this.a = a;
			this.b = b;
		}

		public int compareTo(pair p) {
			if (a == p.a)
				return b - p.b;
			return a - p.a;
		}
	}
}
