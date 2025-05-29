package com.code.jam;

import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

public class BDancingWithGooglers {
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner (new File("C:/codeJam/ficheros2012/BDancingWithGooglers-practice.in"));
		PrintStream ps = new PrintStream("C:/codeJam/ficheros2012/BDancingWithGooglers-practice.out");
		int T = new Integer (in.nextLine());
		for (int nCase = 1; nCase < T + 1; nCase++) {
			Scanner inLine = new Scanner(in.nextLine());
			int numberGooglers = inLine.nextInt();
			int surprisingScore = inLine.nextInt();
			int p = inLine.nextInt();
			int maxGooglersWithScoreX = 0;
			for (int i = 0; i < numberGooglers; i++) {
				int scoreGoogler = inLine.nextInt();
				int desviationScore = scoreGoogler % 3;
				int maxScore = (scoreGoogler - desviationScore) / 3;
				
				if (desviationScore > 0){
					maxScore++;
				}
				
				if (maxScore >= p){
					maxGooglersWithScoreX++;
				}
				else{
					if (scoreGoogler >= p
							&& surprisingScore > 0
							&& maxScore + 1 >= p){
						maxGooglersWithScoreX++;
						surprisingScore--;
					}
				}
			}
			System.out.format("Case #%d: %d\n", nCase, maxGooglersWithScoreX);
			ps.format("Case #%d: %d\n", nCase, maxGooglersWithScoreX);
		}
		ps.flush();
		ps.close();
	}
}
