package com.google.codejam;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ApplicationRecycledNumbers {
	
	public static final String fileName = "E:/Projects/RnD/GoogleCodeJam/src/com/google/codejam/google_data.txt";
	public static void main(String[] args) {
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
			String text = bufferedReader.readLine();
			if (text != null) {
				RecycledNumbersCalculator recycledNumbersCalculator = new RecycledNumbersCalculator();
				recycledNumbersCalculator.processData(Integer.parseInt(text), bufferedReader);
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
}


class RecycledNumbersCalculator {
	
	public void processData(int parseInt, BufferedReader bufferedReader) {
		String lineData;
		for (int counter = 1; counter <= parseInt; counter++) {
			try {
				lineData = bufferedReader.readLine();
				String[] integers = lineData.split(" ");
				int smallNumber = Integer.parseInt(integers[0]);
				int largeNumber = Integer.parseInt(integers[1]);
				int noOfRecyledPairs = getNoOfDistinctRecycledPairs(smallNumber, largeNumber);
				System.out.println("Case #" + counter + ": " + noOfRecyledPairs);
			} catch (IOException e) {
				e.printStackTrace();
			}				
		}
	}
	
	private int getNoOfDistinctRecycledPairs(int smallNumber, int largeNumber) {
			int noOfRecyledPairs = 0; 
			List<Integer> numberUsed = new ArrayList<Integer>();
			
			for (int firstNumber = smallNumber; firstNumber <= largeNumber; firstNumber++) {
				String firstNumberStr = String.valueOf(firstNumber);
				
				for (int m = firstNumber+1; m <= largeNumber; m++) {
					
					String secondNumber = String.valueOf(m);
					int secondNumberLength = secondNumber.length();
					
					for (int p = 1; p <= secondNumberLength-1; p++) {
						
						String trailingChars = secondNumber.substring((secondNumberLength-p), secondNumberLength);
						String startingChars = secondNumber.substring(0, (secondNumberLength-p));
						String newNumber = trailingChars + startingChars;
						if (newNumber.equals(firstNumberStr)) {
							if (!numberUsed.contains(firstNumber) && !numberUsed.contains(secondNumber)) {
								noOfRecyledPairs++;
								break;
							}								
						}
						
						//System.out.println("trailingChars: " + trailingChars + ", startingChars: " + startingChars);
					}
				}				
			}
			
			return noOfRecyledPairs;
	}
}
