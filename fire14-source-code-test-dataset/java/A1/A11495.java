package com.google.jam.eaque.stub;

import java.io.IOException;

public abstract class Stub {

	private String outputFileName;

	public String getOutputFileName() {
		return outputFileName;
	}

	public void setOutputFileName(String outputFileName) {
		this.outputFileName = outputFileName;
	}

	public abstract String runTestCase(InputFileManager ifm)
			throws NumberFormatException, IOException;
}
