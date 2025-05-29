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

public class RecycledNumbers {

	public static void main(String[] args) {
		final FileInputStream fstream;
		String lineStr;
		final StringBuilder sb = new StringBuilder();

		try {
			fstream = new FileInputStream("./testdata/test.in");
			final DataInputStream in = new DataInputStream(fstream);
			final BufferedReader br = new BufferedReader(new InputStreamReader(in));
			final int testNum = Integer.parseInt(br.readLine());

			if (testNum <= 0 || testNum > 50) {
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
			final File out = new File("./results/dancing.out");
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
		final String[] input = inputStr.split(" ");
		final int a = Integer.parseInt(input[0]);
		final int b = Integer.parseInt(input[1]);
		final String aDigit = "" + a;
		final String bDigit = "" + b;

		if (a >= 1 && b >= a && b <= 2000000 && aDigit.length() == bDigit.length()) {
			return "" + getRecycledPairNumber(a, b);
		} else {
			return "invalid";
		}
	}

	public static int getRecycledPairNumber(int a, int b) {
		if (a < 10) {
			return 0;
		}

		int count = 0;
		for (int i = a; i <= b - 1; i++) {
			for (int j = i + 1; j <= b; j++) {
				if (isRecycled(i, j)) {
					count++;
				}
			}
		}
		return count;
	}

	private static boolean isRecycled(int m, int n) {
		final String mStr = "" + m;
		final String nStr = "" + n;
		for (int i = 1; i < mStr.length(); i++) {
			if (mStr.charAt(i) != '0') {
				final String newStr = mStr.substring(i) + mStr.substring(0, i);
				if (newStr.equals(nStr)) {
					return true;
				}
			}
		}
		return false;
	}
}
