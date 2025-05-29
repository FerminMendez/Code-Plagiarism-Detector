package ProblemSolvers;

import CaseSolvers.WiresCase;

public class Wires extends ProblemSolver {

	public Wires(String filePath) {
		super(filePath);
	}

	@Override
	public void process() {
		cases = io.readInt();

		for (int i = 1; i <= cases; i++) {
			new WiresCase(i, io.readInt(), io).process().printSolution();
		}
	}
}
