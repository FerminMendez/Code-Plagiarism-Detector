/**
 * Copyright 2012 Christopher Schmitz. All Rights Reserved.
 */

package com.isotopeent.codejam.lib;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class SolutionWriter extends PrintWriter {

	private static final String FORMAT = "Case #%1$s: %2$s%n";
	private String[] args = new String[2];

	public SolutionWriter(File file) throws FileNotFoundException {
		super(file);
	}

	public void writeSolution(int caseNumber, String solution) {
		args[0] = Integer.toString(caseNumber);
		args[1] = solution;;
		printf(FORMAT, (Object[]) args);
	}

}
