package codejam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class Codejam {

	private static File[] getInputFiles(String filePath) {
		File dir = new File(filePath);
		// filter .in files
		FilenameFilter onlyInFiles = new FilenameFilter() {
			public boolean accept(File file, String name) {
				return name.endsWith(".in") || file.isFile();
			}
		};
		File[] inputFiles = dir.listFiles(onlyInFiles);
		return inputFiles;
	}

	private static BigInteger binomial(final int N, final int K) {
		BigInteger ret = BigInteger.ONE;
		for (int k = 0; k < K; k++) {
			ret = ret.multiply(BigInteger.valueOf(N - k)).divide(
					BigInteger.valueOf(k + 1));
		}
		return ret;
	}

	private static Set<String> getCombinations(String numberStr, int min,
			int max) {
		// System.out.println("numberStr " + numberStr);
		Set<String> allStrings = new HashSet<String>();
		char[] numberStrChars = numberStr.toCharArray();
		String currentNumber;
		int StrLength = numberStrChars.length;
		// System.out.println("StrLength " + StrLength);
		for (int i = 0; i < StrLength - 1; i++) {
			char firstChar = numberStrChars[0];
			for (int j = 1; j < StrLength; j++)
				numberStrChars[j - 1] = numberStrChars[j];
			numberStrChars[StrLength - 1] = firstChar;
			currentNumber = new String(numberStrChars);
			// System.out.println("currentNumber " + currentNumber);
			if (!currentNumber.equals(numberStr)
					&& Integer.parseInt(currentNumber) >= min
					&& Integer.parseInt(currentNumber) <= max)
				allStrings.add(currentNumber);
		}
		return allStrings;
	}

	private static BigInteger getRecycledPairs(int min, int max) {
		//System.out.println("getRecycledPairs start");
		BigInteger recycledPairs = BigInteger.ZERO;
		Set<String> recycledPairStrings = new HashSet<String>();
		for (int i = min; i <= max; i++) {
			String currentNumber = Integer.toString(i);
			if (!recycledPairStrings.contains(currentNumber)) {
				Set<String> currentCombinations = getCombinations(
						currentNumber, min, max);
				if (currentCombinations.size() > 0) {
					recycledPairStrings.addAll(currentCombinations);
					recycledPairs = recycledPairs.add(binomial(
							currentCombinations.size() + 1, 2));
				}
			}
		}
		//System.out.println("getRecycledPairs end " + recycledPairs);
		return recycledPairs;
	}

	private static void processFile(File fileName) {
		System.out.println("Processing file " + fileName);
		try {
			// get reader for current file
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			// create writer using current file + .out
			BufferedWriter bw = new BufferedWriter(new FileWriter(
					fileName.getAbsolutePath() + ".out"));
			// get test cases
			int testCases = Integer.parseInt(br.readLine());
			// process all test cases
			for (int currTestCase = 1; currTestCase <= testCases; currTestCase++) {
				String[] ab = br.readLine().split(" ");
				int A = Integer.parseInt(ab[0]), B = Integer.parseInt(ab[1]);
				BigInteger result = getRecycledPairs(A, B);
				String currTestCaseResult = "Case #" + currTestCase + ": "
						+ result;
				System.out.println(currTestCaseResult);
				bw.write(currTestCaseResult);
				bw.newLine();
			}
			// close the reader and writer
			br.close();
			bw.flush();
			bw.close();
		} catch (Exception e) {// catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("start");
		// get files to process
		File[] inputFiles = getInputFiles("data");
		if (inputFiles != null) {
			for (File inputFile : inputFiles)
				processFile(inputFile);
		}
	}

}
