package com.dagova.recycledNumbers;

import java.util.TreeSet;

public class RecycledNumbersSolver
{
	private static int solution;
	private static int aNumber;
	private static int bNumber;

	
	public static int solve(String line)
	{
		solution = 0;
		
		String[] splittedLine = line.split(" ");
		aNumber = Integer.parseInt(splittedLine[0]);
		bNumber = Integer.parseInt(splittedLine[1]);
		
		for(int number = aNumber; number < bNumber-1; number++)
		{
			solution += solveNumber(number);
		}
		return solution;
	}

	
	public static int solveNumber(int number)
	{
		//	con el treeset evita que un n de varias veces el mismo m. Antes usaba el contador recycledNumbers y por eso fallaba.
		TreeSet<Integer> ms = new TreeSet<Integer>();
//		int recycledNumbers = 0;
		String numberAsString = Integer.toString(number);
		int numberLength = numberAsString.length();
		
		for(int charIterator = 1; charIterator < numberLength; charIterator++)
		{
			if(numberAsString.charAt(charIterator) >= numberAsString.charAt(0))
			{
				int recycledNumber = generateRecycledNumber(numberAsString, charIterator);
				if(recycledNumber <= bNumber && recycledNumber > number)
				{
					ms.add(recycledNumber);
//					recycledNumbers++;
				}
			}	
		}
		
		return ms.size();
//		return recycledNumbers;
	}
	
	
	public static int generateRecycledNumber(String numberAsString, int charIterator)
	{
		String prefix = numberAsString.substring(0, charIterator);
		String sufix = numberAsString.substring(charIterator);
		
		return Integer.parseInt(sufix.concat(prefix));
	}
}
