package com.google.jam.eaque.stub;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class InputFileManager {

	private BufferedReader br;

	public InputFileManager(String filePath) throws NumberFormatException,
			IOException {
		br = new BufferedReader(new FileReader(filePath));
	}

	public void close() throws IOException {
		br.close();
	}

	public String readLine() throws IOException {
		return br.readLine();
	}

	public long readLong() throws NumberFormatException, IOException {
		return Long.parseLong(br.readLine());
	}

	public String[] readAndSplit() throws IOException {
		return br.readLine().split(" ");
	}
}
