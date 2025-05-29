package gcj2012.qr;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DancingWithTheGooglers {

	public static int getMax(int s, int p, int[] scores) {
		int numHigh = 0;
		int numPotential = 0;
		int score = 0;
		int best = 0;
		for (int i = 0; i < scores.length; i++) {
			score = scores[i];
			best = (score + 2) / 3;
			if (best >= p) {
				numHigh++;
			} else if ((score > 1) && (score < 29) && (best == p - 1) &&
					(score % 3 != 1)) {
				numPotential++;
			}
		}
		return numHigh + Math.min(numPotential, s);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		DancingWithTheGooglers sit = new DancingWithTheGooglers();
		if (args.length < 1 ) {
			System.out.println("File name not given");
			System.exit(1);
		}
		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		int t = Integer.parseInt(br.readLine());
		for (int i = 1; i <= t; i++) {
			String[] test = br.readLine().split(" ");
			int n = Integer.parseInt(test[0]);
			int s = Integer.parseInt(test[1]);
			int p = Integer.parseInt(test[2]);
			int[] scores = new int[n];
			for (int j = 0; j < n; j++) {
				scores[j] = Integer.parseInt(test[3 + j]);
			}
			System.out.printf("Case #%d: %d\n", i, getMax(s, p, scores));
		}
		br.close();
	}

}
