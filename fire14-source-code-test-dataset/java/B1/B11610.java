package com.google.codejam.qualrnd.recyclednums;

import java.util.Scanner;

public class RecycledNumbersInputReader {

	public RecycledNumbersInput read() {

		Scanner scanner = new Scanner(System.in);
		String firstLine = scanner.nextLine();
		int noOfLines = Integer.parseInt(firstLine);
		long[][] numPairs = new long[noOfLines][2];
		
		
		for (int lineNum = 0; lineNum < noOfLines; lineNum++) {
			String inputValues[] = scanner.nextLine().split(" ");
			numPairs[lineNum][0] = Integer.parseInt(inputValues[0]);
			numPairs[lineNum][1] = Integer.parseInt(inputValues[1]);
		}

		return new RecycledNumbersInput(noOfLines, numPairs);
	}
}
