package mgg.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author manolo
 * @date 13/04/12
 */
public class FileUtil {

	FileReader reader;
	FileWriter writer;
	
	public FileUtil(String input, String output) {
		try {
			reader = new FileReader(input);
			writer = new FileWriter(output);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
	public String getLine(){
		try {
			
			StringBuilder builder = new StringBuilder();
			char c = (char) reader.read();
			while (c != '\n') {
				builder.append(c);
				//System.out.println("\t\t\t> char: '" + c + "'");
				c = (char) reader.read();
			} ;
			
			System.out.println("\t\t\t----------> line: '" + builder.toString() + "'");
			
			return builder.toString();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void printLine(int lineNumber, String line){
		try {
			writer.write("Case #" + lineNumber + ": " + line + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void closeFiles(){
		try {
			reader.close();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
		
}
