package google.code.jam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class DancingWithTheGooglers {

	final static String fileNameIn = "B-small-attempt0.in";
	final static String fileNameOut = "B-small-attempt0.out";

	private static int solve(int S, int p, List<Integer> t) {
		int count = 0;
		for (int i = 0; i < t.size(); i++) {
			int bestResultNotSurprising = getBestResultNotSurprising(t.get(i));
			int bestResultSurprising = getBestResultSurprising(t.get(i));
			if (bestResultNotSurprising >= p) {
				count++;
			} else if (bestResultSurprising >= p && S > 0) {
				count++;
				S--;
			}
		}
		return count;
	}

	private static int getBestResultNotSurprising(int n) {
		return getBestResult(n, false);
	}

	private static int getBestResultSurprising(int n) {
		return getBestResult(n, true);
	}

	private static int getBestResult(int n, boolean surprising) {
		int average = (int) Math.floor(n / 3);
		int residue = n % 3;
		if (n == 0)
			return 0;
		if (surprising && residue == 0)
			return average + 1;
		if (surprising && residue == 1)
			return average + 1;
		if (surprising && residue == 2)
			return average + 2;
		if (!surprising && residue == 0)
			return average;
		if (!surprising && residue == 1)
			return average + 1;
		if (!surprising && residue == 2)
			return average + 1;
		return average;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(fileNameIn));
		BufferedWriter out = new BufferedWriter(new FileWriter(fileNameOut));
		int testCases = Integer.parseInt(in.readLine());
		for (int i = 0; i < testCases; i++) {
			String[] elements = in.readLine().split(
					new Character((char) 32).toString());
			List<Integer> values = new ArrayList<Integer>();
			for (String v : elements) {
				values.add(Integer.valueOf(v));
			}
			ListIterator<Integer> iterator = values.listIterator();
			int N = iterator.next();
			int S = iterator.next();
			int p = iterator.next();
			List<Integer> t = values.subList(values.size() - N, values.size());
			out.write(String.format("Case #%s: %s\n", i + 1, solve(S, p, t)));
		}
		in.close();
		out.close();
	}

}
