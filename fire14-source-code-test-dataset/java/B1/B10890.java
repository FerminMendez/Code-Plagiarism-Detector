package de.at.codejam.gui;

import javax.swing.JFrame;

import de.at.codejam.util.CodeJamConstants;

public class CodeJamWindow extends JFrame implements CodeJamConstants {

	private static final long serialVersionUID = 3904464282318628286L;

	private static final String titleBase = "Google Code Jam - Client";

	public CodeJamWindow() {
		super(titleBase);
		super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setPreferredSize(DEFAULT_WINDOW_SIZE);
		setSize(DEFAULT_WINDOW_SIZE);
	}

	public void setAssignmentName(String assignmentName) {
		setTitle(titleBase + " (" + assignmentName + ")");
	}
}
