package com.codejam2012.qualificationround;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class B {

	public static int nTest;
	public static int nGoogler;
	public static int nSurprise;
	public static int threshold;
	public static int[] scores;
	public static int nHaveHighScore;
	public static int maxScore;
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(new File("input.txt"));
		FileWriter writer = new FileWriter(new File("output.txt"));
		
		nTest = scanner.nextInt();
		
		for (int i=1;i<=nTest;++i) {
			nHaveHighScore = 0;
			nGoogler = scanner.nextInt();
			nSurprise = scanner.nextInt();
			threshold = scanner.nextInt();
			scores = new int[nGoogler];
			for (int j=0;j<nGoogler;++j) {
				scores[j] = scanner.nextInt();
				
				if (scores[j] % 3 == 0) {
					maxScore = scores[j] / 3;
					if (maxScore >= threshold) {
						nHaveHighScore++;
					}
					else if (nSurprise > 0 && maxScore+1 >= threshold && maxScore-1 >= 0) {
						nHaveHighScore++;
						nSurprise--;
					}
				}
				else if (scores[j] % 3 == 1) {
					maxScore = scores[j] / 3 + 1;
					if (maxScore >= threshold) {
						nHaveHighScore++;
					}
				}
				else if (scores[j] % 3 == 2) {
					maxScore = scores[j] / 3 + 1;
					if (maxScore >= threshold) {
						nHaveHighScore++;
					}
					else if (nSurprise > 0 && maxScore+1 >= threshold && maxScore-1 >= 0) {
						nHaveHighScore++;
						nSurprise--;
					}
				}
			}
			writer.write("Case #" + i + ": " + nHaveHighScore);
			if (i < nTest) {
				writer.write("\n");
			}
			writer.flush();
		}		
		writer.close();
	}
}
