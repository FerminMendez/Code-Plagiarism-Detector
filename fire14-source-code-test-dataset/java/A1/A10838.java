package be.mokarea.gcj.googledancers;

import be.mokarea.gcj.common.TestCase;

public class GoogleDancerTestCase extends TestCase {

	private final int numberOfGooglers;
	private final int numberOfSurprisingTripletsOfScores;
	private final int scoreLowerBoundary;
	private final int[] scores;
	
	protected GoogleDancerTestCase(int caseNumber, int numberOfGooglers, int numberOfSurprisingTripletsOfScores, int scoreLowerBoundary, int[] scores) {
		super(caseNumber);
		this.numberOfGooglers = numberOfGooglers;
		this.numberOfSurprisingTripletsOfScores = numberOfSurprisingTripletsOfScores;
		this.scoreLowerBoundary = scoreLowerBoundary;
		this.scores = scores;
	}

	public int getNumberOfGooglers() {
		return numberOfGooglers;
	}

	public int getMaxNumberOfSurprisingTripletsOfScores() {
		return numberOfSurprisingTripletsOfScores;
	}

	public int getScoreLowerBoundary() {
		return scoreLowerBoundary;
	}

	public int[] getScores() {
		return scores;
	}

}
