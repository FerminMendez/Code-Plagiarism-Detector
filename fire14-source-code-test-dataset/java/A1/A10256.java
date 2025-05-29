import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;




public class Dancers {
	
	@SuppressWarnings("deprecation")
	private static void solveProblem() {
		// Stream to read file
		FileInputStream fin;
		// Stream to write file
		FileOutputStream fout;
	
		try
		{
		    // Open an input stream
		    // fin = new FileInputStream ("B-large.in");
			fin = new FileInputStream ("input.txt");
		    // Open an output stream
		    fout = new FileOutputStream ("output.txt");
		    // reader
		    DataInputStream reader = new DataInputStream(fin);
		    // writer
		    PrintStream writer = new PrintStream(fout);
		    
		    int numCases = Integer.parseInt(reader.readLine());
		    
		    String line = "";
		    for (int i = 1; i <= numCases; i++) 
		    {		    	
		    	line = "Case #" + i + ": " + solveCase(reader);
		    	writer.println(line);
		    	System.out.println(line);
			}		    
	
		    // Close our input stream
		    fin.close();
		    // Close our output stream
		    fout.close();
		}
		// Catches any error conditions
		catch (IOException e)
		{
			System.err.println ("Unable to read from file");
			System.exit(-1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	public static String solveCase(DataInputStream reader) throws Exception, IOException
	{
		return getMaxDancers(reader.readLine().split(" "));
	}
	
	private static String getMaxDancers(String[] values) 
	{
		int numGooglers = Integer.parseInt(values[0]);
		int numSurprising = Integer.parseInt(values[1]);
		int value = Integer.parseInt(values[2]);
		int minCriticalValue = value + 2*(value-2);
		minCriticalValue = minCriticalValue < 0 ? value : minCriticalValue ;
		int maxCriticalValue = minCriticalValue + 1;
		if(value == 0) maxCriticalValue = -1;
		
		int score, maxDancers = 0;
		for (int i = 3; i < 3+numGooglers; i++) 
		{
			score = Integer.parseInt(values[i]);
			if ( score > maxCriticalValue 
					|| score >= minCriticalValue && numSurprising-- > 0)
				maxDancers++;
		}
		
		return maxDancers + "";
	}

	public static void main(String[] args) 
	{
		solveProblem();		
	}
}
