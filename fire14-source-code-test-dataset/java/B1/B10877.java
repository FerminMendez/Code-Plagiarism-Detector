package de.at.codejam.problem3.gui;

import de.at.codejam.AbstractCodeJamProblemSolver;
import de.at.codejam.gui.AbstractCodeJamClient;
import de.at.codejam.problem3.Problem3Case;
import de.at.codejam.problem3.Problem3Solver;

public class Problem3Client extends AbstractCodeJamClient<Problem3Case> {

	@Override
	protected AbstractCodeJamProblemSolver<Problem3Case> getTaskSolver() {

		return new Problem3Solver();
	}

	@Override
	protected String getAssignmentName() {

		return "Recycled Numbers";
	}

	public static final void main(String[] args) {

		Problem3Client client = new Problem3Client();
		client.start();
	}

}
