package quiz2012.quiz2;

import java.util.ArrayList;
import java.util.List;

import domain.QuizSolver;
import domain.QuizTestCaseInput;
import domain.QuizTestCaseOutput;

public class Quiz2Solver implements QuizSolver {
	private static final int NUMBER_OF_JUDGES = 3;

	@Override
	public QuizTestCaseOutput solve(QuizTestCaseInput testCaseInput) {
		Quiz2TestCaseInput input = (Quiz2TestCaseInput) testCaseInput;
		System.out.println(input);
		int numberOfGooglers = input.getNumberOfGooglers();
		int numberOfSurprising = input.getNumberOfSurprising();
		int minBestResult = input.getMinBestResult();
		int[] totalPoints = input.getTotalPoints();
		List<Googler> surprisePossibleGooglers = new ArrayList<Googler>();
		int numberOfGooglersHavingMinBestResultWithoutSurprising = 0;
		for (int i = 0; i < numberOfGooglers; i++) {
			int q = totalPoints[i] / NUMBER_OF_JUDGES;
			int r = totalPoints[i] % NUMBER_OF_JUDGES;
			Googler googler = new Googler(q, r);
			if (googler.getBestResult() >= minBestResult) {
				numberOfGooglersHavingMinBestResultWithoutSurprising++;
			} else {
				if (totalPoints[i] >= 2 && totalPoints[i] <= 28) {
					googler.setSurprising(true);
					surprisePossibleGooglers.add(googler);
				}
			}
		}

		int numberOfPossibleGooglersHavingMinBestResultWithSurprise = 0;
		for (Googler googler : surprisePossibleGooglers) {
			if (googler.getBestResult() >= minBestResult) {
				numberOfPossibleGooglersHavingMinBestResultWithSurprise++;
			}
		}

		int numberOfGooglersHavingMinBestResultWithSurprise = Math.min(
				numberOfSurprising,
				numberOfPossibleGooglersHavingMinBestResultWithSurprise);

		int numberOfGooglersHavingMinBestResult = numberOfGooglersHavingMinBestResultWithoutSurprising
				+ numberOfGooglersHavingMinBestResultWithSurprise;

		System.out.println(numberOfSurprising + ", "
				+ numberOfPossibleGooglersHavingMinBestResultWithSurprise
				+ ", " + numberOfGooglersHavingMinBestResultWithSurprise + ", "
				+ numberOfGooglersHavingMinBestResultWithoutSurprising + ", "
				+ numberOfGooglersHavingMinBestResult);
		return new Quiz2TestCaseOutput(numberOfGooglersHavingMinBestResult);
	}
}

class Googler {
	private final int q;
	private final int r;
	private boolean surprising;

	public Googler(int q, int r) {
		this.q = q;
		this.r = r;
	}

	public void setSurprising(boolean surprising) {
		this.surprising = surprising;
	}

	public Integer getBestResult() {
		switch (r) {
		case 0:
			return q + (surprising ? 1 : 0);

		case 1:
			return q + 1;

		case 2:
			return q + 1 + (surprising ? 1 : 0);
		}
		throw new IllegalStateException("r must be 0, 1, or 2: " + r);
	}

	@Override
	public String toString() {
		return "Googler [q=" + q + ", r=" + r + ", surprising=" + surprising
				+ "]";
	}
}