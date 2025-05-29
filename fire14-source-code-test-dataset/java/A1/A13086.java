package com.nbarraille.gcj;
import java.io.IOException;


public class GCJ extends GCJHelper {
	protected static final String TEST_CASE = "B-small"; // CHANGE THIS WHEN CHANGING PROBLEM
	protected static final boolean RUN_ALL_CASES = true;
	protected static final boolean DEBUG = true;
	
	// DO WHATEVER TO SOLVE THE CASE
	// AND APPEND THE OUTPUT TO SB
	protected static void solveCase() throws IOException {
		long[] input = readLongArray();
		int nbDancers = (int)input[0];
		int nbSurprises = (int)input[1];
		int minScore = (int) input[2];
		long[] totals = new long[nbDancers];
		System.arraycopy(input, 3, totals, 0, nbDancers);
		int nbOk = 0;
		int nbOkWithS = 0;
		for (long t : totals) {
			if (minScore == 0) {
				nbOk++;
			} else if (minScore == 1) {
				if (t >= 1) {
					nbOk++;
				}
			} else if (t >= 3 * minScore - 2) {
				nbOk++;
			} else if (t >= 3 * minScore - 4) {
				nbOkWithS++;
			}
		}
		
		sb.append(nbOk + Math.min(nbSurprises, nbOkWithS));
		
	}

	
	
	
	// DONT TOUCH THIS
	public static void main(String[] args) throws Exception {
		run();
	}
}
