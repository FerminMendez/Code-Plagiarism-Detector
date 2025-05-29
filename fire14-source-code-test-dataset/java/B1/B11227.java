package codezam.util;

import java.io.File;
import java.io.FileReader;
import java.io.LineNumberReader;

public class InputFile {

	private File file;
	FileReader freader;
	LineNumberReader lnreader;
	
	public void setFile(String filename) {
		
		try {
			file = new File(filename);
			freader = new FileReader(file);
			lnreader = new LineNumberReader(freader);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String readLine() {
		String line = null;
		
		try {
			line = lnreader.readLine();
			//System.out.println("Line:  " + lnreader.getLineNumber() + ": " + line);

			if (line==null) {
				close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return line;
	}

	private void close() {
		try {
			freader.close();
			lnreader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
