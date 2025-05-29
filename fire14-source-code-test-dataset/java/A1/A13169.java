package probs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Problem2 {

	public static void main(String[] args) {

		try {

			String filePath = "in-small-2.txt";

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
			int googlers = Integer.parseInt(split[0]);
			int surprisesAllowed = Integer.parseInt(split[1]);
			int criteriaBestScore = Integer.parseInt(split[2]);
			int[] totals = new int[googlers];
			for (int i = 0; i < googlers; i++) {
				totals[i] = Integer.parseInt(split[i + 3]);
			}
			int maxGooglersWithAtleaseRequiredBestResult = processEachTestCase(surprisesAllowed, criteriaBestScore, totals);
			result[count] = maxGooglersWithAtleaseRequiredBestResult;

			count++;
		}

		return result;
	}

	private static int processEachTestCase(int surprisesAllowed,
			int bestScore, int[] totals) {

		int result = 0;

		int maxRange = 2*(bestScore+1);
		int minRange = 2*(bestScore-1);
		if (maxRange>18) {
			maxRange=18;
		}
		if (minRange<0) {
			minRange=0;
		}

		int furtherMaxRange = 2*(bestScore+2);
		int furtherMinRange = 2*(bestScore-2);
		if (furtherMaxRange>18) {
			furtherMaxRange=18;
		}
		if (furtherMinRange<0) {
			furtherMinRange=0;
		}

		int surpriseCounter=0;

		for (int i = 0; i < totals.length; i++) {

			int eachTotal = totals[i];

			if (eachTotal>=3*bestScore) { // 333 to infinity
				result++;
			}else{			
				if(eachTotal>=(bestScore+minRange) && eachTotal<=(bestScore+maxRange)){ // 322 to 344
					result++;
				}else{
					if(eachTotal<(bestScore+minRange) && eachTotal>=(bestScore+furtherMinRange)){ // 311 to 321
						if (surpriseCounter<surprisesAllowed) {
							result++;
							surpriseCounter++;
						}
					}else if(eachTotal>(bestScore+maxRange) && eachTotal<=(bestScore+furtherMaxRange)){ // 345 to 355
						if (surpriseCounter<surprisesAllowed) {
							result++;
							surpriseCounter++;
						}
					}
				}
			}
		}
		
		return result;
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
			//System.out.println(line);
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
