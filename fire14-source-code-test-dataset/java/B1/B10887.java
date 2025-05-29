package de.at.codejam;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import de.at.codejam.util.AbstractOutputFileWriter;
import de.at.codejam.util.CaseSolver;
import de.at.codejam.util.InputFileParser;
import de.at.codejam.util.StatusListener;
import de.at.codejam.util.TaskStatus;

public abstract class AbstractCodeJamProblemSolver<CASE> implements
		StatusListener {

	private final List<StatusListener> statusListenerList = new ArrayList<StatusListener>();

	private TaskStatus taskStatus = null;

	private CaseSolver<CASE> currentCaseSolver;

	public void solveInputFile(File inputFile, File outputFile) {

		taskStatus = new TaskStatus();

		final InputFileParser<CASE> inputFileParser = createInputFileParser(inputFile);
		final AbstractOutputFileWriter<CASE> outputFileWriter = createOutputFileWriter(outputFile);

		inputFileParser.initialize(taskStatus);
		log(LOGLEVEL_INFO, "Initialized: " + taskStatus);

		Thread caseSolvingProcess = new Thread(new Runnable() {

			@Override
			public void run() {

				taskStatus.setCurrentTaskStatus(TaskStatus.STATUS_RUNNING);

				int i = 0;
				try {

					while (inputFileParser.hasNextCase()) {

						final CASE currentCase = inputFileParser.getNextCase();

						i++;
						taskStatus.setNumberCurrentCase(i);

						String result = solveCase(taskStatus, currentCase);
						log(StatusListener.LOGLEVEL_INFO, result);
						outputFileWriter.appendResult(result);

						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
						}
					}

					taskStatus.setCurrentTaskStatus(TaskStatus.STATUS_DONE);

				} catch (Exception exc) {

					exc.printStackTrace();

					log(LOGLEVEL_ERROR,
							"Exception while reading / solving cases: "
									+ exc.getMessage());
					taskStatus.setCurrentTaskStatus(TaskStatus.STATUS_ERROR);
				}
			}
		});
		caseSolvingProcess.start();

		Thread progressUpdateProcess = new Thread(new Runnable() {
			@Override
			public void run() {

				while (!taskStatus.equals(TaskStatus.STATUS_DONE)) {

					updateStatus(taskStatus);

					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}
				}
				updateStatus(taskStatus);
			}
		});
		progressUpdateProcess.start();
	}

	private String solveCase(TaskStatus taskStatus, CASE caseToSolve) {

		if ((null == currentCaseSolver)
				|| !useCaseSolver(currentCaseSolver, caseToSolve)) {
			currentCaseSolver = buildCaseSolver(caseToSolve);
			currentCaseSolver.addStatusListener(this);
		}

		return currentCaseSolver.solveCase(taskStatus, caseToSolve);
	}

	protected abstract boolean useCaseSolver(CaseSolver<CASE> caseSolver,
			CASE caseToSolve);

	protected abstract CaseSolver<CASE> buildCaseSolver(CASE caseToSolve);

	protected abstract InputFileParser<CASE> createInputFileParser(
			File inputFile);

	protected abstract AbstractOutputFileWriter<CASE> createOutputFileWriter(
			File outputFile);

	@Override
	public void updateStatus(TaskStatus taskStatus) {
		for (StatusListener listener : statusListenerList) {
			listener.updateStatus(taskStatus);
		}
	}

	@Override
	public void log(int logLevel, String message) {
		for (StatusListener listener : statusListenerList) {
			listener.log(logLevel, message);
		}
	}

	public void addStatusListener(StatusListener statusListener) {
		statusListenerList.add(statusListener);
	}

	public void removeStatusListener(StatusListener statusListener) {
		statusListenerList.remove(statusListener);
	}
}
