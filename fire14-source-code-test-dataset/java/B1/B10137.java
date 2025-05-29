package qualifying;

import java.util.*;

public class RecycledNumbers {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		final int NUM_TESTS = in.nextInt();
		for (int t = 1; t <= NUM_TESTS; ++t) {
			final int A = in.nextInt();
			final int B = in.nextInt();
			
			final int numDigits = Integer.toString(A).length();
			
			Set<String> pairs = new HashSet<String>();
			for (int n = A; n < B; ++n) {
				for (int i = 1; i < numDigits; ++i) {
					int m = recycle(n, i);
					if (n < m && m <= B)
						pairs.add(n + "," + m);
				}
			}
			
			System.out.println("Case #" + t + ": " + pairs.size());
		}
		
	}
	
	
	// Recycles n by moving the first i digits to the back
	private static int recycle(int n, int i) {
		String iStr = Integer.toString(n);
		String newStr = iStr.substring(i) + iStr.substring(0,i);
		return Integer.parseInt(newStr);
	}
}