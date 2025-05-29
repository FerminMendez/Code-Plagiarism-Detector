package be.mokarea.gcj.googledancers;

import java.io.FileInputStream;
import java.io.PrintWriter;

import be.mokarea.gcj.common.GoogleCodeJamBase;
import be.mokarea.gcj.common.TestCaseReader;
import be.mokarea.gcj.common.Transformation;

public class GoogleDancer extends GoogleCodeJamBase<GoogleDancerTestCase> {
	private final String outputFileName;
	private final String inputFileName;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new GoogleDancer(args[0], args[1]).execute();
	}
	
	GoogleDancer(String inputFileName,String outputFileName) {
		this.inputFileName = inputFileName;
		this.outputFileName = outputFileName;
	}

	@Override
	protected Transformation<GoogleDancerTestCase> createTransformation(
			TestCaseReader<GoogleDancerTestCase> testCaseReader,
			PrintWriter outputWriter) throws Exception {
		return new GoogleDancerTransformation(testCaseReader,outputWriter);
	}

	@Override
	protected String getOutputFileName() throws Exception {
		return outputFileName;
	}

	@Override
	protected TestCaseReader<GoogleDancerTestCase> getTestCaseReader()
			throws Exception {
		return new GoogleDancerTestCaseReader(new FileInputStream(inputFileName));
	}


}
