package com.bd.codejam.y2012;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

class B {
	public void solve() throws IOException {
		Scanner in = new Scanner(new File(getClass().getSimpleName() + ".in.txt"));
		PrintWriter out = new PrintWriter(new File(getClass().getSimpleName() + ".out.txt"));

		int T = Integer.parseInt(in.nextLine());
		for (int t = 0; t < T; t++) {
			int N = in.nextInt();
			int S = in.nextInt();
			int p = in.nextInt();
			int A[] = new int[N];
			for (int n = 0; n < N ; n++) {
				A[n] = in.nextInt();
			}
			int result = getMax(S, p, A);
			out.println("Case #" + (t + 1) + ": " + result);
			System.out.println("Case #" + (t + 1) + ": " + result);
		}

		in.close();
		out.close();
	}
	
	private int getMax(int S, int p, int[] T) {
		int r = 0;
		for (int t : T) {
			int base = t / 3;
			int rest = t % 3;
			if (base >= p) {
				r++;
			} else if (base > 0 && base == p - 1 && rest >= 1) {
				r++;
			} else if (base > 0 && base == p - 1 && rest == 0 && S > 0) {
				r++;
				S--;
			} else if (base > 0 && base == p - 2 && rest == 2 && S > 0) {
				r++;
				S--;
			}
		}
		return r;
	}

	public static void main(String[] args) throws IOException {
		new B().solve();
	}
}