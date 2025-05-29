package b;

import java.io.*;
import java.lang.Math.*;
import java.util.HashMap;

public class B {

	public static void main(String[] args) {

		try {
			BufferedReader input = new BufferedReader(new FileReader("C:/CodeJam/B-small-attempt2.in"));
			BufferedWriter output = new BufferedWriter(new FileWriter("C:/CodeJam/B-small-attempt2.out"));
			try {
				int T = Integer.parseInt(input.readLine());

				//Process each case
				for (int i = 0; i < T; i++) {
					String line = input.readLine();

					String[] data = line.split(" ");
					int N = Integer.parseInt(data[0]);
					int S = Integer.parseInt(data[1]);
					int p = Integer.parseInt(data[2]);

					//Count the possible surprising/unsurprising scores
					int countU = 0;
					int countS = 0;
					for (int j = 0; j < N; j++) {
						int score = Integer.parseInt(data[j + 3]);

						//Minimum score to be surprising/unsurprising
						int minScoreS = 2 * (p - 2) + p;
						int minScoreU = 2 * (p - 1) + p;
						if (p == 0) {
							countU++;
						} else if (p == 1 && score > 0) {
							countU++;
						} else if (minScoreU >= 0 && score >= minScoreU) {
							countU++;
						} else if (minScoreS >= 0 && score >= minScoreS) {
							countS++;
						}
					}
					output.write("Case #" + (i + 1) + ": " + (countU + Math.min(S, countS)) + "\n");
				}
			} finally {
				input.close();
				output.close();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
