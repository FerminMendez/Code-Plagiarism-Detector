package CaseSolvers;

import Controller.IO;

public abstract class CaseSolver {

	private int order;

	public CaseSolver(int order, int numberOfLines, IO io) {
		this.order = order;
		initializeVars();
		addAllLines(io, numberOfLines);
	}

	public abstract void addLine(String line);
	
	public abstract void initializeVars();
	
	public abstract void printSolution();
	
	public abstract CaseSolver process();

	public void addAllLines(IO io, int numberOfLines) {
		for (int i = 0; i < numberOfLines; i++) {
			addLine(io.readLine());
		}
	}	

	public int getOrder() {
		return order;
	}

}
