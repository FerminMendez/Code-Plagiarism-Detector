package com.google.codejam;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CodeJam3 {
	private static int testCase;
	private static FileOutputStream fostream;
	private static DataOutputStream out;

	public static void main(String[] args) {

		try {
			fostream = new FileOutputStream("output3.out");
			out = new DataOutputStream(fostream);
			Scanner scanner = new Scanner(new File("C-small-attempt2.in"));
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
		int A = 0, B = 0;
		int i = 0;
		for (String token : SPACE.split(fstring)) {
			try {
				if (i == 0) {
					A = Integer.parseInt(token);
					i++;
				} else {
					B = Integer.parseInt(token);
					i++;
				}
			} catch (NumberFormatException ex) {
				System.err.println(token + " is not a number");
			}
		}

		int c1, c3, x1, x2, x3, x4;

		int count = 0;
		int length = String.valueOf(A).length();
		if (!(length < 2))
			for (int j = A; j < B; j++) {
				switch (length) {
				case 2:
					c1 = j % 10;
					c3 = j / 10;
					c1 = (c1 * 10) + c3;
					if (c1 > A && c1 <= B) {
						count++;
					}
					A++;
					break;
				case 3:
					x1 = j % 10;
					x2 = j % 100;
					x3 = j / 10;
					x4 = j / 100;
					x1 = (x1 * 100) + x3;
					x2 = (x2 * 10) + x4;
					if (x1 > A && x1 <= B) {
						count++;
					}
					if (x2 > A && x2 <= B) {
						count++;
					}
					A++;
					break;
				}
			}

		System.out.println("Case #" + (caseNumber + 1) + ": " + count);
		try {
			out.writeBytes("Case #" + (caseNumber + 1) + ": " + count + "\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
