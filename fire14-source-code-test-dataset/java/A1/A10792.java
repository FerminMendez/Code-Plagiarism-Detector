package com.elbr.codejam2012.qualification.B;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

public class Dancing {
	private static boolean debug = false;

	private static String findP;

	private static int p = 0;

	private static int s = 0;

	private static boolean checkDiff(String prefix, boolean checkNoSurprise) {
		prefix = prefix.trim();

		if (prefix.length() == 0) {
			return true;
		}

		String[] params = prefix.split("\\s");
		int max = -1;
		int min = -1;

		for (String s : params) {
			int i = Integer.parseInt(s);
			if (min == -1) {
				min = i;
			}

			if (max == -1) {
				max = i;
			}

			max = Math.max(max, i);
			min = Math.min(min, i);
		}

		if ((max > 10) || (min > 10)) {
			return false;
		}

		if (((max - min) > 2) || (max < p)) {
			return false;
		}

		if ((max - min) < 2) {
			return true;
		}

		if (checkNoSurprise) {
			return false;
		}

		if (s == 0) {
			return false;
		}

		s--;

		return true;
	}

	public static int count(String input, String countString) {
		return input.trim().split("\\Q" + countString + "\\E", -1).length - 1;
	}

	public static void main(String[] in) throws IOException {
		// String fileName = "sample2.in";
		String fileName = "B-small-attempt3.in";
		URL file = Dancing.class.getResource(fileName);
		String path = file.getFile();
		BufferedReader reader = new BufferedReader(new FileReader(path));

		File fileOut = new File(fileName + ".out");
		fileOut.createNewFile();
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileOut));

		int numOfCases = Integer.parseInt(reader.readLine());

		for (int t = 0; t < numOfCases; t++) {
			String line = reader.readLine();

			String outputLine = "Case #" + (t + 1) + ": " + result(line);
			if (true || debug) {
				System.out.println(outputLine);
			}
			writer.write(outputLine + System.getProperty("line.separator"));
		}

		reader.close();
		writer.close();
	}

	public static void partition(int n, boolean checkNoSurprise) {
		findP = null;

		partition(n, n, "", checkNoSurprise);
	}

	public static void partition(int n, int max, String prefix,
			boolean checkNoSurprise) {
		if (findP != null) {
			return;
		}

		if (n == 0) {
			if ((count(prefix, " ") == 2)) {
				if (debug) {
					System.out.println("Check votes: " + prefix);
				}

				if (checkDiff(prefix, checkNoSurprise)) {
					findP = prefix;
				}
			}
			return;
		}

		for (int i = Math.min(max, n); i >= 1; i--) {
			String np = prefix + " " + i;
			if (count(prefix, " ") <= 2) {
				partition(n - i, i, np, checkNoSurprise);
			}
		}
	}

	private static int result(String line) {
		String[] params = line.split("\\s");
		int n = Integer.parseInt(params[0]);
		s = Integer.parseInt(params[1]);
		p = Integer.parseInt(params[2]);

		System.out.println(line + ": " + s + ", " + p);

		int[] m = new int[n];

		int a = 0;
		for (int i = 0; i < n; i++) {
			m[i] = Integer.parseInt(params[3 + i]);

			if (debug) {
				System.out.println(m[i] + " => ");
			}

			if ((m[i] == 0) && (p == 0)) {
				findP = "0 0 0";
				if (debug) {
					System.out.println("not surprise => " + findP);
				}
				a++;
			} else {
				partition(m[i], true);

				if (findP != null) {
					a++;
					if (debug) {
						System.out.println("not surprise => " + findP);
					}
				} else {
					if (debug) {
						System.out.println("---");
					}
					partition(m[i], false);
					if (findP != null) {
						a++;
						if (debug) {
							System.out.println("surprise => " + findP);
						}
					}
				}
			}
		}

		return a;
	}
}
