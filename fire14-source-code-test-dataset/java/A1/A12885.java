package com.google.code.p_b;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class Main {

	private static final String fromFile = "D:\\hobbies & work\\programing\\CodeJamTextFiles\\2012\\B-small-attempt0.in";
	private static final String toFile = "D:\\hobbies & work\\programing\\CodeJamTextFiles\\2012\\B-small-attempt0.out";

	
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		System.out.println("Problem B start");
		
		try {

			FileInputStream fstream = new FileInputStream(fromFile);

			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			
			FileWriter fstreamout = new FileWriter(toFile);
			BufferedWriter out = new BufferedWriter(fstreamout);
			
			String strLine;
			boolean firstLine = true;
			int i = 1;
			while ((strLine = br.readLine()) != null) 
			{
				if (!firstLine)
				{
					System.out.println(strLine);
					System.out.println("Case #" + i + ": " + ansForLine(strLine) + "\n");

					out.write("Case #" + i + ": " + ansForLine(strLine) + "\n");
					i++;
				}
				else
				{
					firstLine = false;
				}
			}
			out.close();
			in.close();
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
		
		System.out.println("Problem B end");
	}


	private static int ansForLine(String strLine) 
	{
		String [] splitedLine = strLine.split(" ");
		int nRes = Integer.parseInt(splitedLine[0]);
		int nSurprises = Integer.parseInt(splitedLine[1]);
		int nMax = Integer.parseInt(splitedLine[2]);
		System.out.println("res: " + nRes + ", surprises: " + nSurprises +", max: " + nMax);

		int count = 0;
		
		for (int i = 3; i < splitedLine.length; i++)
		{
			int j = Integer.parseInt(splitedLine[i]);
			int avg = j / 3;
			int m = j % 3;
			
			if (j == 0)
			{
				if (nMax == 0)
					count ++;
				continue;
			}
			
			if (avg >= nMax)
			{
				count ++;
			}
			else if (avg + 1 >= nMax)
			{
				if (m == 0 && nSurprises > 0)
				{
					count ++;
					nSurprises --;
				}
				else if (m == 1 || m == 2)
				{
					count ++;
				}
			}
			else if (avg + 2 >= nMax)
			{
				if (m == 2 && nSurprises > 0)
				{
					count ++;
					nSurprises --;
				}
			}
		}
		
		return count;
	}

}
