package de.at.codejam.util;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractCaseSolver<CASE> implements CaseSolver<CASE> {

	private final List<StatusListener> statusListenerList = new ArrayList<StatusListener>();

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

	protected final String getDefaultResultBegin(TaskStatus taskStatus) {
		return "Case #" + taskStatus.getNumberCurrentCase() + ":";
	}
}
