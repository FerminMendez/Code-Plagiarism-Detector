package de.at.codejam.util;

import java.awt.Color;
import java.awt.Dimension;
import java.io.File;

public interface CodeJamConstants {

	// CODES
	public static final int UNDEFINED = -1;

	// SIZES
	public static final Dimension DEFAULT_WINDOW_SIZE = new Dimension(1024, 720);
	public static final Dimension DEFAULT_STATUSPANEL_SIZE = new Dimension(
			1024, 320);

	// FILES AND DIRECTORIES
	public static final File DEFAULT_CODE_JAM_DIRECTORY = new File(
			Settings.get("default.dir"));

	// COLORS
	public static final Color COLOR_WAITING = Color.WHITE;
	public static final Color COLOR_RUNNING = new Color(0.5f, 0.5f, 0.3f);
	public static final Color COLOR_DONE = new Color(0.2f, 0.5f, 0.3f);
	public static final Color COLOR_ERROR = new Color(0.5f, 0.2f, 0.3f);
}
