package codjamdoce;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class RecycledNumbers {

	private final File file;
	private int ncases;
	private int[] result;
	private NumberSet[] cases;

	public RecycledNumbers(File file) {
		this.file = file;
	}

	public void init() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(file));
		try {
			String line;
			int lineNumber = 0;
			while ((line = reader.readLine()) != null) {
				if (lineNumber == 0) {
					ncases = Integer.valueOf(line.trim());
					result = new int[ncases];
					cases = new NumberSet[ncases];
				} else {
					int index = 0;
					StringTokenizer tokenizer = new StringTokenizer(line.trim(), " ");

					int a = 0;
					int b = 0;
					while (tokenizer.hasMoreElements()) {
						String next = tokenizer.nextToken();

						if (index == 0) {
							a = Integer.valueOf(next);
						} else {
							b = Integer.valueOf(next);
						}
						index++;
					}
					cases[lineNumber - 1] = new NumberSet(a, b);
				}
				lineNumber++;
			}
		} finally {
			reader.close();
		}
	}

	public void getRecycledNumbers() {
		int count = 0;
		for (NumberSet numberset : cases) {
			result[count] = numberset.getRecycledNumbers();
			count++;
		}
	}

	public void printResult() throws Exception {
		int count = 0;
		File outfile = new File("out");
		if (outfile.exists())
			outfile.delete();
		outfile.createNewFile();
		FileOutputStream out = new FileOutputStream(outfile);
		try {
			for (int r : result) {
				if (count == ncases - 1) {
					out.write(MessageFormat.format("Case #{0}: {1}", (count + 1), r).getBytes());
				} else {
					out.write(MessageFormat.format("Case #{0}: {1}\n", (count + 1), r).getBytes());
				}
				count++;
			}
		} finally {
			out.close();
		}
	}

	private static class NumberSetCandidate implements Comparable<NumberSetCandidate> {

		private final int n;
		private final int m;

		public NumberSetCandidate(int n, int m) {
			this.n = n;
			this.m = m;
		}

		@Override
		public int compareTo(NumberSetCandidate o) {
			if (this.n == o.n && this.m == o.m) {
				return 0;
			}
			return -1;
		}

		public int getN() {
			return n;
		}

		public int getM() {
			return m;
		}

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
			NumberSetCandidate other = (NumberSetCandidate) obj;
			if (m != other.m)
				return false;
			if (n != other.n)
				return false;
			return true;
		}

		public String toString() {
			return "[ " + n + ", " + m + "]";
		}
	}

	private static class NumberSet {

		private int nMin;
		private int mMin;

		private int max;
		List<NumberSetCandidate> candidates = new ArrayList<NumberSetCandidate>();

		public NumberSet(int a, int b) {
			nMin = a;

			mMin = a + 1;
			max = b;
		}

		public int getRecycledNumbers() {
			populateCandidates();

			if (candidates.size() == 0) {
				return 0;
			}

			for (NumberSetCandidate candidate : new ArrayList<NumberSetCandidate>(candidates)) {
				int candidaten = candidate.getN();
				int candidatem = candidate.getM();

				String cnvalue = String.valueOf(candidaten);
				int[] set = new int[cnvalue.length()];
				int count = 0;
				for (char c : cnvalue.toCharArray()) {
					set[count] = Integer.valueOf(String.valueOf(c));
					count++;
				}
				try {
					Permutations perm = new Permutations();
					perm.permutations(set, set.length);
					String cmvalue = String.valueOf(candidatem);
					if (!perm.contains(cmvalue)) {
						candidates.remove(candidate);
					} else {
						boolean remove = true;
						int length = cnvalue.length();
						int cnt = 1;
						while (length > 0) {
							LinkedList<String> tailNumbers = new LinkedList<String>();
							for (int i=(cnvalue.length()-cnt); i < length;i++) {
								tailNumbers.addFirst(cnvalue.substring(i));
							}
							StringBuilder builder = new StringBuilder();
							for (String s : tailNumbers) {
								builder.append(s);
							}
							builder.append(cnvalue.substring(0, length-1));
							
							if (builder.toString().equals(cmvalue)) {
								remove = false;
								break;
							}
							cnt++;
							length--;
						}
						if (remove) {
							candidates.remove(candidate);
						}
					}
					
				} catch (Throwable t) {
					t.printStackTrace();
				}
			}

			int size = candidates.size();
			return size;
		}

		private void populateCandidates() {
			int n = nMin;
			int m = mMin;

			while (n < m && m <= max) {
				int innerM = m;
				String nvalue = String.valueOf(n);
				while (innerM <= max) {

					String mvalue = String.valueOf(innerM);
					boolean candidate = nvalue.length() == mvalue.length();
					for (char c : nvalue.toCharArray()) {
						if (mvalue.indexOf(c) < 0) {
							candidate = false;
							break;
						}
					}

					if (candidate) {
						for (char c : mvalue.toCharArray()) {
							if (nvalue.indexOf(c) < 0) {
								candidate = false;
								break;
							}
						}
					}

					if (candidate) {
						boolean cont = true;
						for (char c : mvalue.toCharArray()) {
							if (getMatches(c, nvalue) != getMatches(c, mvalue)) {
								cont = false;
							}
						}
						if (cont) {
							NumberSetCandidate cand = new NumberSetCandidate(n, innerM);
							if (!candidates.contains(cand)) {
								candidates.add(cand);
							}
						}
					}
					innerM++;
				}

				n++;
				m++;
			}
		}

		private int getMatches(char c, String toMatch) {
			int matches = 0;
			for (char t : toMatch.toCharArray()) {
				if (c == t) {
					matches++;
				}
			}
			return matches;
		}
	}

	private static class Permutations extends ArrayList<String> {

		private static final long serialVersionUID = 3487304820400778585L;
		private List<String> failedTries = new ArrayList<String>();

		private void permutations(int[] set, int choices) {

			String resetStr = "";
			for (int j = 0; j < choices; j++) {
				resetStr += String.format("%d", set[0]);
			}
			//
			java.util.Random rand = new java.util.Random();
			// calc the number of values
			long max = permutations(choices, getRad(set));
			while (size() < max) {

				StringBuilder builder = new StringBuilder();

				java.util.ArrayList<Integer> ele = new java.util.ArrayList<Integer>();
				while (ele.size() < choices) {
					int anInt = set[rand.nextInt(set.length)];
					ele.add(anInt);
				}
				for (Integer i : ele) {
					builder.append(i.toString());
				}
				if (failedTries.contains(builder.toString())) {
					continue;
				}

				if (!contains(builder.toString()) && isValid(set, builder.toString())) {
					add(builder.toString());
				}
			}
		}

		private int getRad(int[] set) {
			int rad = 0;
			StringBuilder builder = new StringBuilder();
			for (int i : set) {
				builder.append(i);
			}

			int res[] = new int[256];

			for (int i = 0; i < builder.toString().length(); i++) {
				char charAt = builder.toString().charAt(i);
				res[charAt]++;
			}

			for (int i = 0; i < res.length; i++) {
				if (res[i] != 0) {
					if (res[i] == 1) {
						rad++;
					}
				}
			}
			return rad;
		}

		public long permutations(int n, int r) {
			if (r == 1)
				return n;

			if (r == 0)
				return 1;

			long previous = n;
			long current = 0;
			for (int i = 2; i <= r; i++) {
				current = previous * (n - (i - 1));
				previous = current;
			}
			return current;
		}

		private boolean isValid(int[] set, String string) {
			StringBuilder builder = new StringBuilder();
			for (int i : set) {
				builder.append(i);
			}
			boolean valid = true;
			for (char c : builder.toString().toCharArray()) {
				if (!string.contains(String.valueOf(c))) {
					valid = false;
					failedTries.add(string);
					break;
				}
			}

			if (valid) {
				for (char c : string.toCharArray()) {
					if (getMatches(c, string) != getMatches(c, builder.toString())) {
						valid = false;
						failedTries.add(string);
						break;
					}
				}
			}

			return valid;
		}

		private int getMatches(char c, String toMatch) {
			int matches = 0;
			for (char t : toMatch.toCharArray()) {
				if (c == t) {
					matches++;
				}
			}
			return matches;
		}

		private boolean contains(String str) {
			return ((ArrayList<String>) this).contains(str);
		}
	}

	public static void main(String args[]) throws Exception {
		if (args.length < 1) {
			System.out.println("Provide absolute path of input file");
		}
		File file = new File(args[0]);
		if (file.isFile()) {
			RecycledNumbers recycledNumbers = new RecycledNumbers(file);
			recycledNumbers.init();
			recycledNumbers.getRecycledNumbers();
			recycledNumbers.printResult();
		}
	}
}
