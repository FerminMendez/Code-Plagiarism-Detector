package codejam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public abstract class Task {
	
	private String inputFileName;
	private BufferedReader in;
	private PrintWriter out;

	public Task(String[] args) {
		inputFileName = args[0];
	}
	
	public void execute() throws IOException {
		File f = new File(inputFileName);   
        in = new BufferedReader(new FileReader(f));
        
		catchInputData();
		
		in.close();
		
		processInputData();
		
		f = new File(inputFileName.substring(0, inputFileName.length() - 2) + "out");
		f.createNewFile();
		out = new PrintWriter(new BufferedWriter(new FileWriter(f)));
		
		generateOutputFile();
		
		out.flush();
		out.close();
	}

	protected abstract void generateOutputFile() throws IOException;

	protected abstract void processInputData();

	protected abstract void catchInputData() throws IOException;

	protected String readLine() throws IOException {
		return in.readLine();
	}

	protected void writeLine(String line) throws IOException {
		out.println(line);
	}

}
