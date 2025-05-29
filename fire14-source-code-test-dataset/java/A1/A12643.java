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
public class DancingWithTheGooglers implements ITestCase {

	/*
	 * (非 Javadoc)
	 *
	 * @see jp.ne.sakura.yuki2006.CodeJam.ITestCase#testCase(java.util.Scanner)
	 */
	@Override
	public String testCase(Scanner stdIn) {
		int N = stdIn.nextInt();
		int S = stdIn.nextInt();
		int P = stdIn.nextInt();
		int overCount = 0;
		int under = 0;
		for (int i = 0; i < N; i++) {
			int t = stdIn.nextInt();
			if (3 * P - 2 <= t) {
				overCount++;
			} else if (2 <= P && 3 * P - 4 <= t) {
				if (under < S) {
					under++;
				}
			}
		}

		return (overCount + under) + "";
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new CodeJam(new DancingWithTheGooglers(), "Bout.txt");
	}

}
