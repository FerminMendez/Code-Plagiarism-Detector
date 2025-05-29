package com.sam.googlecodejam.recyclenumbers;

import java.util.HashSet;
import java.util.Set;

import com.sam.googlecodejam.helper.InputReader;

public class RecycleNumbers {
	long pairCount;

	public void getPairCount(long a, long b) {
		int length = Long.toString(a).length();

		long power = 1;
		for (int i = 1; i < length; i++) {
			power = power * 10;
		}

		for (long m = a; m < b; m++) {
			long value = m;
			Set<Long> pairCountSet = new HashSet<>();
			for (int i = 0; i < length; i++) {
				value = value / 10 + (value % 10) * power;

				if (value > m && value <= b) {

					pairCountSet.add(value);
				}
			}
			pairCount = pairCount + pairCountSet.size();
		}
	}

	public static void main(String[] args) {

		InputReader reader = new InputReader("c://input.in");
		reader.readNextLine(); // read the line number off - we don't need it

		String lineRead = null;
		int i = 1;
		while ((lineRead = reader.readNextLine()) != null) {
			RecycleNumbers recycleNumbers = new RecycleNumbers();

			String values[] = lineRead.split(" ");
			recycleNumbers.getPairCount(Long.parseLong(values[0]),
					Long.parseLong(values[1]));
			System.out.println("Case #" + i + ": " + recycleNumbers.pairCount);
			i++;
		}
	}
}
