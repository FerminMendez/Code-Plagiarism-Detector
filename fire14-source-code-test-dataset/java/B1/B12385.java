package com.forbeck.codejam2012;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ProblemC {

	private static final String OUTPUT = "resources/codejam2012/c/C-small-attempt1.out";
	private static final String INPUT = "resources/codejam2012/c/C-small-attempt1.in";

	private static List<String> recycleds;

	public static void main(String[] args) throws IOException {
		final BufferedReader br = new BufferedReader(new FileReader(INPUT));
		final BufferedWriter bw = new BufferedWriter(new FileWriter(OUTPUT));
		final Integer tcs = Integer.parseInt(br.readLine());

		int count = 1;
		while (count <= tcs) {
			recycleds = new ArrayList<String>();

			final StringTokenizer st = new StringTokenizer(br.readLine());
			final String a = st.nextToken(), b = st.nextToken();
			
			for (int m = parseInt(a) + 1; m <= parseInt(b); m++) {
				for (int n = parseInt(a); n < m; n++) {
					verifyRecycled(String.valueOf(n), String.valueOf(m));
				}
			}
			
			out(bw, count++);
		}

		bw.close();
	}

	private static void out(final BufferedWriter bw, int count) throws IOException {
		bw.write("Case #" + count + ": " + recycleds.size() + "\n");
	}

	private static void verifyRecycled(String N, String M) {
		if (N.length() != M.length() || M.length() == 1 || N.length() == 1)
			return;

		for (int i = N.length() - 1; i > 0; i--) {
			final String moved = N.substring(i);

			final String suposedM = moved + N.substring(0, N.lastIndexOf(moved));
			if (!M.equals(suposedM)) 
				continue;
			
			
			 if (!recycleds.contains(N + M)) {
				 recycleds.add(N + M);
			} 
		}
	}
	
}