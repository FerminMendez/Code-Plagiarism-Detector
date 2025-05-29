package de.at.codejam.problem3.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

import de.at.codejam.problem3.Problem3Case;
import de.at.codejam.util.AbstractInputFileParser;
import de.at.codejam.util.TaskStatus;

public class Problem3InputFileParser extends
		AbstractInputFileParser<Problem3Case> {

	private int nextCaseNumber = 1;
	private int nextCaseLine = 2;

	public Problem3InputFileParser(File inputFile) {
		super(inputFile);
	}

	@Override
	public Problem3Case getNextCase() throws IOException {

		Problem3Case problem3Case = new Problem3Case();

		TaskStatus taskStatus = getTaskStatus();
		BufferedReader bufferedReader = null;

		try {

			bufferedReader = checkoutBufferedReader();
			taskStatus.setNumberCurrentCase(nextCaseNumber);

			List<String> lineList = readLines(bufferedReader, nextCaseLine, 1);

			String stringCase = lineList.get(0);
			StringTokenizer stringTokenizer = new StringTokenizer(stringCase,
					" ");

			String numberA = stringTokenizer.nextToken().trim();
			String numberB = stringTokenizer.nextToken().trim();

			problem3Case.setNumberA(numberA);
			problem3Case.setNumberB(numberB);

			nextCaseNumber++;
			nextCaseLine += 1;

		} finally {
			if (null != bufferedReader) {
				try {
					checkinBufferedReader(bufferedReader);
				} catch (IOException e) {

				}
			}
		}

		return problem3Case;
	}

}
