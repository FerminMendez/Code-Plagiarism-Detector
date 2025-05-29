import java.util.Scanner;


public class Scoring {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numLines = sc.nextInt();
		int lineCount = 1;
		
		while (numLines > 0) {
			int numGoogler = sc.nextInt();
			int numSurprisingScores = sc.nextInt();
			int scoreThreshold = sc.nextInt();
			int result = 0;
//			System.out.println(numGoogler +" "+ numSurprisingScores +" "+ scoreThreshold);
			while (numGoogler > 0) {
				int totalScore = sc.nextInt();
//				System.out.println(totalScore);
				boolean passed = processScore(scoreThreshold, totalScore);
				
				if (passed) {
					result++;
//					System.out.println("here!!!");
				} else if (!passed && numSurprisingScores > 0) {
					int maxPossibleScore = calculateMaxScore(totalScore);
					if (maxPossibleScore >= scoreThreshold) {
						result++;
						numSurprisingScores--;
//						System.out.println("here!");
					}
//					System.out.println("here!!");
				}
				numGoogler--;
			}
			System.out.println("Case #" + lineCount + ": " + result);
			lineCount++;
			numLines--;
		}
	}
	
	private static int calculateMaxScore(int totalScore) {
		int avg = totalScore/3;
		int mod = totalScore%3;
		int max = 0;
		if (totalScore != 0) {
			if (mod <= 1) {
				max = avg+1;
			} else if (mod == 2) {
				max = avg+2;
			}
		}
		return max;
	}

	public static boolean processScore(int scoreThreshold, int totalScore) {
		int avg = totalScore/3;
		int mod = totalScore%3;
//		System.out.println(avg+" "+mod);
		
		if (mod > 0) {
			if (avg+1 >= scoreThreshold) {
				return true;
			}
		} else if (mod == 0) {
			if (avg >= scoreThreshold) {
				return true;
			}
		}
		return false;
	}

}
