package be.mokarea.gcj.recyclednumbers;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

import be.mokarea.gcj.common.TestCaseReader;

public class RecycledNumbersTestCaseReader extends
		TestCaseReader<RecycledNumbersTestCase> {
	private final LineNumberReader lineReader;
	private final int NUMBER_TEST_CASE;
	private int currentCaseNumber;

	public RecycledNumbersTestCaseReader(InputStream inputStream) throws NumberFormatException, IOException {
		lineReader = new LineNumberReader(new InputStreamReader(inputStream));
		NUMBER_TEST_CASE = Integer.parseInt(lineReader.readLine());
		currentCaseNumber = 0;	
	}

	@Override
	public RecycledNumbersTestCase nextCase() throws Exception {
		String line = lineReader.readLine();
		if (line != null) {
			currentCaseNumber++;
			String[] tokens = line.split(" ");
			final int a = Integer.parseInt(tokens[0]);
			final int b = Integer.parseInt(tokens[1]);
			return new RecycledNumbersTestCase(currentCaseNumber,a,b);
		}
		return null;
	}

	@Override
	public int getMaxCaseNumber() {
		return NUMBER_TEST_CASE;
	}

}
