package com.irabin.google.codejam.problem3;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class RecycledNumber {

	private Scanner scanner;
	private PrintWriter writer;

	public RecycledNumber(InputStream in, OutputStream os) {
		scanner = new Scanner(in);
		writer = new PrintWriter(os);
	}

	public void solve() {

		int n = Integer.parseInt(scanner.nextLine());

		for (int i = 1; i <= n; i++) {
			writer.print("Case #" + i + ": ");

			String output = "";

			int A = scanner.nextInt();
			int B = scanner.nextInt();

			int total = 0;
			for (int j = A; j <= B; j++) {

				String str = String.valueOf(j);
				if (str.length() < 2) {
					continue;
				}

				int startIndex = 1;
				int endIndex = str.length();
				while (startIndex < endIndex) {
					String notSubStr = str.substring(0, startIndex);
					String substr = str.substring(startIndex);

					String newValue = substr.concat(notSubStr);
					int C = Integer.valueOf(newValue);
					
					String strJ = String.valueOf(j);
					String strC = String.valueOf(C);

					if (A<=j && j < C && C <= B && strJ.length()==strC.length()) {
						total = total + 1;
					}

					startIndex = startIndex + 1;
				}

			}
			output = String.valueOf(total);

			writer.println(output);
			writer.flush();
		}
		writer.close();

	}

	public static void main(String args[]) {

		InputStream input = null;
		input = RecycledNumber.class.getResourceAsStream(args[0]);

		OutputStream output = null;
		try {
			output = new FileOutputStream(args[1]);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		RecycledNumber practise1 = new RecycledNumber(input, output);
		practise1.solve();
	}
}
