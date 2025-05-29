package gs.taral.gcj2012;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Dancing {
	public static void main(String[] args) throws NumberFormatException, IOException {
		List<String> input = readInput(args[0]);
		List<String> output = solve(input);
		writeOutput(args[1], output);
	}

	private static String solveCase(String line) {
		String[] tokens = line.split(" ");
		int n = Integer.parseInt(tokens[0]);
		int s = Integer.parseInt(tokens[1]);
		int p = Integer.parseInt(tokens[2]);
		int[] t = new int[n];
		for (int i = 3; i < tokens.length; i++)
			t[i - 3] = Integer.parseInt(tokens[i]);
		int definitely = 0;
		int possibly = 0;
		for (int score : t) {
			if (score >= 3 * p - 2)
				definitely++;
			else if (p > 1 && score >= 3 * p - 4 )
				possibly++;
		}
		int result = definitely + Math.min(possibly, s);
		return String.valueOf(result);
	}

	private static List<String> solve(List<String> input) {
		List<String> output = new ArrayList<String>();
		for (String line : input)
			output.add(solveCase(line));
		return output;
	}

	private static List<String> readInput(String filename) throws FileNotFoundException,
			IOException {
		BufferedReader in = new BufferedReader(new FileReader(filename));
		List<String> input = new ArrayList<String>();
		int n = Integer.parseInt(in.readLine());
		while (true) {
			String line = in.readLine();
			if (line == null)
				break;
			input.add(line);
		}
		if (input.size() != n)
			throw new IllegalArgumentException();
		return input;
	}

	private static void writeOutput(String filename, List<String> output) throws IOException {
		PrintWriter out = new PrintWriter(new FileWriter(filename));
		for (int i = 0; i < output.size(); i++) {
			int caseNumber = i + 1;
			String line = output.get(i);
			out.println("Case #" + caseNumber + ": " + line);
		}
		out.close();
	}
}
