package google_code_jam;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Dancing {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(new FileInputStream("data/dancers.txt"));
	    try {
			// Read the number of tests
	    	int numTests = 0;
	    	int answer = 0;
	    	String testLine;
	    	if (scanner.hasNextLine())
	    		numTests = Integer.valueOf(scanner.nextLine());
	    	for (int i=1; i<=numTests; i++) {
	    		if (scanner.hasNextLine()) {
	    			testLine = scanner.nextLine();
	    			answer = getAnswer(testLine);
	    			System.out.println("Case #" + i + ": " + answer);
	    		}
			}
	    }
	    finally {
	      scanner.close();
	    }
	}
	
	private static int getAnswer(String testLine) {
		//System.out.println("The updateCounts was called with " + testLine);
		int numDancers = 0;
    	int numSurprises = 0;
    	int scoreToReach = 0;
    	int sumScores = 0;
		String[] parts = testLine.split(" ");
		numDancers = Integer.valueOf(parts[0]);
		numSurprises = Integer.valueOf(parts[1]);
		scoreToReach = Integer.valueOf(parts[2]);
		if (scoreToReach <= 0) {
			return numDancers;
		}
		int answer = 0;
		for (int j=0; j<numDancers; j++) {
			sumScores = Integer.valueOf(parts[j+3]);
			if (canBeNormal(sumScores, scoreToReach)) {
				answer++;
			} else if (numSurprises > 0 && canBeSurprise(sumScores, scoreToReach)) {
				answer++;
				numSurprises--;
			} else {
				// Didn't quality, do nothing
			}
		}
		return answer;
	}

	private static boolean canBeSurprise(int sumScores, int scoreToReach) {
		if (sumScores == 0)
			return false;
		if (sumScores >= 3 * (scoreToReach - 2) + 2)
			return true;
		else
			return false;
	}

	private static boolean canBeNormal(int sumScores, int scoreToReach) {
		return sumScores > 3 * (scoreToReach - 1);
	}
	
	

}
