package codejam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class Dancers {

	/**
	 * @param args
	 * @Testcases
	 */
	// Idea:
	// Greater than or equal to >= 3*P - 2 then will pass the boundary of P.
	// else if it was less than but greater than or equal to 3*P - 4 and S is
	// still > 0 in this case consume a surprising ticket.
	// else less than that Cannot.
	private int calculateMax(int S, int P, int[] scores) {
		int minP = Math.max(0, 3 * P - 4);
		int maxP = Math.max(0, 3 * P - 2);
		int maxNumWinners = 0;
		for (int i = 0; i < scores.length; i++) {
			int score = scores[i];
			if (score >= P) {
				if (scores[i] >= maxP) {
					maxNumWinners++;
				} else if (scores[i] >= minP && S > 0) {
					maxNumWinners++;
					S--;
				}
			}
		}
		return maxNumWinners;
	}

	public int performe(String[] in) {
		int N = Integer.parseInt(in[0]);
		int S = Integer.parseInt(in[1]);
		int P = Integer.parseInt(in[2]);
		int[] scores = new int[N];
		for (int i = 0; i < N; i++) {
			scores[i] = Integer.parseInt(in[i + 3]);
		}
		return calculateMax(S, P, scores);
	}

	// Input
	// 4
	// 3 1 5 15 13 11
	// 3 0 8 23 22 21
	// 2 1 1 8 0
	// 6 2 8 29 20 8 18 18 21
	//
	// Output
	// Case #1: 3
	// Case #2: 2
	// Case #3: 1
	// Case #4: 3
	public static void main(String[] args) {

		Dancers dancers = new Dancers();

		try {
			FileInputStream fstream = new FileInputStream("B-small-attempt0.in");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			FileWriter fwriter = new FileWriter("B-small-attempt0.out");
			BufferedWriter out = new BufferedWriter(fwriter);

			String strLine;
			strLine = br.readLine();
			int testCases = Integer.parseInt(strLine);

			int currentCase = 0;
			while ((strLine = br.readLine()) != null && currentCase < testCases) {
				out.write("Case #" + ++currentCase + ": "
						+ dancers.performe(strLine.split(" ")));
				out.newLine();
			}
			in.close();
			out.close();
		} catch (Exception e) {
			System.err.println("I/O Error while reading file.");
		}

	}

}
