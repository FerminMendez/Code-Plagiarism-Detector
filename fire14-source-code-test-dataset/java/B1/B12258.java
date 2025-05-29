package mar2012;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ProblemC {

	public static void main(String[] args) throws Exception {
		PrintStream out = new PrintStream(new File(
				"/Users/asingh/Desktop/gcj2012/prob.c.out.txt"));
		ProblemC prob = new ProblemC();
		InputStream in = new FileInputStream(new File(
				"/Users/asingh/Desktop/gcj2012/prob.c.in.txt"));
		 prob.solveAll(in, out);
//		prob.solveTestCase(1, 1000000, 2000000, out);
//		prob.solveTestCase(1, 1111, 2222, out);
	}

	private void solveAll(InputStream in, PrintStream out) throws Exception {
		Scanner scanner = new Scanner(in);
		int numTestCases = Integer.parseInt(scanner.nextLine());

		for (int i = 0; i < numTestCases; i++) {
			int min = scanner.nextInt();
			int max = scanner.nextInt();
			if (i < numTestCases - 1)
				scanner.nextLine();
			solveTestCase(i + 1, min, max, out);
		}
	}

	private static class Tuple {
		int one;
		int two;

		public Tuple(int one, int two) {
			this.one = Math.min(one, two);
			this.two = Math.max(one, two);
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + one;
			result = prime * result + two;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Tuple other = (Tuple) obj;
			if (one != other.one)
				return false;
			if (two != other.two)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "{" + one + ", " + two + "}";
		}

	}

	private void solveTestCase(int testCaseId, int min, int max, PrintStream out) {
//		System.out.println("testCaseId: " + testCaseId + ", min: " + min
//				+ ", max: " + max);
		int[] minDigits = getDigits(min);
		int[] maxDigits = getDigits(max);
		Set<Tuple> found = new HashSet<Tuple>();

		for (int n = min; n <= max; n++) {
			// debug("Doing: " + n);
			int[] digits = getDigits(n);
			int prevD = digits[0];
			boolean allSame = true;
			for (int d : digits) {
				if (prevD != d) {
					allSame = false;
					break;
				}
			}
			if (allSame) {
				// debug("   skipping as same digits");
				continue;
			}
			for (int i = 1; i <= digits.length - 1; i++) {
				if (digits[i] > maxDigits[0]) {
					// formed num will be greater, skip
					// debug("     skipping as will be greater than " + max +
					// ", i=" + i + ", digits[i]=" + digits[i]);
					continue;
				}
				if (digits[i] < minDigits[0]) {
					// formed num will be smaller, skip
					// debug("         skipping as will be smaller than " + min
					// +
					// ", i=" + i + ", digits[i]=" + digits[i]);
					continue;
				}

				int[] newNumDigits = swapBlockToBack(digits, i);
				int num = getNum(newNumDigits);
				if (num == n) {
					// debug("     skipping as same nums: " + n);
					continue;
				}
				if (num >= min && num <= max) {
					Tuple tuple = new Tuple(n, num);
					if (found.contains(tuple)) {
						// debug("   skipping as already found: " + num);
						continue;
					} else {
						found.add(tuple);
						//debug("SOLUTION: " + tuple);
					}
				} else {
					// debug("           skipping as not in range - min: "
					// + min + ", max: " + max + ", num: " + num);
				}
			}
		}
		out.println("Case #" + testCaseId + ": " + found.size());
//		System.out.println("Result: " + success);
	}

	private int getNum(int[] digits) {
		int rv = 0;
		for (int i = digits.length - 1, factor = 1; i >= 0; i--) {
			int digit = digits[i];
			rv += factor * digit;
			factor *= 10;
		}
		return rv;
	}

	private int[] swapBlockToBack(int[] digits, int blockSize) {
		int[] newDigits = new int[digits.length];
		System.arraycopy(digits, blockSize, newDigits, 0, digits.length
				- blockSize);
		System.arraycopy(digits, 0, newDigits, digits.length - blockSize,
				blockSize);
		return newDigits;
	}

	private int[] getDigits(int min) {
		char[] digitChars = String.valueOf(min).toCharArray();
		int[] digits = new int[digitChars.length];
		for (int i = 0; i < digits.length; i++) {
			digits[i] = digitChars[i] - '0';
		}
		return digits;
	}
}
