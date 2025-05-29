package de.johanneslauber.codejam.model;

import java.util.List;

public interface IProblem {

	public void setListOfCases(List<ICase> listOfCases);

	public void solveCases();
}
