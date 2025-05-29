package com.google.codejam;

import static java.math.BigInteger.ONE;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;

public class RotatingNumbers {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		new RotatingNumbers().run();
	}

	private int count(BigInteger minValue, BigInteger maxValue) {
		BigInteger currentNumber = minValue;
		int counter = 0;
		
		while (!maxValue.equals(currentNumber)) {
			BigInteger candidate = null;
			int r = 1;
			while (!currentNumber.equals(candidate)) {
				candidate = rotateLeft(currentNumber, r++);
				if (candidate.compareTo(currentNumber) > 0 && candidate.compareTo(maxValue) <= 0 && candidate.compareTo(minValue) >= 0) {
					counter++;
				}
			}
			currentNumber = currentNumber.add(ONE);
		}
		return counter;
	}

	private void run() throws FileNotFoundException {
		BigInteger[][] data = parseInput("input");
		Integer[] result = solve(data);
		printResult(result, "output");
	}
	
	private Integer[] solve(BigInteger[][] data) {
		Integer[] result = new Integer[data.length];
		for (int i = 0; i < data.length; i++) {
			result[i] = count(data[i][0], data[i][1]);
		}
		return result;
	}

	private BigInteger rotateLeft(BigInteger value, int digits) {
		String stringValue = value.toString(10);
		StringBuilder result = new StringBuilder(stringValue.substring(digits));
		result.append(stringValue.substring(0, digits));
		return new BigInteger(result.toString(), 10);
	}

	private void printResult(Integer[] result, String path) throws FileNotFoundException {
		PrintWriter p = new PrintWriter(new File(path));
		try { 
			for (int i = 1; i < result.length+1; i++) {
				p.format("Case #%d: %d\n", i, result[i-1]);
			}
		} finally {
			p.close();
		}
	}

	private BigInteger[][] parseInput(String path) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File(path));
		try {
			BigInteger[][] input = new BigInteger[scanner.nextInt()][2];
			scanner.nextLine(); // skip to the next line
			for (int i = 0; i < input.length; i++) {
				input[i][0] = new BigInteger(scanner.next());
				input[i][1] = new BigInteger(scanner.next());
//				scanner.nextLine();
			}
			return input;
		} finally {
			scanner.close();
		}
	}
}
