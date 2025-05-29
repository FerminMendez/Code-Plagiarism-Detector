package hk.polyu.cslhu.codejam.lib;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class FileStream {
	public static Logger logger = Logger.getLogger(FileStream.class);
	
	/**
	 * Read the content of file with the given file path
	 * 
	 * @param filePath String The location of file
	 * @return The content of file as an instance of list
	 */
	public static List<String> read(String filePath) {
		List<String> content = new ArrayList<String>();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			String line;
			
			while ((line = br.readLine()) != null) {
				content.add(line);
			}
			
			br.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			logger.error("File is not found with the path \"" + filePath + "\"");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
		}
		
		return content;
	}
	
	/**
	 * Save the content to a file
	 * 
	 * @param filePath String The location of file to be saved
	 * @param content String The content to be saved
	 */
	public static void save(String filePath, String content) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
			bw.write(content);
			bw.flush();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
		}
	}
}
