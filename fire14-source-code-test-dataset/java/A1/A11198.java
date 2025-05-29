import java.io.File;
import java.util.*;

public class ProblemB {

	public static void main(String[] args) throws Exception {

		// Scanner sc = new Scanner(new File("C:\\B-small-attempt0.in"));
		Scanner sc = new Scanner(System.in);
		int cases = Integer.parseInt(sc.nextLine().trim());
		for (int i = 0; i < cases; i++) {
			int n = sc.nextInt();
			int s = sc.nextInt();
			int p = sc.nextInt();
			int[] val = new int[n];

			for (int j = 0; j < n; j++) {
				val[j] = sc.nextInt();
			}
			System.out.println("Case #" + (i + 1) + ": " + solve(s, p, val));
		}
	}

	private static int solve(int s, int p, int[] val) {

		int ret = 0;

		for (int v : val) {
			int x1, x2 = 0;

			
			if (v < 2) {
				x1 = v;
			} else if (v > 28) {
				x1 = 10;
			} else if (v % 3 == 1) {
				x1 = (v + 2) / 3;
			} else if (v % 3 == 0) {
				x1 = v / 3;
				if ((x1 == p - 1) && (s > 0)) {
					s--;
					x1++;
				}

			} else {
				x1 = (v + 1) / 3;
				if ((x1 == p - 1) && (s > 0)) {
					s--;
					x1++;
				}
			}
			if (x1 >= p)
				ret++;
		}

		return ret;

	}

}
