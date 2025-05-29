package cj2012;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class c {

	static PrintWriter pw;
	static int testOut = 1;

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader(
				"C://CODEJAM//2012//C-small-0.in"));
		pw = new PrintWriter(new FileWriter("C://CODEJAM//2012//C-small-0.out"));

		int ntest = sc.nextInt();
		// sc.nextLine();

		for (int test = 1; test <= ntest; ++test) {
			// sc.next();
			int A = sc.nextInt();
			int B = sc.nextInt();

			int pairs = 0;

			for (int i = A; i <= B; i++) {
				// System.out.println(i);
				if (i > 9) {
					String is = "" + i;
					HashSet<String> results = new HashSet<String>();
					for (int j = 1; j < is.length(); j++) {
						String changed = is.substring(is.length() - j,
								is.length())
								+ is.substring(0, is.length() - j);
						if (!results.contains(changed)) {
							int ci = Integer.parseInt(changed);
							if (ci > i && ci <= B) {
								//System.out.println(is + "-" + changed);
								pairs++;
								results.add(changed);
							}
						}

					}
				}
			}

			wc("" + pairs);
		}

		pw.close();
		sc.close();
		System.out.println("finished");
	}

	// static int Digits(int number) {
	// int digits = 0;
	// int step = 1;
	// while (step <= number) {
	// digits++;
	// step *= 10;
	// }
	// if (digits == 0)
	// return 1;
	// else
	// return digits;
	// }

	private static void wc(String text) {
		String tt = "Case #" + testOut++ + ": " + text;
		pw.print(tt);
		pw.println();
		System.out.println(tt);
	}
}
