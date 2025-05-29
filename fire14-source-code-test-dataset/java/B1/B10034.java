package com.google.cj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class IOHandler {
	private static Logger logger = Logger.getLogger(IOHandler.class);

	public static List<String> readInput(String fileName) {
		List<String> fileContents = new ArrayList<String>();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(fileName));
			String line = null;

			while ((line = reader.readLine()) != null) {
				fileContents.add(line);
			}

		} catch (IOException e) {
			logger.error(e);
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				logger.error(e);
			}
		}
		Integer noTestCases = Integer.valueOf(fileContents.remove(0));
		System.out.println("No. of test cases [" + noTestCases + "]");

		return fileContents;
	}

	public static void writeOutput(List<String> outputList, String fileName) {
		List<String> finalList = new ArrayList<String>();
		int i = 1;
		for (String output : outputList) {
			finalList.add("Case #" + i + ": " + output);
			i++;
		}

		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new FileWriter(fileName));
			for (String line : finalList) {
				out.write(line);
				out.newLine();
			}
		} catch (IOException e) {
			logger.error(e);
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				logger.error(e);
			}
		}
	}
}
