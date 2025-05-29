package com.skidson.codejam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DancingWithTheGooglers {
	private static final File inFile = new File("input");
	private static final File outFile = new File("output");

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(inFile));
		BufferedWriter out = new BufferedWriter(new FileWriter(outFile));
		int numTests = Integer.parseInt(in.readLine());
		
		for (int x = 0; x < numTests; x++) {
			String[] params = in.readLine().split(" ");
			int N = Integer.parseInt(params[0]);
			int S = Integer.parseInt(params[1]);
			int p = Integer.parseInt(params[2]);
			int y = 0;
			
			int[] t = new int[N];
			for (int j = 3; j < params.length; j++)
				t[j-3] = Integer.parseInt(params[j]);
			
			int[][] scores = new int[N][];
			for (int i = 0; i < N; i++) {
				scores[i] = new int[]{p, p, p};
				
				if (sumArray(scores[i]) <= t[i]) {
					y++;
					continue;
				}
				
				boolean valid = true;
				while (valid && sumArray(scores[i]) != t[i]) {
					/* Decrement an element of the array, prioritizing not consuming an S:
					 *	p	p	p
					 *	p-1	p	p
					 *	p-1	p-1	p
					 *	p-2	p-1	p	... if sum is hit here or after, must consume S (S--)
					 *	p-2 p-2	p	... if sum is not hit by now, this cannot meet  our criteria
					 */
					if (p-scores[i][0] >= 2 && p-scores[i][1] >= 2) {
						valid = false;
					} else if (scores[i][1] == scores[i][0]) {
						if (--scores[i][0] < 0)
							valid = false;
					} else {
						if (--scores[i][1] < 0)
							valid = false;
					}
				}
				
				if (valid) {
					// scores[i][0] will always be smallest, scores[i][2] largest
					if (scores[i][2] - scores[i][0] == 2) {
						if (S > 0) {
							S--;
							y++;
						}
					} else {
						y++;
					}
				}
			}
			out.write("Case #" + (x+1) + ": " + y + "\n");
		}
		out.flush();
		out.close();
	}
	
	private static int sumArray(int[] array) {
		int sum = 0;
		for (int i : array)
			sum += i;
		return sum;
	}

}
