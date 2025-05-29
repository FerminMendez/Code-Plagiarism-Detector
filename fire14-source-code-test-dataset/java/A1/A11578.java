package com.google.codejam.qualrnd.dncingglers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DancingGooglersInputReader {

	public DancingGooglersInput read() {

		Scanner scanner = new Scanner(System.in);
		String firstLine = scanner.nextLine();
		int noOfLines = Integer.parseInt(firstLine);
		GooglersScoreboard[] allScoreboards = new GooglersScoreboard[noOfLines];
		
		for (int lineNum = 0; lineNum < noOfLines; lineNum++) {
			
			String inputValues[] = scanner.nextLine().split(" ");
			GooglersScoreboard scoreboard = new GooglersScoreboard();
			int noOfGooglers = Integer.parseInt(inputValues[0]);
			
			scoreboard.setNoOfGooglers(noOfGooglers);
			scoreboard.setNoOfSurprisingScores(Integer.parseInt(inputValues[1]));
			scoreboard.setBestScore(Integer.parseInt(inputValues[2]));
			
			List<Integer> scores = new ArrayList<Integer>(noOfGooglers);
			
			for (int scoreIndex = 0; scoreIndex < noOfGooglers; scoreIndex++) {
				scores.add(Integer.parseInt(inputValues[scoreIndex+3]));
			}
			
			scoreboard.setScores(scores);
			allScoreboards[lineNum] = scoreboard;
		}

		return new DancingGooglersInput(noOfLines, allScoreboards);
	}
}
