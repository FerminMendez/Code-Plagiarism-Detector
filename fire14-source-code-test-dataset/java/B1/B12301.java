package com.phonescreen;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;

public class RecycledNumber {

	private static int count;

	public static void main(String[] args) {
		try {
			DataInputStream br = new DataInputStream(new BufferedInputStream(new FileInputStream(new File("H:\\C-small-attempt1.in"))));
			String s = br.readLine();
			count = Integer.parseInt(s);
			if (count < 1 || count > 50) {
				return;
			}
			for (int i = 0; i < count; i++) {
				String[] testCase = br.readLine().split(" ");
				if (testCase[0].length() != testCase[1].length()) {
					return;
				}
				int a = Integer.parseInt(testCase[0]);
				int b = Integer.parseInt(testCase[1]);
				if (a < 1 || b > 1000 || a > b) {
					return;
				}
				 System.out.println("Case #" + ( i+1) + ": " + getRecycledNumberCount(a, b));
			}

		} catch (Exception e) {
			System.err.println("Error:" + e.getMessage());
		}
	}

	private static int getRecycledNumberCount(int a, int b) {
		int count = 0;
		for (int i = a; i <= b; i++) {
			for (int j = i; j <= b; j++) {
				if (isRecycledNumbers(i + "", j + "")) {
					count++;
				}
			}
		}
		return count;
	}

	private static boolean isRecycledNumbers(String num1, String num2) {
		for (int i = 0; i < num1.length(); i++) {
			if (num2.indexOf(num1.charAt(i)) == -1 || num1.indexOf(num2.charAt(i)) == -1) {
				return false;
			}
		}
		for (int i = num1.length() - 1; i >= 0; i--) {
			String subStr = num1.substring(i);
			if (num2.indexOf(subStr) == -1) {
				subStr = num1.substring(i + 1);
				String s = subStr + num1.substring(0, (num1.length() - subStr.length()));
				if (s.equals(num2)) {
					return true;
				}
			}
		}
		return false;
	}
}
