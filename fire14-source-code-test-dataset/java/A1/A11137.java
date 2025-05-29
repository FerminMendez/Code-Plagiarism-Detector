package com.google.codejam;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	
	static Scanner in;
	static BufferedWriter writer;
	public static void main(String[] args) throws IOException {
		
		in = new Scanner(new File("src/B-small-attempt0.in"));
		writer = new BufferedWriter(new FileWriter(new File("src/b.out")));

		int T = in.nextInt();
		
		for (int i = 1; i <= T; i++) {
			int N = in.nextInt();
			int S = in.nextInt();
			int P = in.nextInt();
			int[] t = new int[N];
			
			for (int j = 0; j < N; j++) {
				t[j] = in.nextInt();
			}
			solveCase(i, N, S, P, t);
		}
		
		writer.close();

	}

	public static int solveCase(int TEST_CASE, int N, int S, int P, int[] t) throws IOException {
		int ans = 0;
		int minSc = 3*P-2;
		int minScSup = (P==1)?1:3*P-4;
		int validCom = 0;
		int validSup = 0;
		for (int i = 0; i < t.length; i++) {
			if(t[i]>=minSc)
				validCom++;
			else if (t[i]<minSc && t[i]>=minScSup) {
				validSup++;
			}
		}
		if(validSup<=S) ans = validCom + validSup;
		else {
			ans = validCom + S;
		}
		writer.write("Case #" + TEST_CASE + ": " + ans);
		writer.newLine();
		return 0;
	}

}
