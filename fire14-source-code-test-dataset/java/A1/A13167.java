package tr0llhoehle.cakemix.googleCodejam;

import tr0llhoehle.cakemix.utility.googleCodeJam.Solver;

public class DWGSolver implements Solver<DWGProblem> {

	@Override
	public String solve(DWGProblem p) {
		int numberOfBestResult = 0;
		int surprising = 0;

		/*
		 * for (int sum : p.getDancerSums()) { int[] triplet = new int[3];
		 * boolean done = false; int remainder = sum % 3;
		 * 
		 * for (int i : triplet) { i = sum / 3;
		 * 
		 * if (remainder > 0) { i++; remainder--; } // not-surprising triplets
		 * generated.
		 * 
		 * if (i >= p.getBorder()) { numberOfBestResult++; done = true; break; }
		 * }
		 * 
		 * if (!done && sum > 1 && surprising < p.getNumberOfSuprisingTriplets()
		 * && triplet[0] + 1 >= p.getBorder()) { numberOfBestResult++;
		 * surprising++;
		 * 
		 * } }
		 */

		for (int sum : p.getDancerSums()) {
			int avg = sum / 3;
			int remainder = sum % 3;

			if (sum == 0) {
				if (p.getBorder() <= 0) {
					numberOfBestResult++;
				}
			} else if (sum == 1) {
				if (p.getBorder() <= 1) {
					numberOfBestResult++;
				}
			} else { // sum >= 2
				switch (remainder) {
				case 0:
					if (avg >= p.getBorder()) {
						numberOfBestResult++;
					} else if (surprising < p.getNumberOfSuprisingTriplets()
							&& avg + 1 >= p.getBorder()) {
						numberOfBestResult++;
						surprising++;
					}
					break;
				case 1:
					if (avg + 1 >= p.getBorder()) {
						numberOfBestResult++;
					}
					break;
				case 2:
					if (avg + 1 >= p.getBorder()) {
						numberOfBestResult++;
					} else if (surprising < p.getNumberOfSuprisingTriplets()
							&& avg + 2 >= p.getBorder()) {
						numberOfBestResult++;
						surprising++;
					}
					break;
				}
			}
		}

		return numberOfBestResult + "";
	}
}
