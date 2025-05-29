package com.renoux.gael.codejam.utils;

import java.util.Date;

public class Timer {

	private static long timestamp;

	public static void start() {
		timestamp = new Date().getTime();
	}

	public static String check() {
		long delay = (new Date().getTime() - timestamp);

		long seconds = delay / 1000;
		long millis = delay - 1000 * seconds;

		long minutes = seconds / 60;
		seconds = seconds % 60;

		return new StringBuilder().append(minutes).append(" min ")
				.append(seconds).append(" s ").append(millis).append(" ms ")
				.toString();
	}
}
