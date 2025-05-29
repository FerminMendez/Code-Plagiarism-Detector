package tr0llhoehle.cakemix.googleCodeJam.recycledNumbers;

import java.util.ArrayList;

import tr0llhoehle.cakemix.utility.googleCodeJam.Solver;

public class RNSolver implements Solver<RNProblem> {

	@Override
	public String solve(RNProblem p) {
		int amount = 0;

		for (Integer i = p.getLowerBorder(); i < p.getUpperBorder(); i++) {
			ArrayList<String> usedPermutations = new ArrayList<String>();
			String nmbr = String.valueOf(i);

			// for each permutation...
			for (int j = 0; j < nmbr.length(); j++) {
				String tempPermutation = nmbr.substring(j)
						+ nmbr.substring(0, j);

				if (tempPermutation.charAt(0) != '0'
						&& !usedPermutations.contains(tempPermutation)) {
					int permutation = Integer.parseInt(tempPermutation);

					usedPermutations.add(tempPermutation);
					if (permutation > i && permutation <= p.getUpperBorder()) {
						amount++;
						System.out.println("(" + i + ", " + permutation + ")");
					}
				}

			}
		}

		return amount + "";
	}
}
