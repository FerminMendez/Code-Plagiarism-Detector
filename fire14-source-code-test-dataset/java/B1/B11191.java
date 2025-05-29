package codejam.c;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import codejam.TestCaseReader;

public class Main {

	public static void main(String[] args) {

		TestCaseReader<int[]> reader = new TestCaseReader<int[]>("in.txt") {

			@Override
			protected int[] parseTestCase(String line) {
				String[] splitted = line.split("\\s");
				return new int[] { Integer.parseInt(splitted[0]),
						Integer.parseInt(splitted[1]) };
			}
		};

		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(new File("out.txt")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		int testCases = reader.getTestCases();

		int[] testCase = null;

		for (int i = 0; i < testCases; i++) {
			testCase = reader.getNextTestCase();
			long result = Main.solveCase(testCase[0], testCase[1]);
			try {
				writer.write("Case #" + (i + 1) + ": " + result);
				writer.newLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static long solveCase(int a, int b) {

		char[] bArray = Main.converToCharArray(b);

		Set<String> counted = new HashSet<String>();

		for (int num = a; num <= b; num++) {
			char[] numArray = Main.converToCharArray(num);
			char[] numArrayPair = Main.converToCharArray(num);

			for (int i = 0; i < numArray.length - 1; i++) {
				Main.rotateCharArray(numArrayPair);

				if (Main.compare(numArrayPair, bArray) <= 0
						&& Main.compare(numArray, numArrayPair) < 0) {

					String pair = new String(numArray)
							+ new String(numArrayPair);
					if (!counted.contains(pair)) {
						counted.add(pair);
					}

				}
			}
		}

		return counted.size();
	}

	private static char[] converToCharArray(int num) {
		return new Integer(num).toString().toCharArray();
	}

	private static void rotateCharArray(char[] array) {
		char tmp = array[array.length - 1];
		for (int i = array.length - 1; i > 0; i--) {
			array[i] = array[i - 1];
		}
		array[0] = tmp;
	}

	private static int compare(char[] a, char[] b) {

		for (int i = 0; i < a.length; i++) {
			if (a[i] < b[i]) {
				return -1;
			} else if (a[i] > b[i]) {
				return 1;
			}
		}
		return 0;
	}
}
