package codejam2012.qualifier;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class DancingWithTheGooglers {
	private int noOfCases;
	private int currentCase;
	private BufferedReader reader;
	private BufferedWriter writer;
	
	String str;
	
	int noOfTriplets, noOfSurprisingTriplets, targetScore;
	int noOfTargetScores;
	
	public static void main(String[] args) throws Exception {
		new DancingWithTheGooglers().solveProblem("input/2012Qualifier/B-small-attempt0.in.txt", "input/2012Qualifier/B-small-attempt0.out.txt");
	}
	
	private void solveProblem(String inputFileName, String outputFileName) throws Exception {
		reader = new BufferedReader(new FileReader(inputFileName));
		writer = new BufferedWriter(new FileWriter(outputFileName));
		
		try {
			String str = reader.readLine();
			noOfCases = Integer.parseInt(str);
			currentCase = 0;
			
			for(int i=0;i<noOfCases;i++) {
				readInput();
				process();
				writeOutput();
			}
		} finally {
			reader.close();
			writer.flush();
			writer.close();
		}
	}
	
	private void process() throws Exception {
		
	}
	
	private void readInput() throws Exception {
		currentCase++;
		str = reader.readLine();
		String[] strArr = str.split(" ");
		
		noOfTargetScores = 0;
		noOfTriplets = Integer.parseInt(strArr[0]);
		noOfSurprisingTriplets = Integer.parseInt(strArr[1]);
		targetScore = Integer.parseInt(strArr[2]);
		
		for(int i=3; i < strArr.length; i++) {
			int totalScore = Integer.parseInt(strArr[i]);
			int quotient = totalScore / 3;
			int reminder = totalScore % 3;
			
			if(totalScore == 0) {
				if(targetScore == 0) {
					noOfTargetScores++;
				}
			} else {
				if(quotient >= targetScore) {
					noOfTargetScores++;
				} else if(quotient + 1 == targetScore) {
					if(reminder > 0) {
						noOfTargetScores++;
					} else if(reminder == 0 && noOfSurprisingTriplets > 0) {
						noOfSurprisingTriplets--;
						noOfTargetScores++;
					}
				} else if(quotient + 2 == targetScore) {
					if(reminder == 2 && noOfSurprisingTriplets > 0) {
						noOfSurprisingTriplets--;
						noOfTargetScores++;
					}
				}
			}
		}
	}
	
	private void writeOutput() throws Exception {
		writer.write("Case #" + currentCase + ": ");
		writer.write("" + noOfTargetScores);
		writer.write("\n");
	}
}
