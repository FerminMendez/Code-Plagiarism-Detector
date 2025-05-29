package com.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class FileReader {

	/*
	 * Reads data from a given file
	 */
	public static String readFromFile(String fileName) {
		String DataLine = "";
		try {
			File inFile = new File(fileName);
			BufferedReader br = new BufferedReader(new InputStreamReader(
					new FileInputStream(inFile)));
			DataLine = br.readLine();
			br.close();
		} catch (FileNotFoundException ex) {
			System.out.println("File Not Found");
			return (null);
		} catch (IOException ex) {
			System.out.println(" IO Exception");
			return (null);
		}
		return (DataLine);

	}
	
	/*
	 * Reads data from a given file
	 */
	public static String readOneInputFromFile(
			BufferedReader bufferedReader,
			int numberOfLines) {
		String dataOfLine = "";
		String singleInput = null;
		StringBuffer stringBuffer = new StringBuffer();
		try {
			for (int i = 0; i < (numberOfLines - 1); i++) {
				dataOfLine = bufferedReader.readLine();
				if (dataOfLine != null) {
					stringBuffer.append(dataOfLine);
				}
			}
		} catch (IOException ex) {
			System.out.println(" IO Exception");
			return (null);
		}
		
		if (stringBuffer != null && stringBuffer.equals("")) {
			singleInput = stringBuffer.toString();
		}
		return (singleInput);

	}
	
	
	/*
	 * Reads data from a given file
	 */
	public static BufferedReader getBufferedReader(String fileName) {
		BufferedReader br = null;
		try {
			File inFile = new File(fileName);
			br = new BufferedReader(new InputStreamReader(
					new FileInputStream(inFile)));
		} catch (FileNotFoundException ex) {
			System.out.println("File Not Found");
			return (null);
		} catch (IOException ex) {
			System.out.println(" IO Exception");
			return (null);
		}
		return (br);

	}
	
	/*
	 * Reads data from a given file
	 */
	public static String readOneLine(BufferedReader bufferedReader) {
		String DataLine = "";
		try {
			DataLine = bufferedReader.readLine();
		} catch (IOException ex) {
			System.out.println(" IO Exception");
			return (null);
		}
		return (DataLine);

	}
	
	/*
	 * Reads data from a given file
	 */
	public static String[] getSingleInputAsStrArray(
			BufferedReader bufferedReader,
			int numberOfLines) {
		String dataOfLine = "";
		String[] inputStringArray = null;
		if (bufferedReader != null && numberOfLines > 0) {
			try {
				inputStringArray = new String[numberOfLines];
				for (int i = 0; i < (numberOfLines); i++) {
					dataOfLine = bufferedReader.readLine();
					if (dataOfLine != null) {
						inputStringArray[i] = dataOfLine;
					}
				}
			} catch (IOException ex) {
				System.out.println(" IO Exception");
				return (null);
			}
		}

		return (inputStringArray);
	}
	
	public static String[] extractInputSizeAndConstant(
			BufferedReader bufferedReader) {
		String[] strings = null;
		if (bufferedReader != null) {
			
			String tempString = FileReader.readOneLine(bufferedReader);
			if (tempString != null) {
				strings = tempString.split(Constants.SPACE_REG_EXP.getConstant());
			}
		}
		return strings;
	}

	public static void closeBufferedReader(BufferedReader bufferedReader) {
		if (bufferedReader != null) {
			try {
				bufferedReader.close();
			} catch (IOException e) {
				System.out.println(" IO Exception");
			}
		}
	}
	
	
	
}
