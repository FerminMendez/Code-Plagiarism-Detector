package com.elbr.codejam2012.qualification.C;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Recycle {
	private static int a = 0;

	private static int b = 0;

	private static boolean debug = false;

	private static HashSet<String> set = new HashSet<String>();

	private static void isRecycled(int i) {
		String s = i + "";

		LinkedList<String> l = new LinkedList<String>();
		for (int j = 0; j < s.length(); j++) {
			l.add(s.charAt(j) + "");
		}

		for (int j = 0; j < s.length(); j++) {
			String zs = listToString(l);

			if (debug) {
				System.out.println(zs);
			}

			int z = Integer.parseInt(zs);

			if ((z >= a) && (z <= b) && (z > i)) {
				set.add("{" + i + "," + z + "}");
			}

			l.add(l.getFirst());
			l.removeFirst();
		}
	}

	private static String listToString(List<String> l) {
		return l.toString().replace("[", "").replace("]", "").replace(" ", "")
				.replace(",", "");
	}

	public static void main(String[] in) throws IOException {
		String fileName = "C-small-attempt0.in";
		URL file = Recycle.class.getResource(fileName);
		String path = file.getFile();
		BufferedReader reader = new BufferedReader(new FileReader(path));

		File fileOut = new File(fileName + ".out");
		fileOut.createNewFile();
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileOut));

		int numOfCases = Integer.parseInt(reader.readLine());

		for (int t = 0; t < numOfCases; t++) {
			String line = reader.readLine();

			String outputLine = "Case #" + (t + 1) + ": " + result(line);

			System.out.println(outputLine);

			writer.write(outputLine + System.getProperty("line.separator"));
		}

		reader.close();
		writer.close();
	}

	private static int result(String line) {
		String[] params = line.split("\\s");
		a = Integer.parseInt(params[0]);
		b = Integer.parseInt(params[1]);

		set.clear();

		for (int i = a; i <= b; i++) {
			isRecycled(i);
		}

		return set.size();
	}
}
