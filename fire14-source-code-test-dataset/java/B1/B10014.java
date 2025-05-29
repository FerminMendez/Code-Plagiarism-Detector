package googlejam3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class Main3 
{
	static HashMap<String,String> pairsMap = new HashMap<String,String>();
	
	protected static String resolveTestCase(String line)
	{
		String [] tokens = line.split(" ");
		
		int A = Integer.parseInt(tokens[0]);
		int B = Integer.parseInt(tokens[1]);
		
		int pairs = 0;
		
		pairsMap.clear();
		
		for ( int n = A; n <= B; n++ )
		{
			String test = Integer.toString(n);
			
			for ( int j = 1; j < test.length(); j++ )
			{
				String test2 = test.substring(j, test.length()) + test.substring(0, j);
				
				int m = Integer.parseInt(test2);
				
				if ( test2.charAt(0) != '0' && n < m && m <= B && pairsMap.get(test+test2) == null)
				{
					System.out.println("N = " + n + " M = " + m );
					
					pairs++;
					
					pairsMap.put(test+test2, "");
				}
			}
		}
		
		return "" + pairs;
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
