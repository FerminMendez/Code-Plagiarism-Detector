package org.moriraaca.codejam.dancingwithgooglers;

import org.moriraaca.codejam.AbstractSolver;
import org.moriraaca.codejam.SolverConfiguration;

@SolverConfiguration(parser = DancingWithTheGooglersDataParser.class)
public class DancingWithTheGooglersSolver extends
		AbstractSolver<DancingWithTheGooglersTestCase> {

	public static void main(String[] args) {
		new DancingWithTheGooglersSolver().getSolution();
	}

	private int cdiv(int n, int d) {
		return (n % d == 0 ? n / d : n / d + 1);
	}

	@Override
	protected String solveTestCase(DancingWithTheGooglersTestCase testCase) {
		int counter = 0;

		for (int i = 0; i < testCase.scores.length; i++) {
			int max = cdiv(testCase.scores[i], 3);
			
			if (max >= testCase.p) {
				counter++;
			} else if (testCase.scores[i] > 1 && testCase.scores[i] % 3 != 1 && max + 1 >= testCase.p
					&& testCase.S > 0) {
				counter++;
				testCase.S--;
			}
			
		}
		
		return String.valueOf(counter);
	}
}
