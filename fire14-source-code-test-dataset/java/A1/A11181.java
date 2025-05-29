package com.codejam.qualification.b;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;

public class DancingWithGooglers {
	private Map<String, String> language = new HashMap<String, String>();
	
	public void main() throws IOException {
		List<String> inputLines = FileUtils.readLines(new File("B-small-attempt0.in"));
		
		int numberOfCases = Integer.parseInt(inputLines.get(0));
		List<String> outputLines = new ArrayList<String>();
		
		for (int idx = 1; idx < numberOfCases + 1; idx++) {
			int[] numbers = getNumbersForLine(inputLines, idx);
			int numberOfGooglersDancing = numbers[0];
			int numberOfSuprisingTriplets = numbers[1];
			int resultBetterThan = numbers[2];
			
			int countSimilarScores = 0;
			int countSuprisingScores = 0;
			
			int possibleGoodResult = resultBetterThan * 3 - 2;
			int possibleEdgeResult = resultBetterThan * 3 - 4;
			
			for (int resultIdx = 3; resultIdx < numbers.length; resultIdx++) {
				int result = numbers[resultIdx];
			
				if (result < resultBetterThan)
					continue;
				
				if (result >= possibleGoodResult) {
					countSimilarScores++;
				} else if (result >= possibleEdgeResult) {
					countSuprisingScores++;					
				}
			}
			
			int maximumResultsAbove = countSimilarScores;
			
			if (countSuprisingScores >  numberOfSuprisingTriplets) {
				countSuprisingScores = numberOfSuprisingTriplets;
			}
			
			maximumResultsAbove += countSuprisingScores;
			
			outputLines.add("Case #" + idx + ": " + maximumResultsAbove);
		}
		
		FileUtils.writeLines(new File("out.txt"), outputLines);
	}

	private int[] getNumbersForLine(List<String> outputLines, int idx) {
		String rawNumbers[] = outputLines.get(idx).split(" ");
		int numbers[] = new int[rawNumbers.length];
		
		for (int javaSux = 0; javaSux < rawNumbers.length; javaSux++) {
			numbers[javaSux] = Integer.parseInt(rawNumbers[javaSux]);
		}
		
		return numbers;
	}
		
}
