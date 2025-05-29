package com.google.jam.recycled.numbers;

import java.util.SortedSet;
import java.util.TreeSet;

public class RecycledNumberController {

	private final int m;
	private SortedSet<RNumber> numbersSet = new TreeSet<RNumber>();
	
	public RecycledNumberController(int n, int m) {
		this.m = m;
		
		for (int i = n; i <= m; i++)
			numbersSet.add(RNumber.valueOf(i));
	}
	
	public int getNumRecycledNumbers() {
		int count = 0;
		
		for (RNumber number : numbersSet)
			count += number.getNumRecycledNumbersLessThan(m);
		
		return count;
	}
	
}
