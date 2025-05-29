package codejam2012;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import reusable.CodeJamBase;

public class DancingWithTheGooglers {

	public static void main(String[] args) {
		new CodeJamBase("B-small-attempt0") {

			@Override
			protected String solution() {
				int[] input = nextIntArray();

				int googlers = input[0];
				int suprisingTriplets = input[1];
				int minBestResult = input[2];

				int minTotal = Math.max(0, 3 * minBestResult - 2); // (a-1)+(a-1)+a
				int minTotalSuprising = Math.max(2, 3 * minBestResult - 4); // (a-2)+(a-2)+a

				int result = 0;

				List<Integer> googlerScores = new ArrayList<>();
				for (int i = 3; i < googlers + 3; i++) {
					googlerScores.add(input[i]);
				}
				Collections.sort(googlerScores, Collections.reverseOrder());

				for (int googlerScore : googlerScores) {
					if (googlerScore >= minTotal) {
						result++;
					} else if ((suprisingTriplets > 0) && (googlerScore >= minTotalSuprising)) {
						suprisingTriplets--;
						result++;
					} else {
						break;
					}
				}

				return String.valueOf(result);
			}

		}.run();
	}
}
