package codeJam;

import java.util.Scanner;
import java.util.StringTokenizer;

public class DancingWiththeGooglers {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int cases = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < cases; i++) {
			String temp = scan.nextLine();
			StringTokenizer token = new StringTokenizer(temp);
			int N = Integer.parseInt(token.nextToken());
			int S = Integer.parseInt(token.nextToken());
			int P = Integer.parseInt(token.nextToken());
			int[] total = new int[N];
			for (int j = 0; j < total.length; j++) {
				total[j] = Integer.parseInt(token.nextToken());
			}
			System.out.println("Case #" + (i + 1) + ": " + solve(total, S, P));

		}

	}

	private static int solve(int[] total, int s, int p) {
		int ser = s;
		int numberOfWinners = 0;
		for (int i = 0; i < total.length; i++) {
			if (total[i] == 0) {
				if (p == 0)
					numberOfWinners++;
			} else if (total[i] == 1) {
				if (p <= 1)
					numberOfWinners++;
			} else if (total[i] == 2) {
				if (p <= 1)
					numberOfWinners++;
				else if (p == 2 && ser > 0) {
					numberOfWinners++;
					ser--;
				}
			} else {
				int k = total[i] % 3;
				if (k == 0) {
					if (total[i] / 3 >= p)
						numberOfWinners++;
					else if (((total[i] / 3) + 1) >= p && ser > 0) {
						numberOfWinners++;
						ser--;
					}
				} else if (k == 2) {
					int sum = (total[i] / 3) + 1;
					if (sum >= p)
						numberOfWinners++;
					else if ((sum + 1) >= p && ser > 0) {
						numberOfWinners++;
						ser--;
					}

				} else if (k == 1) {
					int sum = (total[i] / 3) + 1;
					if (sum >= p)
						numberOfWinners++;
				}
			}
		}
		return numberOfWinners;

	}
}
