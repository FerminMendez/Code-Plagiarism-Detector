package br.com.atama.google.jam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import br.com.atama.google.jam.dancing.ScoreCalculator;

public class Solver {

	public static void main(String[] args) throws IOException {
		FileReader reader = new FileReader("src/input-small.txt");
		BufferedReader bReader = new BufferedReader(reader);

		final int t = Integer.valueOf(bReader.readLine());
		for (int i = 1; i <= t; i++) {
			String[] tokens = bReader.readLine().split(" ");
			final int n = Integer.valueOf(tokens[0]);
			final int s = Integer.valueOf(tokens[1]);
			final int p = Integer.valueOf(tokens[2]);
			final int[] totals = new int[n];

			for (int j = 0; j < n; j++)
				totals[j] = Integer.valueOf(tokens[3 + j]);

			final ScoreCalculator calculator = new ScoreCalculator(s, p, totals);
			System.out.format("Case #%d: %d\n", i, calculator.calculate());
		}
		bReader.close();
		reader.close();
	}

}
