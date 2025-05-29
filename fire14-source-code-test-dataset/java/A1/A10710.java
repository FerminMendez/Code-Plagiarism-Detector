/*
 * Google Code Challenge Java
 * 
 * Code written for the Google Code Challenge by Greg Dougherty
 * Created: May 7, 2011
 * 
 * Copyright 2011 by Greg Dougherty
 */

package com.google.GregTD.CodeJam2012Quals.Dancing;

import java.io.*;

/**
 * @author Greg Dougherty
 *
 */
public class Dancing
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
				int	numGoog = new Integer (entries[0]).intValue ();
				int	maxSurprise = Integer.valueOf (entries[1]).intValue ();
				int	minScore = Integer.valueOf (entries[2]).intValue ();
				int	bestTotal = minScore * 3 - 2;
				int	surpriseTotal = Math.max (minScore * 3 - 4, minScore);
				int[]	scores = new int[numGoog];
				
				for (int j = 0; j < numGoog; ++j)
					scores[j] = Integer.valueOf (entries[3 + j]).intValue ();
				
				int	numWin = 0;
				int	numSurprise = 0;
				for (int j = 0; j < numGoog; ++j)
				{
					if (scores[j] >= bestTotal)
						++numWin;
					else if (scores[j] >= surpriseTotal)
						++numSurprise;
				}
				
				numWin += Math.min (maxSurprise, numSurprise);
				dataWriter.write ("Case #" + (i + 1) + ": " + numWin);
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
