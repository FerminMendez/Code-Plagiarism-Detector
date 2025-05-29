package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class recycledNumbers {
	
	public static void main(String[] args)
	{
		File inputFile = new File("input/" + args[0]);
		
		if (!inputFile.exists())
		{
			System.out.print("File DNE");
			return;
		}
		
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile)));
			
			Integer caseCount = new Integer(br.readLine());
			Integer[] lowerList = new Integer[caseCount];
			Integer[] upperList = new Integer[caseCount];
			
			for (int i = 0; i < caseCount; i++)
			{
				String[] lineIn= br.readLine().split(" ");
				lowerList[i] = new Integer(lineIn[0]);
				upperList[i] = new Integer(lineIn[1]);
			}
			
			File outputFile = new File("output/" + args[0] + ".out");
			FileWriter fw = new FileWriter(outputFile);
			
			for (int i = 0; i < caseCount; i++)
			{
				foundPairs.clear();
				int finalCount = 0;
				Integer val = lowerList[i];
				while (val <= upperList[i])
				{
					finalCount += rotate(val, lowerList[i], upperList[i]);
					val++;
				}
				System.out.println("Case #" + (i + 1) + ": " + finalCount);
				fw.write("Case #" + (i + 1) + ": " + finalCount + "\n");
			}
			
			fw.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	private static Map<String,Boolean> foundPairs = new HashMap<String, Boolean>();
	
	private static int rotate(Integer val, Integer lowerBound, Integer upperBound)
	{
		char[] valString = val.toString().toCharArray();
		
		List<Character> valCharArray = new ArrayList<Character>(valString.length);
		
		for (int i = 0; i < valString.length; i++)
			valCharArray.add(valString[i]);
		
		int finalCount = 0;
		for (int i = 0; i < valString.length; i++)
		{
			valCharArray.add(valCharArray.remove(0));
			
			String testValString = new String("");
			for (int j = 0; j < valCharArray.size(); j++)
				testValString += valCharArray.get(j);
			
			Integer testVal = new Integer(testValString);
			
			String key1 = val.toString() + "_" + testVal.toString();
			String key2 = testVal.toString() + "_" + val.toString();
			if (foundPairs.get(key1) != null || foundPairs.get(key2) != null)
				continue;
			
			
			if (testVal > val && testVal <= upperBound)
			{
				foundPairs.put(key1,true);
				foundPairs.put(key2,true);
				
				finalCount++;
			}
		}
		return finalCount;
	}
}
