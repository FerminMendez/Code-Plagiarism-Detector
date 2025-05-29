package de.at.codejam.util;

public interface StatusListener {

	public static final int LOGLEVEL_TRACE = 4;
	public static final int LOGLEVEL_INFO = 3;
	public static final int LOGLEVEL_WARN = 2;
	public static final int LOGLEVEL_ERROR = 1;

	void updateStatus(TaskStatus taskStatus);

	void log(int logLevel, String message);
}
