package de.johanneslauber.codejam.model.impl;

import de.johanneslauber.codejam.model.ICase;

/**
 * 
 * @author Johannes Lauber - joh.lauber@googlemail.com
 * 
 */
public class DancingGooglersCase implements ICase {
	private final int numberOfAttributes = 1;
	private int numberOfGooglers;
	private int numberOfTriplets;
	private int minLimitOfPoints;
	private int[] maxPointsOfGooglers;

	@Override
	public void setLine(int lineNumber, String lineValue) {
		if (lineNumber == 1) {
			String[] splittedLine = lineValue.split(" ");
			numberOfGooglers = Integer.parseInt(splittedLine[0]);
			numberOfTriplets = Integer.parseInt(splittedLine[1]);
			minLimitOfPoints = Integer.parseInt(splittedLine[2]);
			maxPointsOfGooglers = new int[splittedLine.length - 3];

			for (int i = 3; i < splittedLine.length; i++) {
				maxPointsOfGooglers[i - 3] = Integer.parseInt(splittedLine[i]);
			}

		} else {
			System.out.println("Linenumber is out of range");
		}
	}

	// Setter & Getter
	@Override
	public int getNumberOfAttributes() {
		return numberOfAttributes;
	}

	public int getNumberOfGooglers() {
		return numberOfGooglers;
	}

	public void setNumberOfGooglers(int numberOfGooglers) {
		this.numberOfGooglers = numberOfGooglers;
	}

	public int getNumberOfTriplets() {
		return numberOfTriplets;
	}

	public void setNumberOfTriplets(int numberOfTriplets) {
		this.numberOfTriplets = numberOfTriplets;
	}

	public int getMinLimitOfPoints() {
		return minLimitOfPoints;
	}

	public void setMinLimitOfPoints(int minLimitOfPoints) {
		this.minLimitOfPoints = minLimitOfPoints;
	}

	public int[] getMaxPointsOfGooglers() {
		return maxPointsOfGooglers;
	}

	public void setMaxPointsOfGooglers(int[] maxPointsOfGooglers) {
		this.maxPointsOfGooglers = maxPointsOfGooglers;
	}

}
