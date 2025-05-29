package de.at.codejam.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AbstractOutputFileWriter<CASE> {

	private File outputFile;

	public AbstractOutputFileWriter(File outputFile) {
		this.outputFile = outputFile;
	}

	public void setOutputFile(File outputFile) {
		this.outputFile = outputFile;
	}

	public void appendResult(String result) {

		FileWriter fileWriter;
		BufferedWriter bufferedWriter;

		try {
			fileWriter = new FileWriter(outputFile, true);
			bufferedWriter = new BufferedWriter(fileWriter);

			bufferedWriter.append(result);
			bufferedWriter.append("\n");

			bufferedWriter.close();
			fileWriter.close();

		} catch (IOException e) {
			// FIXME Error logging
		} finally {
		}

	}
}
