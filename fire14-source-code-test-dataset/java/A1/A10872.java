package tochi.gcj2012;

import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

import javax.swing.text.html.MinimalHTMLWriter;

public class B {
	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		System.setOut(new PrintStream(new File("output.txt")));
		Scanner sc = new Scanner(new File("input.txt"));
		int T = Integer.parseInt(sc.nextLine());
		for (int i = 1; i <= T; i++) {
			String[] strs = sc.nextLine().split(" ");
			int N = Integer.parseInt(strs[0]);
			int S = Integer.parseInt(strs[1]);
			int p = Integer.parseInt(strs[2]);
			int[] t = new int[N];
			for (int j = 0; j < N; j++) {
				t[j] = Integer.parseInt(strs[3 + j]);
			}
			System.out.println("Case #" + i + ": " + answer(N, S, p, t));
		}
	}

	private static int answer(int N, int S, int p, int[] t) {
		int count = 0;
		int count2 = 0;
		for (int i : t) {
			if (i >= (3 * p - 2))
				count++;
			else if ((i >= (3 * p - 4)) && p >= 2)
				count2++;
		}
		int min = S < count2 ? S : count2;
		return count + min;
	}

}
