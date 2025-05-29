import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


/**
 * 
 */

/**
 * @author Ambar May 1, 2010 1:46:25 AM
 */
public class Utility {

	static public String[] getContents(String aPath) {
		// ...checks on aFile are elided
		StringBuilder contents = new StringBuilder();

		// Create a File object from the path
		File aFile = new File(aPath);

		try {
			// use buffering, reading one line at a time
			// FileReader always assumes default encoding is OK!
			BufferedReader input = new BufferedReader(new FileReader(aFile));
			try {
				String line = null; // not declared within while loop
				/*
				 * readLine is a bit quirky : it returns the content of a line
				 * MINUS the newline. it returns null only for the END of the
				 * stream. it returns an empty String if two newlines appear in
				 * a row.
				 */
				while ((line = input.readLine()) != null) {
					contents.append(line);
					contents.append(System.getProperty("line.separator"));
				}
			} finally {
				input.close();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return contents.toString().split("\r\n");
	}

	public static int getNoOfTestCases(String aPath) {
		return Integer.parseInt(getContents(aPath)[0]);
	}



	public static void writeOutput(String aPathForInputFile) {
		String[] contents = getContents(aPathForInputFile);
		int N = getNoOfTestCases(aPathForInputFile);
		
		try {
			// Create file
			FileWriter fstream = new FileWriter("E:\\Temp\\output.txt");
			BufferedWriter out = new BufferedWriter(fstream);
			for (int i = 1; i <= N; i++) {
				String outputLine = "Case #"+i+": "+getReverseWords(contents[i]);
				out.write(outputLine);
				out.newLine();
				
			}
//			out.write("Hello Java");
			// Close the output stream
			out.close();
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
		
	}

	// public static String[] getProperOutput(String aPath){
	// Input[] inputs =getInputs(aPath);
	// String[] output = new String[inputs.length];
	// for (int i = 0; i < output.length; i++) {
	//			
	// }
	// }

	private static String getReverseWords(String sentence) {
		sentence = sentence.substring(0, sentence.length());
		String retVal = "";
		String word = "";
		for (int i = 0; i < sentence.length(); i++) {
			
			if (sentence.charAt(i) != ' ')
				word += sentence.charAt(i);
			else {//if(sentence.charAt(i) == ' ' || (sentence.charAt(i)=='\\' && sentence.charAt(i+1)=='n')){
				retVal = word+" "+retVal;
				word = "";
			}
		}
		return word+" "+retVal;
	}

}
