package com.google;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DancingGooglers {

	private static boolean testing = false;

	private static int surprisingScores;

	private static int getPossibleCount(int score, int findingThreshold) {
		int a;
		int b;
		int c;
		a = b = c = (score / 3);
		int rem = score % 3;
		if (b < findingThreshold - 2) {
			return 0;
		}
		if (b >= findingThreshold) {
			if (testing) {
				System.out.println("SUCCESS1:  score: " + score + ", a: " + a
						+ ", b: " + b + ", c: " + c);
			}
			return 1;
		}
		if (b == findingThreshold - 1) {
			if (rem >= 1) {
				if (testing) {
					System.out.println("SUCCESS2:  score: " + score + ", a: "
							+ a + ", b: " + b + ", c: " + c);
				}
				return 1;
			} else if (surprisingScores > 0 && a > 0) {
				surprisingScores--;
				if (testing) {
					System.out.println("SUCCESS3:  score: " + score + ", a: "
							+ a + ", b: " + b + ", c: " + c);
				}
				return 1;
			}
			return 0;
		}
		if (b == findingThreshold - 2 && rem == 2 && surprisingScores > 0) {
			surprisingScores--;
			if (testing) {
				System.out.println("SUCCESS4:  score: " + score + ", a: " + a
						+ ", b: " + b + ", c: " + c);
			}
			return 1;
		}
		return 0;
	}

	private static int countMaxPossible(Scanner scanner) {
		int count = 0;
		int numOfScores = scanner.nextInt();
		surprisingScores = scanner.nextInt();

		int findingThreshold = scanner.nextInt();
		int[] scores = new int[numOfScores];
		for (int i = 0; i < numOfScores; i++) {
			scores[i] = scanner.nextInt();
			count += getPossibleCount(scores[i], findingThreshold);
		}
		// start printing
		if (testing) {
			System.out.println("numOfScores: " + numOfScores);
			System.out.println("surprisingScores: " + surprisingScores);
			System.out.println("findingThreshold: " + findingThreshold);
			for (int i : scores) {
				System.out.print(i + ", ");
			}
			System.out.println();
		}
		// end printing
		return count;
	}

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("d:\\codeJam\\Dancing\\test.txt");
		Scanner scanner = new Scanner(file);
		int t = scanner.nextInt();
		int count;
		for (int i = 1; i <= t; i++) {
			count = countMaxPossible(scanner);
			System.out.println("Case #" + i + ": " + count);
		}
	}
}
