/**
 * Google CodeJam 2012
 * General framework that takes care of the similar and repetitive tasks for all the problems.
 * E.g. managing case input and output.
 * 
 * By Üllar Soon <positivew@gmail.com>
 */
package eu.positivew.codejam.framework;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


/**
 * CodeJam IO class. Handles some of the test case file IO. Makes my life a bit easier.
 * 
 * @author Üllar Soon <positivew@gmail.com>
 */
public class CodeJamIO {
	
	private BufferedReader inStream;
	private BufferedWriter outStream;
	
	private int testCases = 0;
	private int caseNr = 1;
	
	/**
	 * Opens an input file. Also reads the first line (test case count) and stores its value in testCases.
	 * 
	 * @param inFile	File to open for input
	 * @return			TRUE if the file was opened successfully
	 */
	public boolean inputOpen(File inFile) {
		try {
			inStream = new BufferedReader(new FileReader(inFile));
			if(inStream != null) {
				try {
					testCases = Integer.parseInt(inStream.readLine());
				}
				catch(NumberFormatException ex) {
					System.err.println("Failed to retrieve the number of test cases!");
					return false;
				}
			}
			else
				System.err.println("Failed to open input file!");
			return true;
		}
		catch(IOException ex) {
			System.err.println("Failed to open input file!");
			return false;
		}
	}
	
	/**
	 * Uses the provided parser to read and encapsulate the next available test case from the file opened with inputOpen().
	 * 
	 * @param parser 	CodeJamInput parser that handles retrieving test cases
	 * @return 			A test case object
	 */
	public CodeJamInputCase inputReadCase(CodeJamInputParser parser) {
		return parser.readCase(inStream);
	}
	
	/**
	 * Closes the input file opened with inputOpen().
	 */
	public void inputClose() {
		try {
			inStream.close();
		}
		catch(IOException ex) {
			System.err.println("Failed to close input file!");
		}
	}
	
	/**
	 * Opens a new output file.
	 * 
	 * @param outFile	File to open for output
	 * @return			TRUE if file was opened successfully
	 */
	public boolean outputOpen(File outFile) {
		try {
			outStream = new BufferedWriter(new FileWriter(outFile));
			return true;
		}
		catch(IOException ex) {
			System.err.println("Failed to open output file!");
			return false;
		}
	}
	
	/**
	 * Writes a case result to the output file opened with ouputOpen().
	 * 
	 * @param			caseResult A case result to write to the output file
	 */
	public void outputWriteCase(String caseResult) {
		if(outStream != null) {
			try {
				outStream.write("Case #" + caseNr + ": " + caseResult);
				outStream.newLine();
				caseNr++;
			}
			catch(IOException ex) {
				System.err.println("Failed to write case #" + caseNr + " to output file!");
			}
		}
	}
	
	/**
	 * Closes the output file opened with outputOpen().
	 */
	public void outputClose() {
		try {
			outStream.close();
		}
		catch(IOException ex) {
			System.err.println("Failed to close input file!");
		}
	}
	
	/**
	 * Gets the number of test cases.
	 * 
	 * @return			Number of test cases
	 */
	public int getTestCases() {
		return testCases;
	}

}
