import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class CodeJamTextInputReader {
	private final BufferedReader reader;
	private final int numberOfTestCases;
	private int lastReadTestCase = 0;
	
	public CodeJamTextInputReader(File inputFile) throws IOException, InvalidInputException {
		reader = new BufferedReader(new FileReader(inputFile));
		
		numberOfTestCases = readInNumberOfTestCases();
	}
	
	private int readInNumberOfTestCases() throws IOException, InvalidInputException {
		String firstLine = reader.readLine();
		try {
			return Integer.parseInt(firstLine);
		}
		catch (NumberFormatException e) {
			throw new InvalidInputException("Expected first line to be number of test cases", e);
		}
	}

	public boolean hasNextTestCase() {
		return numberOfTestCases != lastReadTestCase;
	}
	
	public String readNextLine() throws IOException {
		++lastReadTestCase;
		
		return reader.readLine();
	}
	
	public int getLastReadTestCaseNumber() {
		return lastReadTestCase;
	}
	
	public void close() throws IOException {
		this.reader.close();
	}
}
