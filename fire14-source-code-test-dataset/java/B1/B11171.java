import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class RecycledNumbers {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("C-small-attempt0.in"));
		int numTests = in.nextInt();
		in.nextLine();
		for (int i = 0; i < numTests; ++i) {
			int A = in.nextInt();
			int B = in.nextInt();
			in.nextLine();
			System.out.println("Case #" + (i + 1) + ": " + recycle(A, B));
		}
	}

	private static int recycle(int A, int B) {
		int count = 0;
		for (int n = A; n < B; ++n) {
			String nStr = "" + n;
			count += compareM(n, B, nStr);
		}
		return count;
	}

	private static int compareM(int n, int B, String nStr) {
		int numberOfMGreaterThanN = 0; // and they must be less than B too
		int nStrLength = nStr.length();
		for (int i = 1; i < nStrLength; ++i) {
			String mBegin = nStr.substring(0, nStrLength - i);
			String mEnd = nStr.substring(nStrLength - i, nStrLength);
			String mStr = mEnd + mBegin;
			if (hasSameNumDigits(nStr, mStr)) {
				int m = Integer.parseInt(mStr);
				if (n < m && m <= B) {
					++numberOfMGreaterThanN;
				}
			}
		}
		return numberOfMGreaterThanN;
	}

	private static boolean hasSameNumDigits(String n, String m) {
		boolean foundFirstNonZero = false;
		int numDigitsOfN = 0;
		int numDigitsOfM = 0;
		
		for (int i = 0; i < n.length(); ++i) {
			char curChar = n.charAt(i);
			if (curChar != '0') {
				foundFirstNonZero = true;
			}
			if (foundFirstNonZero) {
				++numDigitsOfN;
			}
		}

		foundFirstNonZero = false;
		for (int i = 0; i < m.length(); ++i) {
			char curChar = m.charAt(i);
			if (curChar != '0') {
				foundFirstNonZero = true;
			}
			if (foundFirstNonZero) {
				++numDigitsOfM;
			}
		}
		
		return numDigitsOfM == numDigitsOfN;
	}
}
