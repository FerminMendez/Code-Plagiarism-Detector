package codejam.suraj.quals2012;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public abstract class CodeJamSkeleton {
	// To Read Input file
	private BufferedReader fileReader = null;
	private BufferedWriter fileWriter = null;
	private StringBuffer output = null;
	
	public CodeJamSkeleton()
	{
		this.output = new StringBuffer();
	}
	
	public CodeJamSkeleton(String inputFilename, String outputFilename) 
	throws IOException {
		super();
		try{
			fileReader = 
				new BufferedReader(new FileReader(inputFilename));
		}
		catch(IOException e)
		{
			System.err.println("Could not read from file.");
			e.printStackTrace();
			throw e;
		}
		try{
			fileWriter = new BufferedWriter(
					new FileWriter(outputFilename));
		}catch(IOException e)
		{
			System.err.println("Error opening output file.");
			System.err.println("Output = " + output.toString());
			throw e;
		}
		
		this.output = new StringBuffer();
	}

	
	/*
	 * This method return next non empty line until it encounters 
	 * the end of file
	 */
	protected String readLine() throws IOException
	{
		String line = null;
		do{
			line = fileReader.readLine();
			if(line != null)
			{
				if(line.trim().equals(""))
					continue;
				else
					return line;
			}
		}while(line != null);
		return line;
	}
	
	
	protected void addOutput(int testCaseNumber, String outputText)
	{
		output.append("Case #" + testCaseNumber + ": " + outputText + "\n"); 
	}
	
	protected void writeOutput() throws IOException
	{
		try{	
			System.out.println(output);
			fileWriter.write(output.toString());
			fileWriter.flush();
		}catch(IOException e)
		{
			System.err.println("Error writing in output file.");
			System.err.println("Output = " + output.toString());
			throw e;
		}
		
		try{	
			
			fileWriter.close();
		}catch(IOException e)
		{
			System.err.println("Error closing output file.");
			System.err.println("Output = " + output.toString());
			throw e;
			
		}
	}
	
	protected abstract void handleTestCase(int testCaseNumber) 
	throws IOException;
	
	protected void iterateTestCase() throws IOException
	{
		String currentLineRead = readLine();
		int numCases = Integer.parseInt(currentLineRead.trim());
		
		for(int i = 0; i < numCases; i++)
		{
			handleTestCase(i+1);
		}

	}
	
	public void handleAllTestCases(String inputFilename, String outputFilename)
	
	{
		try{
			fileReader = 
				new BufferedReader(new FileReader(inputFilename));
		}
		catch(IOException e)
		{
			System.err.println("Could not read from file.");
			e.printStackTrace();
			System.exit(1);
		}
		try{
			fileWriter = new BufferedWriter(
					new FileWriter(outputFilename));
		}catch(IOException e)
		{
			System.err.println("Error opening output file.");
			System.err.println("Output = " + output.toString());
			System.exit(1);
		}
		try{
			iterateTestCase();
			writeOutput();
		}
		catch(IOException e)
		{
			e.printStackTrace();
			System.exit(1);
		}
		
		
	}
	
	
	
}
