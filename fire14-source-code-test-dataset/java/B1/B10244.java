package nl.bertjesapps.googlecodejam;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class ProblemThree {
	
	private Set<String> results = new HashSet<>();
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length == 1) {
			String fileName = args[0];
			ProblemThree problemOne = new ProblemThree();
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
		int startingNumber = Integer.parseInt(parts[0]);
		int endingNumber = Integer.parseInt(parts[1]);
		for (int i = startingNumber; i <= endingNumber; i++) {
			countRecycled(i, endingNumber);
		}
		result = results.size();
		results = new HashSet<>();
		return "" + result;
	}
	
	private void countRecycled(int source, int endingNumber) {
		StringBuilder builder = new StringBuilder();
		builder.append(source);
		for (int i = 1; i < builder.length(); i++) {
			String checkNumber = builder.substring(i) + builder.substring(0,i);
			int resultNumber = Integer.parseInt(checkNumber);
			if (resultNumber > source && resultNumber <= endingNumber) {
				results.add("" + source + "" + resultNumber);
			}
		}
	}
}


