package de.at.codejam.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * FIXME - redesign ... keep closing and loading file for each test case, but
 * question every method and variable here. Remember new class TaskStatus - does
 * it inspire?
 */
public abstract class AbstractInputFileParser<CASE> implements
		CodeJamConstants, InputFileParser<CASE> {

	private final File inputFile;

	private TaskStatus taskStatus;

	private int numberCases = UNDEFINED;

	public AbstractInputFileParser(File inputFile) {
		this.inputFile = inputFile;
	}

	@Override
	public void initialize(TaskStatus taskStatus) {

		this.taskStatus = taskStatus;

		countCases();

		taskStatus.setNumberCases(numberCases);
		taskStatus.setNumberCurrentCase(1);
	}

	@Override
	public TaskStatus getTaskStatus() {
		return taskStatus;
	}

	public int countCases() {

		FileReader fileReader;
		BufferedReader bufferedReader;

		try {

			fileReader = new FileReader(inputFile);
			bufferedReader = new BufferedReader(fileReader);

			numberCases = Integer.parseInt(bufferedReader.readLine().trim());

			bufferedReader.close();
			fileReader.close();

		} catch (FileNotFoundException e) {
			// FIXME Error logging
		} catch (IOException e) {
			// FIXME Error logging
		} finally {
		}

		return numberCases;
	}

	public int getNumberCases() {
		return numberCases;
	}

	public boolean hasNextCase() {
		return (null != taskStatus)
				&& (taskStatus.getNumberCases() > taskStatus
						.getNumberCurrentCase());
	}

	public BufferedReader checkoutBufferedReader() throws FileNotFoundException {

		FileReader fileReader = null;
		BufferedReader bufferedReader = null;

		fileReader = new FileReader(inputFile);
		bufferedReader = new BufferedReader(fileReader);

		return bufferedReader;
	}

	public void checkinBufferedReader(BufferedReader bufferedReader)
			throws IOException {

		// Does this call also close the FileReader instance?
		bufferedReader.close();
	}

	public List<String> readLines(BufferedReader bufferedReader,
			int numberOfLines) throws IOException {

		List<String> lineList = new ArrayList<String>();

		int linesRead = 0;
		while (numberOfLines > linesRead) {

			// Reading Line
			String currentLine = bufferedReader.readLine();
			if (null == currentLine) {
				throw new RuntimeException("Unexpected end of file.");
			}

			lineList.add(currentLine);
			linesRead++;
		}

		return lineList;
	}

	public List<String> readLines(BufferedReader bufferedReader, int firstLine,
			int numberOfLines) throws IOException {

		int nrCurrentLine = 1;
		while (firstLine > nrCurrentLine) {

			// Skipping line, probably not the sweetest way to do it ... by any
			// means.
			if (null == bufferedReader.readLine()) {
				throw new RuntimeException("Unexpected end of file.");
			}

			nrCurrentLine++;
		}

		return readLines(bufferedReader, numberOfLines);
	}
}
