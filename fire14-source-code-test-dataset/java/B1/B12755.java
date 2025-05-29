package com.dagova.recycledNumbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class RecycledNumbers
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int testCasesNumber = 0;
		try
		{
			testCasesNumber = Integer.parseInt(bufferedReader.readLine());
			
			for(int testCase = 0; testCase < testCasesNumber; testCase++)
			{
				int solution = RecycledNumbersSolver.solve(bufferedReader.readLine());
				System.out.println("Case #" + (testCase+1) + ": "+solution);
			}
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
