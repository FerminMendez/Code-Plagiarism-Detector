package com.wenod.googlerese.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class GooglereseConverter {

	public static void main(String arg[]) throws NumberFormatException,
			IOException {

		FileInputStream inputreader = new FileInputStream("B-small-attempt3.in");

		DataInputStream in = new DataInputStream(inputreader);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));

		String strLine;

		int input = Integer.parseInt(br.readLine());

		for (int k = 0; k < input; k++) {
			strLine = br.readLine();
			String[] values = strLine.split(" ");

			int numberOfGooglers = Integer.parseInt(values[0]);

			int numberOfSurprisingTriplets = Integer.parseInt(values[1]);
			int numberOfSurprized = 0;
			int resultLimit = Integer.parseInt(values[2]);

			System.out.print(numberOfGooglers + " "
					+ numberOfSurprisingTriplets + " " + resultLimit + " --> ");

			int numberOfBestResult = 0;
			PrintWriter output = new PrintWriter(new BufferedWriter(
					new FileWriter("output.txt", true)));
			output.write("Case #" + (k + 1) + ": ");
			for (int i = 0; i < numberOfGooglers; i++) {
				int val = Integer.parseInt(values[i + 3]);
				System.out.print(val + " ");

				int testingValue = ((resultLimit * 2) - (val - resultLimit));
				if (val >= ((testingValue * 3) - 4)) {
					if (testingValue == 4 || testingValue == 3) {
						if (numberOfSurprized < numberOfSurprisingTriplets) {
							numberOfSurprized++;
							numberOfBestResult++;
						}
					} else if (testingValue < 3) {
						numberOfBestResult++;
					}
				}

			}
			System.out.println(" --> " + numberOfBestResult);
			output.write(Integer.toString(numberOfBestResult));
			output.println();
			output.close();
		}

		in.close();

	}
}
