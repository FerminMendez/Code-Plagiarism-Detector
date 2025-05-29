package de.johanneslauber.codejam.model.impl;

import de.johanneslauber.codejam.model.BaseProblem;
import de.johanneslauber.codejam.model.ICase;
import de.johanneslauber.codejam.model.IProblem;

/**
 * 
 * @author Johannes Lauber - joh.lauber@googlemail.com
 * 
 */
public class DancingGooglersProblem extends BaseProblem implements IProblem {

	@Override
	public void solveCases() {
		for (ICase currentCase : super.listOfCases) {
			StringBuilder builder = new StringBuilder();
			DancingGooglersCase dancingGoogleCase = (DancingGooglersCase) currentCase;

			int[] maxPointsForGooglers = dancingGoogleCase
					.getMaxPointsOfGooglers();

			int minLimitOfPoints = dancingGoogleCase.getMinLimitOfPoints();
			int numberOfTriplets = dancingGoogleCase.getNumberOfTriplets();
			int numberOfGooglersHigherLimit = 0;

			for (int i = 0; i < maxPointsForGooglers.length; i++) {
				int maxPointsForGoogler = maxPointsForGooglers[i];
				double quotient = (double) maxPointsForGoogler / (double) 3;

				// zero is a special case
				if (maxPointsForGoogler != 0) {

					// test whether a triplet with 1 or 2 apart is possible with
					// the
					// current min level
					if ((Math.round(quotient) + 1) >= minLimitOfPoints) {

						// test whether apart is 1 or 2
						if ((minLimitOfPoints - 1) >= quotient) {

							// are ther more triplets left?
							if (numberOfTriplets > 0) {
								numberOfGooglersHigherLimit++;
								numberOfTriplets--;
							} else {
								// its possible to make a triplet with apart of
								// 2,
								// but no more left
								System.out.println("no more left");
							}
						} else {
							numberOfGooglersHigherLimit++;
						}
					}
				} else if (minLimitOfPoints == 0) {
					// if the limit and the max points are 0, it's possible
					numberOfGooglersHigherLimit++;
				}
			}

			// for (int i = 0; i < maxPointsForGooglers.length; i++) {
			// if (((maxPointsForGooglers[i] + 2) / 3) >= minLimitOfPoints) {
			// numberOfGooglersHigherLimit++;
			// } else if ((numberOfTriplets > 0)
			// && (((maxPointsForGooglers[i] + 4) / 3) >= minLimitOfPoints)) {
			// numberOfTriplets--;
			// numberOfGooglersHigherLimit++;
			// }
			// }

			this.writeToFile(String.valueOf(numberOfGooglersHigherLimit));
		}
		this.closeWriter();
	}

}
