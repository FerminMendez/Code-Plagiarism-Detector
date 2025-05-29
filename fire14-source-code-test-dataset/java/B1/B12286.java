package qC;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import qB.B.Pair;

//LetÅfs say a pair of distinct positive integers (n, m) is recycled 
//if you can obtain m by moving some digits from the back of n to the 
//front without changing their order. For example, (12345, 34512) is a 
//recycled pair since you can obtain 34512 by moving 345 from the end 
//of 12345 to the front. Note that n and m must have the same number 
//of digits (excluding leading zeros) in order to be a recycled pair.

//Given integers A and B with the same number of digits, how many distinct
//recycled pairs (n, m) are there with A ? n < m ? B?

public class C2 {

	static int solve(int number, int b) {
		int numDigi = number;
		int orgNumber = number;
		int c = 1;
		int p = 1;
		int counter = 0;

		do {
			numDigi = numDigi / 10;
			p = p * 10;
			c++;
		} while (numDigi != 0);
		int k = c - 1;
		p = p / 10;

		for ( int i = 1; i <= k; i++) {
			number = number % p * 10 + number / p;
			if (number > orgNumber && number <= b) {
				// System.out.println( "no: " + number + ", " + check);
				counter++;
			}
		}
		return counter;
	}

	public static void main(String[] args) throws FileNotFoundException {
		if (args.length == 0) {
			throw new IllegalArgumentException("no file given");
		}
		String filename = args[0];
		Scanner scanner = new Scanner(new File(filename));
		int numOfLines = scanner.nextInt();
		scanner.nextLine();

		for (int lineIdx = 0; lineIdx < numOfLines; lineIdx++) {
			final int start = scanner.nextInt();
			final int end = scanner.nextInt();
			int ans = 0;
			for (int l = start; l <= end; l++) {
				ans += solve(l, end);
			}
			System.out.printf("Case #%d: %d\n", lineIdx + 1, ans);
		}
	}
}
