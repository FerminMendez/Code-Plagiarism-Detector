package Aufgabe2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

	private Scanner scanner;
	private PrintWriter writer;

	public Main(InputStream is, OutputStream os) {
		scanner = new Scanner(is);
		writer = new PrintWriter(os);
	}

	public void solve() {
		
		// Unit Tests:
		int tmp;
		int tmp1[] = {15,13,11};
		if (calculate(1, 5, tmp1)!=3) return;
		int tmp2[] = {23,22,21};
		if (calculate(0, 8, tmp2)!=2) return;
		int tmp3[] = {8,0};
		if (calculate(1, 1, tmp3)!=1) return;
		int tmp4[] = {29,20,8,18,18,21};
		if (calculate(2, 8, tmp4)!=3) return;
		
		for (int i=0; i<200; i++)
			System.out.println("");

		int cases = scanner.nextInt();

		for (int i = 1; i <= cases; i++) {
			writer.print("Case #");
			writer.print(i + ": ");

			scanner.nextLine();
			int n = scanner.nextInt(); // number of Googlers
			int s = scanner.nextInt(); // number of surprising triplets
			int p = scanner.nextInt(); // minimum score
			int t[] = new int[n];
			for (int j = 0; j < n; j++)
				t[j] = scanner.nextInt();

			System.out.println(i + ": MinScore=" + p + ", Surprising Triplets=" + s);
			int result = calculate(s, p, t);

			writer.println(result);
			System.out.println(" -> " + result);
			System.out.println("-------------");
		}
		writer.flush();
	}

	private int calculate(int noSurprisingScores,
			int minimumScore, int[] scores) {
		int result = 0;

		for (int score : scores) {
			int triplet[] = new int[3];
			System.out.print(score + ": ");
			switch (score % 3) {
			case 0:
				if (score / 3 >= minimumScore) {
					result++;
					System.out.println((score / 3) + "," + (score / 3) + "," + (score / 3));
				} else {
					if (noSurprisingScores > 0)
						if (score / 3 + 1 >= minimumScore && score / 3 - 1 >= 0) {
							result++;
							noSurprisingScores--;
							System.out.println((score / 3 - 1) + "," + (score / 3) + "," + (score / 3 + 1) + " *");
						}
				}
				break;
			case 1:
				if ((score-1)/3 + 1 >= minimumScore) {
					result++;
					System.out.println((score-1)/3 + "," + ((score-1)/3) + "," + ((score-1)/3 + 1));
				} else {
					// Surprising Triplet führt nicht zur Erhöhung des max Scores
				}
				break;
			case 2:
				if ((score-2)/3 + 1 >= minimumScore) {
					result++;
					System.out.println((score-2)/3 + "," + ((score-2)/3 + 1) + "," + ((score-2)/3 + 1));
				} else {
					if (noSurprisingScores > 0)
						if ((score - 2) / 3 + 2 >= minimumScore) {
							result++;
							noSurprisingScores--;
							System.out.println((score-2)/3 + "," + (score-2)/3 + "," + ((score-2)/3 + 2) + " *");
						}
				}
				break;
			}

		}

		return result;
	}

	/*
	 * private boolean exceedsMinumumScore(int[] triplet, int minScore) { for
	 * (int i=0; i<3; i++) if (triplet[i] >= minScore) return true; return
	 * false; }
	 */

	public static void main(String[] args) {
		try {
			InputStream is = new FileInputStream("B-small-attempt.in");
			OutputStream os = new FileOutputStream("B-small-attempt.out");
			Main problem = new Main(is, os);
			problem.solve();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println("finished");
	}
}
