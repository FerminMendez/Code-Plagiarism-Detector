package com.self.code.jam.twelve;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;

public class DancingScores {

	public static void main(String[] argv)
	{
		try
		{
			long startTime = System.currentTimeMillis();
			Reader reader = new FileReader("D:\\workspace\\Learn\\src\\com\\self\\code\\jam\\twelve\\input\\dancing\\B-small-attempt0.in");
			BufferedReader bufReader = new BufferedReader(reader);
			String x = bufReader.readLine();
			int count = 0;

			File file = new File("D:\\workspace\\Learn\\src\\com\\self\\code\\jam\\twelve\\output\\dancing\\B-small-attempt0.out");
			FileWriter writer = new FileWriter(file);
			
			while((x = bufReader.readLine()) != null)
			{
				count++;
				String res = DancingScores.getMaxBestResult(x);
				if (count == 1)
					writer.write("Case #"+count+": " + res);
				else
					writer.write("\nCase #"+count+": " + res);
			}
			writer.close();
			System.out.println("Total time = " +( System.currentTimeMillis() - startTime));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static String getMaxBestResult(String input) {
		String[] numbers = input.split(" ");
		if(numbers.length <= 3)
			return "0";
		int N = Integer.parseInt(numbers[0]);
		int S = Integer.parseInt(numbers[1]);
		int P = Integer.parseInt(numbers[2]);

		int maxBestResult = 0;
		
		for (int i=3; i<(3+N); i++)
		{
			int number = Integer.parseInt(numbers[i]);
			int division = number/3 ;
			int remainder = number % 3;
			
			if (remainder == 0)
			{
				if (division >= P)
				{
					maxBestResult ++;
				}
				else if ((S != 0) && ((division + 1) >= P) && (division !=0))
				{
					S--;
					maxBestResult ++;
				}
			}
			else if (remainder == 1)
			{
				if ((division + 1) >= P)
				{
					maxBestResult ++;
				}
				// it can not be a Surprising case
			}
			else if (remainder == 2)
			{
				if ((division + 1) >= P)
				{
					maxBestResult ++;
				}
				else if ((S != 0) && ((division + 2) >= P))
				{
					S--;
					maxBestResult ++;
				}
			}
		}
		return String.valueOf(maxBestResult);
	}
}
