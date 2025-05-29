package de.hg.codejam.tasks.dance.domain;

public class Case {
	private final byte[] totalPoints;
	private final int numberOfSurprisingTriplets;
	private final int numberOfGooglers;
	private final short bestResult;

	public Case(short bestResult, int numberOfSurprisingTriplets,
			byte[] totalPoints) {
		this.totalPoints = totalPoints;
		this.numberOfSurprisingTriplets = numberOfSurprisingTriplets;
		this.bestResult = bestResult;

		numberOfGooglers = totalPoints.length;
	}

	public byte[] getTotalPoints() {
		return totalPoints;
	}

	public int getNumberOfSurprisingTriplets() {
		return numberOfSurprisingTriplets;
	}

	public int getNumberOfGooglers() {
		return numberOfGooglers;
	}

	public short getBestResult() {
		return bestResult;
	}

	public static Case parse(String inputString) {
		String[] splitted = inputString.split(" ");

		int numberOfGooglers = Integer.parseInt(splitted[0]);
		int numberOfSurprisingTriplets = Integer.parseInt(splitted[1]);
		short bestResult = Short.parseShort(splitted[2]);

		byte[] totalPoints = new byte[numberOfGooglers];
		for (int i = 0; i < numberOfGooglers; i++)
			totalPoints[i] = Byte.parseByte(splitted[i + 3]);

		return new Case(bestResult, numberOfSurprisingTriplets, totalPoints);
	}

	@Override
	public String toString() {
		String s = "CASE[Number of Googlers: " + numberOfGooglers
				+ ", Number of surprising Scores: "
				+ numberOfSurprisingTriplets + ", Best result at least: "
				+ bestResult + ", Scores: ";

		for (int i = 0; i < totalPoints.length; i++)
			s += totalPoints[i] + (i < (numberOfGooglers - 1) ? " " : "");

		s += "]";

		return s;
	}
}
