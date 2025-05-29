package be.mokarea.gcj.googledancers;

import java.io.PrintWriter;

import be.mokarea.gcj.common.TestCaseReader;
import be.mokarea.gcj.common.Transformation;

public class GoogleDancerTransformation extends
		Transformation<GoogleDancerTestCase> {

	public GoogleDancerTransformation(
			TestCaseReader<GoogleDancerTestCase> caseReader,
			PrintWriter outputWriter) {
		super(caseReader, outputWriter);
	}

	@Override
	protected String transform(GoogleDancerTestCase testCase) {
		final int minimumScoreWithoutSurprise = Math.max((3 * testCase.getScoreLowerBoundary()) - 2,testCase.getScoreLowerBoundary());
		final int mimnumScoreWithSurprise = Math.max(minimumScoreWithoutSurprise -2,testCase.getScoreLowerBoundary());
		int countNotSurpisingScores = 0;
		int countSurpisingScores = 0;
		for (int score : testCase.getScores()) {
			if (score >=minimumScoreWithoutSurprise) {
				countNotSurpisingScores++;
			} else if (score >=mimnumScoreWithSurprise) {
				countSurpisingScores++;
			}
		}
		int count = countNotSurpisingScores + Math.min(countSurpisingScores, testCase.getMaxNumberOfSurprisingTripletsOfScores());
		return formatOutput(testCase.getCaseNumber(), count);
	}

	private String formatOutput(int caseNumber, int count) {
		StringBuffer buf = new StringBuffer();
		buf.append("Case #");
		buf.append(caseNumber);
		buf.append(": ");
		buf.append(count);
		return buf.toString();
	}

}
