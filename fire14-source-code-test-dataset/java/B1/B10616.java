package ProblemSolvers;

import CaseSolvers.DancingGooglersCase;

public class DancingGooglers extends ProblemSolver {

	public DancingGooglers(String filePath) {
		super(filePath);
	}

	@Override
	public void process() {
		cases = io.readInt();
		
		for (int i = 1; i <= cases; i++) {
			new DancingGooglersCase(i, 1, io).process().printSolution();
		}
	}
}
