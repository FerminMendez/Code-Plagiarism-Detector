package qualifiers.dancing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Dancing
{
	public static void main(String[] args)
	{
		try
		{
			FileReader fileReader = new FileReader("input/B-small-attempt0.in");
			BufferedReader bufferedReader = new BufferedReader(fileReader);		
			
			String record = null;
			int numOfCases = -1;
			int lineCount = 0;
			List<String> inputList = new ArrayList<String>();
			
			// Read input
			while ((record = bufferedReader.readLine()) != null)
			{
				// First row is number of cases
				if (lineCount == 0)
				{
					numOfCases = Integer.valueOf(record);
				} 
				// Input
				else
				{
					inputList.add(record);					
				}
								
				lineCount++;
			}			
			fileReader.close();
			
			// Perform algo
			List<Integer> results = new ArrayList<Integer>();
			for (String input : inputList)
			{
				String[] inputStrArray = input.split(" ");				
				int numOfGooglers = Integer.valueOf(inputStrArray[0]);
				int numOfSurprisingScores = Integer.valueOf(inputStrArray[1]);
				int point = Integer.valueOf(inputStrArray[2]);
				
				// Constraints
				int constraint1 = ((3 * point - 4) < point) ? point : (3 * point - 4);
				int constraint2 = (constraint1 < 2) ? constraint1 : constraint1 + 1;
				int surePassConstraint = (constraint2 < 2) ? constraint2 : constraint2 + 1;
				
				// Calc
				int result = 0;
				int count = 3 + numOfGooglers;
				for (int i = 3; i < count; i++)
				{
					int totalScoreOfGoogler = Integer.valueOf(inputStrArray[i]);
					// Sure pass
					if (totalScoreOfGoogler >= surePassConstraint)
					{
						result++;
					}
					// Sure fail
					else if (totalScoreOfGoogler < constraint1)
					{
						continue;
					}
					// Surprise score
					else if (totalScoreOfGoogler == constraint1 || totalScoreOfGoogler == constraint2)
					{
						if (numOfSurprisingScores > 0)
						{
							result++;
							numOfSurprisingScores--;
						}
						else
						{
							continue;
						}
					}
				}
				
				results.add(result);
			}

			// Write output
			FileWriter fileWriter = new FileWriter("output/results.out");
		  BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		  for (int i = 0; i < results.size(); i++)
			{
		  	int result = results.get(i);
				bufferedWriter.write("Case #" + (i+1) + ": " + result);
				if (i < results.size() - 1) bufferedWriter.write("\n");
			}
		  //Close the output stream
		  bufferedWriter.close();
		}
		catch (IOException e)
		{ 
			System.out.println("IOException error!");
			e.printStackTrace();
		}
	}
}
