package ProblemSolvers;

import CaseSolvers.AllYourBaseCase;

public class AllYourBase extends ProblemSolver {

	public AllYourBase(String filePath) {
		super(filePath);
	}

	@Override
	public void process() {
		cases = io.readInt();
		for (int i = 1; i <= cases; i++) {
			new AllYourBaseCase(i, 1, io).process().printSolution();
		}
	}

}
