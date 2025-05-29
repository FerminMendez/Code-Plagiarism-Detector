package cj2012.qual;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.TreeSet;

public class C {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(new File("in/C-small-attempt0.in"));
		int T = scan.nextInt();
		PrintWriter out = new PrintWriter(new File("out/C-small-attempt0.txt"));
		for (int z = 1; z <= T; z++) {
			int A = scan.nextInt();
			int B = scan.nextInt();
			int D = 1 + (int) Math.log10(B);
			int C = (int) Math.pow(10, D - 1);
			int res = 0;
			TreeSet<Integer> set = new TreeSet<Integer>();
			for (int n = A; n <= B; n++) {
				for (int s = 1; s < D; s++) {
					int m = n;
					for (int k = 0; k < s; k++)
						m = (m % 10) * C + (m / 10);
					if (m < A || m > B || n >= m) continue;
					set.add(m);
				}
				res += set.size();
				set.clear();
			}
			out.println("Case #" + z + ": " + res);
		}
		out.close();
	}
}
