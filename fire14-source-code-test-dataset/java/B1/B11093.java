package qualifiers.recyclednumbers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RecycledNumbers
{
	public static void main(String[] args)
	{
		try
		{
			FileReader fileReader = new FileReader("input/C-small-attempt0.in");
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
				String[] boundStrArray = input.split(" ");
				int lowerBound = Integer.valueOf(boundStrArray[0]);				
				int upperBound = Integer.valueOf(boundStrArray[1]);				
				int result = 0;
				
				// 1 - 9
				if (upperBound <= 9)
				{
					results.add(result);
					continue;
				}
				else
				{
					int numOfDigits = String.valueOf(upperBound).length();
					Map<String, List<String>> exclusionMap = new HashMap<String, List<String>>();
					List<String> resultValueList = new ArrayList<String>();

					for (int i = lowerBound; i <= upperBound; i++)
					{
						// Shift to front by j digits
						for (int j = 1; j < numOfDigits; j++)
						{
							String value = String.valueOf(i);
							String newValue = value.substring(value.length() - j) + value.substring(0, value.length() - j);
							
							// Leading 0 - continue
							if (newValue.charAt(0) == '0')
							{
								continue;
							}
							// More than upperBound - continue
							else if (Integer.valueOf(newValue) > upperBound)
							{
								continue;
							}
							// Less than lowerBound - continue
							else if (Integer.valueOf(newValue) < lowerBound)
							{
								continue;
							}
							// Same values
							else if (value.equals(newValue))
							{
								continue;
							}
							else
							{
								// In exclusion list already - continue
								if (exclusionMap.containsKey(value))
								{
									List<String> exclusionList = exclusionMap.get(value);
									if (exclusionList.contains(newValue)) continue;
								}
								
								// In exclusion list already - continue
								if (exclusionMap.containsKey(newValue))
								{
									List<String> exclusionList = exclusionMap.get(newValue);
									if (exclusionList.contains(value)) continue;
								}
								
								// Match, add to exclusion list so we don't run again								
								if (exclusionMap.containsKey(value))
								{
									List<String> exclusionList = exclusionMap.get(value);
									exclusionList.add(newValue);
								}
								else
								{
									List<String> exclusionList = new ArrayList<String>();
									exclusionList.add(newValue);
									exclusionMap.put(value, exclusionList);
								}
								
								// Match, add to exclusion list so we don't run again								
								if (exclusionMap.containsKey(newValue))
								{
									List<String> exclusionList = exclusionMap.get(newValue);
									exclusionList.add(value);
								}
								else
								{
									List<String> exclusionList = new ArrayList<String>();
									exclusionList.add(value);
									exclusionMap.put(newValue, exclusionList);
								}
								
								result++;
							}
						}
					}
					
					results.add(result);
				}
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
