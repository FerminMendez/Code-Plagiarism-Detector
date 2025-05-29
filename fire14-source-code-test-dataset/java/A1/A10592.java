package ProblemSolvers;
import Controller.IO;

public abstract class ProblemSolver {

	protected IO io;
	protected int cases;

	public ProblemSolver(String filePath) {
		io = new IO(filePath);
	}

	public abstract void process();

}
