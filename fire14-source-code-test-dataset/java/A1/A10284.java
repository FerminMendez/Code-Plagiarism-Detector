/*
 * Anand Oza
 * Apr 14, 2012
 */

import java.util.*;
import java.io.*;

public class B_DancingWithTheGooglers {
	public static void main(String[] args) throws IOException {
		long startTime = System.nanoTime();
		BufferedReader reader = new BufferedReader(new FileReader("B_DancingWithTheGooglers.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("B_DancingWithTheGooglers.out")));
		StreamTokenizer in = new StreamTokenizer(reader);

		in.nextToken();
		int T = (int) in.nval;
		for (int testcase = 1; testcase <= T; testcase++) {
			in.nextToken();
			int N = (int) in.nval;
			in.nextToken();
			int S = (int) in.nval;
			in.nextToken();
			int P = (int) in.nval;
			int unsurprisingThreshold = 2 * Math.max((P - 1), 0) + P;
			int surprisingThreshold = 2 * Math.max((P - 2), 0) + P;
			int countUnsurprising = 0;
			int countSurprising = 0;
			for (int i = 0; i < N; i++) {
				in.nextToken();
				int t = (int) in.nval;
				if (t >= unsurprisingThreshold)
					countUnsurprising++;
				else if (t >= surprisingThreshold)
					countSurprising++;
			}

			int ans = countUnsurprising + Math.min(S, countSurprising);
			out.format("Case #%d: %d%n", testcase, ans);
		}

		out.close();
		System.out.println("Time (ms): " + (double) (System.nanoTime() - startTime) / 1000000);
		System.exit(0);
	}
}
