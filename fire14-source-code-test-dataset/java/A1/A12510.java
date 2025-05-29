package main;

import java.io.*;
import java.util.Scanner;

class Solver {
	public void createSolution(Scanner input, BufferedWriter outWriter) throws IOException {
		int numCases = input.nextInt();
		for (int i = 0; i < numCases; i++) {
			int solution = 0;
			int possibilities = 0;

			int numDancers = input.nextInt();
			int surprises = input.nextInt();
			int p = input.nextInt();
			
			for (int k = 0; k < numDancers; k++) {
				int score = input.nextInt();
				if (p == 0 || score > Math.max(0, (3*p - 3))) {
					solution++;
				} else if (score > Math.max(0, (3*p - 5))) {
					possibilities++;
				} else {
					// ignore because score < 3*p - 4
				}
			}

			if (surprises < possibilities) {
				solution = solution + surprises;
			} else {
				solution = solution + possibilities;
			}

			outWriter.write("Case #" + String.valueOf(i + 1) + ": " + solution + "\n");
		}
		outWriter.close();
	}
}
