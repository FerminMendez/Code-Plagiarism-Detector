package com.google.code.p_c;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class Main {

	private static final String fromFile = "D:\\hobbies & work\\programing\\CodeJamTextFiles\\2012\\C-small-attempt0.in";
	private static final String toFile = "D:\\hobbies & work\\programing\\CodeJamTextFiles\\2012\\C-small-attempt0.out";

	
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
System.out.println("Problem C start");
		
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
					int ans = ansForLine(strLine);
					System.out.println("Case #" + i + ": " + ans + "\n");

					out.write("Case #" + i + ": " + ans + "\n");
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
		
		System.out.println("Problem C end");
	}


	private static int ansForLine(String strLine) 
	{
		String [] sp = strLine.split(" ");
		String n1s = sp [0];
		String n2s = sp [1];
		
		int n1 = Integer.parseInt(n1s);
		int n2 = Integer.parseInt(n2s);
		int count = 0;
		for (int i = n1; i < n2 ; i++)
		{
			String s1 = Integer.toString(i);
			String s1b = s1;
			System.out.println("--- " + s1);

			for (int j = 0; j < s1.length() - 1; j++)
			{
				s1 = s1.charAt(s1.length() - 1) + s1.substring(0, s1.length() - 1);
				//System.out.println(s1);
				if (s1.equals(Integer.toString(i)))
					continue;
				
				if (Integer.parseInt(s1) >= n1 && Integer.parseInt(s1) <= n2 && Integer.parseInt(s1) > Integer.parseInt(s1b))
				{
					System.out.println("y " + s1);
					count ++;
					//break;
				}
				else
				{
					System.out.println("n " + s1);
				}
			}
		}
		
		return count;
	}

}
