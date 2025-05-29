package gcj2012;

import java.io.FileInputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class B {

	public static void main(String[] args) throws Exception {
		new B().run();
	}

	void run() throws Exception {
		Scanner in = new Scanner(System.in);
		in = new Scanner(new FileInputStream("B-small-attempt0.in"));
		PrintStream out = System.out;
		out = new PrintStream("B-small-attempt0.out");

		int T = in.nextInt();
		for (int x = 1; x <= T; x++) {
			int N = in.nextInt();
			int S = in.nextInt();
			int p = in.nextInt();
			int t[] = new int[N];
			for (int i = 0; i < t.length; i++)
				t[i] = in.nextInt();
			out.printf("Case #%d: %d\n", x, countAtLeastP(t, p, S));
		}

	}

	int countAtLeastP(int[] t, int p, int s) {
		int canN = 0;
		int canS = 0;
		for (int i : t)
			if (canAtLeastPNonSurprising(i, p)) canN++;
			else if (canAtLeastPSurprising(i, p)) canS++;
		return (canN ) + Math.min(canS, s);
	}

	// min total score with best ind score of p is p + (p-1) + (p-1)
	boolean canAtLeastPNonSurprising(int s, int p) {
		return s >= 3 * p - 2;
	}

	// min surp total score with best ind score of p is p + (p-2) + (p-2)
	boolean canAtLeastPSurprising(int s, int p) {
		if (s < 2) return false;
		return s >= 3 * p - 4;
	}

}
