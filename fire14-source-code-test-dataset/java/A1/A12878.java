package GCJ_2012.QualifiactionRound;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class B {
	static int[] scores;
	static int p;
	static int[][] dp;
	static int inf = 10000000;

	public static int solve(int idx, int remSurprising) {
		if (idx == scores.length) {
			if (remSurprising == 0)
				return 0;
			return -inf;
		}
		if (dp[idx][remSurprising] != -1)
			return dp[idx][remSurprising];
		if (scores[idx] % 3 == 0) {
			if (remSurprising > 0 && scores[idx] / 3 != 0) {
				int maxOpt1 = scores[idx] / 3 + 1;
				int maxOpt2 = scores[idx] / 3;
				int opt1, opt2;
				if (maxOpt1 >= p) {
					opt1 = 1 + solve(idx + 1, remSurprising - 1);
				} else {
					opt1 = solve(idx + 1, remSurprising - 1);
				}
				if (maxOpt2 >= p) {
					opt2 = 1 + solve(idx + 1, remSurprising);
				} else {
					opt2 = solve(idx + 1, remSurprising);
				}
				return dp[idx][remSurprising] = Math.max(opt1, opt2);
			} else {
				int max = scores[idx] / 3;
				if (max >= p) {
					return dp[idx][remSurprising] = 1 + solve(idx + 1,
							remSurprising);
				} else {
					return dp[idx][remSurprising] = solve(idx + 1,
							remSurprising);
				}
			}
		} else if (scores[idx] % 3 == 1) {
			if (remSurprising > 0 && scores[idx] / 3 != 0) {
				int maxOpt1 = scores[idx] / 3 + 1;
				int maxOpt2 = scores[idx] / 3 + 1;
				int opt1, opt2;
				if (maxOpt1 >= p) {
					opt1 = 1 + solve(idx + 1, remSurprising - 1);
				} else {
					opt1 = solve(idx + 1, remSurprising - 1);
				}
				if (maxOpt2 >= p) {
					opt2 = 1 + solve(idx + 1, remSurprising);
				} else {
					opt2 = solve(idx + 1, remSurprising);
				}
				return dp[idx][remSurprising] = Math.max(opt1, opt2);
			} else {
				int max = scores[idx] / 3 + 1;
				if (max >= p) {
					return dp[idx][remSurprising] = 1 + solve(idx + 1,
							remSurprising);
				} else {
					return dp[idx][remSurprising] = solve(idx + 1,
							remSurprising);
				}
			}
		} else {
			if (remSurprising > 0) {
				int maxOpt1 = scores[idx] / 3 + 2;
				int maxOpt2 = scores[idx] / 3 + 1;
				int opt1, opt2;
				if (maxOpt1 >= p) {
					opt1 = 1 + solve(idx + 1, remSurprising - 1);
				} else {
					opt1 = solve(idx + 1, remSurprising - 1);
				}
				if (maxOpt2 >= p) {
					opt2 = 1 + solve(idx + 1, remSurprising);
				} else {
					opt2 = solve(idx + 1, remSurprising);
				}
				return dp[idx][remSurprising] = Math.max(opt1, opt2);
			} else {
				int max = scores[idx] / 3 + 1;
				if (max >= p) {
					return dp[idx][remSurprising] = 1 + solve(idx + 1,
							remSurprising);
				} else {
					return dp[idx][remSurprising] = solve(idx + 1,
							remSurprising);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		 Scanner sc = new Scanner(new FileReader("C:/Users/Mostafa/Downloads/B-small-attempt0.in"));
		//Scanner sc = new Scanner(System.in);
		FileWriter fw = new FileWriter("D:/output.txt");
		PrintWriter out = new PrintWriter(System.out);
		int cases = sc.nextInt();
		for (int i = 0; i < cases; i++) {
			int N = sc.nextInt();
			int S = sc.nextInt();
			p = sc.nextInt();
			scores = new int[N];
			for (int j = 0; j < N; j++) {
				scores[j] = sc.nextInt();
			}
			dp = new int[N][S + 1];
			for (int j = 0; j < N; j++)
				Arrays.fill(dp[j], -1);
			int res = solve(0, S);
			fw.write("Case #" + (i + 1) + ": " + res + "\n");
			out.print("Case #" + (i + 1) + ": " + res + "\n");
		}
		fw.flush();
		out.flush();
	}
}
