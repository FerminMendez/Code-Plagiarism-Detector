/*
 * Problem B. Dancing With the Googlers
 * 
 * You're watching a show where Googlers (employees of Google) dance, and then
 * each dancer is given a triplet of scores by three judges. Each triplet of
 * scores consists of three integer scores from 0 to 10 inclusive. The judges
 * have very similar standards, so it's surprising if a triplet of scores
 * contains two scores that are 2 apart. No triplet of scores contains scores
 * that are more than 2 apart.
 * 
 * For example: (8, 8, 8) and (7, 8, 7) are not surprising. (6, 7, 8) and
 * (6, 8, 8) are surprising. (7, 6, 9) will never happen.
 * 
 * The total points for a Googler is the sum of the three scores in that
 * Googler's triplet of scores. The best result for a Googler is the maximum of
 * the three scores in that Googler's triplet of scores. Given the total points
 * for each Googler, as well as the number of surprising triplets of scores,
 * what is the maximum number of Googlers that could have had a best result of
 * at least p?
 * 
 * For example, suppose there were 6 Googlers, and they had the following total
 * points: 29, 20, 8, 18, 18, 21. You remember that there were 2 surprising
 * triplets of scores, and you want to know how many Googlers could have gotten
 * a best result of 8 or better.
 * 
 * With those total points, and knowing that two of the triplets were
 * surprising, the triplets of scores could have been:
 * 
 * 10 9 10
 * 6 6 8 (*)
 * 2 3 3
 * 6 6 6
 * 6 6 6
 * 6 7 8 (*)
 * 
 * The cases marked with a (*) are the surprising cases. This gives us 3
 * Googlers who got at least one score of 8 or better. There's no series of
 * triplets of scores that would give us a higher number than 3, so the answer
 * is 3.
 * 
 * Input
 * 
 * The first line of the input gives the number of test cases, T. T test cases 
 * follow. Each test case consists of a single line containing integers
 * separated by single spaces. The first integer will be N, the number of
 * Googlers, and the second integer will be S, the number of surprising triplets
 * of scores. The third integer will be p, as described above. Next will be N
 * integers ti: the total points of the Googlers.
 * 
 * Output
 * 
 * For each test case, output one line containing "Case #x: y", where x is the 
 * case number (starting from 1) and y is the maximum number of Googlers who
 * could have had a best result of greater than or equal to p.
 * 
 * Limits
 * 
 * 1 ≤ T ≤ 100.
 * 0 ≤ S ≤ N.
 * 0 ≤ p ≤ 10.
 * 0 ≤ ti ≤ 30.
 * At least S of the ti values will be between 2 and 28, inclusive.
 * 
 * Small dataset
 * 1 ≤ N ≤ 3.
 * 
 * Large dataset
 * 1 ≤ N ≤ 100.
 * 
 * Sample
 * 
 * Input 			
 * 4
 * 3 1 5 15 13 11
 * 3 0 8 23 22 21
 * 2 1 1 8 0
 * 6 2 8 29 20 8 18 18 21
 * 
 * Output 
 * Case #1: 3
 * Case #2: 2
 * Case #3: 1
 * Case #4: 3
 * 
 */
package google.codejam.y2012.qualifications;

import java.io.IOException;
import java.util.StringTokenizer;

import google.codejam.commons.Utils;

/**
 * @author Marco Lackovic <marco.lackovic@gmail.com>
 * @version 1.0, Apr 14, 2012
 */
public class DancingWithTheGooglers {

	private static final String INPUT_FILE_NAME = "B-small-attempt2.in";
	private static final String OUTPUT_FILE_NAME = "B-small-attempt2.out";

	private static final int NUM_SCORES = 3;
	private static final int MAX_SCORE = 10;

	public static void main(String[] args) throws IOException {
		String[] input = Utils.readFromFile(INPUT_FILE_NAME);
		String[] output = new String[input.length];
		int x = 0;
		for (String line : input) {
			StringTokenizer st = new StringTokenizer(line);
			int numGooglers = Integer.valueOf(st.nextToken());
			int numSurprisingScores = Integer.valueOf(st.nextToken());
			int bestResult = Integer.valueOf(st.nextToken());
			int[] totalPoints = new int[numGooglers];
			for (int i = 0; i < totalPoints.length; i++) {
				totalPoints[i] = Integer.valueOf(st.nextToken());
			}
			output[x++] = "Case #"
					+ x
					+ ": "
					+ maxNumGooglers(numSurprisingScores, bestResult,
							totalPoints);
		}
		Utils.writeToFile(output, OUTPUT_FILE_NAME);
	}

	private static int getMax(int total, boolean surprise) {
		if (total == 0) {
			return 0;
		}
		if (total == MAX_SCORE * NUM_SCORES) {
			return MAX_SCORE;
		}
		int floor = total / NUM_SCORES;
		if (surprise) {
			if ((total % NUM_SCORES) == 2) {
				floor += 2;
			} else {
				floor++;
			}
		} else {
			if ((total % NUM_SCORES) != 0) {
				floor++;
			}
		}
		return floor;
	}

	private static int maxWithoutSurprise(int total) {
		return getMax(total, false);
	}

	private static int maxWithSurprise(int total) {
		return getMax(total, true);
	}

	private static int maxNumGooglers(int numSurprisingScores, int bestResult,
			int[] totalPoints) {
		int numBestResults = 0;
		if (numSurprisingScores == 0) {
			for (int i = 0; i < totalPoints.length; i++) {
				if (maxWithoutSurprise(totalPoints[i]) >= bestResult) {
					numBestResults++;
				}
			}
			return numBestResults;
		}
		// Use the surprise on the first total which increases numBestResults
		int i = 0;
		for (; i < totalPoints.length; i++) {
			if (maxWithoutSurprise(totalPoints[i]) >= bestResult) {
				numBestResults++;
			} else {
				if (canUseSurprise(totalPoints[i])
						&& maxWithSurprise(totalPoints[i]) >= bestResult) {
					numBestResults++;
					int newSize = totalPoints.length - i - 1;
					if (newSize > 0) {
						int[] newTotalPoints = new int[newSize];
						for (int j = 0; j < newTotalPoints.length; j++) {
							newTotalPoints[j] = totalPoints[++i];
						}
						int numBestResults2 = (numBestResults - 1)
								+ maxNumGooglers(numSurprisingScores,
										bestResult, newTotalPoints);
						numBestResults += maxNumGooglers(
								numSurprisingScores - 1, bestResult,
								newTotalPoints);
						if (numBestResults > numBestResults2) {
							return numBestResults;
						}
						return numBestResults2;
					}
					return numBestResults;
				}
			}
		}
		return numBestResults;
	}

	private static boolean canUseSurprise(int total) {
		return total > 1 && total < 29;
	}
}
