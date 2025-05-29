package de.johanneslauber.codejam.model.impl;

import de.johanneslauber.codejam.model.BaseProblem;
import de.johanneslauber.codejam.model.ICase;
import de.johanneslauber.codejam.model.IProblem;

/**
 * 
 * @author Johannes Lauber - joh.lauber@googlemail.com
 * 
 */
public class RecycledNumbersProblem extends BaseProblem implements IProblem {

	@Override
	public void solveCases() {
		for (ICase currentCase : super.listOfCases) {
			int countPairs = 0;

			RecycledNumbersCase recycledNumbersCase = (RecycledNumbersCase) currentCase;

			int a = recycledNumbersCase.getA();
			int b = recycledNumbersCase.getB();

			for (int n = a; n < b; n++) {
				for (int m = (n + 1); m <= Math.min(10 * n, b); m++) {
					if (isRecycledPair(n, m)) {
						countPairs++;
					}
				}
			}

			this.writeToFile(String.valueOf(countPairs));
		}
		this.closeWriter();
	}

	private boolean isRecycledPair(int n, int m) {
		String nString = String.valueOf(n);
		char[] nCharArray = nString.toCharArray();
		int lengthBegin;
		StringBuilder builder;
		int recycledN;

		// try every possible length to cut of the end and move to the front
		for (int i = 1; i < nCharArray.length; i++) {

			lengthBegin = nCharArray.length - i;
			builder = new StringBuilder();

			builder.append(nString.substring(lengthBegin, nCharArray.length));
			builder.append(nString.substring(0, lengthBegin));

			recycledN = Integer.parseInt(builder.toString());

			if (recycledN == m) {
				return true;
			}
		}
		return false;
	}
}
