/**
 * Copyright 2012 Christopher Schmitz. All Rights Reserved.
 */

package com.isotopeent.codejam;

import com.isotopeent.codejam.lib.SolverBase;
import com.isotopeent.codejam.lib.Utils;
import com.isotopeent.codejam.lib.converters.IntArrayLine;

public class Solver extends SolverBase<int[]> {

	private static final String FILE_PATH = "C:\\codejam\\";
	private static final String FILE_NAME = "B-small-attempt0";
	private static final int INIT_PARAM_COUNT = 1;

	private static final int PARAM_COUNT = 3;
	private static final int MAX_ARRAY_SIZE = PARAM_COUNT + 100; // 3 params + N=100
	private static final int SCORE_COUNT = 3;

	public static void main(String [] args) {
		Utils.solve(FILE_PATH, FILE_NAME, new IntArrayLine(new int[MAX_ARRAY_SIZE]), new Solver());
	}

	public Solver() {
		super(INIT_PARAM_COUNT);
	}

	@Override
	protected String solve(int[] input) {
		int surprisingScores = input[1];
		int scoreThreashold = input[2];
		int minUnsurprisingScore = scoreThreashold * SCORE_COUNT - SCORE_COUNT + 1;
		int minSurprisingScore = Math.max(minUnsurprisingScore - SCORE_COUNT + 1, scoreThreashold);

		int count = 0;
		int length = input.length;
		for (int i = PARAM_COUNT; i < length; i++) {
			int score = input[i];
			if (score >= minUnsurprisingScore) {
				count++;
			} else if (score >= minSurprisingScore && surprisingScores > 0) {
				count++;
				surprisingScores--;
			}
		}
		return Integer.toString(count);
	}

}
