//package com.GoogleCodeJam.y2012.Qualification.DancingWithTheGooglers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DancingWithTheGooglers {
	public static void main(String[] args) {
		try {
			BufferedReader in = new BufferedReader(new FileReader(new File("B-small-attempt0.in")));
			int numCases = Integer.parseInt(in.readLine());
			for (int caseNum = 1; caseNum <= numCases; caseNum++) {
				String[] caseInput = in.readLine().split(" ");
				int numFound = getNumOverBar(caseInput);
				System.out.println("Case #"+ caseNum + ": " + numFound);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static int getNumOverBar(String[] caseInput) {
		int numGooglers = Integer.parseInt(caseInput[0]);
		int surprisingRemaining = Integer.parseInt(caseInput[1]);
		int minThreshhold = Integer.parseInt(caseInput[2]);
		int numFound = 0;
		for (int scoreId = 3; scoreId < (numGooglers + 3); scoreId ++) {
			int givenScore = Integer.parseInt(caseInput[scoreId]);
			int checkedScore = givenScore %3 == 0 ? givenScore : (givenScore + 3 - givenScore %3);
			if (checkedScore/3 >= minThreshhold) {
				numFound ++;
			} else if (givenScore == 0) {
				if (minThreshhold == 0) {
					numFound++;
				}
			} else if (surprisingRemaining > 0) {
				if (givenScore % 3 == 2) {
					if ((givenScore + 4)/3 >= minThreshhold) {
						numFound ++;
						surprisingRemaining --;
					}
				} else if (givenScore % 3 == 0) {
					if ((givenScore+3) / 3 >= minThreshhold) {
						numFound ++;
						surprisingRemaining --;
					}
				}
			}
		}
		return numFound;

	}
}
