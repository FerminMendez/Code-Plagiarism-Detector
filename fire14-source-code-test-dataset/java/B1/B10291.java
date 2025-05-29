package com.gcj.parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Parser {

	private String inputFileDest;
	private FileInputStream fileInputStream;

	public Parser(String inputFileDest) {
		super();
		this.inputFileDest = inputFileDest;
		try {
			fileInputStream = new FileInputStream(new File(inputFileDest));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public String getInputFileDest() {
		return inputFileDest;
	}

	public void setInputFileDest(String inputFileDest) {
		this.inputFileDest = inputFileDest;
	}

	public FileInputStream getFileInputStream() {
		return fileInputStream;
	}

	public void setFileInputStream(FileInputStream fileInputStream) {
		this.fileInputStream = fileInputStream;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Integer>[] toArray(){
		
		Scanner scan = new Scanner(getFileInputStream());
		
		// The first line must be an number
		Integer nbOfLines = new Integer(scan.nextLine());
		
		ArrayList<Integer>[] parsedData = new ArrayList[nbOfLines];
		int index = 0;
		
		while (scan.hasNextLine()){
			
			String line = scan.nextLine();
			String[] datas = line.split(" ");
			
			ArrayList<Integer> dataRow = new ArrayList<Integer>();
			
			for (String data : datas){
				dataRow.add(new Integer(data));
			}
			
			parsedData[index] = dataRow;
			index++;
		}
		
		return parsedData;
		
	}
	
	
}
