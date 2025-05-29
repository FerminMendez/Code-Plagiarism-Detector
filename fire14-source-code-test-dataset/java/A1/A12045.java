import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DancingWithGooglers {
	final static int[] _3n_2 = new int[] { 2, 5, 8, 11, 14, 17, 20, 23, 26, 29 };
	final static int[] _3n_4 = new int[] { 4, 7, 10, 13, 16, 19, 22, 25, 28 };

	// return -1 if cannot be written as surprising form
	public static int surprisingN(int n) {
		if (n == 0)
			return -999;
		for (int i : _3n_2)
			if (i == n)
				return (n - 2) / 3;
		if (n % 3 == 0) // 3n+3
			return (n-3) / 3;
		return (n - 4) / 3;
	}

	public static int nonSurprisingN(int n) {
		if ((n - 1) % 3 == 0)
			return (n - 1) / 3;
		if ((n - 2) % 3 == 0)
			return (n - 2) / 3;
		return n / 3;
	}

	public static int enact(int S, int p, int[] scores) {
		if (S == 0) {
			// find best score
			// return
			int tmp = 0;
			for (int i : scores) {
				int n = nonSurprisingN(i);
				if (p <= n)
					tmp++;
				else if (p == n + 1) {
					if (i % 3 != 0)
						tmp++;
				}
			}
			return tmp;
		}

		int max = 0;
		int N = 0; // number of googlers have a best score at least p
		// setting one valid googler to be surprising case
		for (int i = 0; i < scores.length; i++) {
			int tmp = scores[i];
			scores[i] = -999;
			N = enact(S - 1, p, scores);
			scores[i] = tmp;

			if (p <= surprisingN(scores[i]) + 2)
				N++;

			if (N > max)
				max = N;
		}
		return max;
	}

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("B-small-attempt2.in"));
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int n = sc.nextInt();
			int S = sc.nextInt();
			int p = sc.nextInt();
			int[] scores = new int[n];
			for (int j = 0; j < n; j++) {
				scores[j] = sc.nextInt();
			}

			int result = enact(S, p, scores);
			System.out.format("Case #%d: %d%n", i + 1, result);
		}
	}
}
