package codejam;

import java.util.Scanner;

public class Qual2012B {
	private final int[] score;
	private int[] countWithSurprise;
	private int[] countWithoutSurprise;

	public Qual2012B(int[] score, int resultAsked) {
		this.score = score;
		this.countWithoutSurprise = new int[31];
		this.countWithSurprise = new int[31];
		initCountArrays(resultAsked);
	}

	protected void initCountArrays(int resultAsked) {
		for (int a = 0; a <= 10; a++)
			for (int b = Math.max(0, a - 2); b <= Math.min(10, a + 2); b++)
				for (int c = Math.max(0, a - 2); c <= Math.min(10, a + 2); c++) {
					int diff = Math
							.max(Math.abs(b - c), Math.max(Math.abs(a - c), Math.abs(a - b)));
					if (diff >= 3)
						continue;
					int count = 0;
					if (a >= resultAsked)
						count++;
					if (b >= resultAsked)
						count++;
					if (c >= resultAsked)
						count++;
					int total = a + b + c;
					if (diff == 2) {
						if (count > countWithSurprise[total])
							countWithSurprise[total] = 1;
					} else {
						if (count > countWithoutSurprise[total])
							countWithoutSurprise[total] = 1;
					}
				}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner( System.in);
		int nrOfTestCases = scanner.nextInt();
		for (int caseNr = 1; caseNr <= nrOfTestCases; caseNr++) {
			int googCount = scanner.nextInt();
			int surprises = scanner.nextInt();
			int resultAsked = scanner.nextInt();
			int[] score = new int[googCount];
			for (int i = 0; i < googCount; i++)
				score[i] = scanner.nextInt();
			Qual2012B solver = new Qual2012B(score, resultAsked);
			System.out.println("Case #" + caseNr + ": " + solver.solve(0, surprises));
		}
	}

	private int solve(int index, int surprisesLeft) {
		if (index >= score.length)
			return surprisesLeft == 0 ? 0 : Integer.MIN_VALUE;
		int thisScore = score[index];
		int bestWithoutSurprise = countWithoutSurprise[thisScore] + solve(index + 1, surprisesLeft);
		if (surprisesLeft > 0) {
			int bestWithSurprise = countWithSurprise[thisScore]
					+ solve(index + 1, surprisesLeft - 1);
			return Math.max(bestWithSurprise, bestWithoutSurprise);
		}
		return bestWithoutSurprise;
	}
}
