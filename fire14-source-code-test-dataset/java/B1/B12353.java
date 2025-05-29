package com.google.jam.recycled.numbers;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class RNumber implements Comparable<RNumber> {

	private final int n;

	private final int rank;

	private final SortedSet<Integer> recycledNumbers = new TreeSet<Integer>();

	private static final Map<Integer, RNumber> cache = new HashMap<Integer, RNumber>();

	private RNumber() {
		assert false;
		n = 0;
		rank = 0;
	}

	private RNumber(int n) {
		this.n = n;

		int i = 0;
		for (i = 1; (n / (int) Math.pow(10, i)) > 0; i++)
			;
		rank = i - 1;

		for (int x = (int) Math.pow(10, rank), y = 10; x > 0; x /= 10, y *= 10) {
			int recycledNumber = (n % x) * y + (n / x);

			if (recycledNumber > n)
				recycledNumbers.add(recycledNumber);
		}
	}

	public static RNumber valueOf(int i) {
		if (!cache.containsKey(i))
			cache.put(i, new RNumber(i));

		return cache.get(i);
	}

	@Override
	public int compareTo(RNumber o) {
		return n - o.n;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (!(obj instanceof RNumber))
			return false;

		RNumber o = (RNumber) obj;
		return n == o.n;
	}

	@Override
	public int hashCode() {
		return n;
	}

	public int getNumRecycledNumbersLessThan(int m) {
		int count = 0;
		for (Integer rn : recycledNumbers)
			if (rn > m)
				break;
			else
				count++;
		return count;
	}

}
