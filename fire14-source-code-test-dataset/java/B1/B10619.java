package ProblemSolvers;

import CaseSolvers.RecycledNumbersCase;

public class RecycledNumbers extends ProblemSolver {

	public RecycledNumbers(String filePath) {
		super(filePath);
	}

	@Override
	public void process() {
		cases = io.readInt();

		for (int i = 1; i <= cases; i++) {
			new RecycledNumbersCase(i, 1, io).process().printSolution();
		}
	}
}
