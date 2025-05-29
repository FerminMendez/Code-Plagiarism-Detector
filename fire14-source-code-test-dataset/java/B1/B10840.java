package quals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Recycler {

	public static void main(String args[]) {
		try {
			System.setIn(new FileInputStream("C-small-attempt0.in"));
			Scanner scanner = new Scanner(System.in);

			int testCases = scanner.nextInt();
			scanner.nextLine();

			for (int i = 1; i <= testCases; i++) {
				int a = scanner.nextInt();
				int b = scanner.nextInt();

				int numRecycledPairs = recycler(a, b);
				System.out.println(String.format("Case #%d: %d", i,
						numRecycledPairs));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	private static int recycler(int a, int b) {
		int numRecycled = 0;
		
		int digits = (int) Math.log10(a) + 1;


		Set<Integer> recycled = new HashSet<Integer>();
		for (int m = a; m <= b; m++) {
			for (int pos = 1; pos <= digits; pos++) {
				int n = recycle(m, pos);
				if (m < n && n <= b && !recycled.contains(n)) {
					numRecycled++;
					recycled.add(n);
				}
			}
			recycled.clear();
		}
		return numRecycled;
	}
	
	private static int recycle(int a, int pos) {
		return a / (int) Math.pow(10, pos) + (a % (int) Math.pow(10, pos))
				* (int) Math.pow(10, (int) Math.log10(a) - pos + 1);
	}
}
