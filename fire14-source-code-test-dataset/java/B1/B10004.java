package qualification;

import java.util.HashMap;
import java.util.Scanner;

public class RecycledNumbers {

	//recycled numbers between A and B
	//OK, the key is being able to reduce each number to a single comparable value instead of comparing every possible match.
	//Let's say: We will take the permutation that has the smallest value.
	//creating them may be slow as long as looking them up is fast.

	//[not needed] Cache values to improve performance
	// perf test - worst possible case was solved in seconds.
	//we've only given 50 cases at most.
	//[DONE] what if more than two match? does that make 3 distinct recycled pairs?
	public static void main(final String[] args) {
		new RecycledNumbers().start();
	}

	private  void start() {
		final Scanner s = new Scanner(System.in);
		final int numTests = s.nextInt();
		for (int i = 0; i < numTests; i++) {
			//			deb("Case " + (i + 1) + "---------");
			final int startNum = s.nextInt();
			final int endNum = s.nextInt();
			final HashMap<String, Integer> values = new HashMap<String, Integer>();
			int distinctPairsCount = 0;
			for (int val = startNum; val <= endNum; val++) {
				final String newValue = findSmallestPermutation(""+val);
				if (values.containsKey(newValue)) {
					final int count = values.get(newValue);
					distinctPairsCount += count;
					values.put(newValue, count + 1);
					//					deb("found a match of " + count + ", total matches: " + distinctPairsCount);
				} else {
					values.put(newValue, 1);
				}
			}
			System.out.println("Case #" + (i+1) + ": " + distinctPairsCount);
		}
	}

	//We can't compare every permutation to every permutation
	//so we find the smallest and only use that.
	//this function looks slow, but it isn't called that often so should be OK.
	private String findSmallestPermutation(final String value) {
		int bestValue = Integer.MAX_VALUE;
		String bestString = null;
		final String valueTwice = value + value; //We will extract the substrings from this.
		for (int i = 0; i < value.length(); i++) {
			final String permutation = valueTwice.substring(i, value.length() + i);
			final int permutationValue = Integer.parseInt(permutation);
			if (permutationValue < bestValue) {
				bestValue = permutationValue;
				bestString = permutation;
			}
		}
		//		deb("source: " + value +", adding " + bestString);
		return bestString;
	}

	//	private void deb(final Object o) {
	//		System.out.println(o.toString());
	//	}

}
