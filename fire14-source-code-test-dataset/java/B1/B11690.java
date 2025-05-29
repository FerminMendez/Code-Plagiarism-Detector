import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.HashSet;
import java.util.Scanner;

public class RecycledNumbers {

	private static String solve(int A, int B) {
		int count = 0;
		final HashSet<Integer> seen = new HashSet<Integer>(10);
		for (int n = A; n < B; n++) {
			// Find number of decimal digits.
			int nTemp = n, digits = 0, unit = 1;
			while (nTemp > 0) {
				digits++;
				nTemp /= 10;
				unit *= 10;
			}
			unit /= 10;

			int m = n;
			seen.clear();
			for (int i = 1; i < digits; i++) {
				if (m % 10 == 0) {
					// Don't process because there will be a leading zero.
					m /= 10;
				} else {
					m = (unit * (m % 10)) + (m / 10);
					if (m > n && m <= B && !seen.contains(m)) {
						seen.add(m);
						count++;
					}
				}
			}
		}

		return "" + count;
	}

	public static void main(String[] args) throws FileNotFoundException {
		//String filename = "C-test.in";
		String filename = "C-small-attempt0.in";
		// String filename = "C-large.in";
		assert filename.endsWith(".in");
		Scanner in = new Scanner(new File(filename));
		Formatter out = new Formatter(new File(filename.replace(".in", ".out")));

		assert in.hasNext();
		int T = in.nextInt();
		in.nextLine();
		for (int t = 0; t < T; t++) {
			int A = in.nextInt();
			int B = in.nextInt();

			String ans = solve(A, B);

			String result;
			if (t < T - 1)
				result = String.format("Case #%d: %s%n", t + 1, ans);
			else
				result = String.format("Case #%d: %s", t + 1, ans);
			out.format(result);
			System.out.format(result);
		}

		out.flush();
		out.close();
	}

}
