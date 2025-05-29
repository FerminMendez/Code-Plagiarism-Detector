package com.qvark.codejam.dancinggooglers;

import java.util.Scanner;

public class DancingGooglers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i = 1; i <= t; i++) {
			int n = in.nextInt();
			int s = in.nextInt();
			int p = in.nextInt();
			int r = 0;
			for (int j = 0; j < n; j++) {
				int total = in.nextInt();
				int score = total / 3;
				int mod = total % 3;
				if (total == 0) {
					if (p == 0)
						r++;
				} else if (score >= p || (score+1>=p && mod>=1)) {
					r++;
				} else if (score + 1 >= p && mod < 1 && s > 0) {
					r++;
					s--;
				} else if (score + 2 >= p && mod == 2 && s > 0) {
					r++;
					s--;
				}
			}
			System.out.format("Case #%d: %d\n", i, r);
		}
		
		
	}

}
