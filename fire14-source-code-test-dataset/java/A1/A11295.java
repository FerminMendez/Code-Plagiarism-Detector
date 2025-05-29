package codejam;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

public class CodeJamRunner {

	private PrintWriter pw = null;

	/**
	 * Override this to do the real stuff.
	 * @param inputLine
	 */
	protected void process( int lineNr, String inputLine )
	{
		printlnOutput( "#" + lineNr + " " + inputLine );
	}
	
	protected void printlnOutput( String outputLine )
	{
		pw.println( outputLine );
	}
	
	public void run( String inFilePath, String outFilePath )
	{
		BufferedReader fr = null;
		try {
			fr = new BufferedReader( new FileReader( inFilePath ) );
			pw = new PrintWriter(new File( outFilePath ));
			String nextLine;
			int lineNr = 1;
			while ( (nextLine = fr.readLine()) != null) {
				process( lineNr, nextLine );
				lineNr++;
			}
			pw.flush();
		} catch (Throwable e) {
			e.printStackTrace();
		} finally
		{
			if ( pw != null )
			{
				try{
					pw.close();
				}
				catch ( Throwable pwT ) {
					pwT.printStackTrace();
				}
			}
			if ( fr != null )
			{
				try
				{
					fr.close();
				}
				catch ( Throwable frT ) {
					frT.printStackTrace();
				}
			}
		}
	}
	
	public void run( String[] args ){
		String inFilePath;
		String outFilePath;
		if (args.length < 2) {
			System.out.println("Usage : java codejam.CodeJamRunner [inputFilePath] [OutputFilePath]");
			System.out.println("using defaults");
			inFilePath = "input/input.txt";
			outFilePath = "output/output.txt";
		} else {
			inFilePath = args[0];
			outFilePath = args[1];
		}
		run( inFilePath, outFilePath);
	}
	
	public static void main(String[] args) {
		CodeJamRunner runner = new CodeJamRunner();
		runner.run(args);
	}
}
