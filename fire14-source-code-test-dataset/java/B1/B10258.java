package com.numbers.recycle.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

public class FileOutputWriter {
	
	private FileWriter writer;
	private BufferedWriter bWriter;
	
	public void writeToFile(List<String> outputFileContents) {
		File file = new File("C:/Documents and Settings/Administrator/My Documents/Code Jam/output.out");
		try{
		writer = new FileWriter(file);
		bWriter = new BufferedWriter(writer);
		for(String line: outputFileContents){
		bWriter.write(line);
		bWriter.newLine();
		}
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(writer, bWriter);
		}
	}
	
	private void close(FileWriter writer, BufferedWriter bWriter) {
		try{
		bWriter.close();
		writer.close();
		}
		catch(Exception e){
		}
	}
}
