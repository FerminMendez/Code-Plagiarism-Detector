import java.util.Scanner;
import java.io.*;

public class DancingGooglers {
	private static Scanner inFile;
	private static PrintWriter outFile;
	private static final String FILE_NAME = "B-small-attempt0";
	
	/* Copy & Paste: VARIABLES */
	
	private static int numCases, numGooglers, surpriseScores, bestScore, totalScore, trio, score1, score2, score3, answer;
	private static boolean trioFound;
	
	/* Copy & Paste: VARIABLES */
	
	public static void main(String[] args) throws IOException {
		inFile = new Scanner(new File(FILE_NAME + ".in"));
		outFile = new PrintWriter(FILE_NAME + ".out");
		
		numCases = inFile.nextInt();
		
		for (int caseNum = 0; caseNum < numCases; caseNum++) {
			numGooglers = inFile.nextInt();
			surpriseScores = inFile.nextInt();
			bestScore = inFile.nextInt();
			answer = 0;
			
			for (int googlerNum = 0; googlerNum < numGooglers; googlerNum++) {
				totalScore = inFile.nextInt();
				trioFound = false;
				
				if (bestScore > 0) {
					trio = 28 - (27 - ((bestScore - 1) * 3));
					score1 = bestScore;
					score2 = bestScore - 1;
					score3 = score2;
				}
				else {
					trio = 0;
					score1 = 0;
					score2 = 0;
					score3 = 0;
				}
				
				for (trio = trio; trio < 31 && !trioFound; trio++) {
					if (score1 + score2 + score3 == totalScore) {
						answer++;
						trioFound = true;
					}
					else {
						if (trio % 3 == 0) {
							score1++;
						}
						else if (trio % 3 == 1) {
							score2++;
						}
						else {
							score3++;
						}
					}
				}
				
				if (bestScore >= 2 && (totalScore - 1) % 3 != 0 && !trioFound) {
					
					score1 = bestScore;
					score2 = bestScore - 2;
					score3 = score2;
					
					for (trio = (bestScore - 2) * 2; trio < 18 && !trioFound && surpriseScores > 0; trio++) {
						if (score1 + score2 + score3 == totalScore) {
							answer++;
							surpriseScores--;
							trioFound = true;
						}
						else {
							if (trio % 2 == 0) {
								score2++;
							}
							else {
								score1++;
								score3++;
							}
						}
					}
				}
			}
			
			outFile.printf("Case #%d: %d\n", caseNum + 1, answer);
		}
		
		inFile.close();
		outFile.close();
		System.out.println("Succesfully written to " + FILE_NAME + ".out.");
	}
}
