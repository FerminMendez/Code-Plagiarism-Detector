package com.khajochi.codejam;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class DancingWithTheGooglers
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		try
		{
			RecycledNumbers sp = new RecycledNumbers();

			FileInputStream fstream = new FileInputStream("/Users/msmart/Documents/My Work/Workspace/M/resource/2012round1/1BSmall.in");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String str = br.readLine();
			int count = 1;
			while ((str = br.readLine()) != null)
			{
//				System.out.println(str);
				
				String[] strSpilt = str.split(" ");
				
				int numInput = Integer.parseInt(strSpilt[0]);
				int numSurprise = Integer.parseInt(strSpilt[1]);
				int sum = Integer.parseInt(strSpilt[2]);
				
				int[] allInput = new int[numInput];
				
				for (int i = 0; i < numInput; i++)
				{
					allInput[i] = Integer.parseInt(strSpilt[i+3]);
//					System.out.println(allInput[i]);
				}
				
				int ans = 0;
				
				Arrays.sort(allInput);
				
				for (int i = 0; i < allInput.length; i++)
				{
					if ( allInput[i] >= sum * 3 )
					{
						ans++;
						continue;
					}
					
					if ( sum * 3 - 2 < 0 )
					{
						continue;
					}
					else if (allInput[i] >= sum * 3 - 2 )
					{
						ans++;
						continue;
					}
					
					if ( sum * 3 - 4 < 0 )
					{
						continue;
					}
					else if (allInput[i] >= sum * 3 - 4 && numSurprise > 0 )
					{
						ans++;
						numSurprise--;
						continue;
					}
					
				}
//				System.out.println(ans);
				
				System.out.println("Case #" + count++ + ": " + ans);
				
			}
			in.close();
		}
		catch (Exception e)
		{
			System.err.println(e);
		}
	
	}

}
