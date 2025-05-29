package jpt.codejam;

import java.io.PrintStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Codejam2012 {
	static void solve_Qual_B() throws Exception {
		Scanner in = new Scanner(System.in);
		PrintStream out = System.out;
		
		int cases = in.nextInt();
		for (int nCase = 1; nCase <= cases; ++nCase) {
			int N = in.nextInt();
			int S = in.nextInt();
			int p = in.nextInt();
			int res = 0;
			for (int i=0; i<N; ++i) { 
				int t = in.nextInt();

				int max1 = (t+2)/3;
				int max2 = (t+4)/3;
				if (t<=1 || t>=29) max2 = -1;
				
				if (max1 >= p) ++res;
				else if (max2 >= p && S > 0) {
					++res;
					--S;
				}
			}
			out.printf("Case #%d: %d\n", nCase, res);
		}
	}

	
	static void solve_Qual_C() throws Exception {
		Scanner in = new Scanner(System.in);
		PrintStream out = System.out;
		
		int[] ten = new int[8];
		ten[0] = 1;
		for (int i=1; i<ten.length; ++i) ten[i] = ten[i-1]*10;
		
		
		int cases = in.nextInt();
		for (int nCase = 1; nCase <= cases; ++nCase) {
			int A = in.nextInt();
			int B = in.nextInt();
			int res = 0;
			Set<Integer> ms = new HashSet<Integer>();
			for (int n=A; n<=B; ++n) {
				int d = 1;
				for (int aux=10; aux<=n; aux*=10) ++d;
				ms.clear();
				for (int k=1; k<d; ++k) {
					int q = n % ten[k];
					if (q<ten[k-1]) continue;
					int p = n / ten[k];
					int m = q * ten[d-k] + p;
					if (A<=m && B>=m && n!=m && !ms.contains(m)) ++res;
					ms.add(m);
				}
			}
			out.printf("Case #%d: %d\n", nCase, res/2);
		}
	}
	
	public static void main(String[] args) throws Exception {
		//solve_Qual_B();
		solve_Qual_C();
		//solve_1A_A();
		//solve_1A_B();
		//solve_1A_C();
	}
}
