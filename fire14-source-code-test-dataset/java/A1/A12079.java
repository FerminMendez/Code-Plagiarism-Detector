package com.renoux.gael.codejam.cj2012.qb;

import com.renoux.gael.codejam.fwk.Solver;
import com.renoux.gael.codejam.utils.ArrayUtils;
import com.renoux.gael.codejam.utils.Input;
import com.renoux.gael.codejam.utils.Output;

public class QB extends Solver {

	public static void main(String... args) throws Exception {
		new QB().run();
	}

	@Override
	protected void solveCase(Input in, Output out) {
		System.out.println();
		int[] line = ArrayUtils.parseInts(in.readLine().split(" "));
		int ctGooglers = line[0];
		int ctSurprises = line[1];
		int target = line[2];

		int ctStars = 0;

		for (int i = 3; i < line.length; i++) {
			int totalScore = line[i];

			int lowestScoreNoSurprise = Math.max(target - 1, 0);
			int lowestScoreWithSurprise = Math.max(target - 2, 0);

			int lowestTotalNoSurprise = target + 2 * lowestScoreNoSurprise;
			int lowestTotalWithSurprise = target + 2 * lowestScoreWithSurprise;

			if (lowestTotalNoSurprise <= totalScore) {
				ctStars++;
				System.out.println("Guy " + (i - 2) + " did great");
			} else if (lowestTotalWithSurprise <= totalScore && ctSurprises > 0) {
				ctStars++;
				ctSurprises--;
				System.out.println("Guy " + (i - 2) + " did ok");
			}
		}

		out.writeLine(ctStars);
	}

	@Override
	protected String getProblemName() {
		return "QB";
	}

	@Override
	protected boolean disableSmall() {
		return true;
	}

	@Override
	protected boolean disableLarge() {
		return true;
	}
}
