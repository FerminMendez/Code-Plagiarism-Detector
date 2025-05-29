//RECYCLED NUMBERS

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

//Importing classes / interface from java.io pacckage to work with files

public class RecycledNumbers
{
	static boolean checkForNewM(int temp , int [] m , int totalMForThisN)
	{
		for(int i = 0 ; i < totalMForThisN ; i++)
		{
			if(temp == m[i])
			{
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args)
	{
		try
		{
			// Open the input file
			FileInputStream fistream = new FileInputStream("C-small-attempt0.in");
			
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fistream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			
			//Create output file
			File file = new File("output.out");
			boolean exist = file.createNewFile();
			
			if (!exist)
			{
				System.out.println("File already exists.");
				System.exit(0);
			}
			
			FileWriter fostream = new FileWriter("output.out");
			BufferedWriter out = new BufferedWriter(fostream);
			
			int counterCases = 0;		//Counter purpose
			
			//Read File Line By Line
			int totalNumberOfCases = 0;
			while ((strLine = br.readLine()) != null)
			{
				if(counterCases == 0)
				{
					//Ignore the first Line for Conversion
					totalNumberOfCases = Integer.parseInt(strLine);
					counterCases++;
					continue;
				}
				
				String[] results = strLine.split(" ");
				
				int A = Integer.parseInt(results[0]);
				int B = Integer.parseInt(results[1]);
				
				int counter = 0;
				
				for(int n = A ; n < B ; n++)
				{			
					String nTemp = "" + n;
					String mTemp;
					
					int totalMForThisN = 0;
					int [] m = new int [nTemp.length() - 1];
					
					for(int i= (nTemp.length() - 1) ; i >= 0 ; i--)
					{
						mTemp = nTemp.substring(i) + nTemp.substring(0,i);
						
						if(mTemp.startsWith("0"))
						{
							continue;
						}
						else
						{
							int temp = Integer.parseInt(mTemp);
							
							if(temp > n && temp <= B)
							{
								if(checkForNewM(temp, m, totalMForThisN))
								{
									m[totalMForThisN] = temp;
									totalMForThisN++;
									counter++;
								}
							}
						}
					}
				}
				// Print the content in the output file
				out.write("Case #" + counterCases + ": " + counter);
				
				if(counterCases < totalNumberOfCases)
				{
					out.write("\n");
				}
				counterCases++;
			}
			//Close the input stream
			in.close();

			//Close the output Stream
			out.close();
		}
		
		catch(Exception e)
		{
			//Catch exception if any
			System.err.println("Error: " + e.getMessage() + " : " + e);
		}
	}
}