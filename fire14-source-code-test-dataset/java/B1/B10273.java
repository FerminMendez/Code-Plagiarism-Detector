import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;




public class RecycleNumbers 
{
	
	@SuppressWarnings("deprecation")
	private static void solveProblem() 
	{
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
		return getNumRecyclers(reader.readLine().split(" "));
	}
	
	private static String getNumRecyclers(String[] values) 
	{
		int A = Integer.parseInt(values[0]);
		int B = Integer.parseInt(values[1]);
		
		int n, m, numRescyclers = 0;
		String numS = "";
		for (n = A; n <= B; n++) 
		{
			numS = n + "";
			for (int length= numS.length(), j = 0; j < length; j++) 
			{
				// A <= n < m <= B.
				m = Integer.parseInt(numS);
				if ( A <= n && n < m && m <= B ) numRescyclers++;
//				if ( A <= n && n < m && m <= B ) {
//					numRescyclers++;
//					System.out.println("("+n+","+m+")");
//				}
				numS = numS.charAt(length-1) + numS.substring(0, length-1);
			}
		}
		
		return numRescyclers + "";
	}

	public static void main(String[] args) 
	{
		solveProblem();		
	}
}
