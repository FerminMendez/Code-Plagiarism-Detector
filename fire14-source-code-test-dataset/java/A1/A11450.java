package de.hg.codejam.tasks.dance.service;

import de.hg.codejam.tasks.dance.domain.Case;

public abstract class Calculator {

	public static int[] calculate(Case[] cases) {
		int[] results = new int[cases.length];

		for (int i = 0; i < cases.length; i++)
			results[i] = calculate(cases[i]);

		return results;
	}

	public static int calculate(Case c) {
		int result = 0;

		short upperBorder = calculateUpperBorder(c.getBestResult());
		short lowerBorder = calculateLowerBorder(c.getBestResult());

		int numberOfSurprisingTriplets = c.getNumberOfSurprisingTriplets();

		for (byte points : c.getTotalPoints()) {
			if (points >= upperBorder)
				result++;
			else if (points >= lowerBorder && numberOfSurprisingTriplets > 0) {
				result++;
				numberOfSurprisingTriplets--;
			}
		}

		return result;
	}

	private static short calculateUpperBorder(short bestResult) {
		if (bestResult < 1)
			return bestResult;

		return (short) (bestResult + 2 * (bestResult - 1));
	}

	private static short calculateLowerBorder(short bestResult) {
		if (bestResult < 2)
			return bestResult;

		return (short) (bestResult + 2 * (bestResult - 2));
	}

}
