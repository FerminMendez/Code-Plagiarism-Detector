package Controller;

import ProblemSolvers.ProblemSolver;
import ProblemSolvers.RecycledNumbers;

public class Main {
	public static void main(String[] args) {

		ProblemSolver problem = new RecycledNumbers("recycledNumbers");
		problem.process();

	}
}
