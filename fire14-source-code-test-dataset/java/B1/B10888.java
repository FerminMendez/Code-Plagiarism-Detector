package de.at.codejam.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;

import de.at.codejam.AbstractCodeJamProblemSolver;
import de.at.codejam.util.CodeJamConstants;
import de.at.codejam.util.StatusListener;

public abstract class AbstractCodeJamClient<CASE> implements CodeJamConstants {

	private final CodeJamWindow window = new CodeJamWindow();
	private final CodeJamMainPanel mainPanel = new CodeJamMainPanel();

	private final StatusListener statusListener = mainPanel;

	protected abstract AbstractCodeJamProblemSolver<CASE> getTaskSolver();

	protected abstract String getAssignmentName();

	public void start() {

		if (!DEFAULT_CODE_JAM_DIRECTORY.exists()) {
			DEFAULT_CODE_JAM_DIRECTORY.mkdirs();
		}

		window.setAssignmentName(getAssignmentName());
		window.setContentPane(mainPanel);
		window.setEnabled(true);
		window.setVisible(true);

		final JFileChooser fileChooser = mainPanel.getFileChooser();
		fileChooser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (e.getActionCommand().equals(JFileChooser.CANCEL_SELECTION)) {
					System.exit(0);
					return;
				}

				File inputFile = fileChooser.getSelectedFile();

				String inputFilename = inputFile.getAbsolutePath();

				int suffixIndex = inputFilename.lastIndexOf(".in");
				String neutralFilenamePart = inputFilename.substring(0,
						suffixIndex);
				String outputFilename = neutralFilenamePart + ".out";

				File outputFile = new File(outputFilename);

				System.out.println("Input: " + inputFilename + ", exists: "
						+ inputFile.exists());
				System.out.println("Output: " + outputFilename + ", exists: "
						+ outputFile.exists());

				if (outputFile.exists()) {
					outputFile.delete();
				}

				try {
					outputFile.createNewFile();
				} catch (IOException ioexception) {
					ioexception.printStackTrace();
				}

				if ((null != inputFile) && (inputFile.exists())) {
					AbstractCodeJamProblemSolver<CASE> taskSolver = getTaskSolver();
					taskSolver.addStatusListener(statusListener);
					taskSolver.solveInputFile(inputFile, outputFile);
				}
			}
		});
	}
}
