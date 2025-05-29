package com.nitrous.codejam;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DancingWithGooglers {
	public static void readFile(String inputFile) throws IOException {
		File in = new File(inputFile);
		File dir = in.getParentFile();
		File outFile = new File(dir, in.getName()+".out");
		System.out.println("Output file is "+outFile.getAbsolutePath());
		PrintWriter out = new PrintWriter(outFile);
		BufferedReader reader = new BufferedReader(new FileReader(in));
		
		String line = null;
		
		int testCaseCount = Integer.parseInt(reader.readLine().trim());
		System.out.println("Read count="+testCaseCount);
		for (int testCase = 0 ; testCase < testCaseCount; testCase++) {
			line = reader.readLine();
//			// debug - ignore commented lines in input file
//			if (line.startsWith("#")) {
//				continue;
//			}
			
			System.out.println("\nCase #"+(testCase+1)+": "+line);
			String[] numStrArr = line.split(" ");
			int[] numArr = new int[numStrArr.length];
			for (int i = 0 ; i < numStrArr.length; i++) {
				numArr[i] = Integer.parseInt(numStrArr[i]);
			}
			int numGooglers = numArr[0];
			int surprises = numArr[1];
			int minHighScore = numArr[2];
			System.out.println("Googlers="+numGooglers);
			System.out.println("Suprises="+surprises);
			System.out.println("minHighScore="+minHighScore);
			int[] totalScore = new int[numGooglers];
			Googler[] googlers = new Googler[numGooglers];
			for (int googler = 0; googler < numGooglers; googler++) {
				totalScore[googler] = numArr[3 + googler];
				System.out.println("Googler ["+(googler+1)+"] got score "+totalScore[googler]);
				googlers[googler] = getPossibleScores(totalScore[googler], minHighScore);				
			}

			int result = calculate(googlers, surprises, minHighScore);
			out.println("Case #"+(testCase+1)+": "+result);
			System.out.println("Case #"+(testCase+1)+": "+result);
		}
		out.flush();
		out.close();
	}
	
	private static int calculate(Googler[] allGooglers, int expectedSurprises, int expectedMinResult) {
		// the active triplets being considered for the current iteration
		Triplet[] activeTriplet = new Triplet[allGooglers.length];
		Triplet[] resultTriplet = new Triplet[allGooglers.length];
		// pointer to current triplet being considered for each googler
		int[] activeTripletIdx = new int[allGooglers.length];
		for (int i = 0 ; i < activeTripletIdx.length; i++) {
			activeTripletIdx[i] = 0;
		}

		int permutations = 0;
		for (Googler googler : allGooglers) {
			if (permutations == 0) {
				permutations = googler.possibleScores.length;
			} else {
				permutations = permutations * googler.possibleScores.length;
			}
		}
		System.out.println("Processing "+permutations+" permutations");
		
		// the result
		int maxWinningGooglers = -1;
		for (int permutation = 0 ; permutation < permutations; permutation++) {
			// update pointers based on current permutation
			int tempPermutation = permutation;
			for (int googlerIdx = allGooglers.length - 1; googlerIdx >=0; googlerIdx--) {
				int idx = tempPermutation % allGooglers[googlerIdx].possibleScores.length;
				activeTripletIdx[googlerIdx] = idx;
				tempPermutation = tempPermutation / allGooglers[googlerIdx].possibleScores.length;
				// grab active triplet from each googler
				int pointer = activeTripletIdx[googlerIdx];
				activeTriplet[googlerIdx] = allGooglers[googlerIdx].possibleScores[pointer]; 
			}
			
			// check current set of triplets to see whether it yields the highest result
			int winningGooglers = 0;
			int numSurprises = 0;
			for (Triplet triplet : activeTriplet) {
				if (triplet.isSurprise) {
					numSurprises++;
				}
				if (numSurprises > expectedSurprises) {
					// exceeds expected number of surprises. not a match
					break;
				}
				
				if (triplet.bestResult >= expectedMinResult) {
					winningGooglers++;
				}
			}
			
			if (numSurprises == expectedSurprises) {
				// found the expected number of surprises.
				maxWinningGooglers = Math.max(maxWinningGooglers, winningGooglers);

				// debug
				for (int i = 0 ; i < resultTriplet.length; i++) {
					resultTriplet[i] = activeTriplet[i];
				}
			}			
		}
		
		// debug
		StringBuffer debug = new StringBuffer("Max winning scores: ");
		for (int i = 0 ; i < resultTriplet.length; i++) {
			debug.append(resultTriplet[i]+",");
		}
		System.out.println(debug.toString());
		
		return maxWinningGooglers;		
	}
	
	
	private static Googler getPossibleScores(int score, int minHighScore) {
		ArrayList<Triplet> possibleScores = new ArrayList<Triplet>();
		for(int judge0Score = 0; judge0Score <= 10; judge0Score++) {
			for(int judge1Score = 0; judge1Score <= 10; judge1Score++) {
				for(int judge2Score = 0; judge2Score <= 10; judge2Score++) {
					// skip impossible scores where 2 or more scores are more than 2 apart
					if (Triplet.isImpossible(judge0Score, judge1Score, judge2Score)) {
						continue;
					}
					
					// only add score combinations that result in the correct total score
					int totalScore = judge0Score + judge1Score + judge2Score;
					if (totalScore != score) {
						// skip non matching total scores
						continue;
					} 
					
					// valid score combination add to googler
					Triplet t = new Triplet(judge0Score, judge1Score, judge2Score);
					possibleScores.add(t);
					System.out.println("possible scores= ("+judge0Score+","+judge1Score+","+judge2Score+") "+(t.isSurprise ? " (*)" :""));
				}
			}
		}
		System.out.println("Possible score count "+possibleScores.size());
		Googler googler = new Googler(possibleScores.toArray(new Triplet[possibleScores.size()]));
		return googler;
	}
	
	private static class Googler {
		Triplet[] possibleScores;
		
		public Googler(Triplet[] possibleScores) {
			this.possibleScores = possibleScores;
		}
	}
	
	private static class Triplet {
		boolean isSurprise;
		int bestResult;
		
		private int scoreA, scoreB, scoreC;
		public Triplet(int scoreA, int scoreB, int scoreC) {
			this.scoreA = scoreA;
			this.scoreB = scoreB;
			this.scoreC = scoreC;
			this.isSurprise = isSurprise(scoreA, scoreB, scoreC);
			this.bestResult = Math.max(scoreA, Math.max(scoreB, scoreC));
		}
		
		
		@Override
		public String toString() {
			return "sum="+(scoreA+scoreB+scoreC)+" (" + scoreA + ", " + scoreB+", "+ scoreC + ")" +(isSurprise ? " *" : "");
		}


		/**
		 * Triplet is surprising if 2 or more scores are 2 apart 
		 * @param scoreA
		 * @param scoreB
		 * @param scoreC
		 * @return
		 */
		public static boolean isSurprise(int scoreA, int scoreB, int scoreC) {
			if (Math.max(scoreA, scoreB) - Math.min(scoreA, scoreB) >= 2) {
				return true;
			}
			if (Math.max(scoreB, scoreC) - Math.min(scoreB, scoreC) >= 2) {
				return true;
			}
			if (Math.max(scoreA, scoreC) - Math.min(scoreA, scoreC) >= 2) {
				return true;
			}
			return false;
		}
		/**
		 * No triplet contains scores > 2 apart
		 * @param scoreA
		 * @param scoreB
		 * @param scoreC
		 * @return
		 */
		public static boolean isImpossible(int scoreA, int scoreB, int scoreC) {
			if (Math.max(scoreA, scoreB) - Math.min(scoreA, scoreB) > 2) {
				return true;
			}
			if (Math.max(scoreB, scoreC) - Math.min(scoreB, scoreC) > 2) {
				return true;
			}
			if (Math.max(scoreA, scoreC) - Math.min(scoreA, scoreC) > 2) {
				return true;
			}
			return false;
		}
	}
	
	public static void main (String[] args) throws IOException {
//		readFile("D:/workspace/CodeJam/data/in.txt");
		readFile("D:/workspace/CodeJam/data/B-small-attempt0.in");
		
	}
}
