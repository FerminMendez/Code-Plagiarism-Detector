package com.google.codejam;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CodeJam2 {
	private static int N, P, S;
	private static int inputNumbers[];
	private static int testCase;
	private static FileOutputStream fostream;
	private static DataOutputStream out;

	public static void main(String[] args) {

		try {
			fostream = new FileOutputStream("output2.out");
			out = new DataOutputStream(fostream);
			Scanner scanner = new Scanner(new File("B-small-attempt0.in"));
			String inputNumberline = scanner.nextLine();
			testCase = Integer.parseInt(inputNumberline);
			for (int i = 0; i < testCase; i++) {
				filterString(scanner.nextLine(), i);
			}
			out.close();
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}

	}

	private static void filterString(String fstring, int caseNumber) {

		final Pattern SPACE = Pattern.compile(" ");
		ArrayList<Integer> myList = new ArrayList<Integer>();
		ArrayList<Integer> baseList = new ArrayList<Integer>();
		int i = 0;
		for (String token : SPACE.split(fstring)) {
			try {
				if (i == 0) {
					inputNumbers = new int[Integer.parseInt(token) + 3];
					inputNumbers[i] = Integer.parseInt(token);
					i++;
				} else {
					inputNumbers[i] = Integer.parseInt(token);
					i++;
				}
			} catch (NumberFormatException ex) {
				System.err.println(token + " is not a number");
			}
		}

		P = inputNumbers[2];
		S = inputNumbers[1];
		N = inputNumbers[0];

		for (int j = 3; j < inputNumbers.length; j++) {
			myList.add(inputNumbers[j]);
			baseList.add(inputNumbers[j] / 3);

		}

		int mod[] = new int[N];
		int count;
		count = 0;
		for (int l = 0; l < N; l++) {
			mod[l] = myList.get(l) % 3;
			switch (mod[l]) {
			case 0:
				if (baseList.get(l) >= P)
					count++;
				else {
					if (S > 0 && baseList.get(l) > 0
					&& baseList.get(l) + 1 >= P) {
						count++;
						S--;
					}
				}
				break;
			case 1:
				if (baseList.get(l) >= P || baseList.get(l) + 1 >= P) {
					count++;
				} else {
					if (baseList.get(l) > 0 && baseList.get(l) + 1 >= P) {
						count++;
						S--;
					}
				}
				break;
			case 2:
				if (baseList.get(l) + 1 >= P || baseList.get(l) >= P) {
					count++;
				} else {
					if (S > 0 && baseList.get(l) + 2 >= P) {
						count++;
						S--;
					}
				}
				break;

			}
		}

		System.out.println("Case #" + (caseNumber + 1) + ": " + count);
		try {
			out.writeBytes("Case #" + (caseNumber + 1) + ": " + count + "\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} }

}



