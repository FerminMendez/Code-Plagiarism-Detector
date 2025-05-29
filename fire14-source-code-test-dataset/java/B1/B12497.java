package com.google;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class RecycledNumbers {

	private static int numberOfRecycledPairsPossible(int a, int lowerLimit,
			int upperLimit) {
		int length = (a + "").length();
		if (length == 1) {
			return 0;
		}

		int[] digits = new int[length];
		int b = a;
		boolean isRecyclePossible = false;
		int temp = 0;
		;
		Set<String> set = new HashSet<String>();

		digits[length - 1] = b % 10;
		b /= 10;

		for (int i = length - 2; i >= 0; i--) {
			digits[i] = b % 10;
			b /= 10;
			if (digits[i] != digits[i + 1]) {
				isRecyclePossible = true;
			}
		}
		if (!isRecyclePossible) {
			return 0;
		}

		for (int i = 1; i < length; i++) {
			temp = 0;
			for (int j = i; j < length; j++) {
				temp = temp * 10 + digits[j];
			}
			for (int j = 0; j < i; j++) {
				temp = temp * 10 + digits[j];
			}
			if (temp <= upperLimit && temp >= lowerLimit && temp > a) {
				set.add(a + "" + temp);
			}
		}
		return set.size();
	}

	private static int getRecycledNumbers(int start, int end) {
		int count = 0;
		for (int i = start; i <= end; i++) {
			count += numberOfRecycledPairsPossible(i, start, end);
		}
		return count;
	}

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("d:\\codeJam\\Numbers\\test.txt");
		Scanner scanner = new Scanner(file);
		int t = scanner.nextInt();
		int count = 0;
		for (int i = 1; i <= t; i++) {
			count = getRecycledNumbers(scanner.nextInt(), scanner.nextInt());
			System.out.println("Case #" + i + ": " + count);
		}
	}
}
