package probs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Problem3 {

	public static void main(String[] args) {

		try {

			String filePath = "in-small-3.txt";

			List<String> input = readInput(filePath);
			int[] output = process(input);
			writeOutput(output);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static int[] process(List<String> input) {

		int[] result = new int[input.size()];
		int count = 0;
		for (String eachLine : input) {
			String[] split = eachLine.split(" ");
			String min = split[0];
			String max = split[1];

			int eachResult = processEachTestCase(min, max);
			result[count] = eachResult;

			count++;
		}

		return result;
	}

	private static int processEachTestCase(String min, String max) {

		int result = 0;

		int length = min.length();
		int minValue = Integer.parseInt(min);
		int maxValue = Integer.parseInt(max);

		for (int x = minValue; x <= maxValue; x++) {
			// System.out.println("trying for " + x);
			Set<Integer> set = new HashSet<Integer>();
			// performing rotations on a number x
			for (int i = 0; i < length; i++) {
				int y = rotate(x, i, length);
				if (x < y && y <= maxValue) {
					if(!set.contains(y)){
						set.add(y);
						result++;
					}
					
				}
			}

		}

		return result;
	}

	private static int rotate(int x, int i, int length) {

		int y;

		int temp = (int) Math.pow(10, i);

		int remainder = x % temp;
		y = x / temp;
		y = y + remainder * (int) (Math.pow(10, (length - i)));

		return y;
	}

	private static List<String> readInput(String filePath)
			throws FileNotFoundException {

		List<String> list = new ArrayList<String>();

		File file = new File(filePath);
		Scanner scanner = new Scanner(file);
		if (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			int testCases = Integer.parseInt(line);
		}
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			// System.out.println(line);
			list.add(line);
		}

		return list;
	}

	private static void writeOutput(int[] list) {

		int n = list.length;

		for (int i = 0; i < n; i++) {
			System.out.println("Case #" + (i + 1) + ": " + list[i]);
		}
	}

}
