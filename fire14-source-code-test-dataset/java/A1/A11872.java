package qualificationround;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class ProblemBDancingGooglers {

	public ProblemBDancingGooglers() {
		try {
			FileReader fr = new FileReader("B-small-attempt0.in");
			BufferedReader br = new BufferedReader(fr);
			
			FileWriter fw = new FileWriter("B-small-attempt0.out");
			BufferedWriter bw = new BufferedWriter(fw);
			
			int numCases = Integer.parseInt(br.readLine());
			int caseNum = 1;
			
			String line = br.readLine();
			while (line != null) {
				System.out.println(line);
				int numGooglers = getNumGooglersFromLine(line);
				int numSurprises = getNumSurprisesFromLine(line);
				int bestScore = getBestScoreFromLine(line);
				int[] scores = getScoresFromLine(line, numGooglers);
				
				int possibles = 0;
				for (int i=0; i<scores.length; i++) {
					int withSurprise = bestScoreWithSurprise(scores[i]);
					int withoutSurprise = bestScoreNoSurprise(scores[i]);
					
					if (withoutSurprise >= bestScore) {
						possibles++;
					} else if (withSurprise >= bestScore && numSurprises > 0) {
						possibles++;
						numSurprises--;
					}
				}
				
				String output = "Case #"+ caseNum;
				output += ": "+possibles;
				
				System.out.println(output);
				bw.append(output);
				if (caseNum != numCases)
					bw.newLine();
				
				caseNum++;
				line = br.readLine();
			}
			
			bw.flush();
			bw.close();
			br.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public int[] getScoresFromLine(String line, int numScores) {
		int[] scores = new int[numScores];

		int firstSpace = line.indexOf(" ");
		int secondSpace = line.indexOf(" ",firstSpace + 1);
		int thirdSpace = line.indexOf(" ",secondSpace + 1);
		
		line = line.substring(thirdSpace + 1);
		
		String[] scoreStrings = line.split(" ");
		for (int i=0; i<scoreStrings.length; i++) {
			scores[i] = Integer.parseInt(scoreStrings[i]);
		}
		
		return scores;
	}
	
	public int getNumGooglersFromLine(String line) {
		String[] split = line.split(" ");
		return Integer.parseInt(split[0]);
	}
	
	public int getNumSurprisesFromLine(String line) {
		String[] split = line.split(" ");
		return Integer.parseInt(split[1]);
	}
	
	public int getBestScoreFromLine(String line) {
		String[] split = line.split(" ");
		return Integer.parseInt(split[2]);
	}
	
	/**
	 * 
	 * @param totalScore
	 * @return the best possible score without a surprise
	 */
	public int bestScoreNoSurprise(int totalScore) {
		return Math.min(totalScore, (totalScore + 2) / 3);
	}
	
	/**
	 * 
	 * @param totalScore
	 * @return the best possible score with a surprise
	 */
	public int bestScoreWithSurprise(int totalScore) {
		return Math.min(totalScore,Math.min((totalScore + 4) / 3,10));
	}
	
	public static void main(String[] args) {
		new ProblemBDancingGooglers();
	}

}
