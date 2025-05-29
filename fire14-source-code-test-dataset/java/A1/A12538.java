package small;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class DancingGooglers {
	private static int noOfCases;
	private static int[] noOfGooglers;
	private static int[] noOfSurprisingTriplets;
	private static int[] bestResult;
	private static int[][] scores;
	private static String[] result;

	public static void main(String[] args) {

		readInputFile();
		result = new String[noOfCases];

		for (int i = 0; i < noOfCases; i++) {
			int totalSum = 0;
			int surprisingCount = 0;
			for (int j = 0; j < noOfGooglers[i]; j++) {
				// System.out.print(" "+scores[i][j]);
				if (scores[i][j] >= bestResult[i]) {
					if ((scores[i][j] - bestResult[i]) / 2 >= bestResult[i] - 2) {
						totalSum++;
						if ((scores[i][j] - bestResult[i]) / 2 == bestResult[i] - 2) {
							surprisingCount++;
						}
					}
				}

			}

			if (surprisingCount > noOfSurprisingTriplets[i]) {
				totalSum = totalSum
						- (surprisingCount - noOfSurprisingTriplets[i]);
			}
			System.out.println();
			System.out.println("Case #" + (i + 1) + ": " + totalSum);
			result[i] = "Case #" + (i + 1) + ": " + totalSum;

		}

		writeToFile(result);

	}

	private static void readInputFile() {

		try {
			FileInputStream fstream = new FileInputStream("B-small-attempt0.in");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			noOfCases = Integer.parseInt(br.readLine());
			String strLine;
			scores = new int[noOfCases][];
			noOfGooglers = new int[noOfCases];
			noOfSurprisingTriplets = new int[noOfCases];
			bestResult = new int[noOfCases];
			for (int i = 0; i < noOfCases; i++) {
				strLine = br.readLine();
				String[] temp = strLine.split(" ");
				noOfGooglers[i] = Integer.parseInt(temp[0]);
				noOfSurprisingTriplets[i] = Integer.parseInt(temp[1]);
				bestResult[i] = Integer.parseInt(temp[2]);
				scores[i] = new int[noOfGooglers[i]];

				// System.out.println("No of Googlers: "+noOfGooglers);
				// System.out.println("No of surp trip: "+noOfSurprisingTriplets);
				// System.out.println("Best Result: "+bestResult);

				for (int j = 0; j < noOfGooglers[i]; j++) {
					scores[i][j] = Integer.parseInt(temp[3 + j]);
					System.out.println(scores[i][j]);
				}

			}

			in.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Error: " + e.getMessage());
		}
	}

	public static void writeToFile(String args[]) {
		try {
			FileWriter fstream = new FileWriter("B-small-attempt0.out");
			BufferedWriter out = new BufferedWriter(fstream);
			for (int i = 0; i < args.length; i++) {
				out.write(args[i]);
				if (i != args.length - 1)
					out.newLine();
			}
			out.close();
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}

}
