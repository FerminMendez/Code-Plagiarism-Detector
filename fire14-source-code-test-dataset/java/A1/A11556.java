package cj2012;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class b {

	static PrintWriter pw;
	static int testOut = 1;

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader(
				"C://CODEJAM//2012//B-small-0.in"));
		pw = new PrintWriter(new FileWriter("C://CODEJAM//2012//B-small-0.out"));

		int ntest = sc.nextInt();

		for (int test = 1; test <= ntest; ++test) {
			int N = sc.nextInt();
			int S = sc.nextInt();
			int p = sc.nextInt();
			// System.out.print(N+"."+S+"."+p+".");

			int y = 0;

			for (int i = 1; i <= N; i++) {
				int t = sc.nextInt();

				// System.out.print(t+",");
				if (t >= p) {

					if (t >= ((3 * p) - 2)) {
						y++;
					} else if ((t >= ((3 * p) - 4)) && (S > 0)) {
						y++;
						S--;
					}
				}

			}

			// System.out.println();
			wc("" + y);
		}

		pw.close();
		sc.close();
		System.out.println("finished");
	}

	private static void wc(String text) {
		String tt = "Case #" + testOut++ + ": " + text;
		pw.print(tt);
		pw.println();
		System.out.println(tt);
	}
}
