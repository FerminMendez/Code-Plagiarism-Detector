import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;


public class ProblemB {
	public int[] deriveScores(int totalScore) {
		if (totalScore < 0 || totalScore > 30) {
			throw new IllegalArgumentException("invalid totalScore passed: " + totalScore);
		}
		
		int n = totalScore / 3;
		int r = totalScore % 3;
		int[] scores = new int[3];
		
		scores[0] = n;
		scores[1] = n + r / 2;
		scores[2] = n + r - (r / 2);
		
//		if (n == 0) {
//			if (surprise) {
//				scores[2] += r;
//			} else {
//				scores[1] += r / 2;
//				scores[2] += r - (r / 2);
//			}
//		} else if (n == 9) {
//			scores[1] += r / 2;
//			scores[2] += r - (r / 2);
//		} else if (0 < n && n < 9) {
//			if (surprise) {
//				if (r == 0) {
//					scores[0]--;
//					scores[2]++;
//				} else if (r == 1) {
//					scores[0]--;
//					scores[1]++;
//					scores[2] += 1;
//				} else if (r == 2) {
//					scores[2] += r;	
//				}
//			} else {
//				scores[1] += r / 2;
//				scores[2] += r - (r / 2);
//			}
//		}
		
		return scores;
	}
	
	public int[] makeSurprise(int[] scores) {
		int[] newScores = scores.clone();
		
		if (scores[0] >= 1 && scores[2] <= 9) {
			if (scores[2] == scores[0]) {
				newScores[0]--;
				newScores[2]++;				
			} else if (scores[2] == scores[1]) {
				newScores[1]--;
				newScores[2]++;
			}
		}
		
		return newScores;
	}
	
	public boolean checkIfSurprisingScore(int[] scores) {
		return scores[scores.length - 1] - scores[0] >= 2;
	}
	
	public void solve(String inputFileName, String outputFileName) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File(inputFileName)));
			BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));
			
			int testCount = Integer.parseInt(reader.readLine());
			for (int i = 0; i < testCount; i++) {
				String testCase = reader.readLine();
				String[] fields = testCase.split(" ");
				int manCount = Integer.parseInt(fields[0]);
				int surpriseCount = Integer.parseInt(fields[1]);
				int bestScore = Integer.parseInt(fields[2]);
				int bestScoreCount = 0;
				
				for (int j = 0; j < manCount; j++) {
					int totalScore = Integer.parseInt(fields[j + 3]);
					int[] scores = this.deriveScores(totalScore);
					
					if (scores[2] < bestScore) {
						if (surpriseCount > 0) {
							int[] tempScores = this.makeSurprise(scores);
							if (tempScores[2] >= bestScore) {
								scores = tempScores;
								surpriseCount--;
							}	
						}
					}
					
					if (scores[2] >= bestScore) {
						bestScoreCount++;
//						System.out.println(totalScore + ", best");
					} else {
//						System.out.println(totalScore);
					}
				}
				
				writer.write("Case #" + (i + 1) + ": " + bestScoreCount);
				writer.newLine();
			}
			
			reader.close();
			writer.close();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
	
	public static void main(String[] args) {
		ProblemB problem = new ProblemB();
//		problem.solve("B-small-attempt.in", "B-small-attempt.out");
		problem.solve("B-small-attempt0.in", "B-small-attempt0.out");
//		problem.solve("B-small-attempt.in", "B-small-attempt.out");
//		problem.solve("B-small-attempt.in", "B-small-attempt.out");
//		problem.solve("B-small-attempt.in", "B-small-attempt.out");
	}
}
