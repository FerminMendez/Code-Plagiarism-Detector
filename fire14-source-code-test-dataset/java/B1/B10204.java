import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class JamInputReader {
	int		numItem;
	String	thisLine = null;
	BufferedReader	in;
	StringTokenizer	tokenizer;
	
	public JamInputReader(String fileName) {
		try {
			in = new BufferedReader(new FileReader(fileName));
/*			String text = in.readLine();
			numItem = Integer.parseInt(text);*/
			
			readNextLine();
			tokenizer = new StringTokenizer(thisLine, " ");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
	}
	
	void readNextLine() {
		try {
			thisLine = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	int getNumItems() {
		numItem = Integer.parseInt(tokenizer.nextToken());
		return numItem;
	}
	
	String getNextItem() {
		if(false == tokenizer.hasMoreTokens()) {
			readNextLine();
			tokenizer = new StringTokenizer(thisLine, " ");
		}
		return tokenizer.nextToken();
	}

	String getNextLine() {
		readNextLine();
		return thisLine;
	}
	
	int getNextInt() {
		return Integer.parseInt(getNextItem());
	}
	
	long getNextLong() {
		return Long.parseLong(getNextItem());
	}
	
	byte[] getNextLineByte() {
		readNextLine();
		return thisLine.getBytes(); 
	}
}
