package probb;

import codejam.CodeJam;

public class Main extends CodeJam {

	public static void main(String[] args) {
		new Main() {
			// Override the input file with the following: e.g. if the value is "large", then read "A-large.in" instead of the default
			//@SuppressWarnings("unused")
			//public static final String OVERRIDE_INPUT_FILE = "small-attempt0"; // "large";
		};
	}

	// --------------------------------------------------------------------------------------------------------------

	private static void max(int[] bestScoreForTot, int tot, int bestTot) {
		if (bestTot <= 10)
			bestScoreForTot[tot] = Math.max(bestScoreForTot[tot], bestTot);
	}

	@Override
	public void solve() {

		int[] bestScoreForTot_surprising = new int[31];
		int[] bestScoreForTot_nonSurprising = new int[31];
		for (int a = 1; a <= 10; a++) {
			max(bestScoreForTot_nonSurprising, (a + 0) + (a + 0) + (a + 0), a);
			max(bestScoreForTot_nonSurprising, (a + 0) + (a + 0) + (a + 1), a + 1);
			max(bestScoreForTot_nonSurprising, (a + 0) + (a + 1) + (a + 1), a + 1);
			max(bestScoreForTot_surprising, (a + 0) + (a + 0) + (a + 2), a + 2);
			max(bestScoreForTot_surprising, (a + 0) + (a + 1) + (a + 2), a + 2);
			max(bestScoreForTot_surprising, (a + 0) + (a + 2) + (a + 2), a + 2);
		}
		//		for (int i = 3; i <= 30; i++) 
		//			System.out.println(i + " " + bestScoreForTot_surprising[i] + " " + bestScoreForTot_nonSurprising[i]);
		//		3 0 1
		//		4 0 2
		//		5 3 2
		//		6 3 2
		//		7 3 3
		//		8 4 3
		//		9 4 3
		//		10 4 4
		//		11 5 4
		//		12 5 4
		//		13 5 5
		//		14 6 5
		//		15 6 5
		//		16 6 6
		//		17 7 6
		//		18 7 6
		//		19 7 7
		//		20 8 7
		//		21 8 7
		//		22 8 8
		//		23 9 8
		//		24 9 8
		//		25 9 9
		//		26 10 9
		//		27 10 9
		//		28 10 10
		//		29 0 10
		//		30 0 10

		int T = readInt();
		for (int t = 0; t < T; t++) {
			int N = readInt();
			int S = readInt();
			int p = readInt();
			
			int numGooglersWithMinScore = 0;
			for (int i = 0; i < N; i++) {
				int totScore = readInt();
				int bestScoreSurprising = bestScoreForTot_surprising[totScore];
				int bestScoreNonSurprising = bestScoreForTot_nonSurprising[totScore];
				if (bestScoreNonSurprising >= p) {
					numGooglersWithMinScore++;
				} else if (bestScoreSurprising < p) {
					// skip
				} else if (bestScoreSurprising >= p) {
					if (S > 0) {
						S--;
						numGooglersWithMinScore++;
					}
				}
			}
			
			writeCaseNumThenLine(numGooglersWithMinScore);
		}
	}
}
