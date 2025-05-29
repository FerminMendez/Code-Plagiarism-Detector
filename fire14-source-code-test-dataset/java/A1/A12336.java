package codejam;

/**
 * @author kaaja
 *
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;

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
				String testCaseLine = br.readLine();
				String[] testCaseLineNumbers = testCaseLine.split(" ");
				int N = Integer.parseInt(testCaseLineNumbers[0]);
				int S = Integer.parseInt(testCaseLineNumbers[1]);
				int p = Integer.parseInt(testCaseLineNumbers[2]);
				int minNormalGradesLimit = Math.max(p * 3 - 2, 0);
				int minSurprisingGradesLimit = Math.max(minNormalGradesLimit - 2, 0);
				int normalBestResults = 0;
				int surprisingBestResults = 0;
				for (int i = 0; i < N; i++) {
					int currentGrades = Integer
							.parseInt(testCaseLineNumbers[3 + i]);
					if (currentGrades >= minNormalGradesLimit)
						normalBestResults++;
					else if (currentGrades >= minSurprisingGradesLimit && surprisingBestResults < S && currentGrades > 0)
						surprisingBestResults++;
				}
				String result = Integer.toString(normalBestResults
						+ surprisingBestResults);
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
