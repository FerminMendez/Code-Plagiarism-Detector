import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

public class ProblemB {
	private static List<Integer> digits100(int i) {
		List<Integer> digits = new ArrayList<Integer>();
		while (i > 0) {
			digits.add(i % 10);
			i /= 10;
		}
		Collections.sort(digits);
		return digits;
	}

	private static List<Integer> firstDigits1000(int i) {
		List<Integer> digits = new ArrayList<Integer>();
		digits.add(i % 10);
		digits.add((i - (i % 10)) / 10);
		Collections.sort(digits);
		return digits;
	}

	private static List<Integer> secondDigits1000(int i) {
		List<Integer> digits = new ArrayList<Integer>();
		digits.add(i % 100);
		digits.add((i - (i % 100)) / 100);
		Collections.sort(digits);
		return digits;
	}

	public static void main(String[] args) throws NumberFormatException,
			IOException {

		BufferedReader br = new BufferedReader(new FileReader("C-small-attempt0.in"));
		PrintWriter out = new PrintWriter(new FileWriter("output.txt"));

		ArrayList<List<Integer>> digitsList = new ArrayList<List<Integer>>();
		LinkedHashSet<List<Integer>> digitsSet = new LinkedHashSet<List<Integer>>();

		int testCases = Integer.parseInt(br.readLine());
		for (int i = 1; i <= testCases; i++) {
			out.print("Case #"+i+": ");
			String[] str = br.readLine().split(" ");
			int int1 = Integer.parseInt(str[0]);
			int int2 = Integer.parseInt(str[1]);
			for (int j = int1; j <= int2; j++) {
				if (j < 100) {
					digitsList.add(digits100(j));
					digitsSet.add(digits100(j));
				} else if (j < 1000) {
					if (firstDigits1000(j).get(1) > 9) {
						digitsList.add(firstDigits1000(j));
						digitsSet.add(firstDigits1000(j));
					}
					if (!firstDigits1000(j).equals(secondDigits1000(j))
							&& secondDigits1000(j).get(1) > 9) {
						digitsList.add(secondDigits1000(j));
						digitsSet.add(secondDigits1000(j));
					}

				}
			}
			out.println(digitsList.size() - digitsSet.size());
			for (List<Integer> li : digitsSet) {
				digitsList.remove(digitsList.indexOf(li));
			}
			System.out.println(digitsList.toString());
			System.out.println(digitsList.size());
			// System.out.println(digitsSet.toString());
			// System.out.println(firstDigits1000(100));
			// System.out.println(secondDigits1000(100));
			digitsSet.clear();
			digitsList.clear();
		}

		out.close();
	}

}
