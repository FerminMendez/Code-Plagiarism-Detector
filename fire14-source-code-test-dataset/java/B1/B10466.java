package com.ravi;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class RecycledNumbers {
	private static boolean matches(String a, String b) {
		if (a.equals(b)) {
			return false;
		}
		for (int j = 0; j < a.length(); j++) {
			if (!b.contains("" + a.charAt(j))) {
				return false;
			}
			// Remove the matched character
			b = b.replaceFirst("" + a.charAt(j), "");
		}
		return true;
	}

	private static Integer getRecycledPairs(String A, String B) {
		int a = Integer.parseInt(A);
		int b = Integer.parseInt(B);
		if (a < 10 || b < 10) {
			return 0;
		}

		Set<String> pairs = new HashSet<>();
		for (int n = a; n <= b; n++) {
			for (int m = a + 1; m <= b; m++) {
				if (n < m) {
					String nStr = n + "";
					String mStr = m + "";
					if (matches(nStr, mStr)) {
						for (int i = 0; i < nStr.length() - 1; i++) {
							String newNStr = nStr.substring(i + 1)
									+ nStr.substring(0, i + 1);
							if (newNStr.equals(mStr)) {
								pairs.add(nStr + "," + mStr);
							}
						}
					}
				}
			}
		}
		return pairs.size();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		in.nextLine();
		for (int i = 1; i <= T; i++) {
			String thisLine = in.nextLine();
			String[] AB = thisLine.split(" ");
			System.out.println("Case #" + i + ": "
					+ getRecycledPairs(AB[0], AB[1]));
		}
	}
}