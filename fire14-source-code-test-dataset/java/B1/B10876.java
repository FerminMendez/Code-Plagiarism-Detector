package de.at.codejam.problem3;

import java.io.File;

import de.at.codejam.AbstractCodeJamProblemSolver;
import de.at.codejam.problem3.util.Problem3CaseSolver;
import de.at.codejam.problem3.util.Problem3InputFileParser;
import de.at.codejam.problem3.util.Problem3OutputFileWriter;
import de.at.codejam.util.AbstractOutputFileWriter;
import de.at.codejam.util.CaseSolver;
import de.at.codejam.util.InputFileParser;

public class Problem3Solver extends AbstractCodeJamProblemSolver<Problem3Case> {

	@Override
	protected boolean useCaseSolver(CaseSolver<Problem3Case> caseSolver,
			Problem3Case caseToSolve) {

		return false;
	}

	@Override
	protected CaseSolver<Problem3Case> buildCaseSolver(Problem3Case caseToSolve) {

		return new Problem3CaseSolver();
	}

	@Override
	protected InputFileParser<Problem3Case> createInputFileParser(File inputFile) {

		return new Problem3InputFileParser(inputFile);
	}

	@Override
	protected AbstractOutputFileWriter<Problem3Case> createOutputFileWriter(
			File outputFile) {

		return new Problem3OutputFileWriter(outputFile);
	}

}
