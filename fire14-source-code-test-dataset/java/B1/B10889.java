package de.at.codejam.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import de.at.codejam.util.CodeJamConstants;
import de.at.codejam.util.StatusListener;
import de.at.codejam.util.TaskStatus;

public class CodeJamStatusPanel extends JPanel implements CodeJamConstants,
		StatusListener {

	private static final long serialVersionUID = -4645339049484500917L;

	private int currentLogLevelTreshold = StatusListener.LOGLEVEL_INFO;

	private JPanel statusIconPanel = new JPanel() {

		private static final long serialVersionUID = -1109894604603210990L;

		public Insets getInsets() {
			return new Insets(10, 10, 10, 10);
		}
	};

	private JTextArea consoleArea = new JTextArea();

	private JProgressBar progressBar = new JProgressBar();

	public CodeJamStatusPanel() {

		super(new BorderLayout());

		setPreferredSize(DEFAULT_STATUSPANEL_SIZE);

		statusIconPanel.setBackground(Color.WHITE);
		statusIconPanel.setBorder(BorderFactory.createRaisedBevelBorder());
		statusIconPanel.setPreferredSize(new Dimension(128, 128));
		statusIconPanel.setSize(128, 128);
		add(statusIconPanel, BorderLayout.WEST);

		consoleArea.setText("All console input goes here ..." + '\n');

		JPanel consolePanel = new JPanel();
		consolePanel.setLayout(new BorderLayout());
		consolePanel.add(new JScrollPane(consoleArea), BorderLayout.CENTER);

		JPanel loglevelPanel = new JPanel(new BorderLayout());

		loglevelPanel.setBorder(BorderFactory.createTitledBorder("LogLevel"));

		JRadioButton loglevelButtonTrace = new JRadioButton("Trace");
		loglevelButtonTrace.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				CodeJamStatusPanel.this.currentLogLevelTreshold = StatusListener.LOGLEVEL_TRACE;
			}
		});
		JRadioButton loglevelButtonInfo = new JRadioButton("Info");
		loglevelButtonInfo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				CodeJamStatusPanel.this.currentLogLevelTreshold = StatusListener.LOGLEVEL_INFO;
			}
		});
		JRadioButton loglevelButtonWarning = new JRadioButton("Warning");
		loglevelButtonWarning.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				CodeJamStatusPanel.this.currentLogLevelTreshold = StatusListener.LOGLEVEL_WARN;
			}
		});
		JRadioButton loglevelButtonError = new JRadioButton("Error");
		loglevelButtonError.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				CodeJamStatusPanel.this.currentLogLevelTreshold = StatusListener.LOGLEVEL_ERROR;
			}
		});

		if (StatusListener.LOGLEVEL_TRACE == currentLogLevelTreshold) {
			loglevelButtonTrace.setSelected(true);
		} else if (StatusListener.LOGLEVEL_INFO == currentLogLevelTreshold) {
			loglevelButtonInfo.setSelected(true);
		} else if (StatusListener.LOGLEVEL_WARN == currentLogLevelTreshold) {
			loglevelButtonWarning.setSelected(true);
		} else if (StatusListener.LOGLEVEL_ERROR == currentLogLevelTreshold) {
			loglevelButtonError.setSelected(true);
		}

		ButtonGroup loglevelGroup = new ButtonGroup();
		loglevelGroup.add(loglevelButtonTrace);
		loglevelGroup.add(loglevelButtonInfo);
		loglevelGroup.add(loglevelButtonWarning);
		loglevelGroup.add(loglevelButtonError);

		JPanel levelGrid = new JPanel(new GridLayout(1, 4));
		levelGrid.add(loglevelButtonTrace);
		levelGrid.add(loglevelButtonInfo);
		levelGrid.add(loglevelButtonWarning);
		levelGrid.add(loglevelButtonError);
		loglevelPanel.add(levelGrid);
		consolePanel.add(loglevelPanel, BorderLayout.NORTH);

		JPanel progressPanel = new JPanel(new BorderLayout());
		progressPanel.setBorder(BorderFactory.createTitledBorder("Progress"));
		progressPanel.add(progressBar, BorderLayout.CENTER);
		consolePanel.add(progressPanel, BorderLayout.SOUTH);

		add(consolePanel, BorderLayout.CENTER);
	}

	@Override
	public Insets getInsets() {
		return new Insets(10, 10, 10, 10);
	}

	@Override
	public void updateStatus(TaskStatus taskStatus) {

		progressBar.setStringPainted(true);

		boolean indeterminate = (UNDEFINED == taskStatus.getNumberCases())
				|| (UNDEFINED == taskStatus.getNumberCurrentCase());

		if (!indeterminate) {

			progressBar.setMaximum(taskStatus.getNumberCases());
			progressBar.setMinimum(1);
			progressBar.setValue(taskStatus.getNumberCurrentCase());
		}
		progressBar.setIndeterminate(indeterminate);

		if (TaskStatus.STATUS_WAITING == taskStatus.getCurrentTaskStatus()) {
			progressBar.setString("Waiting");
			statusIconPanel.setBackground(COLOR_WAITING);
		} else if (TaskStatus.STATUS_RUNNING == taskStatus
				.getCurrentTaskStatus()) {
			progressBar.setString("Running");
			statusIconPanel.setBackground(COLOR_RUNNING);
		} else if (TaskStatus.STATUS_DONE == taskStatus.getCurrentTaskStatus()) {
			progressBar.setString("Done");
			statusIconPanel.setBackground(COLOR_DONE);
		} else if (TaskStatus.STATUS_ERROR == taskStatus.getCurrentTaskStatus()) {
			progressBar.setString("Sad Panda");
			statusIconPanel.setBackground(COLOR_ERROR);
		}
	}

	@Override
	public void log(int logLevel, String message) {

		if (logLevel > currentLogLevelTreshold) {
			return;
		}

		StringBuilder newConsoleText = new StringBuilder(consoleArea.getText());
		newConsoleText.append("\n");
		newConsoleText.append(message);

		consoleArea.setText(newConsoleText.toString());
	}
}
