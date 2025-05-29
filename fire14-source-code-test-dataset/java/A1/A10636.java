package cj2012;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class B {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader buffer = new BufferedReader(new FileReader(
				"B-small-attempt0.in"));
		int t = Integer.parseInt(buffer.readLine());
		for (int i = 0; i < t; i++) {
			String kase = buffer.readLine();
			StringTokenizer tokenizer = new StringTokenizer(kase);
			int n = Integer.parseInt(tokenizer.nextToken());
			int s = Integer.parseInt(tokenizer.nextToken());
			int p = Integer.parseInt(tokenizer.nextToken());
			int[] scores = new int[n];
			for (int j = 0; j < scores.length; j++) {
				scores[j] = Integer.parseInt(tokenizer.nextToken());
			}
			boolean done = false;
			int solution = 0, sdash = 0;
			int x = 0;
			for (int k = 0; k < n && !done; k++) {
				int make = make(scores[k], p);
				if (make == 0)
					x++;
				else if (make == 1 && s > sdash) {
					x++;
					sdash++;
				}
			}
			solution = x;
			System.out.printf("Case #%d: %d\n", (i + 1), solution);
		}
	}

	private static int make(int i, int p) {
		i -= p;
		if (i > 2 * p)
			return 0;
		if (i < 0)
			return -1;
		if (i > 2 * p - 3 && i < 2 * p + 3)
			return 0;
		if (i > 2 * p - 5 && i < 2 * p + 5)
			return 1;

		return -1;
	}
}
