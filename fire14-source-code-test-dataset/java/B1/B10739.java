/*
 * Google Code Challenge Java
 * 
 * Code written for the Google Code Challenge by Greg Dougherty
 * Created: May 7, 2011
 * 
 * Copyright 2011 by Greg Dougherty
 */

package com.google.GregTD.CodeJam2012.Recycled;

import java.io.*;

/**
 * @author Greg Dougherty
 *
 */
public class Recycled
{
	
	private static final String	kInSuffix = ".in";
	private static final String	kOutSuffix = ".out";
	
	/**
	 * @param args
	 */
	public static void main (String[] args)
	{
		String	inName = args[0];
		int		nameLen = inName.indexOf (kInSuffix);
		String	outName = inName.substring (0, nameLen) + kOutSuffix;
		File	dataFile = new File (args[0]);
		File	resultFile = new File (outName);
		
		try
		{
			BufferedReader	dataReader = new BufferedReader (new FileReader (dataFile));
			BufferedWriter	dataWriter = new BufferedWriter (new FileWriter (resultFile));
			String			line = dataReader.readLine ();	// Get first line
			int				numCases = Integer.valueOf (line).intValue ();
			
			// Run each test case
			for (int i = 0; i < numCases; ++i)
			{
				// Get data
				line = dataReader.readLine ();
				
				String[]	entries = line.split (" ");
				int	minValue = new Integer (entries[0]).intValue ();
				int	maxValue = Integer.valueOf (entries[1]).intValue ();
				int	numPairs = 0;
				for (int j = minValue; j <= maxValue; ++j)
				{
					String	str = "" + j;
					int		strLen = str.length ();
					if (strLen < 2)
						continue;
					
					--strLen;
					for (int k = 0; k < strLen; ++k)
					{
						str = str.charAt (strLen) + str.substring (0, strLen);
						int	value = Integer.valueOf (str).intValue ();
						if ((value > j) && (value <= maxValue))
							++numPairs;
					}
				}
				
				dataWriter.write ("Case #" + (i + 1) + ": " + numPairs);
				dataWriter.newLine ();
				dataWriter.flush ();
			}
		}
		catch (IOException ioE)
		{
			ioE.printStackTrace ();
		}
	}
	
}
