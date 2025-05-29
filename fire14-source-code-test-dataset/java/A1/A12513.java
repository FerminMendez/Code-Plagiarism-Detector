/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dancingwithgoogler;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author WC
 */
public class CodeJamFileManager {
	private final static String problemIntro = "Problem reading file: ";
	private final static String location = "C:\\CodeJamTests\\";
	
	public static String getStringOfFile(String filename) {
		String filepath = location + filename;
		byte[] buffer = new byte[(int) new File(filepath).length()];
    BufferedInputStream stream = null;
    try {
        stream = new BufferedInputStream(new FileInputStream(filepath));
        stream.read(buffer);
    }
		catch (Exception ex) { 
			return problemIntro + ex.getMessage();
		}
		finally {
			if (stream != null) {
				try { 
					stream.close(); 
				}
				catch (IOException ex) {
					return problemIntro + ex.getMessage(); 
				}
			}
    }
    return new String(buffer);
	}
	
	public static int getIntFromFirstLineOfFile(String filename, String separator) {
		String[] lines = getTextLinesOfFile(filename, separator);
		int i = 1;
		return extractInt(lines[0]);
	}
	
	public static String[] getTextLinesOfFile(String filename, String separator) {
		String fileStr = getStringOfFile(filename);
		return fileStr.split(separator);
	}
	
	public static void saveOutputFile(String output, String filename, String separator) {
		String filepath = location + filename;
		try {
			File outFile = new File(filepath);
			FileWriter writer = new FileWriter(outFile);
			BufferedWriter bWriter = new BufferedWriter(writer);
			bWriter.write(output);
			bWriter.close();
		}
		catch (Exception ex) {
			System.out.println("Failed to save file with error: " + ex.getMessage());
		}
	}
	
		
	private static int extractInt(String line) {
		Matcher intMatcher = Pattern.compile("[0-9]*").matcher(line);
		int i = 0;
		if (intMatcher.find()) {
			String numStr = intMatcher.group(0);
			i = Integer.parseInt(numStr);
		}
		return i;
	}
}
