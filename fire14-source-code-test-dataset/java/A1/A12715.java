package com.dagova.dancingWithTheGooglers;

public class DancingWithTheGooglersSolver
{
	private int solution;
	private int bestScore;
	private int surprisedTriplets;
	private int numberOfGooglers;
	
	
	public DancingWithTheGooglersSolver()
	{
		solution = 0;
	}
	
	
	private void checkTotalPoints(int googlerTotalPoints)
	{
		float quotient = googlerTotalPoints / 3f;
		
		if(quotient >= bestScore)
			solution++;
		else
		{
			googlerTotalPoints -= bestScore;
			if(googlerTotalPoints >= 0)
			{
				quotient = googlerTotalPoints / 2f;
				if(quotient + 1 >= bestScore)
					solution++;
				else
				{
					if(surprisedTriplets > 0 && quotient + 2 >= bestScore)
					{
						surprisedTriplets--;
						solution++;
					}
				}
			}
		}
	}
	
	
	public int solve(String line)
	{
		String[] splittedLine = line.split(" ");
		numberOfGooglers = Integer.parseInt(splittedLine[0]);
		surprisedTriplets = Integer.parseInt(splittedLine[1]);
		bestScore = Integer.parseInt(splittedLine[2]);
		
		for(int googler = 0; googler < numberOfGooglers; googler++)
		{
			checkTotalPoints(Integer.parseInt(splittedLine[3+googler]));
		}
		
		return solution;
	}
}
