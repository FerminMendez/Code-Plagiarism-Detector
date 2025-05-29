import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Problem

Do you ever become frustrated with television because you keep seeing the same things, recycled over and over again? Well I personally don't care about television, but I do sometimes feel that way about numbers.

Let's say a pair of distinct positive integers (n, m) is recycled if you can obtain m by moving some digits from the back of n to the front without changing their order. For example, (12345, 34512) is a recycled pair since you can obtain 34512 by moving 345 from the end of 12345 to the front. Note that n and m must have the same number of digits in order to be a recycled pair. Neither n nor m can have leading zeros.

Given integers A and B with the same number of digits and no leading zeros, how many distinct recycled pairs (n, m) are there with A ² n < m ² B?

Input

The first line of the input gives the number of test cases, T. T test cases follow. Each test case consists of a single line containing the integers A and B.

Output

For each test case, output one line containing "Case #x: y", where x is the case number (starting from 1), and y is the number of recycled pairs (n, m) with A ² n < m ² B.

Limits

1 ² T ² 50.
A and B have the same number of digits.

Small dataset

1 ² A ² B ² 1000.

Large dataset

1 ² A ² B ² 2000000.

Sample


Input 
 	
Output 
 
4
1 9
10 40
100 500
1111 2222
Case #1: 0
Case #2: 3
Case #3: 156
Case #4: 287

Are we sure about the output to Case #4?

Yes, we're sure about the output to Case #4.

 * @author andrey
 *
 */
public class QCRecycledNumbers {
	
	private static int[] INT_LENGTH = new int[] {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000};
	
	public static void solve(BufferedReader reader, BufferedWriter writer) throws IOException {
		int testCount = readIntFromLine(reader);
		
		for (int test = 1; test <= testCount; test++) {
			writer.append("Case #").append(Integer.toString(test)).append(": ");
			
			solveTestCase(reader, writer);
			
			writer.newLine();
		}
		writer.flush();
	}

	private static void solveTestCase(BufferedReader reader, BufferedWriter writer) throws IOException {
		String[] testCase = reader.readLine().split("\\s");
		int minValue = Integer.parseInt(testCase[0]);
		int maxValue = Integer.parseInt(testCase[1]);
		
		int length = testCase[0].length();
		
		if (minValue >= maxValue) {
			writer.append('0');
			return;
		}
		
		int recycledCount = 0;
		int recycledNumber;
		int lowerPart;
		int foundRecycledNumbersCount;
		int[] foundRecycledNumbers = new int[length - 1];
		
		for (int i = minValue; i < maxValue; i++) {				
			foundRecycledNumbersCount = 0;
			
			for (int j=1; j < length; j++) {
				lowerPart = i % INT_LENGTH[j];
				if (lowerPart < INT_LENGTH[j - 1]) {
					// can't rotate, because first digit in lowerPart is 0
					continue;
				}
				
				recycledNumber = lowerPart*INT_LENGTH[length - j] + i/INT_LENGTH[j];
				if (recycledNumber <= i || recycledNumber > maxValue) {
					// recycled number exceeds limits
					continue;
				}
				
				boolean duplicate = false;
				for (int k=0; k < foundRecycledNumbersCount; k++) {
					if (foundRecycledNumbers[k] == recycledNumber) {
						duplicate = true;
						break;
					}
				}
				if (duplicate) {
					continue; // such permutation already found
				}
				
//				if (foundRecycledNumbersCount == 0) {
//					System.out.print(i + " -> ");
//				}
//				System.out.print(recycledNumber + ", ");
				foundRecycledNumbers[foundRecycledNumbersCount++] = recycledNumber;
				recycledCount++;
			}
//			if (foundRecycledNumbersCount > 0) {
//				System.out.println();
//			}
		}
		
		writer.append(Integer.toString(recycledCount));
	}
	
	public static void solve(String inputFile, String outputFile) throws IOException {
		File input = new File(inputFile);
		File output = new File(outputFile);
		
		if (!input.exists()) {
			throw new IllegalArgumentException("Input file doesn't exist: " + inputFile);
		}
		
		BufferedReader reader = null;
		BufferedWriter writer = null;
		try {
			reader = new BufferedReader(new FileReader(input));
			writer = new BufferedWriter(new FileWriter(output));
			solve(reader, writer);
		
		} finally {
			if (reader != null)
				reader.close();
			if (writer != null)
				writer.close();
		}
	}
	
	public static int readIntFromLine(BufferedReader reader) throws IOException {
		String line = reader.readLine();
		int testCount = Integer.parseInt(line);
		return testCount;
	}

	public static void main(String[] args) throws IOException {
		System.out.println("Start...");
		solve("res/input.txt", "res/output.txt");
		System.out.println("Done!");
		
	}
}
