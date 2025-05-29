package codejam;

import java.util.HashSet;
import java.util.Scanner;

public class Qual2012C {
	private static int digitCount;
	private static int[] MULTIPLES = { 1, 10, 100, 1000, 10000, 100000, 1000000, 10000000 };

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nrOfTestCases = scanner.nextInt();
		for (int caseNr = 1; caseNr <= nrOfTestCases; caseNr++) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			digitCount = digitCount(a);
			System.out.println("Case #" + caseNr + ": " + solve(a, b));
		}
	}

	private static int digitCount(int a) {
		if (a == 0)
			return 0;
		return 1 + digitCount(a / 10);
	}

	private static long solve(int min, int max) {
		long total = 0;
		for (int n = min; n < max; n++)
			total += pairsFor(n, max);
		return total;
	}

	private static int pairsFor(int n, int max) {
		if (n >= max)
			return 0;
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 1; i < digitCount; i++) {
			int multipleSplit = MULTIPLES[i];
			int tail = n % multipleSplit;
			if (tail < MULTIPLES[i - 1])
				continue;
			int m = tail * MULTIPLES[digitCount - i] + (n / multipleSplit);
			if (n < m && m <= max)
				set.add(m);
		}
		return set.size();
	}
}
