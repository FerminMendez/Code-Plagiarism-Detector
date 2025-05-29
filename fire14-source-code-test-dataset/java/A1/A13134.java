package com.irabin.google.codejam.problem2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class DanceWithGoogler {

	class Score {

		private Long score;
		private Long firstJury;
		private Long secondJury;
		private Long thirdJury;

		public Score() {
		}

		public Long getScore() {
			return score;
		}

		public void setScore(Long score) {
			this.score = score;
		}

		public Long getFirstJury() {
			return firstJury;
		}

		public void setFirstJury(Long firstJury) {
			this.firstJury = firstJury;
		}

		public Long getSecondJury() {
			return secondJury;
		}

		public void setSecondJury(Long secondJury) {
			this.secondJury = secondJury;
		}

		public Long getThirdJury() {
			return thirdJury;
		}

		public void setThirdJury(Long thirdJury) {
			this.thirdJury = thirdJury;
		}

		public boolean isSuprisedResult() {
			boolean suprise = false;
			if (Math.abs(firstJury - secondJury) >= 2
					|| Math.abs(firstJury - thirdJury) >= 2
					|| Math.abs(secondJury - thirdJury) >= 2) {
				suprise = true;
			}
			return suprise;
		}

	}

	private Scanner scanner;
	private PrintWriter writer;

	public DanceWithGoogler(InputStream in, OutputStream os) {
		scanner = new Scanner(in);
		writer = new PrintWriter(os);
	}

	public void solve() {

		int n = Integer.parseInt(scanner.nextLine());

		for (int i = 1; i <= n; i++) {
			writer.print("Case #" + i + ": ");

			if (i == n-1) {
				System.out.println("Debug");
			}

			int N = scanner.nextInt();
			int S = scanner.nextInt();
			int p = scanner.nextInt();

			String output = "";
			int totalBetterThanP = 0;
			int foundSuprise = 0;

			Score[] scores = new Score[N];
			for (int j = 0; j < N; j++) {
				scores[j] = new Score();
				scores[j].setScore(scanner.nextLong());
			}

			// sort ascending
			for (int j = 0; j < N; j++) {
				for (int k = j + 1; k < N; k++) {
					if (scores[k].getScore() > scores[j].getScore()) {
						Score tempScore = scores[k];
						scores[k] = scores[j];
						scores[j] = tempScore;
					}
				}
			}

			for (int j = 1; j <= N; j++) {

				Long equalScore = scores[j - 1].getScore() / 3;

				Long firstJury = equalScore;
				Long secondJury = equalScore;
				Long thirdJury = equalScore;

				Long dividen = scores[j - 1].getScore() % 3;
				while (dividen > 0) {
					firstJury = firstJury + 1;
					dividen = dividen - 1;
					if (dividen > 0) {
						secondJury = secondJury + 1;
						dividen = dividen - 1;
					}
					if (dividen > 0) {
						thirdJury = thirdJury + 1;
						dividen = dividen - 1;
					}
				}

				scores[j - 1].setFirstJury(firstJury);
				scores[j - 1].setSecondJury(secondJury);
				scores[j - 1].setThirdJury(thirdJury);
			}

			for (int j = 1; j <= N; j++) {

				if (scores[j - 1].isSuprisedResult()) {
					foundSuprise = foundSuprise + 1;
				} else {
					if (foundSuprise < S && ((scores[j-1].getFirstJury()<p && scores[j-1].getSecondJury()<p && scores[j-1].getThirdJury()<p)||(j<N && scores[j].getScore()<5))) {
						scores[j - 1].setFirstJury(scores[j-1].getFirstJury() - 1);
						if (scores[j - 1].getSecondJury() < p) {
							scores[j - 1].setSecondJury(scores[j - 1].getSecondJury() + 1);
						} else if (scores[j - 1].getThirdJury() < p) {
							scores[j - 1].setThirdJury(scores[j - 1].getThirdJury() + 1);
						} else {
							scores[j - 1].setSecondJury(scores[j - 1].getSecondJury() + 1);
						}
						foundSuprise = foundSuprise + 1;
					}
				}

				if (scores[j-1].getFirstJury() >= p || scores[j-1].getSecondJury() >= p || scores[j-1].getThirdJury() >= p) {
					totalBetterThanP = totalBetterThanP + 1;
				}

			}
			output = String.valueOf(totalBetterThanP);

			writer.println(output);
			writer.flush();
		}
		writer.close();

	}

	public static void main(String args[]) {

		InputStream input = null;
		input = DanceWithGoogler.class.getResourceAsStream(args[0]);

		OutputStream output = null;
		try {
			output = new FileOutputStream(args[1]);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		DanceWithGoogler practise1 = new DanceWithGoogler(input, output);
		practise1.solve();
	}
}
