package com.paupicas.year2012.codejam.qr;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class C {

	public static void main(String[] args) throws Exception {
		String filename = "C-small-attempt1";
		BufferedReader inputFile = new BufferedReader(new FileReader(filename + ".in"));
		FileWriter outputFile = new FileWriter(filename + ".out");

		int casesNumber = Integer.valueOf(inputFile.readLine());
		for (int cn = 1; cn <= casesNumber; cn++) {
			String result = "Case #" + cn + ": ";

			String[] tn = inputFile.readLine().split(" ");
			int a = Integer.valueOf(tn[0]);
			int b = Integer.valueOf(tn[1]);

			boolean[][] counted = new boolean[b - a + 1][b - a + 1];

			int c = 0;
			for (int i = a; i <= b; i++) {
				String is = String.valueOf(i);
				// System.out.println(is);
				for (int j = 1; j < is.length(); j++) {
					String ps = is.substring(j, is.length()) + is.substring(0, j);
					int p = Integer.valueOf(ps);
					if (p > i && p <= b && !counted[i - a][p - a]) {
						c++;
						counted[i - a][p - a] = true;
					}
					// System.out.println(ps);
				}
			}

			result = result + c;

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
