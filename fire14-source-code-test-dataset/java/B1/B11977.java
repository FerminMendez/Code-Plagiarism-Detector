/**
 * @author Saifuddin Merchant 
 * 
 */
package com.sam.googlecodejam.helper;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class InputReader {

	BufferedReader iFileBuffer;
	long iCurrentLineNumber;

	public InputReader(String pFileName) {
		try {
			iFileBuffer = new BufferedReader(new FileReader(pFileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		iCurrentLineNumber = 0;
	}

	public String readNextLine() {
		try {
			return iFileBuffer.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void close() 
	{
		try {
			iFileBuffer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
