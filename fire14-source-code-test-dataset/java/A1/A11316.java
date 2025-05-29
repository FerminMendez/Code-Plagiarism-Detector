// Dancing With the Googlers

import java.io.*;

public class DancingWithGooglers {
	public static void main(String[] args) throws Exception {
		String inputPath = args[args.length-2];
		String outputPath = args[args.length-1];
		
		BufferedReader br = new BufferedReader(new FileReader(inputPath));
		int numberOfTestCases = Integer.parseInt(br.readLine());
		
		StringBuilder output = new StringBuilder();
		
		for (int i=1; i<=numberOfTestCases; i++) {
			String components[] = br.readLine().split(" ");
			int numberOfDancers = Integer.parseInt(components[0]);
			int numberOfSurprisingResults = Integer.parseInt(components[1]);
			int bestScore = Integer.parseInt(components[2]);
			int numberOfBestScores = 0;
			
			for (int totalScoreIndex=3; totalScoreIndex<(3+numberOfDancers); totalScoreIndex++) {
				int totalScore = Integer.parseInt(components[totalScoreIndex]);
				int average = totalScore / 3;
				int overflow = totalScore % 3;
				
				if (average >= bestScore) {
					numberOfBestScores++;
				} else if ((overflow != 0) && ((average+1) >= bestScore)) {
					numberOfBestScores++;
				} else if (numberOfSurprisingResults != 0) {
					if ((overflow == 2) && ((average+overflow) >= bestScore)) {
						numberOfBestScores++;
						numberOfSurprisingResults--;
					} else if ((overflow == 0) && (average > 0) && ((average+1) >= bestScore)) {
						numberOfBestScores++;
						numberOfSurprisingResults--;
					}
				}
				
//				System.out.println(totalScore + " " + average + " " + overflow + " " + numberOfBestScores);
			}
//			System.out.println("Case #" + i + ": " + numberOfBestScores + "\n");
			output.append("Case #" + i + ": " + numberOfBestScores + "\n");
		}
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(outputPath));
		String outputString = output.toString();
		bw.write(outputString, 0, outputString.length());
		bw.close();
	}
}
