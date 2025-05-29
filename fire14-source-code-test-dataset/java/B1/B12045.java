package RecycledNumbers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class RecyledNumbers {

	public RecyledNumbers() {

	}

	public static int findRecycled(int low, int high) {
		Set<Pair> pairs = new HashSet<Pair>();
		for (int i = low; i <= high; i++) {
			String s = String.valueOf(i);
			for (int j = 1; j < s.length(); j++) {
				String newString = s.substring(j) + s.substring(0, j);
				int newValue = Integer.parseInt(newString);
				if (newValue <= high && newValue >= low && newValue != i
						&& !newString.startsWith("0")) {
					if (!pairs.contains(new Pair(newValue, i))) {
						pairs.add(new Pair(i, newValue));
					}
				}
			}

		}
		return pairs.size();
	}

	private static int parse(String input) {
		StringTokenizer st = new StringTokenizer(input, " ");
		if (st.countTokens() != 2)
			throw new IllegalArgumentException("Wrong no of values");
		int low = Integer.parseInt(st.nextToken());
		int high = Integer.parseInt(st.nextToken());

		return findRecycled(low, high);
	}

	public static void main(String[] args) {
		if (args.length != 2)
			throw new IllegalArgumentException("No file specified");

		List<String> data = new ArrayList<String>();
		List<String> results = new ArrayList<String>();
		try {
			FileInputStream fstream = new FileInputStream(args[0]);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			while ((strLine = br.readLine()) != null) {
				data.add(strLine);
			}
			in.close();
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}

		if (data.size() == 0)
			throw new IllegalArgumentException("No data in file");

		int noTestCases = Integer.parseInt(data.get(0));
		if (data.size() != noTestCases + 1)
			throw new IllegalArgumentException("Number of test cases is not "
					+ noTestCases);

		for (int i = 1; i <= noTestCases; i++) {
			results.add("Case #" + i + ": " + parse(data.get(i)));
		}

		try {
			FileWriter fostream = new FileWriter(args[1]);
			BufferedWriter out = new BufferedWriter(fostream);
			for (int i =0;i<results.size();i++) {
				String s = results.get(i);
				out.write(s);
				if (i<results.size()-1)
					out.newLine();
			}
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
