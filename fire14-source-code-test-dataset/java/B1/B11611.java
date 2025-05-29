package com.google.codejam.qualrnd.recyclednums;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class RecycledNumbers {

	public void resolve() {
		
		RecycledNumbersInputReader inputReader = new RecycledNumbersInputReader();
		RecycledNumbersInput input = inputReader.read();
		
		int noOfCases = input.getNoOfCases();
		long[][] valuePairs = input.getNumPairs();
		
		long start = 0;
		long end = 0;
		BufferedOutputStream outputStream = null;
		try {
			outputStream = new BufferedOutputStream(new FileOutputStream("out.txt"));

			for (int caseIndex = 0; caseIndex < noOfCases; caseIndex++) {
				start = valuePairs[caseIndex][0];
				end = valuePairs[caseIndex][1];
				long output = findNoOfRecycledNumsBetween(start, end, 0);
			
				outputStream.write(String.format("Case #%d: %s\n", caseIndex+1, output).getBytes());
				System.out.printf("Case #%d: %s\n", caseIndex+1, output);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (outputStream != null) {
				try {
					outputStream.flush();
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private long findNoOfRecycledNumsBetween(long start, long end, long recycledNumsCount) {
		recycledNumsCount = countNoOfRecycledNums(start, end, start+1, recycledNumsCount);
		if (start < end) {
			recycledNumsCount = findNoOfRecycledNumsBetween(start+1, end, recycledNumsCount);
		}
		return recycledNumsCount;
				
	}
	
	private long countNoOfRecycledNums(long minLimit, long maxLimit, long nextNum, long recycledNumsCount) {
		if (nextNum > maxLimit) {
			return recycledNumsCount;
		}
		if (areCycleable(minLimit, nextNum)) {
			recycledNumsCount++;
		}
		recycledNumsCount = countNoOfRecycledNums(minLimit, maxLimit, nextNum+1, recycledNumsCount);
		return recycledNumsCount;
	}
	
	private boolean areCycleable(long a, long b) {
		
		if (a < b) {
			String num1 = String.valueOf(a);
			String num2 = String.valueOf(b);
			
			char[] digits = num1.toCharArray();
			
			if (num1.length() == num2.length()) {
				for (int index = 0; index < digits.length; index++) {
					// rotating the number
					char lastDigit = digits[digits.length-1];
					for (int rotateIndex = digits.length-1; rotateIndex > 0; rotateIndex--) {
						digits[rotateIndex] = digits[rotateIndex-1];
					}
					digits[0] = lastDigit;
					
					String rotatedNum = new String(digits);
					if (Integer.parseInt(rotatedNum, 10) == b) {
//						System.out.printf("Numbers %d and %d are recyclable.%n", a, b);
						return true;
					}
				}
			}
		}
//		System.out.printf("Numbers %d and %d are not recyclable.%n", a, b);
		return false;
	}
	
	public static void main(String[] args) {
		new RecycledNumbers().resolve();
	}
}
