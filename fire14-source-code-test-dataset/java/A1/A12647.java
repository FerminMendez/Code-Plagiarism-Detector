package net.mauhiz.contest.codejam.qual2012;

import java.io.IOException;

import net.mauhiz.contest.codejam.CodejamLineChunkSolver;

public class DancingGoogler extends CodejamLineChunkSolver {

	public static void main(String... args) throws IOException {
		new DancingGoogler().run(args);
	}

	@Override
	protected String doJamProblem(String[] chunks) {
		int n = Integer.parseInt(chunks[0]);
		int s = Integer.parseInt(chunks[1]);
		int p = Integer.parseInt(chunks[2]);
		int[] t = new int[n];
		for (int i = 0; i < n; i++) {
			t[i] = Integer.parseInt(chunks[3 + i]);
		}
		int y = solve(s, p, t);
		return Integer.toString(y);
	}

	protected int solve(int s, int p, int[] t) {
		log.fine("s " + s);
		log.fine("p " + p);
		int r = s; // remaining surprises
		int y0 = 0, y1 = 0, y2 = 0;
		int t0 = 0, t1 = 0, t2 = 0;
		for (int i = 0; i < t.length; i++) {
			int mod = t[i] % 3;

			switch (mod) {
			case 0:
				t0++;
				int m0 = t[i] / 3;
				if (m0 >= p) {
					y0++;
				} else if (r > 0 && m0 + 1 == p && t[i] >= 3) {
					// consume a surprise
					r--;
					y0++;
				}
				break;
			case 1:
				t1++;
				int m1 = (t[i] + 2) / 3;
				if (m1 >= p) {
					y1++;
				}
				break;
			case 2:
				t2++;
				int m2 = (t[i] + 1) / 3;
				if (m2 >= p) {
					y2++;
				} else if (r > 0 && m2 + 1 == p) {
					// consume a surprise
					r--;
					y2++;
				}
				break;
			}
		}
		log.fine("r " + r);
		log.fine("t0 " + t0);
		log.fine("t1 " + t1);
		log.fine("t2 " + t2);
		log.fine("y0 " + y0);
		log.fine("y1 " + y1);
		log.fine("y2 " + y2);

		return y0 + y1 + y2;
	}

	@Override
	public String getName() {
		return "DancingGoogler";
	}
}
