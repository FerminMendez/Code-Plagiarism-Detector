package codejam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class RecycledNumbers {

	/**
	 * @param args
	 */

	public boolean isRecycled(char[] f, char[] s) {
		// f.length == s.length;
		char firstChar = f[0];
		int len = f.length;
		boolean match = false;
		for (int i = 0; i < len && !match; i++) {
			if (s[i] == firstChar) {
				int k = i;
				match = true;
				for (int j = 0; j < len && match; j++, k++) {
					if (f[j] != s[k % len]) {
						match = false;
					}
				}
			}
		}
		return match;
	}

	public int getMaxRecycle(int min, int max) {
		int count = 0;
		char[] f;
		char[] s;
		for (int i = min; i < max; i++) {
			f = ("" + i).toCharArray();
			for (int j = i + 1; j < max; j++) {
				s = ("" + j).toCharArray();
				if (f.length == s.length) {
					if (isRecycled(f, s)) {
						count++;
					}
				}
			}
		}
		return count;
	}

	// Input
	// 4
	// 1 9
	// 10 40
	// 100 500
	// 1111 2222
	//
	// Output
	// Case #1: 0
	// Case #2: 3
	// Case #3: 156
	// Case #4: 287

	public static void main(String[] args) {
		RecycledNumbers r = new RecycledNumbers();
		try {
			FileInputStream fstream = new FileInputStream("C-small-attempt0.in");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			FileWriter fwriter = new FileWriter("C-small-attempt0.out");
			BufferedWriter out = new BufferedWriter(fwriter);

			String strLine;
			strLine = br.readLine();
			int testCases = Integer.parseInt(strLine);

			int currentCase = 0;
			String[] input;
			int min, max;
			long start = System.currentTimeMillis();
			while ((strLine = br.readLine()) != null && currentCase < testCases) {
				input = strLine.split(" ");
				min = Integer.parseInt(input[0]);
				max = Integer.parseInt(input[1]);
				if (min > max) {
					min += max;
					max = min - max;
					min -= max;
				}
				out.write("Case #" + ++currentCase + ": "
						+ r.getMaxRecycle(min, max));

				out.newLine();
			}
			System.out.println("Time is: "
					+ (System.currentTimeMillis() - start) * 10E-3 + " Sec.");
			in.close();
			out.close();
		} catch (Exception e) {
			System.err.println("I/O Error while reading file.");
		}
	}
}
