package codejam2012;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import reusable.CodeJamBase;

public class RecycledNumbers {

	public static void main(String[] args) {
		new CodeJamBase("C-small-attempt0") {

			private int rotate(int value, int rotations, int totalRotations) {
				int tens = (int) Math.pow(10, rotations);
				int left = (int) Math.pow(10, totalRotations - rotations);

				return left * (value % tens) + (value / tens);
			}

			@Override
			protected String solution() {
				int[] input = nextIntArray();

				int lowerBound = input[0];
				int upperBound = input[1];

				Map<Integer, List<Integer>> distinctPairs = new HashMap<>();

				int result = 0;

				for (int n = lowerBound; n <= upperBound; n++) {
					int totalRotations = String.valueOf(lowerBound).length();

					for (int rotations = 1; rotations < totalRotations; rotations++) {
						int m = rotate(n, rotations, totalRotations);
						if (String.valueOf(m).length() != totalRotations) {
							continue;
						}

						if (distinctPairs.get(n) == null) {
							distinctPairs.put(n, new ArrayList<Integer>());
						}
						if (distinctPairs.get(n).contains(m)) {
							continue;
						}

						if ((lowerBound <= n) && (n < m) && (m <= upperBound)) {
							distinctPairs.get(n).add(m);
							result++;
						}
					}
				}

				return String.valueOf(result);
			}

		}.run();
	}

}
