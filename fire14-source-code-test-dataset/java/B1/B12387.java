package com.bd.codejam.y2012;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class C {
	public void solve() throws IOException {
		Scanner in = new Scanner(new File(getClass().getSimpleName() + ".in.txt"));
		PrintWriter out = new PrintWriter(new File(getClass().getSimpleName() + ".out.txt"));

		int T = Integer.parseInt(in.nextLine());
		for (int t = 0; t < T; t++) {
			int A = in.nextInt();
			int B = in.nextInt();
			int result = solve(A, B);
			
			out.println("Case #" + (t + 1) + ": " + result);
			System.out.println("Case #" + (t + 1) + ": " + result);
		}

		in.close();
		out.close();
	}
	
	private int solve(int A, int B) {
		line = 1;
		int r = 0;
		for (int n = A; n < B; n++) {
			r += recycledPairs(n, B);
		}
		
		return r;
	}
	
	int line = 1;
	private int recycledPairs(int n, int max) {
		int r = 0;
		for (int pair : recycledPairs(n)) {
			if (n < pair && pair <= max) {
				r++;
				//System.out.println((line++) + ": " + n + " " + pair);
			}
		}
		return r;
		
		
	}
	
	private List<Integer> recycledPairs(int n) {
		String s = Integer.toString(n);
		
		List<Integer> r = new ArrayList<Integer>(s.length()-1);
		for (int i = 1; i < s.length(); i++) {
			String shift = shift(s, i);
			if (shift.charAt(0) != '0') {
				int shifti = Integer.parseInt(shift);
				if (!r.contains(shifti)) {
					r.add(shifti);
				}
			}
		}
		return r;
	}
	
	private String shift(String s, int n) {
		char[] c = new char[s.length()];
		for (int i = 0; i < s.length(); i++) {
			c[i] = s.charAt(((i+(s.length()-n))%s.length()));
		}
		
		return new String(c);
	}
	
	

	public static void main(String[] args) throws IOException {
		new C().solve();
	}
}