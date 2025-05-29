import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class DancingWithTheGooglers {
	private static final boolean DEBUG = false;
	private static final String FILENAME = "dancing";

	public static void main(String[] args) throws IOException {
		long startTime = System.nanoTime();

		if(DEBUG) {
			System.setIn(new BufferedInputStream(new FileInputStream(FILENAME + "_example.in")));
		} else {
			System.setIn(new BufferedInputStream(new FileInputStream(FILENAME + ".in")));
			System.setOut(new PrintStream(FILENAME + ".out"));
		}

		Scanner sc = new Scanner(System.in);

		int numTestCases = sc.nextInt();
		for(int caseNum = 1; caseNum <= numTestCases; caseNum++) {
			int numGooglers = sc.nextInt();
			int numSurprising = sc.nextInt();
			int scoreMaxLowerBound = sc.nextInt();
			
			int numGooglersWithBetter = 0;
			
			for(int i = 0; i < numGooglers; i++) {
				int totalScore = sc.nextInt();
				
				if(totalScore <= 1) {
					if(totalScore >= scoreMaxLowerBound) {
						numGooglersWithBetter++;
					}
				} else {
					int maxScore;
					if(totalScore % 3 == 0) {
						maxScore = totalScore / 3;
					} else {
						maxScore = totalScore / 3 + 1;
					}
					
					if(maxScore >= scoreMaxLowerBound) {
						numGooglersWithBetter++;
					} else if(numSurprising > 0) {
						maxScore++;
						
						if(maxScore >= scoreMaxLowerBound) {
							numGooglersWithBetter++;
							numSurprising--;
						}
					}
				}
			}
			
			System.out.println("Case #" + caseNum + ": " + numGooglersWithBetter);
		}

		if(DEBUG) System.out.println("Total time: " + ((System.nanoTime() - startTime) / 1000.0 / 1000.0 / 1000.0) + "s");
	}
}