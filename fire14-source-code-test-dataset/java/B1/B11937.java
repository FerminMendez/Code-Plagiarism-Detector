package com.google.codejam.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CodeJamInputFile extends File {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8294095294390757204L;
	private BufferedReader reader;
	private int cases;
	
	public CodeJamInputFile(String pathname) {
		super(pathname);
		
		try {
			this.setReader();
		} catch (FileNotFoundException e) {
		}
		try {
			this.setCases(Integer.valueOf(this.getReader().readLine()));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void setReader() throws FileNotFoundException {
		reader = new BufferedReader(new FileReader(this));
		
	}

	public BufferedReader getReader() {
		return reader;
	}

	public void setCases(int cases) {
		this.cases = cases;
	}

	public int getCases() {
		return cases;
	}
	
	public void close() {
		try {
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getLine() {
		String line = "";
		try {
			line = reader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return line;
	}

}
