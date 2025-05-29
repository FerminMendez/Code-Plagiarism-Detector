package at.jaki.codejam.qr2012.B;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class B {

	private static final String TEMPLATE = "Case #%d: %d";

	private static final String IN = "B-small-attempt0.in";
	private static final String OUT = "B-small-attempt0.out";

	private static Scanner sc;
	private static PrintWriter pw;

	public static void main(String[] args) throws FileNotFoundException {
		sc = new Scanner(new File(IN));
		pw = new PrintWriter(new File(OUT));
		int tests = sc.nextInt();
		for (int i = 1; i <= tests; i++) {
			resolve(i);
		}
		pw.flush();
		pw.close();
	}

	private static void resolve(int TT) {
		int n = sc.nextInt();
		int s = sc.nextInt();
		int p = sc.nextInt();
		int[] scores = new int[n];
		for (int i = 0; i < n; i++) {
			scores[i] = sc.nextInt();
		}

		int total = 0;
		for (int i = 0; i < n; i++) {
			int q = scores[i] / 3;
			int r = scores[i] % 3;

			int best;
			if (r == 0) {
				best = q;
			} else {
				best = q + 1;
			}
			if (best >= p) {
				total++;
				continue;
			}

			if (best == p - 1) {
				if (s > 0 && r != 1 && scores[i] != 0) {
					total++;
					s--;
					continue;
				}
			}
		}
		pw.println(String.format(TEMPLATE, TT, total));
		System.out.println(total);

	}
}

// 4---> 2 1 1
// 4*--> 2 2 0

// 5---> 2 2 1
// 5*--> 3 1 1

// 6---> 2 2 2
// 6*--> 3 2 1

// 7---> 3 2 2
// 7*--> 3 3 1 