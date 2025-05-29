package com.google.codejam.qualrnd.dncingglers;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DancingGooglers {

	public void resolve() {
		
		DancingGooglersInputReader inputReader = new DancingGooglersInputReader();
		DancingGooglersInput input = inputReader.read();
		
		int noOfCases = input.getNoOfCases();
		GooglersScoreboard[] allScoreboards = input.getScoreboards();
		
		int[] result = null;
		
		BufferedOutputStream outputStream = null;
		try {
			outputStream = new BufferedOutputStream(new FileOutputStream("out.txt"));
		
			for (int caseIndex = 0; caseIndex < noOfCases; caseIndex++) {
				
				List<int[]> bestAndSurprisingTriplets = new ArrayList<int[]>();
				
				GooglersScoreboard scoreboard = allScoreboards[caseIndex];
				
				int bestScore = scoreboard.getBestScore();
				int expectedSurprising = scoreboard.getNoOfSurprisingScores();
				
				int totalBestScores = 0;
				int totalSurprising = 0;
				int both = 0;
				
				for (int score : scoreboard.getScores()) {
	
					result = findTripletFor(score, 2);
					
					if (isTripletBestResult(result, bestScore)) {
						totalBestScores++;
					}
					
					if (isTripletSurprising(result)) {
						totalSurprising++;
					}
	
					if (isTripletBestResult(result, bestScore)
							&& isTripletSurprising(result)) {
						both++;
						bestAndSurprisingTriplets.add(result);
					}
					
//					System.out.printf("[%d, %d, %d] ", result[0], result[1], result[2]);
				}
				
//				System.out.printf("Best: %d, Surprising: %d, Both:%d %n", totalBestScores, totalSurprising, both);
	
				if (totalSurprising > expectedSurprising) {
					totalSurprising = totalSurprising - (totalSurprising - both);
				}
				
				if (totalSurprising > expectedSurprising) {
					for (int[] tmpTriplet : bestAndSurprisingTriplets) {
						if (isStillBestAfterNonSurprisable(tmpTriplet, bestScore)) {
							totalSurprising--;
							both--;
						}
						
						if (totalSurprising <= expectedSurprising) {
							break;
						}
					}
				}
				
				if (totalSurprising > expectedSurprising) {
					totalBestScores = totalBestScores - (totalSurprising - expectedSurprising);
				}
				
				outputStream.write(String.format("Case #%d: %s\n", caseIndex+1, totalBestScores).getBytes());
				System.out.printf("Case #%d: %s%n", caseIndex+1, totalBestScores);
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (outputStream != null) {
				try {
					outputStream.flush();
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
			
			
	}
	
	private boolean isStillBestAfterNonSurprisable(int[] triplet, int bestScore) {
		if ((triplet[0] - 1) >= bestScore) {
			return true;
		}
		return false;
	}
	
	private int[] findTripletFor(int totalScore, int minDiff) {
		return processTriplet(10, 10, 10, totalScore, minDiff);
	}
	
	private int[] processTriplet(int sc1, int sc2, int sc3, int targetScore, int minDiff) {
		
//		System.out.printf("%d %d %d%n", sc1, sc2, sc3);
		
		int tripletTotal = sc1 + sc2 + sc3;
		
		if (tripletTotal == targetScore) {
			return (new int[]{sc1, sc2, sc3});
		}
		
		if ((sc3 > 0) && (sc2 - sc3 < minDiff) && (sc1 - sc3 < minDiff)) {
			return processTriplet(sc1, sc2, sc3-1, targetScore, minDiff);
		} else if (sc2 > 0 && sc1 - sc2 < minDiff) {
			return processTriplet(sc1, sc2-1, sc3, targetScore, minDiff);
		} else {
			return processTriplet(sc1-1, sc2, sc3, targetScore, minDiff);
		}
	}
	
	private boolean isTripletSurprising(int[] triplet) {
		return (triplet[0] - triplet[1] == 2 
				|| triplet[1] - triplet[2] == 2 
				|| triplet[0] - triplet[2] == 2);
	}
	
	private boolean isTripletBestResult(int[] triplet, int bestScore) {
		return (triplet[0] >= bestScore 
				|| triplet[1] >= bestScore 
				|| triplet[2] >= bestScore);
	}
	
	public static void main(String[] args) {
		new DancingGooglers().resolve();
	}
}
