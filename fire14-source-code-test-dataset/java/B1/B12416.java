package codejam12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class RoundOneProblemC {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		BufferedReader input = new BufferedReader(new FileReader("input.txt"));
		BufferedWriter output = new BufferedWriter(new FileWriter("output.txt"));
		
		int noOfTestCases = Integer.parseInt(input.readLine());
		
		for(int i=1;i<=noOfTestCases;i++)
		{
			String inputLine = input.readLine();
			String strArr[] = inputLine.split("\\s+");
			int a = Integer.parseInt(strArr[0]);
			int b = Integer.parseInt(strArr[1]);
			
			String bStr = Integer.toString(b);
			
		    char firstBDigit = bStr.charAt(0);
			
			int no = 0;
			for(int num=a;num<=b;num++)
			{
				String numStr = Integer.toString(num);
				
				char firstChar = numStr.charAt(0);
				
				//if(firstChar == firstBDigit)
					//continue;
				
				for(byte k=1;k<numStr.length();k++)
				{
					if(numStr.charAt(k)>=firstChar && numStr.charAt(k)<=firstBDigit)
					{
						int newNumber = Integer.parseInt(numStr.substring(k) + numStr.substring(0,k));
						
						if(newNumber <= b && newNumber > num)
						{
							
							no++;
						}
						
						
					}
				}
				
			}
			
			output.write("Case #" + i + ": " + no + "\n");
		}
		
		input.close();
		output.close();

	}
	
	
}
