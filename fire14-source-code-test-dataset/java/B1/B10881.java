package de.at.codejam.util;

public interface CaseSolver<CASE> extends StatusListener {

	String solveCase(TaskStatus taskStatus, CASE caseToSolve);

	void addStatusListener(StatusListener statusListener);

	void removeStatusListener(StatusListener statusListener);
}
