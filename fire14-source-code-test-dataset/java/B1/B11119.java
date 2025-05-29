package gcj2012;

import java.io.FileInputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class C {

	public static void main(String[] args) throws Exception {
		new C().run();
	}

	void run() throws Exception {
		Scanner in = new Scanner(System.in);
		in = new Scanner(new FileInputStream("C-small-attempt0.in"));
		// in = new Scanner(new FileInputStream("C-large.in"));
		PrintStream out = System.out;
		out = new PrintStream("C-small-attempt0.out");
		// out = new PrintStream("C-large.out");

		int T = in.nextInt();
		for (int x = 1; x <= T; x++) {
			int A = in.nextInt();
			int B = in.nextInt();
			out.printf("Case #%d: %d\n", x, countRecycled(A, B));
		}

	}

	private int countRecycled(int a, int b) {
		int res = 0;
		int p0 = 1;
		while (p0 < b)
			p0 *= 10;
		for (int s = a; s <= b; s++)
			res += countRecycledStartingBy(a, b, s, p0);
		return res;
	}

	private int countRecycledStartingBy(int a, int b, int s, int p0) {
		int p = 1;
		Set<Integer> recs = new TreeSet<Integer>();
		while (p < 1000000) {
			int end = s % p;
			int beg = s / p;
			int rec = end * p0 + beg;
			if (rec >= a && rec <= b && rec != s && s < rec) recs.add(rec);
			p *= 10;
			p0 /= 10;
		}
		return recs.size();
	}

}
