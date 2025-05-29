package de.hg.codejam.tasks.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public abstract class Writer {

	public static String generateOutputPath(String inputPath) {
		return inputPath.substring(0, inputPath.lastIndexOf('.') + 1) + "out";
	}

	public static void print(String[] output) {
		for (String s : output)
			System.out.println(s);
	}

	public static void write(String[] output) {
		for (int i = 0; i < output.length; i++)
			System.out.println(getCase(i + 1, output[i]));
	}

	public static void write(String[] output, String path) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(path,
				false))) {
			for (int i = 0; i < output.length; i++) {
				writer.append(getCase(i + 1, output[i]));
				writer.newLine();
				writer.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static String getCase(int number, String caseString) {
		return "Case #" + (number) + ": " + caseString;
	}

}
