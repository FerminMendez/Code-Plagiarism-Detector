package QualificationRound2012.C.RecycledNumbers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class RecycledNumbers {
	static final String _DIR = "src/QualificationRound2012/C/RecycledNumbers/";
	static final String INPUT_FILE = _DIR + "C-small-attempt0.in";
	static final String OUTPUT_FILE = INPUT_FILE + ".out";

	private static int algorithm(final String line) {
		int distinctPairs = 0;
		final String[] split = line.split(" ");
		final String A_str = split[0];
		final String B_str = split[1];
		final int A = Integer.parseInt(A_str);
		final int B = Integer.parseInt(B_str);

		// A ≤ n < m ≤ B
		for (int m = A; m <= B; m++) {
			for (int n = m + 1; n <= B; n++) {
				// System.out.print(A + " ≤ " + m + " < " + n + " ≤ " + B);
				if (isRecycled(m, n)) {
					// System.out.println(" --> YES!");
					distinctPairs++;
				} else {
					// System.out.println();
				}
			}
		}
		return distinctPairs;
	}

	private static boolean isRecycled(final int m, final int n) {
		final String mString = String.valueOf(m);
		final String nString = String.valueOf(n);
		final int length = mString.length();
		String rot = mString;
		for (int i = 0; i < length; i++) {
			if (rot.equals(nString)) {
				return true;
			}
			rot = rotate(rot);
		}
		return false;
	}

	public static void main(final String args[]) throws IOException {
		final BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE));
		final BufferedReader reader = new BufferedReader(new FileReader(new File(INPUT_FILE)));

		long timeStart = System.currentTimeMillis();

		String line;
		int testcase = 0;
		while ((line = reader.readLine()) != null) {
			if (testcase != 0) {
				System.out.println("Case #" + testcase + ": " + algorithm(line));
			}
			testcase++;
		}

		long timeEnd = System.currentTimeMillis();
		System.out.println(timeEnd - timeStart + " millis");

	}

	private static String rotate(final String number) {
		final char[] numberArray = number.toCharArray();
		final char last = numberArray[numberArray.length - 1];
		return last + number.substring(0, number.length() - 1);
	}
}
