/**
 * Copyright 2012 Christopher Schmitz. All Rights Reserved.
 */

package com.isotopeent.codejam.lib;

public abstract class SolverBase<T> {

	private InputReader<T> inputReader;
	protected int[] params;

	public SolverBase(int initParamCount) {
		if (initParamCount > 0) {
			params = new int[initParamCount];
		}
	}

	public void init(InputReader<T> inputReader) {
		this.inputReader = inputReader;

		if (params != null) {
			try {
				String line = inputReader.readLine();
				params = Utils.convertToIntArray(line, params.length);
			} catch (Exception e) {
				System.err.println("Error while reading initial parameters");
				e.printStackTrace();
			}
		}
	}

	public final String solveNext() {
		String solution = null;
		T input = inputReader.readInput();
		if (input != null) {
			solution = solve(input);
		}
		return solution;
	}

	protected abstract String solve(T input);

}
