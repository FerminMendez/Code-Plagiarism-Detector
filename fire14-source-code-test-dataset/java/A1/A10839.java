package be.mokarea.gcj.googledancers;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

import be.mokarea.gcj.common.TestCaseReader;

public class GoogleDancerTestCaseReader extends
		TestCaseReader<GoogleDancerTestCase> {
	private final LineNumberReader lineReader;
	private final int NUMBER_TEST_CASE;
	private int currentCaseNumber;
	
	public GoogleDancerTestCaseReader(InputStream inputStream) throws NumberFormatException, IOException {
		lineReader = new LineNumberReader(new InputStreamReader(inputStream));
		NUMBER_TEST_CASE = Integer.parseInt(lineReader.readLine());
		currentCaseNumber = 0;	}

	@Override
	public GoogleDancerTestCase nextCase() throws Exception {
		String line = lineReader.readLine();
		if (line != null) {
			currentCaseNumber++;
			String[] tokens = line.split(" ");
			final int numberOfGooglers = Integer.parseInt(tokens[0]);
			final int numberOfSurprisingTripletsOfScores = Integer.parseInt(tokens[1]);
			final int scoreLowerBoundary = Integer.parseInt(tokens[2]);
			
			final int scores[] = new int[numberOfGooglers];
			for (int i = 3, j = 0 ; i < tokens.length ; i++, j++) {
				scores[j] = Integer.parseInt(tokens[i]);
			}
			return new GoogleDancerTestCase(currentCaseNumber, numberOfGooglers, numberOfSurprisingTripletsOfScores, scoreLowerBoundary, scores);
		}
		return null;	}

	@Override
	public int getMaxCaseNumber() {
		return NUMBER_TEST_CASE;
	}

}
