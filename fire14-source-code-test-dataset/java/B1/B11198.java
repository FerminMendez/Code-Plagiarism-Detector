/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Jeric Bryle Sy Dy
 */
public class GJamC2 {

	private static class Ref {

		public int cnt;
		public Set<String> set;

		public Ref() {
			cnt = 0;
			set = new HashSet<String>();
		}
	}

	private static void permuteMove(char[] arr, int len, String strN, String strB, Ref ref) {
		int arrLen = arr.length;
		char[] result = new char[arrLen];

		int index = 0;
		for (int i = arrLen - len; i < arrLen; ++i) {
			result[index++] = arr[i];
		}
		for (int i = 0; i < arrLen - len; ++i) {
			result[index++] = arr[i];
		}

		String strCur = new String(result);
		if (strCur.compareTo(strN) > 0 && strCur.compareTo(strB) <= 0 && !ref.set.contains(strCur)) {
			ref.set.add(strCur);
			++ref.cnt;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("C:/Users/Jeric Bryle Sy Dy/Downloads/C-small-attempt0.in"));
		PrintWriter out = new PrintWriter("C:/Users/Jeric Bryle Sy Dy/Downloads/C-small-attempt0.out");

		int t = Integer.parseInt(br.readLine());

		for (int tIter = 0; tIter < t; ++tIter) {
			Scanner s = new Scanner(br.readLine());

			int a = s.nextInt();
			int b = s.nextInt();

			Ref ref = new Ref();

			for (int n = a; n < b; ++n) {
				ref.set.clear();
				String strN = String.valueOf(n);
//				permute(strN.toCharArray(), 0, strN, String.valueOf(b), 1, ref);
				for (int len = 1; len < strN.length(); len++) {
					permuteMove(strN.toCharArray(), len, strN, String.valueOf(b), ref);
				}
			}

			s.close();

			out.printf("Case #%d: %d\n", tIter + 1, ref.cnt);
		}

		br.close();
		out.close();
	}
}
