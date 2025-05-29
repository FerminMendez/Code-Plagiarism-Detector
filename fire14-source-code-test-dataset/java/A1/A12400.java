import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class BSmall {

	static GoogleanScore[]	allScores	= new GoogleanScore[31];
	static int				T, S, N, p, sums[];
	// static GoogleanScore[] scores;

	static Scanner			scanf;

	public static void main(String[] args) throws FileNotFoundException {
		for (int i = 0; i < 31; i++) {
			allScores[i] = new GoogleanScore(i);
		}

		scanf = new Scanner(new File("BSmall_in.txt"));

		T = scanf.nextInt();

		for (int t = 1; t <= T; t++) {
			int result = -1;
			takeInputForACase();
			switch (S) {
				case 0:
					result = solveForSIsZero();
					break;
				case 1:
					result = solveForSIsOne();
					break;
				case 2:
					result = solveForSIsTwo();
					break;
				case 3:
					result = solveForSIsThree();
					break;
			}

			System.out.println("Case #" + t + ": " + result);
		}
	}

	static void takeInputForACase() {
		N = scanf.nextInt();
		S = scanf.nextInt();
		p = scanf.nextInt();

		sums = new int[N];
		for (int n = 0; n < N; n++) {
			sums[n] = scanf.nextInt();
		}
	}

	static int solveForSIsZero() {
		int result = 0;
		for (int sum : sums) {
			if (allScores[sum].nonSurprising.bestIsAtLeast(p)) {
				result ++;
			}
		}

		return result;
	}

	static int solveForSIsOne() {
		int result = -1;
		for (int sIndex = 0; sIndex < sums.length; sIndex++) {
			int current = 0;
			int sSum = sums[sIndex];

			if (sSum >= 2) {
				if (allScores[sSum].surprising.bestIsAtLeast(p)) {
					current++;
				}
			}

			for (int nsIndex = 0; nsIndex < sums.length; nsIndex++) {
				if (nsIndex == sIndex) {
					continue;
				}
				int nsSum = sums[nsIndex];
				if (allScores[nsSum].nonSurprising.bestIsAtLeast(p)) {
					current++;
				}
			}

			if (current > result) {
				result = current;
			}
		}

		return result;
	}

	static int solveForSIsTwo() {
		int result = -1;

		for (int nsIndex = 0; nsIndex < sums.length; nsIndex++) {
			int current = 0;
			int nsSum = sums[nsIndex];
			if (allScores[nsSum].nonSurprising.bestIsAtLeast(p)) {
				current++;
			}

			for (int sIndex = 0; sIndex < sums.length; sIndex++) {
				if (sIndex == nsIndex) {
					continue;
				}

				int sSum = sums[sIndex];
				if (sSum >= 2) {
					if (allScores[sSum].surprising.bestIsAtLeast(p)) {
						current++;
					}
				}
			}

			if (current > result) {
				result = current;
			}
		}

		return result;
	}

	static int solveForSIsThree() {
		int result = 0;
		for (int sum : sums) {
			if (allScores[sum].surprising.bestIsAtLeast(p)) {
				result += 1;
			}
		}

		return result;
	}

	static class GoogleanScore {
		Triplet	surprising, nonSurprising;

		public GoogleanScore(int score) {
			nonSurprising = new NoSurpriseTriplet(score);
			surprising = new SurprisingTriplet(score);
		}
	}

	static abstract class Triplet {
		int	values[]	= new int[3];

		public Triplet(int sum) {
			generateValues(sum);
		}

		@Override
		public String toString() {
			return Arrays.toString(values);
		}

		boolean bestIsAtLeast(	int p) {
			return values[2] >= p;
		}

		protected abstract void generateValues(	int sum);
	}

	static class NoSurpriseTriplet extends Triplet {

		public NoSurpriseTriplet(int sum) {
			super(sum);
		}

		@Override
		protected void generateValues(	int sum) {
			values[0] = sum / 3;
			sum -= values[0];

			values[1] = sum >> 1;
			values[2] = sum - values[1];
		}
	}

	static class SurprisingTriplet extends Triplet {
		public SurprisingTriplet(int sum) {
			super(sum);
		}

		@Override
		protected void generateValues(	int sum) {
			values[2] = ((sum - 2) / 3) + 2;
			values[0] = values[2] - 2;
			values[1] = sum - (values[0] + values[2]);
		}
	}
}
