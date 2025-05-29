package com.nbarraille.gcj;
import java.io.IOException;


public class GCJ extends GCJHelper {
	protected static final String TEST_CASE = "C-small"; // CHANGE THIS WHEN CHANGING PROBLEM
	protected static final boolean RUN_ALL_CASES = true;
	protected static final boolean DEBUG = true;
	
	// DO WHATEVER TO SOLVE THE CASE
	// AND APPEND THE OUTPUT TO SB
	protected static void solveCase() throws IOException {
		long[] inp = readLongArray();
		int a = (int) inp[0];
		int b = (int) inp[1];
		int nbDigits = String.valueOf(a).length();
		int nbOk = 0;
		for (int i = a; i <= b; i++) {
			int i2 = i;
			for (int j = 1; j < nbDigits; j++) {
				i2 = shift(i2, nbDigits);
				if (i2 >= a && i2 <= b && i < i2) {
					nbOk++;
				}
			}
		}
		sb.append(nbOk);
	}
	
	
	private static int shift(int i, int nbDigits) {
		String s = String.valueOf(i);
		while (s.length() < nbDigits) {
			s = "0" + s;
		}
		return Integer.valueOf(s.charAt(s.length() - 1) + s.substring(0, s.length() - 1));
	}

	
	
	
	// DONT TOUCH THIS
	public static void main(String[] args) throws Exception {
		run();
	}
}
