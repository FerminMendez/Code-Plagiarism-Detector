package com.kiwien.google;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DancingWithTheGooglers {

	public static void main(String[] args) {
		final FileInputStream fstream;
		String lineStr;
		final StringBuilder sb = new StringBuilder();

		try {
			fstream = new FileInputStream("./testdata/test.in");
			final DataInputStream in = new DataInputStream(fstream);
			final BufferedReader br = new BufferedReader(new InputStreamReader(in));
			final int testNum = Integer.parseInt(br.readLine());
			
			if (testNum <= 0 || testNum > 100) {
				return;
			}

			for (int i = 0; i < testNum; i++) {
				lineStr = br.readLine();
				sb.append("Case #" + (i + 1) + ": " + process(lineStr) + "\n");
			}

			writeToFile(sb.toString());
			System.out.println(sb.toString());
			System.out.println("Finished.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void writeToFile(String str) {
		BufferedWriter writer = null;
		try {
			File out = new File("./results/dancing.out");
			writer = new BufferedWriter(new FileWriter(out));
			writer.write(str);
			System.out.println("Test result saved to " + out.getAbsolutePath());

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (writer != null)
					writer.close();
			} catch (IOException e) {
			}
		}
	}

	private static String process(String inputStr) {
		String[] input = inputStr.split(" ");
		if (input.length >= 3) {
			int n = Integer.parseInt(input[0]);
			if (n < 0 || n > 100) {
				return "";
			}
			int s = Integer.parseInt(input[1]);
			if (s < 0 || s > n) {
				return "";
			}

			int p = Integer.parseInt(input[2]);
			if (p < 0 || p > 10) {
				return "";
			}

			List<Integer> totalPoints = new ArrayList<Integer>();

			for (int i = 3; i < input.length; i++) {
				int totalPoint = Integer.parseInt(input[i]);
				if (totalPoint < 0 || totalPoint > 30) {
					return "";
				}
				totalPoints.add(totalPoint);
			}

			return "" + getMaximumNum(n, s, p, totalPoints.toArray(new Integer[0]));
		}
		return "invalid";
	}

	/**
	 * 
	 * @param n googler number
	 * @param s surprising number
	 * @param p maximum result
	 * @param totalPoints
	 * @return
	 */
	public static int getMaximumNum(Integer n, Integer s, Integer p, Integer[] totalPoints) {
		int count = 0;
		for (int t : totalPoints) {
			int nonSurprisingMax = 3 * p - 2;
			int surprisingMax = 3 * p - 4;
			
			if (t >= nonSurprisingMax) {
				count++;
			} else if (s > 0 && t >= 2 && t <= 28) {
				if (t >= surprisingMax) {
					count++;
					s--;
				}
			}
		}
		return count;
	}

}
