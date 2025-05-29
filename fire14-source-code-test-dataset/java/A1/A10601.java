package Controller;

import ProblemSolvers.DancingGooglers;
import ProblemSolvers.ProblemSolver;

public class Main {
	public static void main(String[] args) {

		ProblemSolver problem = new DancingGooglers("dancingGooglers");
		problem.process();

	}
}
