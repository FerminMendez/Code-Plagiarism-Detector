package com.paupicas.year2012.codejam.qr;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Collections;

public class B {

	public static void main(String[] args) throws Exception {
		String filename = "B-small-attempt3";
		BufferedReader inputFile = new BufferedReader(new FileReader(filename + ".in"));
		FileWriter outputFile = new FileWriter(filename + ".out");

		int casesNumber = Integer.valueOf(inputFile.readLine());
		for (int cn = 1; cn <= casesNumber; cn++) {
			String result = "Case #" + cn + ": ";

			String inputLine = inputFile.readLine();
			String[] textNums = inputLine.split(" ");
			int n = Integer.valueOf(textNums[0]);
			int s = Integer.valueOf(textNums[1]);
			int p = Integer.valueOf(textNums[2]);
			Integer[] scores = new Integer[n];

			for (int i = 3; i < textNums.length; i++) {
				int v = Integer.valueOf(textNums[i]);
				scores[i - 3] = v;
			}

			Arrays.sort(scores, Collections.reverseOrder());

			int count = 0;
			for (int i = 0; i < scores.length; i++) {
				Integer c = scores[i] / 3;
				Integer m = scores[i] % 3;

				if (m > 0) {
					c++;
				}

				if (c >= p) {
					count++;
				} else if (s > 0) {
					if ((m == 0 || m == 2) && c + 1 >= p && c + 1 <= scores[i]) {
						count++;
						s--;
					}
				}
			}

			result = result + count; // + " (" + inputLine + ")";

			System.out.println(result);
			outputFile.write(result);
			if (cn < casesNumber) {
				outputFile.write("\n");
			}
		}

		inputFile.close();
		outputFile.close();
	}

}
