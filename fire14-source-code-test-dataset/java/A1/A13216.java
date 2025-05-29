package com.google.codejam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

public class DancingGooglers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String input = null;
		// String outputFileLocation =
		// "C:\\google-code-jam\\output\\B-large-output.txt";
		String outputFileLocation = "C:\\google-code-jam\\output\\B-small-output.txt";
		// String inputFileLocation =
		// "C:\\google-code-jam\\input\\B-large-practice.in";
		String inputFileLocation = "C:\\google-code-jam\\input\\B-small-practice.in";
		File outputFile = new File(outputFileLocation);

		BufferedWriter outputWriter = null;
		DataInputStream in = null;
		int caseNum = 1;
		int count = 0;
		String appCount = "";

		try {
			outputWriter = new BufferedWriter(new FileWriter(outputFile));

			// Open the file that is the first
			// command line parameter
			FileInputStream fstream = new FileInputStream(inputFileLocation);

			// Get the object of DataInputStream
			in = new DataInputStream(fstream);

			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine = null;

			int numtestCases = 1;

			int numofGooglers = 0;
			int numberofSurprisingTriplet = 0;
			int optimalValue = 0;

			numtestCases = new Integer(br.readLine()).intValue();

			// Read File Line By Line
			for (int i = 1; i <= numtestCases; i++) {

				// get credit from file
				input = br.readLine();

				// System.out.println("##  " + i + " " + input);

				String[] a = input.split("\\s");
				// System.out.println("a = " + a);

				numofGooglers = Integer.parseInt(a[0]);
				numberofSurprisingTriplet = Integer.parseInt(a[1]);
				optimalValue = Integer.parseInt(a[2]);

				// System.out.println("numofGooglers = " + numofGooglers);
				// System.out.println("numberofSurprisingTriplet = "
				// + numberofSurprisingTriplet);
				// System.out.println("optimal value = " + optimalValue);

				int answer = 0;
				int usedNumofSurprisingTroplets = 0;
				for (int j = 3; j < numofGooglers + 3; j++) {
					int totalScore = Integer.parseInt(a[j]);

					int quotient = totalScore / 3;
					int remainder = totalScore % 3;

					// System.out.println("Quotient = " + quotient);
					// System.out.println("remainder = " + remainder);
					// System.out.println("optimal value = " + optimalValue);

					if (quotient >= optimalValue) {
						answer++;

					} else if (quotient == 0 && remainder > 0) {
						if (remainder >= optimalValue && optimalValue <= 1) {
							answer++;
						}

					} else if (quotient > 0 && quotient < optimalValue
							&& remainder > 0) {

						if (quotient + 1 == optimalValue) {
							answer++;
						} else if (quotient + 2 == optimalValue) {
							if (numberofSurprisingTriplet > 0
									&& usedNumofSurprisingTroplets <= numberofSurprisingTriplet) {
								usedNumofSurprisingTroplets++;
								numberofSurprisingTriplet--;

								System.out.println("111 used "
										+ usedNumofSurprisingTroplets);
								System.out
										.println("111 numberofSurprisingTriplet "
												+ numberofSurprisingTriplet);

								answer++;
							}
						}

					} else if (quotient > 0 && quotient < optimalValue
							&& remainder == 0) {
						// System.out.println("22222 quotient " + quotient);
						if (quotient + 1 == optimalValue) {
							/*
							 * System.out.println("222 numberofSurprisingTriplet "
							 * + numberofSurprisingTriplet);
							 */
							if (numberofSurprisingTriplet > 0
									&& usedNumofSurprisingTroplets <= numberofSurprisingTriplet) {
								usedNumofSurprisingTroplets++;
								numberofSurprisingTriplet--;
								/*
								 * System.out.println("222 used " +
								 * usedNumofSurprisingTroplets);
								 */
								answer++;
							}
						}
					}

					// outputWriter.write("Case #" + i + ": " + arrSoln[0] + " "
					// + arrSoln[1]);

					// outputWriter.newLine();

				}// inner for loop

				// System.out.println("used " + usedNumofSurprisingTroplets);
				// System.out.println("Case #" + i + ": " + answer);
				outputWriter.write("Case #" + i + ": " + answer);
				outputWriter.newLine();

			}// test case for loop

			// Close the input stream
			in.close();

			// Close the output stream
			outputWriter.close();

			System.out.println("Done");
		} catch (IOException e) // Catch exception if any
		{
			System.err.println("IO Error: " + e.getMessage());
		} catch (Exception e) // Catch exception if any
		{
			System.err.println("Error: " + e.getMessage());
		}

	}

}
