package com.snap.training;

import java.io.*;
import java.util.ArrayList;

public class RecycledNumbers {

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
				System.out.println("Case #" + (i+1) + ": " + outputList.get(i));
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

		int noOfTestCases = Integer.parseInt(inputList.get(0).toString());
		int a, b, count = 0;
		for(int i = 1; i < noOfTestCases + 1; i++)
		{
			inputStr = inputList.get(i);
			finalStr = "";
			String[] splitStr = inputStr.split(" ");
			a = Integer.parseInt(splitStr[0]);
			b = Integer.parseInt(splitStr[1]);
			for(int j = a; j <= b; j++)
			{
				char[] tempChar = String.valueOf(j).toCharArray();
				char[] tempCharConverted = new char[tempChar.length];
				ArrayList<Integer> checkList = new ArrayList<Integer>();
				for(int k = 1; k < tempChar.length; k++)
				{
					for(int l = 0, x = k; l < tempChar.length; l++)
					{
						tempCharConverted[l] =  tempChar[x];
						x++;
						if(x == tempChar.length)
							x = 0;
					}
					if(tempCharConverted[0] != '0')
					{
						int value = Integer.parseInt(new String(tempCharConverted));
						if(value > j && value <= b && !checkList.contains(new Integer(value)))
						{
							checkList.add(new Integer(value));
							count++;
						}
					}
				}
			}
			finalStr = "" + count;
			count = 0;
			outputList.add(finalStr.trim());
		}

		writeToFile(outputList);

	}

}
