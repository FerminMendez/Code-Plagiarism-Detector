import java.io.*;
import java.util.*;
import java.util.regex.*;

import static java.lang.Math.*;

public class B {
	
	public class Tripple {
		Integer t1, t2, t3;

		public Tripple() {
		}

		@Override
		public String toString() {
			return "(" + t1 + ", " + t2 + ", " + t3 + ")";
		}
	}
	
	public static void main(String[] args) throws Exception {
		B b = new B();
		b.run(args);
	}

	public void run(String[] args) throws Exception {
		
		Scanner in = (args.length > 0) ? new Scanner(new File(args[0])) : new Scanner(System.in);
		int T = in.nextInt();
		for(int zz = 1; zz <= T;zz++){
			System.err.format("#%d\n", zz);
			System.out.format("Case #%d: ", zz);

			int N = in.nextInt();
			int S = in.nextInt();
			int s = S;
			int p = in.nextInt();
			
			int tps[] = new int[N];
			int count = 0;
			for (int n = 0; n < N; n++) {
				tps[n] = in.nextInt();
				Tripple tripple = new Tripple();
				int tp = tps[n];
				s = tripple(tp, p, s, tripple);
				if (s >= 0 && tripple.t1 != null && tripple.t1 >= p) {
					count++;
				}
				System.err.println(tp + "_" + p + " : " + tripple + " ... " + s + " c: " + count);
			}
			
			System.out.format("%d\n", count);
		}
	}

	private int tripple(int tp, int p0, int s, Tripple t) {
		if (s < 0 || tp < p0) {
			t.t1 = null;
			return s;
		}

		int p = p0;
		boolean possible1 = false;
		while(!possible1) {
			possible1 = true;
		
			int r = tp;
			t.t1 = p;
			r -= p;
			
			int p2 = p;
			
			boolean possible = false;
			int run = 0;
			while(!possible) {
				run++;
				t.t2 = p2;
				int r2 = r - p2;
				t.t3 = r2;
				if (t.t2 + 1 >= p && t.t3 + 1 >= p) {
					possible = true;
				} else if (t.t2 + 2 >= p && t.t3 + 2 >= p && run > 1) {
					
					if (s <= 0) {
						p--;
						possible1 = false;
					} else {
						s--;
					}
					possible = true;
					
				} else if (p2 < 1) {
					t.t1 = null;
					return s;
				} else {
					p2--;
				}
			}
			
			if (t.t3 > p) {
				p++;
				possible1 = false;
			}
			
		}
		return s;
	}
}
