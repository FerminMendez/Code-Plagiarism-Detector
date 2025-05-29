package de.at.codejam.util;

public class TaskStatus implements CodeJamConstants {

	public static final int STATUS_WAITING = 0;
	public static final int STATUS_RUNNING = 1;
	public static final int STATUS_DONE = 2;
	public static final int STATUS_ERROR = 3;

	private int currentTaskStatus = STATUS_WAITING;

	private int numberCases = UNDEFINED;

	private int numberCurrentCase = UNDEFINED;

	public int getCurrentTaskStatus() {
		return currentTaskStatus;
	}

	public void setCurrentTaskStatus(int currentTaskStatus) {
		this.currentTaskStatus = currentTaskStatus;
	}

	public int getNumberCases() {
		return numberCases;
	}

	public void setNumberCases(int numberCases) {
		this.numberCases = numberCases;
	}

	public int getNumberCurrentCase() {
		return numberCurrentCase;
	}

	public void setNumberCurrentCase(int numberCurrentCase) {
		this.numberCurrentCase = numberCurrentCase;
	}

	@Override
	public String toString() {
		return "TaskStatus [currentTaskStatus=" + currentTaskStatus
				+ ", numberCases=" + numberCases + ", numberCurrentCase="
				+ numberCurrentCase + "]";
	}
}
