package codejam2012.r0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * @author julian
 */
public class B {

	public static final void main(String[] args) throws IOException {
		(new B()).run();
	}

	private int getBestRes(int v) {
		return ((v % 3 == 0) ? 0 : 1) + ((int) v / 3);
	}

	private int getBestSurRes(int v) {
		return ((v % 3 == 2) ? 2 : Math.min(v, 1)) + ((int) (v / 3));
	}

	public void run() throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("B-small.in"));
		BufferedWriter out = new BufferedWriter(new FileWriter("B.out"));
		int t = Integer.parseInt(in.readLine());
		for (int i = 0; i < t; i++) {
			StringTokenizer stok = new StringTokenizer(in.readLine());
			int n = Integer.parseInt(stok.nextToken());
			int s = Integer.parseInt(stok.nextToken());
			int p = Integer.parseInt(stok.nextToken());
			int[] total = new int[n];
			for (int k = 0; k < n; k++) {
				total[k] = Integer.parseInt(stok.nextToken());
			}
			out.write("Case #" + (i + 1) + ": " + solve(n, s, p, total) + "\n");
		}
		in.close();
		out.flush();
		out.close();
	}

	public int solve(int n, int s, int p, int[] t) {
		int good = 0;
		int soso = 0;
		for (int i = 0; i < n; i++) {
			if (getBestRes(t[i]) >= p) {
				good++;
			} else if (getBestSurRes(t[i]) >= p) {
				soso++;
			}
		}

		return good + Math.min(s, soso);
	}

}
