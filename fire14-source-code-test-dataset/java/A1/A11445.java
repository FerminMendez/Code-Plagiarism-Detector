package my.codejam.y12.qualification;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class ProblemB {

	static void runIt() throws IOException {

		String inFName = "resource/B-small-attempt0.in";
		// String inFName = "resource/B-large.in";
		String outFName = "resource/B-small.out";
		// String outFName = "resource/B-large.out";

		BufferedReader in = new BufferedReader(new FileReader(inFName));
		PrintWriter out = new PrintWriter(new File(outFName));

		int testCases = Integer.parseInt(in.readLine());

		for (int i = 0; i < testCases; ++i) {

			String line = in.readLine();
			System.out.println(line);
			StringBuilder output = new StringBuilder();
			output.append("Case #" + (i + 1) + ": ");

			int googlers = 0;
			int surprisedGooglers = 0;

			String[] t = line.split(" ");
			int N = Integer.parseInt(t[0]);
			int S = Integer.parseInt(t[1]);
			int p = Integer.parseInt(t[2]);

			for (int j = 3; j < t.length; ++j) {
				int score = Integer.parseInt(t[j]);
				int diff = score - (p * 3);
				if ((p == 1 && diff > -2) || (p != 1 && diff > -3)) {
					googlers++;
				} else if (p != 1 && diff > -5) {
					surprisedGooglers++;
				}
			}

			surprisedGooglers = surprisedGooglers > S ? S : surprisedGooglers;
			googlers += surprisedGooglers;

			output.append(googlers);
			System.out.println(output);
			out.println(output);
		}

		in.close();
		out.flush();
		out.close();
	}

	public static void main(String[] args) {

		try {
			ProblemB.runIt();
		} catch (IOException e) {

			System.out.println(e.getMessage());
			e.printStackTrace();

		} catch (Exception e) {

			System.out.println(e.getMessage());
			e.printStackTrace();

		}
	}
}
