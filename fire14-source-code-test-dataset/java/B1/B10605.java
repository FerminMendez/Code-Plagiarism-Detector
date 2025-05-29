package google.code.jam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;

public class RecycledNumbers {

	final static String fileNameIn = "C-small-attempt0.in";
	final static String fileNameOut = "C-small-attempt0.out";

	private static int solve(int A, int B) {
		HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
		for (int i = A; i <= B; i++) {
			String n = new Integer(i).toString();
			String key = minimum(n);
			if (Integer.valueOf(n) >= A && Integer.valueOf(n) <= B) {
				if (!hashMap.containsKey(key)) {
					hashMap.put(key, 1);
				} else {
					hashMap.put(key, hashMap.get(key) + 1);
				}
			}
		}
		int count = 0;
		for (String key : hashMap.keySet()) {
			Integer value = hashMap.get(key);
			count = count + (value * (value - 1) / 2);
		}
		return count;
	}

	private static String minimum(String input) {
		String min = input;
		for (int i = 0; i < input.length(); i++) {
			if (Integer.valueOf(shift(input, i)) < Integer.valueOf(min)) {
				min = shift(input, i);
			}
		}
		return min;
	}

	private static String shift(String input, int n) {
		return input.substring(n, input.length()) + input.substring(0, n);
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
			int A = iterator.next();
			int B = iterator.next();
			out.write(String.format("Case #%s: %s\n", i + 1, solve(A, B)));
		}
		in.close();
		out.close();
	}

}
