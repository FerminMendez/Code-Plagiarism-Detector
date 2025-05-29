package com.clausewitz.codejam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public abstract class Solver {
	protected BufferedReader fileIn = null;
	
	protected String outFilename = "output.out";
	protected int numOfTestCase = -1;
	
	protected String answer[] = null;

	public void openFile(String filename) {
		try {
			fileIn = new BufferedReader(new FileReader(filename));
			if(filename.substring(filename.length()-3,filename.length()).equals(".in"))
				outFilename = filename.substring(0, filename.length()-3) + ".out";
		} catch (IOException e) {
			System.out.println("Cannot open file: " + e.getMessage());
		}
	}
	
	public void closeFile() {
		try {
			if(fileIn!=null) fileIn.close();
		} catch (IOException e) {
			System.out.println("Cannot close file: " + e.getMessage());
		}
	}
	
	public void setOutFilename(String filename) {
		this.outFilename = filename;
	}
	
	public int readNumber(int defaultValue) {
		int result = defaultValue;
		try {
			result = Integer.parseInt(fileIn.readLine());
		} catch (Exception e) {
			System.out.println("Cannot read a number from file: " + e.getMessage());
		}
		return result;
	}
	
	public void prepareAnswers() {
		answer = new String[numOfTestCase];
	}
	
	public abstract void readProblem() throws IOException;
	public abstract void algorithm(int idx);
	
	public void printAnswer() {
		try {
			BufferedWriter fileOut = new BufferedWriter(new FileWriter(this.outFilename));
			for(int i=0;i<numOfTestCase;++i) {
				String output = "Case #" + (i+1) + ": " + answer[i] + "\n";
				System.out.print(output);
				fileOut.write(output);
			}
			fileOut.close();
		} catch (IOException e) {
			System.out.println("Exception to print answers: " + e.getMessage());
		}
	}
	
	public void solve(String filename) {
		openFile(filename);
		
		numOfTestCase = readNumber(-1);
		prepareAnswers();
		
		for(int i=0;i<numOfTestCase;++i) {
			try {
				readProblem();
				algorithm(i);
			} catch (IOException e) {
				System.out.println("Exception at reading problem #" + (i+1) + ": " + e.getMessage());
			}
		}
		printAnswer();
		
		closeFile();
	}
}
