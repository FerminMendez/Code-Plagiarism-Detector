package qualification_2012;

import java.io.PrintWriter;
import java.util.Scanner;

public class PB {
	static Scanner sc = new Scanner(System.in);
	static PrintWriter pw = new PrintWriter(System.out);

	public static void main(String[] args) {
		int t = sc.nextInt();
		for (int i = 1; i <= t; i++) {
			int n = sc.nextInt();
			int s = sc.nextInt();
			int p = sc.nextInt();
			int[][] d1 = new int[n + 1][s + 1];
			int[][] d2 = new int[n + 1][s + 1];

			for (int j = 1; j <= n; j++) {
				int x = sc.nextInt();

				for (int k = 0; k <= Math.min(s, j); k++) {
					if (k != 0)
						d1[j][k] = Math.max(d1[j - 1][k - 1], d2[j - 1][k - 1])
								+ (check(x, p, true) ? 1 : 0);
					if (k < j)
						d2[j][k] = Math.max(d2[j - 1][k], d1[j - 1][k])
								+ (check(x, p, false) ? 1 : 0);
				}
			}
			pw.println("Case #" + i + ": " + Math.max(d1[n][s], d2[n][s]));
		}
		pw.flush();
	}

	static boolean check(int a, int p, boolean surprised) {

		if (surprised) {
			switch (a % 3) {
			case 0:
				return (a > 0 && a < 28 && ((a + 3) / 3) >= p);
			case 1:
				return (a > 1 && a < 29 && ((a + 2) / 3) >= p);
			case 2:
				return (a < 27 && ((a + 4) / 3) >= p);
			}
		} else {
			switch (a % 3) {
			case 0:
				return (a / 3) >= p;
			case 1:
				return ((a + 2) / 3) >= p;
			case 2:
				return ((a + 1) / 3) >= p;
			}
		}
		return false;
	}
}
