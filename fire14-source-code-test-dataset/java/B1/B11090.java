package codejam;

import fixjava.Pair;

public class Utils {

	public static long minLong(long firstVal, long... otherVals) {
		long minVal = firstVal;
		for (int i = 0; i < otherVals.length; i++)
			minVal = Math.min(firstVal, otherVals[i]);
		return minVal;
	}

	public static int minInt(int firstVal, int... otherVals) {
		int minVal = firstVal;
		for (int i = 0; i < otherVals.length; i++)
			minVal = Math.min(firstVal, otherVals[i]);
		return minVal;
	}

	public static float minFloat(float firstVal, float... otherVals) {
		float minVal = firstVal;
		for (int i = 0; i < otherVals.length; i++)
			minVal = Math.min(firstVal, otherVals[i]);
		return minVal;
	}

	/**
	 * ArgMin returned as a Pair<Integer, Integer>(index, value). Array must
	 * have at least one value.
	 */
	public static Pair<Integer, Integer> argMin(int[] arr) {
		int min = arr[0];
		int argMin = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < min) {
				min = arr[i];
				argMin = i;
			}
		}
		return new Pair<Integer, Integer>(argMin, min);
	}

	/**
	 * ArgMax returned as a Pair<Integer, Integer>(index, value). Array must
	 * have at least one value.
	 */
	public static Pair<Integer, Integer> argMax(int[] arr) {
		int max = arr[0];
		int argMax = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
				argMax = i;
			}
		}
		return new Pair<Integer, Integer>(argMax, max);
	}

}
