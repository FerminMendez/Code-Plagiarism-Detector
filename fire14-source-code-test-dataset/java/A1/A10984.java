package org.moriraaca.codejam;

import java.io.InputStream;
import java.util.Scanner;

public abstract class AbstractDataParser {
	protected Scanner scanner;

	protected TestCase[] testCases;

	public AbstractDataParser(InputStream input) {
		scanner = new Scanner(input);
		parse();
	}

	abstract protected void doParse();

	protected void parse() {
		doParse();
	}

	public TestCase[] getTestCases() {
		return testCases;
	}
}
