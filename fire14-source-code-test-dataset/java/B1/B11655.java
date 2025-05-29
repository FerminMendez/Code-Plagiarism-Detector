package com.quosco.codejam.pre;

import static java.lang.Math.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
	
	private static final String OUT_FORMAT = "Case #%d: %d\n";

	private static void solve() throws IOException {
		FileWriter fstream = new FileWriter("out.txt");		
		BufferedWriter out = new BufferedWriter(fstream);		
		
		
		Scanner s = new Scanner(Main.class.getResourceAsStream("/input.txt"));
		Integer nbOfCases = Integer.valueOf(s.nextLine());
		for (int i = 0; i < nbOfCases; i++) {
			String[] caseInputs = s.nextLine().split("\\s");
			Integer start = Integer.valueOf(caseInputs[0]);
			Integer end = Integer.valueOf(caseInputs[1]);
			int result = solveCase(start, end, out);
			out.write(String.format(OUT_FORMAT, i + 1, result));
		}
		out.close();
		
	}
	
	
	private static int solveCase(Integer start, Integer end, BufferedWriter out) throws IOException {
		HashSet<String> magicNumbers = new HashSet<String>();
//		int magicNumbers = 0;
		for (int i = start; i <= end; i++) {
			int nbOfDigits = (int) ceil(log10(i+1));
			for (int j = 1; j < nbOfDigits; j++) {
				int isMagic = ismagic(i, j, start, end);
				if (isMagic > 0) {
					magicNumbers.add(i + "," + isMagic);
//					magicNumbers++;
				}
			}
		}
		return magicNumbers.size();
//		return magicNumbers;
	}


	private static int ismagic(int initialNumber, int numberOfDigits, Integer start, Integer end) {
		String stringValue = Integer.toString(initialNumber);
		int cutPoint = stringValue.length() - numberOfDigits;
		
		if (stringValue.charAt(cutPoint) == '0') {
			return -1;
		}
		
		String stringNewNumber = stringValue.substring(cutPoint) + stringValue.substring(0, cutPoint);
		int newNumber = Integer.parseInt(stringNewNumber); 
		if (initialNumber < newNumber && newNumber >= start && newNumber <= end) {
			return newNumber;
		}
		
		return -1;
		
	}


	public static void main(String[] args) throws IOException {
		
		solve();
	}

}
