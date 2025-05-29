package cj2012.qual;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class B {
	static boolean[][] NW = new boolean[11][31];
	static boolean[][] SW = new boolean[11][31];
	
	static {
		for (int a = 0; a < 11; a++) {
			for (int b = 0; b < 11; b++) {
				for (int c = 0; c < 11; c++) {
					int max = Math.max(Math.max(a, b), c);
					int min = Math.min(Math.min(a, b), c);
					if (max - min <= 1) NW[max][a+b+c] = true;
					if (max - min == 2) SW[max][a+b+c] = true;
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(new File("in/B-small-attempt0.in"));
		int T = scan.nextInt();
		PrintWriter out = new PrintWriter(new File("out/B-small-attempt0.txt"));
		for (int z = 1; z <= T; z++) {
			int N = scan.nextInt();
			int S = scan.nextInt();
			int p = scan.nextInt();
			int[] a = new int[N];
			for (int i = 0; i < N; i++)
				a[i] = scan.nextInt();
			boolean[][] m = new boolean[N][2];
			// False/True: no-win/win
			// 0/1: not-surprising/surprising
			int[] cc = new int[4];
			int alwaysLose = 0;
			int surpriseLose = 1;
			int surpriseWin = 2;
			int alwaysWin = 3;
			for (int i = 0; i < N; i++) {
				for (int j = p; j <= 10; j++) {
					m[i][0] = m[i][0] || NW[j][a[i]];
					m[i][1] = m[i][1] || SW[j][a[i]];
				}
				int k = 0;
				if (m[i][0]) k += 1;
				if (m[i][1]) k += 2;
				cc[k]++;
			}
			int ret = 0;
			while (S > 0 && cc[surpriseWin] > 0) {S--; cc[surpriseWin]--; ret++;}
			while (S > 0 && cc[alwaysLose] > 0) {S--; cc[alwaysLose]--;}
			while (S > 0 && cc[alwaysWin] > 0) {S--; cc[alwaysWin]--; ret++;}
			while (S > 0 && cc[surpriseLose] > 0) {S--; cc[surpriseLose]--;}
			ret += cc[alwaysWin] + cc[surpriseLose];
			out.println("Case #" + z + ": " + ret);
		}
		out.close();
	}
}
