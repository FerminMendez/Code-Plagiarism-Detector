package de.at.codejam.gui;

import java.awt.BorderLayout;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;

import de.at.codejam.util.CodeJamConstants;
import de.at.codejam.util.StatusListener;
import de.at.codejam.util.TaskStatus;

public class CodeJamMainPanel extends JPanel implements CodeJamConstants,
		StatusListener {

	private static final long serialVersionUID = 5367570736703559286L;

	private JPanel mainArea = new JPanel(new BorderLayout());

	private final CodeJamStatusPanel statusPanel = new CodeJamStatusPanel();
	private final JFileChooser fileChooser = new JFileChooser(
			DEFAULT_CODE_JAM_DIRECTORY);

	public CodeJamMainPanel() {

		super(new BorderLayout());

		fileChooser.setAcceptAllFileFilterUsed(true);
		fileChooser.setDialogType(JFileChooser.OPEN_DIALOG);
		fileChooser.setDialogTitle("Input File Selection");
		FileFilter fileFilter = new FileFilter() {
			@Override
			public boolean accept(File inFile) {
				return inFile.isFile() && inFile.getName().endsWith(".in");
			}

			@Override
			public String getDescription() {
				return "Google Code Jam - .in files";
			}
		};
		fileChooser.addChoosableFileFilter(fileFilter);

		mainArea.add(statusPanel, BorderLayout.NORTH);
		mainArea.add(fileChooser);
		add(mainArea);
	}

	@Override
	public void updateStatus(TaskStatus taskStatus) {
		statusPanel.updateStatus(taskStatus);
	}

	@Override
	public void log(int logLevel, String message) {
		statusPanel.log(logLevel, message);
	}

	public JFileChooser getFileChooser() {
		return fileChooser;
	}
}
