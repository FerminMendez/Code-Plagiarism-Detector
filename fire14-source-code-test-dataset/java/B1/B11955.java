package qual;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Recycled {
	public static void main(String[] args) throws IOException {
		new Recycled().run();
	}
	class Pair {
		int a, b;
		Pair(int a, int b) {
			this.a = a;
			this.b = b;
		}
		public boolean equals(Object other) {
			Pair p = (Pair) other;
			return this.a == p.a && this.b == p.b;
		}
		public int hashCode() {
			return this.a * 2000003 + this.b;
		}
		
	}
	public HashSet<Pair> set = new HashSet<Pair>();
	
	void add(Pair p, int left, int right) {
		if (p.a < p.b && left <= p.a && p.a <= right && left <= p.b && p.b <= right) {
			set.add(p);
		}
	}
	
	int powers[] = {10, 100, 1000, 10000, 100000, 1000000, 10000000};
	
	void fill(int left, int right, int curpow) {
		for (int i = left; i <= right; i++) {
			int val = i;
			for (int p : powers) {
				if (val >= p) {
					int lp = val / p;
					int rp = val % p;
					int newval = rp * (curpow / p) + lp;
					add(new Pair(val, newval), left, right);
				}
			}
		}
	}
	
	public void run() throws IOException {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		fill(1,       9,       10);
		fill(10,      99,      100);
		fill(100,     999,     1000);
		fill(1000,    9999,    10000);
		fill(10000,   99999,   100000);
		fill(100000,  999999,  100000);
		fill(1000000, 2000000, 10000000);
		
		int tests = in.nextInt();
		for (int test = 0; test < tests; test++) {
			int a = in.nextInt(), b = in.nextInt();
			int count = 0;
			for (Pair p: set) {
				if (a <= p.a && p.a <= b && a <= p.b && p.b <= b) {
					count++;
				}
			}
			out.printf("Case #%d: %d\n", test + 1, count); 
		}
		out.close();
	}
}
