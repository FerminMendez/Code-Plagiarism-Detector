import java.util.Scanner;

import jp.ne.sakura.yuki2006.CodeJam.CodeJam;
import jp.ne.sakura.yuki2006.CodeJam.ITestCase;

/**
 *
 */

/**
 * @author yuki
 *
 */
public class RecycledNumbers implements ITestCase {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new CodeJam(new RecycledNumbers(), "Cout.txt");
	}

	/*
	 * (非 Javadoc)
	 *
	 * @see jp.ne.sakura.yuki2006.CodeJam.ITestCase#testCase(java.util.Scanner)
	 */
	@Override
	public String testCase(Scanner stdIn) {
		int A = stdIn.nextInt();
		int B = stdIn.nextInt();
		int totalCount = 0;
		for (int i = A; i <= B; i++) {
			int length = String.valueOf(i).length();

			for (int j = 0; j < length; j++) {
				int radix = (int) (Math.pow(10, j));
				int top = i / radix;
				int other = i % radix;

				Integer rn = Integer.parseInt(String.valueOf(other) + String.valueOf(top));

				if (rn<=B && i < rn) {
					System.err.println(i);
					System.err.println(rn);
					System.err.println();
					totalCount++;
				}
			}
		}
		return totalCount + "";
	}
}
