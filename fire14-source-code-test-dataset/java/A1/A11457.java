package edu.gcj.solutions;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class DancingGooglers {
	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner inf = new Scanner(new File("C:\\Users\\Coltin\\Downloads\\B-small-attempt0.in"));
		
		int T = inf.nextInt();
		System.out.println(T);
		
		for (int t = 0; t < T; t++) {
			int N = inf.nextInt(); // Number of googlers
			int S = inf.nextInt(); // Number of surprisingly triplets
			int p = inf.nextInt(); // Max score we want to find in a triplet

			int results = 0;
			for (int n = 0; n < N; n++) { // We can calculate googlers scores independently, so 1 at a time
				int googlerScore = inf.nextInt();
				//System.out.print("Googler Score: " + googlerScore + "   p=" + p);
				if (p == 0) {
					results++;
					continue;
				} else if (googlerScore == 0) {
					continue;
				} else if (Maximize(googlerScore) >= p) {
					//System.out.println("   Maximized");
					results++;
				} else if ((S > 0) && (MaximizeSurprising(googlerScore) >= p)) {
					//System.out.println("   MaximizedSURPRISE");
					S -= 1;
					results++;
				} else {
					//System.out.println("   NONE");
				}
			}
			System.out.println("Case #" + (t+1) + ": " + results);
		}
	}

	private static int MaximizeSurprising(int googlerScore) {
		int perJudge = googlerScore/3;
		int pointsRemaining = googlerScore - (perJudge*3);
		if (pointsRemaining == 2) {
			return perJudge+2;
		}
		return perJudge+1;
	}

	private static int Maximize(int googlerScore) {
		int perJudge = googlerScore/3;
		int pointsRemaining = googlerScore - (perJudge*3);
		if (pointsRemaining == 0) {
			return perJudge;
		}
		return perJudge+1;
	}
}
