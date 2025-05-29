package round1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class Recycled {

	private int noCases;
	private int[] minBounds;
	private int[] maxBounds;
	private int[] noDigits;

	private void readFile(String filepath) {
		try {
			Scanner sc = new Scanner(new FileInputStream(new File(filepath)));
			noCases = Integer.parseInt(sc.nextLine());
			noDigits = new int[noCases];
			minBounds = new int[noCases];
			maxBounds = new int[noCases];

			for (int i = 0; i < noCases; i++) {
				String[] line = sc.nextLine().split(" ");
				noDigits[i] = line[0].length();
				minBounds[i] = Integer.parseInt(line[0]);
				maxBounds[i] = Integer.parseInt(line[1]);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private int answer(int min, int max, int digits) {
		HashSet<Recycled.Pair> pairs = new HashSet<Recycled.Pair>();
		for (int n = min; n < max; n++) {
			for (int d = 1; d < digits; d++) {
				int m = n / (int) Math.pow(10, d) + n % (int) Math.pow(10, d)
						* (int) Math.pow(10, digits - d);

				if (m > n && m <= max) {
					pairs.add(new Pair(n,m));
				}
			}
		}
		return pairs.size();
	}

	public static void main(String args[]) {

		Recycled r = new Recycled();
		r.readFile(args[0]);

		for (int i = 1; i <= r.noCases; i++) {
			System.out.println("Case #"
					+ i
					+ ": "
					+ r.answer(r.minBounds[i - 1], r.maxBounds[i - 1],
							r.noDigits[i - 1]));
		}
	}

	private class Pair {
		int n, m;

		public Pair(int n, int m) {
			this.n = n;
			this.m = m;
		}

		@Override
		public boolean equals(Object o) {
			if (!(o instanceof Pair)) return false;
			Pair p = (Pair) o;
			if (this.n != p.n) return false;
			if (this.m != p.m) return false;
			return true;
		}

		@Override
		public int hashCode() {
			return (n + m) % 3571;
		}
	}
}
