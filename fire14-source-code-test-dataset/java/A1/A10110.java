package org.alaoui.googledance;

public class Dancer {

	private int totalScore;

	private Integer maxOrdinaryScore;

	private Integer maxSurprisingScore;

	public Dancer(int totalScore) {
		this.totalScore = totalScore;
		computeMaxScores();
	}

	private void computeMaxScores() {
		int mod = totalScore % 3;
		int floor = (int) Math.floor(totalScore / 3);

		maxOrdinaryScore = floor;
		if (mod >= 1) {
			maxOrdinaryScore++;
		}

		if (mod != 1 && maxOrdinaryScore != 10 && maxOrdinaryScore != 0) {
			maxSurprisingScore = maxOrdinaryScore + 1;
		}

	}

	/**
	 * @return the maxOrdinaryScore
	 */
	public Integer getMaxOrdinaryScore() {
		return maxOrdinaryScore;
	}

	/**
	 * @param maxOrdinaryScore
	 *            the maxOrdinaryScore to set
	 */
	public void setMaxOrdinaryScore(Integer maxOrdinaryScore) {
		this.maxOrdinaryScore = maxOrdinaryScore;
	}

	/**
	 * @return the maxSurprisingScore
	 */
	public Integer getMaxSurprisingScore() {
		return maxSurprisingScore;
	}

	/**
	 * @param maxSurprisingScore
	 *            the maxSurprisingScore to set
	 */
	public void setMaxSurprisingScore(Integer maxSurprisingScore) {
		this.maxSurprisingScore = maxSurprisingScore;
	}
}
