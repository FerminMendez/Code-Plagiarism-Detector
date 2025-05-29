package com.khajochi.codejam;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class RecycledNumbers
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		try
		{
			RecycledNumbers sp = new RecycledNumbers();

			FileInputStream fstream = new FileInputStream("/Users/msmart/Documents/My Work/Workspace/M/resource/2012round1/1CSmall.in");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String str = br.readLine();
			int count = 1;
			while ((str = br.readLine()) != null)
			{
//				System.out.println(str);
				
				int start = Integer.parseInt(str.split(" ")[0]);
				int end = Integer.parseInt(str.split(" ")[1]);
				
				int possible = findPossible(start,end);
				
				System.out.println("Case #" + count++ + ": " + possible);
				
			}
			in.close();
		}
		catch (Exception e)
		{
			System.err.println(e);
		}
	
	}

	private static int findPossible(int start, int end)
	{
		int count = 0;
		HashMap <String, String> exclude = new HashMap <String, String>();
		
		for (int i = start; i <= end; i++)
		{
			String num = String.valueOf(i);
			
			if ( num.length() > 1 )
			{
				for (int j = 1; j < num.length(); j++)
				{
					int newNum = Integer.valueOf(num.substring(j,num.length()) + num.substring(0,j)).intValue();
//					System.out.println(newNum);
					
					if ( newNum >= start && newNum <= end && newNum != Integer.parseInt(num) )
					{
						boolean skip = false;
						
						if ( exclude.get(num) != null && exclude.get(num).equals(String.valueOf(newNum)) )
							skip = true;
						
						if ( exclude.get(newNum) != null && exclude.get(String.valueOf(newNum)).equals(num) )
							skip = true;
						
						if ( skip == false )
						{
//							System.out.println("Yes : " + num + " > " + newNum);
							exclude.put(num, String.valueOf(newNum));
							count++;
							continue;
						}
					}
				}
			}
		}
		
//		System.out.println(count/2);
		return count/2;
	}

}
