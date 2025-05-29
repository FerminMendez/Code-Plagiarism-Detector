package nl.bertjesapps.googlecodejam;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ProblemTwo {
	
	enum Result { NOT_POSSIBLE,POSSIBLE_SURPRISING, POSSIBLE};
	private Map<Integer,Map<Integer, Result>> resultMap;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length == 1) {
			String fileName = args[0];
			ProblemTwo problemOne = new ProblemTwo();
			try {
				problemOne.solveFile(fileName);
			} catch (FileNotFoundException fnf) {
				System.out.println("File not found!");
				System.out.println(fnf.getMessage());
			} catch (IOException e) {
				System.out.println("Could not read file!");
			}
		} else {
			System.out.println("Need 1 argument!");
		}
	}

	private void solveFile(String fileName) throws IOException {
		fillResultMap();
		StringBuilder output = new StringBuilder();
		File file = new File(fileName);
		FileReader fileReader = new FileReader(file);
		BufferedReader reader = new BufferedReader(fileReader);
		String numberOfCasesString = reader.readLine();
		int numberOfCases = Integer.parseInt(numberOfCasesString);
		for (int i = 1; i <= numberOfCases; i++) {
			output.append("Case #" + i + ": ");
			output.append(solveLine(reader.readLine()));
			output.append("\r\n");
		}
		//output.append(results.size());
		FileWriter writer = new FileWriter(fileName.replace(".in", ".out"));
		writer.write(output.toString());
		writer.close();
	}
	
	private String solveLine(String lineToBeSolved) {
		int result = 0;
		String[] parts = lineToBeSolved.split(" ");
		int numberOfCandidates = Integer.parseInt(parts[0]);
		int surprisingScores = Integer.parseInt(parts[1]);
		int scoredAtLeast = Integer.parseInt(parts[2]);
		Map<Integer, Result> findMap = resultMap.get(scoredAtLeast); 
		for (int i = 3; i < numberOfCandidates + 3; i++) {
			if (findMap.get(Integer.parseInt(parts[i])) == Result.POSSIBLE) {
				result++;
			} else if (surprisingScores > 0 && findMap.get(Integer.parseInt(parts[i])) == Result.POSSIBLE_SURPRISING) {
				result++;
				surprisingScores--;
			}
		}
		return "" + result;
	}
	
	private void fillResultMap() {
		this.resultMap = new HashMap<>();
		for (int i = 0; i <= 10; i++) {
			Map<Integer, Result> scoreResults = new HashMap<>();
			for (int j = 0; j <=30;j++) {
				scoreResults.put(j, calculateResult(j, i));
			}
			resultMap.put(i, scoreResults);
		}
	}
	
	private Result calculateResult(int googlerScore, int scoredAtLeast) {
		Result res = Result.NOT_POSSIBLE;
		int scoredAtLeastMin1 = scoredAtLeast - 1 >= 0?  scoredAtLeast - 1 : 0;
		int scoredAtLeastMin2 = scoredAtLeast - 2 >= 0?  scoredAtLeast - 2 : scoredAtLeastMin1;
		if (googlerScore >= scoredAtLeast + scoredAtLeastMin1 + scoredAtLeastMin1) {
			res = Result.POSSIBLE;
		} else if (googlerScore >= scoredAtLeast + scoredAtLeastMin2 + scoredAtLeastMin2) {
			res = Result.POSSIBLE_SURPRISING;
		}
		return res;
	}

}


