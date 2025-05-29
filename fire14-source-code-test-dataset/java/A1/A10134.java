package qualifying;

import java.util.*;

public class DancingWithGooglers {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		final int T = in.nextInt();
		for (int testCase = 1; testCase <= T; ++testCase) {

			// initialize parameters
			int N = in.nextInt();
			int S = in.nextInt();
			int p = in.nextInt();
			
			int[] t = new int[N];
			for (int i = 0; i < N; ++i)
				t[i] = in.nextInt();
			Arrays.sort(t);
			
			// make as many people as possible >= p
			int overCount = 0;
			for (int i = N - 1; i >=0; --i) {
				int disagree = minDisagreement(t[i], p);
				if (disagree > 2) {
					break;
				} else if (disagree == 2 && S == 0) {
					break;
				} else if (disagree == 2) {
					--S;
				}
				++overCount;
			}
			assert (S == 0);
			System.out.printf("Case #%d: %d\n", testCase, overCount);
			
		}
	}
	
	private static int minDisagreement(int total, int minHighScore) {
		if (total >= 3 * minHighScore)
			return 0;
		else if (total < minHighScore)
			return Integer.MAX_VALUE; //i.e. impossible
		else
			return minHighScore - (total - minHighScore)/2;
	}
	
}
