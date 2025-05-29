package QualificationRound.dancingwiththegooglers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Scoring {
	private List<String> inputLines = new ArrayList<String>();
	private List<String> outputLines = new ArrayList<String>();
	private static final String INPUT_FILE_NAME = "B-small-attempt0.in";
	private static final String OUTPUT_FILE_NAME = "output.txt";
	
	private List<SingleCase> cases = new ArrayList<Scoring.SingleCase>();
	
	public static void main(String[] args) {
		Scoring s = new Scoring();
		s.readLines();
		s.parseLines();
		s.generateOutput();
		s.outputLines();
	}
	
	
	private void readLines() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(INPUT_FILE_NAME));

			String line = reader.readLine();
			
			line = reader.readLine();
			while (line != null) {
				inputLines.add(line);
				line = reader.readLine();
			}
			
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	private void parseLines() {
		for (String inputLine : inputLines) {
			int readNumbers = 0;
			SingleCase singleCase = new SingleCase();
			String[] split = inputLine.split(" ");
			for (String s : split) {
				switch (readNumbers) {
					case 0:
						singleCase.numberOfGooglers = Integer.parseInt(s);
						break;
					case 1:
						singleCase.numberOfSurprises = Integer.parseInt(s);
						break;
					case 2:
						singleCase.minBestResult = Integer.parseInt(s);
						break;
					default:
						singleCase.scores.add(Integer.parseInt(s));
				}
				readNumbers++;
			}
			cases.add(singleCase);
		}
	}
	
	
	private void generateOutput() {
		int caseNumber = 1;
		for (SingleCase singleCase : cases) {
			outputLines.add(getOutputPrefix(caseNumber++) + singleCase.getResult());
		}
	}
	

	private void outputLines() {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME, false));
			
			for (String line : outputLines) {
				writer.write(line);
				if (!line.equals(outputLines.get(outputLines.size() - 1))) {
					 writer.write("\n");
				}
			}
			
			writer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private class SingleCase {
		@SuppressWarnings("unused") //unnecessary. Just use number of scores
		private int numberOfGooglers = 0;
		private int numberOfSurprises = 0;
		private int minBestResult = 0;
		private List<Integer> scores = new ArrayList<Integer>();
		
		private int getResult() {
			int clearPasses = 0;
			int potentialSurprises = 0;
			
			//Minimum clear pass is x + x-1 + x-1 where x is the minBestResult 
			int minForClearPass = (minBestResult * 3) - 2;
			//Minimum surprise pass is x + x-2 + x-2 where x is the minBestResult
			int minForSurprisePass = (minBestResult * 3) - 4;
			if (minForSurprisePass  < 1) {
				if (minBestResult == 0) {
					minForSurprisePass = 0;
				}
				else {
					minForSurprisePass = 1;
				}
			}
			
			for (int score : scores) {
				if (score >= minForClearPass) {
					clearPasses++;
				}
				else if (score >= minForSurprisePass) {
					potentialSurprises++;
				}
			}
			
			return clearPasses + (Math.min(potentialSurprises, numberOfSurprises));
		}
	}
	
	private String getOutputPrefix(int number) {
		return "Case #" + number + ": ";
	}
}
