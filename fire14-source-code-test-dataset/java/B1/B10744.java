package qualification.c;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 
 * Problem
Do you ever become frustrated with television because you keep seeing the same things, recycled over and over again? Well I personally don't care about television, but I do sometimes feel that way about numbers.
Let's say a pair of distinct positive integers (n, m) is recycled if you can obtain m by moving some digits from the back of n to the front without changing their order. For example, (12345, 34512) is a recycled pair since you can obtain 34512 by moving 345 from the end of 12345 to the front. Note that n and m must have the same number of digits in order to be a recycled pair. Neither n nor m can have leading zeros.
Given integers A and B with the same number of digits and no leading zeros, how many distinct recycled pairs (n, m) are there with A ≤ n < m ≤ B?

Input
The first line of the input gives the number of test cases, T. T test cases follow. Each test case consists of a single line containing the integers A and B.

Output
For each test case, output one line containing "Case #x: y", where x is the case number (starting from 1), and y is the number of recycled pairs (n, m) with A ≤ n < m ≤ B.

Limits
1 ≤ T ≤ 50.
A and B have the same number of digits.

Small dataset
1 ≤ A ≤ B ≤ 1000.

Large dataset
1 ≤ A ≤ B ≤ 2000000.

Sample
Input 
4
1 9
10 40
100 500
1111 2222
Output 
Case #1: 0
Case #2: 3
Case #3: 156
Case #4: 287
Are we sure about the output to Case #4?
Yes, we're sure about the output to Case #4.

 * 2012.04.14. 16:22 - 16:38
 * @author Chei
 */
public class RecycledNumbers {
	Scanner scanner;
	public static void main(String[] args) throws FileNotFoundException {
		new RecycledNumbers().solve();
	}
	
	void solve() throws FileNotFoundException {
		//scanner = new Scanner(new File("resources/C-large.in"));
		scanner = new Scanner(new File("resources/C-small-attempt0.in"));
		//scanner = new Scanner(new File("resources/C-example.in"));
		int numberOfTestCases = scanner.nextInt();
		for (int testCaseIndex = 1; testCaseIndex <= numberOfTestCases; testCaseIndex++) {
			int result = solveTestCase();
			System.out.format("Case #%d: %d%n", testCaseIndex, result);
		}
	}

	int solveTestCase() {
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		Set<String> recycledNumbers = new HashSet<String>();
		int result = 0;
		for (int num = a; num <= b; num++) {
			String numString = String.valueOf(num);
			recycledNumbers.clear();
			for (int i = 0; i < numString.length(); i++) {
				String newString = numString.substring(i) + numString.substring(0, i);
				if (newString.charAt(0) != '0') {
					int newNum = Integer.parseInt(newString);
					if (newNum >= a && newNum <= b) {
						recycledNumbers.add(newString);
					}
				}
			}
			result += recycledNumbers.size() - 1;
		}
		// all pairs were counted twice
		return result / 2;
	}
}
