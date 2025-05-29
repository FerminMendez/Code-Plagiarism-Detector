import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class C {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("C-small-attempt0.in"));
		String li;
		int tcn = Integer.parseInt(in.readLine());
		Scanner sc;
		String A, B, is, tmp;
		List<Pair> ar = new ArrayList<Pair>();
		for (int tc = 0; tc < tcn; tc++) {
			ar.clear();
			li = in.readLine();
			sc = new Scanner(li);
			A = sc.next(); B = sc.next();
			int a = Integer.parseInt(A), b = Integer.parseInt(B), tmpi;
			int result = 0;
			if (a > 9) {
				for (int i = a; i <= b; i++) {
					is = String.valueOf(i);
					if (!isSame(is)) {
						for (int j = 1, l = is.length(); j < l; j++) {
							tmp = is.substring(j) + is.substring(0, j);
							tmpi = Integer.valueOf(tmp);
							if (i != tmpi) {
								Pair p = new Pair(i, tmpi);
								if (!ar.contains(p) && tmpi > a && tmpi < b) {
									ar.add(p);
									result++;
								}
							}
						}
					}
				}

			}
			System.out.println("Case #" + (tc + 1) + ": " + result);
		}
		in.close();
	}

	static boolean isSame(String s) {
		char[] ds = s.toCharArray();
		char fd = ds[0];
		for (char d : ds) {
			if (d != fd) return false;
		}

		return true;
	}

	static class Pair {
		final int f;
		final int s;

		Pair(int f, int s) {
			this.f = f;
			this.s = s;
		}

		public boolean equals(Object o) {
			Pair that = (Pair) o;

			return ((this.f == that.f && this.s == that.s) || (this.f == that.s && this.s == that.f));
		}

		public String toString() {
			return "(" + f + "," + s + ")";
		}
	}
}
