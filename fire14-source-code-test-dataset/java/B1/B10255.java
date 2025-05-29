package com.numbers.recycle.algo;

import java.util.ArrayList;
import java.util.List;

public class Recycler {
	
	public int getRecycledNumberCount(String[] wordsInOrder){
		int beginNumber = Integer.valueOf(wordsInOrder[0]);
		int endNumber = Integer.valueOf(wordsInOrder[1]);
		int counter = 0;
		for(int current = beginNumber ; current <= endNumber ; current++)
		{
			List<Integer> recycledNumbers = getRecycledNumbers(current);
			for(int recycledNumber: recycledNumbers)
			{
				if(beginNumber <= current 
						&& current < recycledNumber
						&& recycledNumber <= endNumber)
					counter ++;
			}
		}
		return counter;
	}

	private List<Integer> getRecycledNumbers(int i) {
		List<Integer> returnList = new ArrayList<Integer>();
		String number = String.valueOf(i);
		int length = number.length();
		for(int counter = 1; counter < length; counter++)
		{
			number = number.charAt(length - 1) + number.substring(0,length - 1);
			int numValue = Integer.valueOf(number);
			if(!returnList.contains(numValue))
			returnList.add(Integer.valueOf(number));
		}
		return returnList;
	}

}
