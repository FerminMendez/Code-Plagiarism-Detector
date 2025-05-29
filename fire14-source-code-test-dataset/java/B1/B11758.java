package kjetil.codejam.qualification.recycled;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Set;

public class RecycledNumbers {

	private static final String INPUT_FILENAME = "input_recycled/C-small-attempt0.in";
	private static final String OUTPUT_FILENAME = "output_files/recycled.out";

	static class Pair {
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + m;
			result = prime * result + n;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pair other = (Pair) obj;
			if (m != other.m)
				return false;
			if (n != other.n)
				return false;
			return true;
		}

		private int n, m;
		
		Pair(int n, int m) {
			this.n = n;
			this.m = m;
		}

		public int getN() {
			return n;
		}

		public int getM() {
			return m;
		}
	}
	
	public static void main(String[] args) {

		try {

			FileWriter fstream = new FileWriter(OUTPUT_FILENAME);
			BufferedWriter out = new BufferedWriter(fstream);

			File file = new File(INPUT_FILENAME);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			
			int numberOfTestCases = Integer.parseInt(reader.readLine());
			
			for (int i = 0; i < numberOfTestCases; i++) {
				String[] numberStrings = reader.readLine().split(" ");
				int a = Integer.parseInt(numberStrings[0]);
				int b = Integer.parseInt(numberStrings[1]);
				int numberOfRecycledPairs = getNumberOfRecycledPairs(a, b);
				out.write("Case #" + (i+1) + ": " + Integer.toString(numberOfRecycledPairs) +"\n");
			}
			
			out.close();
			reader.close();
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
	
	private static int getNumberOfRecycledPairs(int a, int b) {
		Set<Pair> pairs = new HashSet<Pair>();
		for (int n = a; n < b; n++) {
			String current = Integer.toString(n);
			for (int j = 1; j < current.length(); j++) {
				String sub = current.substring(j);
				if (sub.charAt(0) != '0') {
					int m = Integer.parseInt(sub+current.substring(0, j));
					if (n < m && m <= b ) {
						pairs.add(new Pair(n, m));
					}
				}
			}
		}
		return pairs.size();
	}
}

