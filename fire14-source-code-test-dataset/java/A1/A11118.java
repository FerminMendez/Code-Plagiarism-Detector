package com.googlecode.codejam.model;

import java.util.Arrays;
import java.util.concurrent.Callable;

public abstract class JamCaseResolver implements Callable<String> {

	private final int caseNumber;
	
	public JamCaseResolver(int caseNumber) {
		this.caseNumber = caseNumber;
	}

	@Override
	public final String call() throws Exception {
		return this.resolve();
	}

	protected abstract String resolve();
	
	protected long[] parse(final String[] numbers) {
		final long[] parsed = new long[numbers.length];
		for (int i = 0; i < numbers.length; i++) 
			parsed[i] = this.parse(numbers[i]);
		return parsed;
	}
	
	protected long parse(final String number) {
		return Long.parseLong(number);
	}
	
	protected int[] parseInt(final String[] numbers) {
		final int[] parsed = new int[numbers.length];
		for (int i = 0; i < numbers.length; i++) 
			parsed[i] = this.parseInt(numbers[i]);
		return parsed;
	}
	
	protected int parseInt(final String number) {
		return Integer.parseInt(number);
	}
	
	protected long sum(final Iterable<Long> elements) {
		long sum = 0;
		for (final long element : elements)
			sum += element;
		return sum;
	}
	
	protected long sum(final Long[] elements) {
		return this.sum(Arrays.asList(elements));
	}
	
	protected String toMatrixString(final String matrixString) {
		return matrixString.replaceAll("\\},\\{", "\n").replaceAll("(^\\{\\{|\\}\\}$)|,", "");
	}
	
	public int getCaseNumber() {
		return caseNumber;
	}

	@Override
	public String toString() {
		return "JamCaseResolver [caseNumber=" + caseNumber + "]";
	}
	
}

