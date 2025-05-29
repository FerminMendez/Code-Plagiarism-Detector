package com.google.codejam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GooglerDanceSolver {

	public static int getMaximumPassCount(int passScore, int surpriseCount, List<Integer> scores) {
		int passCount = 0;

		int lowerBound = (passScore > 1) ? 3 * passScore - 4 : passScore;
		
		for (int score : scores) {
			if (score < lowerBound) {
				continue;
			} else if (score > 3 * passScore - 3) {
				passCount++;
			} else if (surpriseCount > 0) {
				passCount++;
				surpriseCount--;
			}
		}
		
		return passCount;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int totalCount = Integer.parseInt(scanner.nextLine());
		
		for (int i = 0; i < totalCount; i++) {
			String[] inputs = scanner.nextLine().split(" ");
			int n = Integer.parseInt(inputs[0]);
			int s = Integer.parseInt(inputs[1]);
			int p = Integer.parseInt(inputs[2]);
			List<Integer> scores = new ArrayList<Integer>(n);
			for (int j = 0; j < n; j++) {
				scores.add(Integer.parseInt(inputs[j+3]));
			}
			int answer = GooglerDanceSolver.getMaximumPassCount(p, s, scores);
			System.out.printf("Case #%d: %d%n", i+1, answer);
			//System.err.printf("[Debug Info] p=%d, s=%d, scores=%s%n", p, s, scores.toString());
		}
	}

}
