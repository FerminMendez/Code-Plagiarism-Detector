package googlejam2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main2 
{
	static int surprising = 0;
	
	public static String resolveTestCase(String line)
	{
		// Read input parameters
		String tokens [] = line.split(" ");
		
		int N = Integer.parseInt(tokens[0]);
		int S = Integer.parseInt(tokens[1]);
		int P = Integer.parseInt(tokens[2]);
		
		surprising = 0;
		
		System.out.println("N = " + N + ", S = " + S + ", P = " + P);
		
		int [] scores = new int[N];
		
		for ( int i = 0; i < N; i++)
		{
			scores[i] = Integer.parseInt(tokens[3+i]);
		}
		
		// calculate result
		int result = 0;
		
		for ( int i = 0; i < N; i++ )
		{
			System.out.print("Dancer " + i + " score " + scores[i]);
			
			if ( scores[i] >= Math.max(3 * P - 2, P) )
			{
				result++;
				
				System.out.println(" ok ");
			}
			else if ( surprising < S )
			{
				if ( scores[i] >= Math.max( 3 * P - 4, P ) )
				{
					result++;
					surprising++;
					
					System.out.println(" surprising ");
				}
			}
		}
		
		return "" + result;
	}
	
	public static void main (String [] args) throws IOException
	{
		String inputFile = args[0];
		
		File f = new File(inputFile);
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		
		File f2 = new File(inputFile + ".out");
		FileWriter fw = new FileWriter(f2);

		String line = br.readLine();
		
		int count = Integer.parseInt(line);

		// resolve test cases
		int testcase = 1;
		
		for(int tests = 0; tests < count; tests++)
		{
			line = br.readLine();
			
			System.out.println(line);

			String output = "Case #"+testcase+": ";
			
			output += resolveTestCase(line);
			
			System.out.println(output+"\n");
			fw.write(output+"\r\n");
			
			testcase++;
		}
		
		fw.close();
		
	}
}
