package qualification.dancingWithTheGooglers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DancingWithTheGooglers {

	// Input
	//
	// 4
	// 3 1 5 15 13 11
	// 3 0 8 23 22 21
	// 2 1 1 8 0
	// 6 2 8 29 20 8 18 18 21
	//
	// 1 ≤ T ≤ 100.
	// 0 ≤ S ≤ N.
	// 0 ≤ p ≤ 10.
	// 0 ≤ ti ≤ 30.
	// At least S of the ti values will be between 2 and 28, inclusive.

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Scanner scan = new Scanner(
					new File(
							"D:\\eclipse\\Ghani\\GCJ\\src\\qualification\\dancingWithTheGooglers\\B-small-attempt1.in"));
			// new File(
			// "D:\\eclipse\\Ghani\\GCJ\\src\\qualification\\dancingWithTheGooglers\\test.txt"));
			try {
				int nbCas = Integer.parseInt(scan.nextLine());
				String result = new String();
				for (int i = 0; i < nbCas; i++) {
					int nbG = scan.nextInt();
					int nbS = scan.nextInt();
					int p = scan.nextInt();

					ArrayList<Integer> scores = new ArrayList<Integer>();

					for (int j = 0; j < nbG; j++) {
						scores.add(scan.nextInt());
					}

					int reponse = bestResult(scores, nbS, p);
					result += printCase(i, reponse);
				}
				System.out.print(result);
			} finally {
				scan.close();
			}
		} catch (IOException ioe) {
			System.out.println("Erreur --" + ioe.toString());
		}

	}

	private static int bestResult(ArrayList<Integer> scores, int nbS, int p) {
		int result = 0;
		int surprising = 0;
		if (p > 0 && p < 30) {
			for (Integer integer : scores) {
				// System.out.println(integer);
				if (integer < (3 * (p - 1)) - 1 || integer == 0) {
					result += 0;
					// System.out.println("aucun");
				} else if (integer >= (3 * p) - 2) {
					result += 1;
					// System.out.println("tous");
				} else {
					surprising += 1;
					// System.out.println("ça depend");
				}

			}
			result += Math.min(surprising, nbS);
		} else if (p == 10) {
			for (Integer integer : scores) {
				if (integer == 30) {
					result += 1;
				}
			}
		} else {
			result = scores.size();
		}
		return result;
	}

	public static String printCase(int i, int reponse) {

		String ligne = "Case #" + (i + 1) + ": " + reponse + "\n";
		return ligne;
	}

}
