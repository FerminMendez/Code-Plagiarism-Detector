package quals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Dancing {

	public static void main(String args[]) {
		try {
			System.setIn(new FileInputStream("B-small-attempt0.in"));
			Scanner scanner = new Scanner(System.in);

			int testCases = scanner.nextInt();
			scanner.nextLine();

			for (int i = 1; i <= testCases; i++) {
				int numGooglers = scanner.nextInt();
				int numSurprising = scanner.nextInt();
				int bestResultThreshold = scanner.nextInt();

				int[] googlers = new int[numGooglers];
				for (int j = 0; j < numGooglers; j++) {
					googlers[j] = scanner.nextInt();
				}

				int passingGooglers = dancingWithTheGooglers(numGooglers,
						numSurprising, bestResultThreshold, googlers);
				System.out.println(String.format("Case #%d: %d", i,
						passingGooglers));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static int dancingWithTheGooglers(int numGooglers,
			int numSurprising, int bestResultThreshold, int[] googlers) {
		int passingGooglers = 0;

		for (int i = 0; i < numGooglers; i++) {
			if (googlers[i] / 3.0 > bestResultThreshold - 1) {
				// in the case of say, [30,29,28,27,26,25], they can all meet
				// a threshold of 9 without being 'surprising'
				passingGooglers++;
			} else if (numSurprising > 0
					&& bestResultThreshold > 1
					&& googlers[i] >= ((bestResultThreshold - 1) * 3) - 1) {
				// boundary cases are when the threshold is 1 or less - in that
				// case, any non zero score would work here.
				passingGooglers++;
				numSurprising--;
			}
		}

		return passingGooglers;
	}

}
