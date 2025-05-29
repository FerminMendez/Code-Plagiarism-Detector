package com.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ProblemCSolver {

	private static boolean debug = false;

	private static List<TestCase> testCases;

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		loadCase(new File(args[0]));
		for (int i = 0; i < testCases.size(); i++) {
			Solve(testCases.get(i));
		}
	}

	private static void Debug(String s) {
		if (debug) {
			System.out.println(s);
		}
	}

	private static class TestCase {
		int caseNo;

		// Test specific properties
		int A;
		int B;

		public TestCase(int caseNo, int A, int B) {
			super();
			this.caseNo = caseNo;
			this.A = A;
			this.B = B;
		}

		@Override
		public String toString() {
			return "TestCase [caseNo=" + caseNo + ", A=" + A + ", B=" + B + "]";
		}
	}

	private static void loadCase(File inputFile) throws NumberFormatException,
			IOException {
		BufferedReader r = null;

		try {
			r = new BufferedReader(new FileReader(inputFile));

			// Problem specific loading routine

			int count = Integer.parseInt(r.readLine());

			testCases = new ArrayList<TestCase>(count);

			for (int i = 1; i <= count; i++) {
				String line = r.readLine();
				StringTokenizer token = new StringTokenizer(line);

				TestCase thisCase = new TestCase(i, Integer.parseInt(token
						.nextToken()), Integer.parseInt(token.nextToken()));
				testCases.add(thisCase);

			}
		} finally {
			if (r != null) {
				r.close();
			}
		}
	}

	private static void Solve(TestCase t) {
		Debug("Solving:" + t);

		String res = null;
		// TODO: implement the test

		int count = 0;
		for (int i = t.A; i < t.B; i++) {
			for (int j = i + 1; j <= t.B; j++) {
				if (isRecycled(i, j)) {
					count++;
				}
			}
		}

		res = "" + count;

		// Standard output format
		System.out.printf("Case #%d: %s%n", t.caseNo, res);
	}

	private static boolean isRecycled(int A, int B) {
		String aString = String.valueOf(A);
		String bString = String.valueOf(B);

		for (int i = 1; i < aString.length(); i++) {
			if ((aString.substring(i) + aString.substring(0, i))
					.equals(bString)) {
				return true;
			}
		}
		return false;
	}
}
