package com.eevoskos.codejam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class RecycledNumbers {
	
	private static final boolean DEBUG = false;
	
	public static void main(String... args) {
		RecycledNumbers instance = new RecycledNumbers();
		
		try {
			BufferedReader c = new BufferedReader(new InputStreamReader(System.in));

			// Number of test cases
			int T = Integer.valueOf(c.readLine());

			System.out.println();

			// Do, for each test case
			for (int i = 0; i < T; i++) {

				// Read input string
				String input = c.readLine();

				// Process input
				String output = instance.solveCase(input);

				// Print the translated text
				System.out.println("Case #" + (i + 1) + ": " + output);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	Set<Pair> allPairs = new HashSet<Pair>();
	Set<Pair> countPairs = new HashSet<Pair>();

	private String solveCase(String input) {
		// Init variables
		countPairs = new HashSet<Pair>();
		
		String[] split = input.split(" ");
		int A = Integer.valueOf(split[0]);
		int B = Integer.valueOf(split[1]);		
		return getTotalRecycledPairs(A, B);
	}

	private String getTotalRecycledPairs(int a, int b) {
		int numOfPairs = 0;
		for (int i = a; i <= b; i++) {
			numOfPairs += countRecycledPairs(i, a, b);
		}		
		return String.valueOf(numOfPairs);
	}

	private int countRecycledPairs(int num, int a, int b) {
		int count = 0;
		Set<Pair> pairs = getAllPairs(num);
		for (Pair p : pairs) {
			if (p.isIncludedIn(a, b) && p.isRecycled()) {
				if (!countPairs.contains(p)) {
					countPairs.add(p);
					count++;
					if (DEBUG) {
						System.out.println(p + ": counts!");
					}
				} else {
					if (DEBUG) {
						System.out.println(p + ": already count");
					}
				}
			} else {
				if (DEBUG) {
					System.out.println(p + ": does not count");
				}
			}
		}
		return count;
	}
	
	private Set<Pair> getAllPairs(int num) {
		HashSet<Pair> pairs = new HashSet<Pair>();
		String s = String.valueOf(num);
		for (int i = 0; i < s.length(); i++) {
			String s1 = s.substring(0, i);
			String s2 = s.substring(i);
			pairs.add(new Pair(Integer.valueOf(s1 + s2), Integer.valueOf(s2 + s1)));
		}
		return pairs;
	}

	class Pair {
		int n, m;
		
		Pair(int n, int m) {
			this.n = Math.min(n, m);
			this.m = Math.max(n, m);
		}
		
		@Override
		public String toString() {
			return "(" + n + ", " + m + ")";
		}
		
		boolean isRecycled() {
			String N = String.valueOf(n);
			String M = String.valueOf(m);
			
			if (N.length() != M.length()) {
				return false;
			}
			
			for (int i = 0; i < N.length(); i++) {
				String n1 = N.substring(0, i);
				String n2 = N.substring(i);
				if ((n2 + n1).matches(M)) {
					return true;
				}
			}
			
			return false;
		}
		
		boolean isIncludedIn(int a, int b) {
			return a <= n && n < m && m <= b;
		}
		
		@Override
		public boolean equals(Object another) {
			if (another == null)
				return false;

			if (!(another instanceof Pair))
				return false;

			return (this.m == ((Pair) another).m && this.n == ((Pair) another).n)
					|| (this.m == ((Pair) another).n && this.n == ((Pair) another).m);
		}
		
		@Override
		public int hashCode() {
			return String.valueOf(n).hashCode() + String.valueOf(m).hashCode();
		}
	}

}
