package ProblemSolvers;

import CaseSolvers.GooglereseCase;
import CaseSolvers.WiresCase;

public class Googlerese extends ProblemSolver {

	public Googlerese(String filePath) {
		super(filePath);
	}

	@Override
	public void process() {
		cases = io.readInt();

		for (int i = 1; i <= cases; i++) {
			new GooglereseCase(i, 1, io).process().printSolution();
		}
	}
}
