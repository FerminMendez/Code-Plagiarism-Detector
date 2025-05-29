//package com.GoogleCodeJam.y2012.Qualification.RecycledNumbers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class RecycledNumbers {
	public static void main(String[] args) {
		try {
			BufferedReader in = new BufferedReader(new FileReader(new File("C-small-attempt0.in")));
			int numberOfCases = Integer.parseInt(in.readLine());
			for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
				String[] bounds = in.readLine().split(" ");
				int min = Integer.parseInt(bounds[0]);
				int max = Integer.parseInt(bounds[1]);
				int number = getNumber(min, max);
				System.out.println("Case #" + caseNumber + ": " + number);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static int getNumber(int min, int max) {
		int sum = 0;
		int length = (min+"").length();
		for (int i=min; i<=max; i++) {
			if (isMinimalRotation(i, min, max, length)) {
				sum += getNumberOfPairs(i, min, max, length);
			}
		}
		return sum;
	}

	public static boolean isMinimalRotation(int posit, int min, int max, int length) {
		String doubledIn = posit + "" + posit;
		for (int j = 0; j<length; j++) {
			int theorem = Integer.parseInt((String) doubledIn.subSequence(j, j+length));
			if (theorem >= min && theorem < posit) {
				return false;
			}
		}
		return true;
	}
	public static int getNumberOfPairs(int posit, int min, int max, int length) {
		Set<String> seen = new HashSet<String>();
		String doubledIn = posit + "" + posit;
		int counted = 0;
		for (int j = 0; j<length; j++) {
			String subSequence = (String) doubledIn.substring(j, j+length);
			int theorem = Integer.parseInt(subSequence);
			if (theorem >= min && theorem <= max && !seen.contains(subSequence)) {
				seen.add(subSequence);
				counted += 1;
			}
		}
		if (counted == 1) {
			return 0;
		}
		if (counted == 2) {
			return 1;
		}
		if (counted == 3) {
			return 3;
		}
		if (counted == 4) {
			return 6;
		}
		if (counted == 5) {
			return 10;
		}
		if (counted == 6) {
			return 15;
		}
		if (counted == 7) {
			return 21;
		}
		return counted*(counted-1)/2;
	}
}
