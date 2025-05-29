package com.snap.training;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DancingGooglers {

	public static ArrayList<String> readFromFile() 
	{
		ArrayList<String> inputList = new ArrayList<String>();
		try
		{
			FileReader fr = new FileReader("C:\\Users\\sanath\\Downloads\\code\\input.in");
			BufferedReader br = new BufferedReader(fr);
			String readLine = null;
			while((readLine=br.readLine())!=null)
			{
				inputList.add(readLine);
			}
		}
		catch (IOException e) {
			inputList = null;
			e.printStackTrace();
		}
		return inputList;
	}
	
	public static void writeToFile(ArrayList<String> outputList)
	{
		try
		{
			FileWriter fw = new FileWriter("C:\\Users\\sanath\\Downloads\\code\\output.out");
			BufferedWriter br = new BufferedWriter(fw);
			for(int i = 0; i < outputList.size(); i++)
			{
				br.write("Case #" + (i+1) + ": " + outputList.get(i));
				br.newLine();
			}
			br.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ArrayList<String> inputList = readFromFile(); 
		
		String inputStr = null;
		String finalStr = null;
		ArrayList<String> outputList = new ArrayList<String>();
		
		int noOfGooglers, noOfSurprises, reqdResult, reqdCount;
		int sCount, r, q;
		
		int noOfTestCases = Integer.parseInt(inputList.get(0).toString());
		for(int i = 1; i < noOfTestCases + 1; i++)
		{
			inputStr = inputList.get(i);
			String[] splitStr = inputStr.split(" ");
			noOfGooglers = Integer.parseInt(splitStr[0]);
			noOfSurprises = Integer.parseInt(splitStr[1]);
			reqdResult = Integer.parseInt(splitStr[2]);
			int[] points = new int[noOfGooglers];
			for(int j = 3, k = 0; j < splitStr.length; j++,k++)
			{
				points[k] = Integer.parseInt(splitStr[j]);
			}
			
			sCount = 0;
			reqdCount = 0;
			for(int l = 0; l < points.length; l++)
			{
				q = points[l] /  3;
				r = points[l] %  3;
				if(r == 0)
				{
					if( q >= reqdResult)
					{
						reqdCount++;
					}
					else if( (q + 1) >= reqdResult && sCount < noOfSurprises && points[l] > 0 )
					{
						reqdCount++;
						sCount++;
					}
				}
				else if (r == 1)
				{	
					if( (q+1) >= reqdResult)
					{
						reqdCount++;
					}
				}
				else if (r == 2)
				{
					if( (q+1) >= reqdResult)
					{
						reqdCount++;
					}
					else if( (q + 2) >= reqdResult && sCount < noOfSurprises )
					{
						reqdCount++;
						sCount++;
					}
				}
			}
			finalStr = "" + reqdCount;
			outputList.add(finalStr.trim());
		}
		
		writeToFile(outputList);
		
	}

}
