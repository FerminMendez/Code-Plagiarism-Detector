package gcj2012.qualificationround;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class RecycledNumbers {

	public static void main(String[] args) throws Exception {
		solve(System.in, System.out);
	}
	
	private static void solve(InputStream in, PrintStream out) throws IOException {
		Scanner scanner = new Scanner(in);
		int T = scanner.nextInt();
		for (int t=1; t<=T; t++) {
			
			final int A = scanner.nextInt();
			final int B = scanner.nextInt();
			
			Map<Integer, Set<Integer>> pairs = new LinkedHashMap<Integer, Set<Integer>>();
			for (int i=A; i<=B; i++) {
				pairs.put(i, new LinkedHashSet<Integer>());
			}
			for (int i=A; i<=B; i++) {
				String s = Integer.toString(i);
				for (int splitPoint=1; splitPoint<=numDigitsIn(A)-1; splitPoint++) {
					String sa = s.substring(0, splitPoint);
					String sb = s.substring(splitPoint);
					int newnum = Integer.parseInt(sb+sa);
					if (i < newnum && newnum <= B) {
						pairs.get(i).add(newnum);
					}
				}
			}
			
			int numRecycledPairs = 0;
			for (int n=A; n<B; n++) {
				numRecycledPairs += pairs.get(n).size();
			}
			
			out.printf("Case #%d: %d%n", t, numRecycledPairs);
		}
		scanner.close();
	}
	
	private static int numDigitsIn(int n) {
		return 1 + (int) (Math.log10(n));
	}
	
}
