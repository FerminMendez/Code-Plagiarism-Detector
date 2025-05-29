package codejam.surprisingGooglers;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CaseReader {

	private final String filename;

	public CaseReader(String filename) {
		this.filename = filename;
	}

	public List<ProblemCase> getCases(){
		BufferedReader r = null;
		try {
			r = getReader();
			return readFile(r);
		} catch (FileNotFoundException e){
			throw new IllegalArgumentException("Unknown file: "+filename);
		} catch(Exception e){
			throw new FileFormatException("Could not read file", e);
		}
		finally {
			close(r);
		}
		
	}

	private BufferedReader getReader() throws FileNotFoundException {
		return new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
	}

	private List<ProblemCase> readFile(BufferedReader r) throws IOException {
		int numberOfCases = Integer.parseInt(r.readLine());
		List<ProblemCase> caseList = new ArrayList<ProblemCase>(numberOfCases);
		for (int i = 0; i < numberOfCases; i++) {
			caseList.add(parseLine(r.readLine()));
		}
		return caseList;
	}

	private ProblemCase parseLine(String readLine) {
		String[] splitted = readLine.split("\\s");
		Integer[] scores = new Integer[splitted.length-3];
		for (int i = 3; i < splitted.length; i++) {
			scores[i-3] = Integer.parseInt(splitted[i]);
		}
		return new ProblemCase(scores, Integer.parseInt(splitted[2]), Integer.parseInt(splitted[1]));
	}

	private static void close(Closeable r) {
		try {
			if (r!=null)
				r.close();
		} catch (IOException e) {
			// ignore error during closing
		}
	}
	
}
