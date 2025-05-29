package com.dagova.dancingWithTheGooglers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DancingWithTheGooglers
{
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		DancingWithTheGooglersSolver solver;
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int testCasesNumber = 0;
		try
		{
			testCasesNumber = Integer.parseInt(bufferedReader.readLine());
			
			for(int testCase = 0; testCase < testCasesNumber; testCase++)
			{
				solver = new DancingWithTheGooglersSolver();
				int solution = solver.solve(bufferedReader.readLine());
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
