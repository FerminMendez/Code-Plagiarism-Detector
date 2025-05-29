package at.jaki.codejam.qr2012.C;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class C {

	private static final String TEMPLATE = "Case #%d: %d";

	private static final String IN = "C-small-attempt0.in";
	private static final String OUT = "C-small-attempt0.out";

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
		int A = sc.nextInt();
		A = Math.max(A, 10);
		int B = sc.nextInt();
		long total = 0;

		boolean[] used = new boolean[B + 1];

		for (Integer i = A; i <= B; i++) {
			if (!used[i]) {
				used[i] = true;
				List<Integer> res = turn(i.toString(), A, B);
				int n = res.size();
				total += (n * (n + 1) / 2);
				for (Integer j : res) {
					used[j] = true;
				}
			}
		}
		System.out.println(total);
		pw.println(String.format(TEMPLATE, TT, total));
	}

	private static final List<Integer> turn(String x, int min, int max) {
		StringBuilder sb = new StringBuilder(x);
		List<Integer> l = new LinkedList<Integer>();
		for (int i = 0; i < x.length() - 1; i++) {
			char ch = sb.charAt(0);
			sb.delete(0, 1);
			sb.append(ch);
			if (sb.charAt(0) != '0') {
				String string = sb.toString();
				if (!string.equals(x)) {
					Integer y = Integer.valueOf(string);
					if (y >= min && y <= max) {
						if (!l.contains(y))
							l.add(y);
					}
				}
			}
		}
		return l;
	}
}
