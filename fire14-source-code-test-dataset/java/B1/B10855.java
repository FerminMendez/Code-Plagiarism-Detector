package be.mokarea.gcj.common;

import java.io.PrintWriter;

public abstract class Transformation<T extends TestCase> {
	private TestCaseReader<T> caseReader;
	private final PrintWriter outputWriter;

	public Transformation(TestCaseReader<T> caseReader, PrintWriter outputWriter) {
		this.caseReader = caseReader;
		this.outputWriter = outputWriter;
	}

	public void transformAll() throws Exception {
		T testCase = caseReader.nextCase();
		while (testCase != null) {
			outputWriter.println(transform(testCase));
			testCase = caseReader.nextCase();
		};

	}
	
	protected abstract String transform(T testCase);
}
