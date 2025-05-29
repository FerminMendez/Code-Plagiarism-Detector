package RecycledNumber;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class RecycledNumber 
{
	public static void main(String[] args) throws IOException
	{
		//open the file
		FileReader reader = new FileReader(args[0]);	   		
		BufferedReader input = new BufferedReader(reader);
		
		FileWriter fOut = new FileWriter("out.txt", false);
		BufferedWriter out = new BufferedWriter(fOut);
			
		//first line is the number of test cases
		int testCases = Integer.parseInt(input.readLine());
					
		for(int i = 0; i < testCases; i++)
		{			
			String line = input.readLine();
			System.out.println(line);
			
			int answer = 0;
			
			String[] ab = line.split(" ");

			int a = Integer.parseInt(ab[0]);	
			int b = Integer.parseInt(ab[1]);
			
			int n = a;
			int m = b;
			
			//figure out the length we are dealing with
			int length = (int)(Math.log10(a)+1);
			
			HashMap<Integer,Integer> matches = new HashMap<Integer,Integer>();
			
			for(int j = n; j < m; j++)
			{
				for(int k = m; k > j; k--)
				{
					//now, shift digits from back of j and compare to k
					String shifter = String.valueOf(j);
					for(int shift = 1; shift < length; shift ++)
					{						
						String front = shifter.substring(0,shift);
						String back = shifter.substring(shift, shifter.length());
						
						//no leading zeroes after shift
						if(!back.startsWith("0"))
						{							
							int shiftedInt = Integer.parseInt(back + front);
							
							//match!
							if(shiftedInt == k 
									&& (!matches.containsKey(shiftedInt) || matches.get(shiftedInt) != j)
									)
							{
								answer++;
								matches.put(shiftedInt, j);							
							}
						}
					}				
				}
			}
						
			out.write("Case #" + (i + 1) + ": " + answer + "\n");
			System.out.println(answer);			
		}
		
		out.close();
	}
}
