package de.hg.codejam.tasks.numbers.service;

import java.util.HashSet;
import java.util.Set;

public class Calculator {

	private final Set<Integer> overallShifts = new HashSet<>();

	public int calculate(int[] pair) {
		int result = 0;

		int lowerBorder = pair[0];
		int upperBorder = pair[1];

		for (int i = lowerBorder; i <= upperBorder; i++) {
			if (!overallShifts.contains(i)) {
				Set<Integer> shifts = getShifts(i);

				int numberOfValidPairs = countValidPairs(shifts, lowerBorder,
						upperBorder);

				result += numberOfValidPairs;
			}
		}

		return result;
	}

	public static int[] calculate(int[][] pairs) {
		int[] results = new int[pairs.length];

		for (int i = 0; i < pairs.length; i++)
			results[i] = new Calculator().calculate(pairs[i]);

		return results;
	}

	private Set<Integer> getShifts(int number) {
		String n = String.valueOf(number);

		Set<Integer> result = new HashSet<>(n.length());
		result.add(number);

		for (int i = 1; i < n.length(); i++) {
			n = n.substring(n.length() - 1) + n.substring(0, n.length() - 1);

			result.add(Integer.parseInt(n));
		}

		overallShifts.addAll(result);

		return result;
	}

	private int countValidPairs(Set<Integer> numbers, int lowerBorder,
			int upperBorder) {
		int counter = 0;

		Integer[] array = new Integer[numbers.size()];
		numbers.toArray(array);

		for (int i = 0; i < array.length; i++)
			if (array[i] >= lowerBorder && array[i] <= upperBorder)
				for (int j = i + 1; j < array.length; j++)
					if (array[j] >= lowerBorder && array[j] <= upperBorder)
						if (array[i] != array[j]
								&& String.valueOf(array[i]).length() == String
										.valueOf(array[j]).length())
							counter++;

		return counter;
	}

}
