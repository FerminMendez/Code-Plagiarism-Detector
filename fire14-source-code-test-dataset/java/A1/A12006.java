package com.utility;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterUtility {

	public static File getFile(String outputFileLoc) {
		File outputFile = null;
		if (outputFileLoc != null)  {
			outputFile = new File(outputFileLoc);
			if (!outputFile.exists()) {
				try {
					outputFile.createNewFile();
				} catch (IOException e) {
					System.out.println("Error :" + e.getMessage());
				}
			}
		}
		return outputFile;
	}
	
	public static File getNewFile(String outputFileLoc) {
		File outputFile = null;
		if (outputFileLoc != null)  {
			outputFile = new File(outputFileLoc);
			if (!outputFile.exists()) {
				try {
					outputFile.delete();
					outputFile.createNewFile();
				} catch (IOException e) {
					System.out.println("Error :" + e.getMessage());
				}
			}
		}
		return outputFile;
	}

	public static BufferedWriter getBufferedWriter(File outputFile) {
		BufferedWriter bufferedWriter = null;
		if (outputFile != null) {
			FileWriter fileWriter;
			try {
				fileWriter = new FileWriter(outputFile);
				bufferedWriter = new BufferedWriter(fileWriter);
			} catch (IOException e) {
				System.out.println("Error :" + e.getMessage());
			}
		}
		return bufferedWriter;
	}
	
	public static BufferedWriter getBufferedWriter(String fileName) {
		BufferedWriter bufferedWriter = null;
		if (fileName != null) {
			File file = new File(fileName);
			bufferedWriter = getBufferedWriter(file);
		}
		return bufferedWriter;
	}

	public static void write(BufferedWriter bufferedWriter, String outputString) {
		if (bufferedWriter != null && outputString != null) {
			try {
				bufferedWriter.write(outputString);
			} catch (IOException e) {
				System.out.println("Error :" + e.getMessage());
			}
		}
	}
	
	public static void writeNewLine(BufferedWriter bufferedWriter) {
		if (bufferedWriter != null) {
			try {
				bufferedWriter.write("\n");
			} catch (IOException e) {
				System.out.println("Error :" + e.getMessage());
			}
		}
	}

	public static void closeBufferedWriter(BufferedWriter bufferedWriter) {
		if (bufferedWriter != null) {
			try {
				bufferedWriter.close();
			} catch (IOException e) {
				System.out.println("Error :" + e.getMessage());
			}
		}
	}

}
