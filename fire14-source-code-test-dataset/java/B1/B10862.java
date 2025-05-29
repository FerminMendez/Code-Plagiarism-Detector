package be.mokarea.gcj.recyclednumbers;

import java.io.FileInputStream;
import java.io.PrintWriter;

import be.mokarea.gcj.common.GoogleCodeJamBase;
import be.mokarea.gcj.common.TestCaseReader;
import be.mokarea.gcj.common.Transformation;

public class RecycledNumbers extends GoogleCodeJamBase<RecycledNumbersTestCase> {
	private final String outputFileName;
	private final String inputFileName;

	
	public RecycledNumbers(String inputFileName, String outputFileName) {
		super();
		this.inputFileName = inputFileName;
		this.outputFileName = outputFileName;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new RecycledNumbers(args[0], args[1]).execute();

	}

	@Override
	protected Transformation<RecycledNumbersTestCase> createTransformation(
			TestCaseReader<RecycledNumbersTestCase> testCaseReader,
			PrintWriter outputWriter) throws Exception {
		return new RecycledNumbersTransformation(testCaseReader,outputWriter);
	}

	@Override
	protected String getOutputFileName() throws Exception {
		return outputFileName;
	}

	@Override
	protected TestCaseReader<RecycledNumbersTestCase> getTestCaseReader()
			throws Exception {
		return new RecycledNumbersTestCaseReader(new FileInputStream(inputFileName));
	}


}
