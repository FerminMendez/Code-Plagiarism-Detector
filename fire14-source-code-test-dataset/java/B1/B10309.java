/*
 * Anand Oza
 * Apr 14, 2012
 */

import java.util.*;
import java.io.*;

public class C_RecycledNumbers {
	public static void main(String[] args) throws IOException {
		long startTime = System.nanoTime();
		BufferedReader reader = new BufferedReader(new FileReader("C_RecycledNumbers.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C_RecycledNumbers.out")));
		StreamTokenizer in = new StreamTokenizer(reader);

		in.nextToken();
		int T = (int) in.nval;
		for (int testcase = 1; testcase <= T; testcase++) {
			in.nextToken();
			int A = (int) in.nval;
			in.nextToken();
			int B = (int) in.nval;

			int ans = 0;
			for (int n = A; n <= B; n++) {
				String s = String.valueOf(n);
				Set<Integer> mvalues = new HashSet<Integer>();
				for (int i = 0; i < s.length(); i++) {
					int m = Integer.parseInt(s.substring(i) + s.substring(0, i));
					if (m > n && m <= B && m >= A)
						mvalues.add(m);
				}
				ans += mvalues.size();
			}

			out.format("Case #%d: %d%n", testcase, ans);
		}

		out.close();
		System.out.println("Time (ms): " + (double) (System.nanoTime() - startTime) / 1000000);
		System.exit(0);
	}
}
