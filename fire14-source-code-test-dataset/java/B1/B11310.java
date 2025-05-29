/**
 * Copyright 2012 Christopher Schmitz. All Rights Reserved.
 */

package com.isotopeent.codejam.lib;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Utils {

	private static final String FILE_IN_EXTENSION = ".in";
	private static final String FILE_OUT_EXTENSION = ".out";
	private static final String OUT_DATE_FORMAT = "_yyyy-MM-dd_HH-mm-ss";

	public static <T> void solve(String filePath, String fileName, InputConverter<T> inputConverter, SolverBase<T> solver) {
		File folder = new File(filePath);
		File fin = getInputFile(folder, fileName);
		File fout = getOutputFile(folder, fileName);
		if (!fout.exists()) {
			try {
				fout.createNewFile();
			} catch (IOException e) {
				System.err.println("Error creating file " + fout.getAbsolutePath());
				e.printStackTrace();
			}
		}
		InputReader<T> reader = null;
		SolutionWriter writer = null;
		try {
			reader = new InputReader<T>(fin, inputConverter);
			solver.init(reader);
			writer = new SolutionWriter(fout);
	
			int caseNum = 1;
			String solution;
			long startTime = System.currentTimeMillis();
			while ((solution = solver.solveNext()) != null) {
				writer.writeSolution(caseNum++, solution);
				writer.flush();
			}
			int time = (int)(System.currentTimeMillis() - startTime);
			System.out.println("Done in " + (time / 1000) + " seconds (" + (time / (caseNum - 1)) + "ms average)");
		} catch (Exception e) {
			System.err.println("Error solving");
			e.printStackTrace();
		}
		if (reader != null) {
			try {
				reader.close();
			} catch (IOException e) {
				// do nothing
			}
		}
		if (writer != null) {
			writer.flush();
			writer.close();
		}
	}

	public static File getInputFile(File folder, String fileName) {
		return new File(folder, fileName + FILE_IN_EXTENSION);
	}

	public static File getOutputFile(File folder, String fileName) {
		DateFormat dateFormat = new SimpleDateFormat(OUT_DATE_FORMAT);
		String date = dateFormat.format(Calendar.getInstance().getTime());
		return new File(folder, fileName + date + FILE_OUT_EXTENSION);
	}

	public static String[] convertToStringArray(String line) {
		return line.split(" ");
	}

	public static int[] convertToIntArray(String line, int count) {
		int[] items = new int[count];
		int wordStart = 0;
		for (int i = 0; i < count; i++) {
			int wordEnd = line.indexOf(' ', wordStart);
			if (wordEnd < 0) {
				wordEnd = line.length();
			}
			int param = Integer.parseInt(line.substring(wordStart, wordEnd));
			items[i] = param;
			wordStart = wordEnd + 1;
		}
		return items;
	}

	public static int convertToIntArray(String line, int[] itemsOut) {
		int count = 0;
		int wordStart = 0;
		int length = line.length();
		while (wordStart < length) {
			int wordEnd = line.indexOf(' ', wordStart);
			if (wordEnd < 0) {
				wordEnd = line.length();
			}
			int param = Integer.parseInt(line.substring(wordStart, wordEnd));
			itemsOut[count++] = param;
			wordStart = wordEnd + 1;
		}
		return count;
	}

}
