package com.first;

import java.io.*;
import java.util.ArrayList;

public class ReadWriteFileForCodeJam {

	String fileRead;
	String fileWrite;
	String fileContentToWrite;
	String fileSeparatorForWrite, fileSeparatorForRead;
	boolean firstTimeRead;
	int readCursor;
	ArrayList<String> fileContentAsArrayList;

	public ReadWriteFileForCodeJam(){
		fileContentToWrite = new String();
		fileRead = new String();
		fileWrite = new String();
		fileSeparatorForWrite = new String();
		fileSeparatorForRead = new String();
		firstTimeRead = true;
		fileContentAsArrayList = new ArrayList<String>();
	}

	public void setFileNameForRead(String fileName){
		fileRead = fileName;
	}

	public void setFileNameForWrite(String fileName){
		fileWrite = fileName;
	}

	public void setFileSeperatorForWrite(String separator){
		fileSeparatorForWrite = separator;
	}

	public void setFileContentToWrite(String content, boolean append, boolean newLine){

		String separator = new String();

		if (append){
			if (newLine){
				separator = System.getProperty("line.separator");
			}
			else{
				separator = fileSeparatorForWrite;
			}
		}

		if (fileContentToWrite != null && fileContentToWrite.length() == 0)
			fileContentToWrite = content;
		else
			fileContentToWrite = fileContentToWrite + separator + content;
	}

	public String ReadFile(boolean returnContent) {

		StringBuilder content = new StringBuilder();

		File aFile = new File(fileRead);

		if (firstTimeRead){
			firstTimeRead = false;
			try {
				BufferedReader input = new BufferedReader(new FileReader(aFile));
				try {
					String line = null;
					while ((line = input.readLine()) != null) {
						content.append(line);
						fileContentAsArrayList.add(line);
						content.append(System.getProperty("line.separator"));
					}
				} finally {
					input.close();
				}
			} catch (IOException io) {
				return (io.toString());
			}
			if (returnContent)
				return content.toString();
		}
		return null;
	}

	public String GetSingleLineFromFile(int lineNumber){
		try{
			return fileContentAsArrayList.get(lineNumber - 1).toString();
		}catch (IndexOutOfBoundsException e){
			return null;
		}
	}

	public int getNoOfLinesInFile(){
		return fileContentAsArrayList.size();
	}

	public boolean WriteFile(boolean appendLine) {
		File aFile = new File(fileWrite);
		Boolean writeSuccess = true;
		try {
			Writer output = new BufferedWriter(new FileWriter(aFile));
			try {
				output.write(fileContentToWrite);
			} finally {
				output.close();
			}
		} catch (IOException io) {
			writeSuccess = false;
		}
		return writeSuccess;
	}
}
