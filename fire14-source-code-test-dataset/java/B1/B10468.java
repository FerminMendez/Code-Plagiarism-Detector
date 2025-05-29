package CodeJam2012;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class RecycledNumbers {
	public static void main(String[] args) throws IOException {
		FileReader in = new FileReader("C-small-attempt0.in");
		BufferedReader buff = new BufferedReader(in);
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"C-small-attempt0.out")));

		int nCases = Integer.parseInt(buff.readLine());
		StringBuilder output = new StringBuilder("");

		for (int i = 0; i < nCases; i++) {
			String input = buff.readLine();
			output.append("Case #" + (i + 1) + ": " + getPairs(input) + "\n");
		}
		out.print(output.toString());
		in.close();
		out.close();
	}

	private static long getPairs(String input) {
		StringTokenizer st = new StringTokenizer(input);
		String first = st.nextToken();
		String second = st.nextToken();
		int from = Integer.parseInt(first);
		int to = Integer.parseInt(second);
		long counter = 0;

		HashSet<String> set = new HashSet<String>();
		for (int i = from; i <= to; i++) {
			String temp = i + "";
			for (int j = 0; j < temp.length(); j++) {
				String next = temp.substring(j, temp.length())
						+ temp.substring(0, j);
				int x = Integer.parseInt(next);
				if (x <= to && x >= from && i < x
						&& !set.contains(temp + "$" + next)) {
					counter++;
					set.add(temp + "$" + next);
				}
			}
		}
		return counter;
	}
}
