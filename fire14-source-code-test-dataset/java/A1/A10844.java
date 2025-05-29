package qualifying;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Google Code Jam, Problem B. Result finder
 * 
 * @author Petar
 * 
 */
public class Dancers {
	private static BufferedReader in;
	private static BufferedWriter out;

	/**
	 * Main, reads in scores, outputs max num of Googler's with result p
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> scores;
		int numSurprise, numGooglers, p, maxGooglers;
		String currLine = "";

		try {
			out = new BufferedWriter(new FileWriter(".out"));
			in = new BufferedReader(new FileReader(".in"));
			int testNum = Integer.parseInt(in.readLine());
			for (int i = 0; i < testNum; i++) {
				maxGooglers = 0;
				currLine = in.readLine();
				String[] testBound = currLine.split(" ");

				numGooglers = Integer.parseInt(testBound[0]);
				numSurprise = Integer.parseInt(testBound[1]);
				p = Integer.parseInt(testBound[2]);
				System.out
						.println(String
								.format("The bounds of the problem are %d googlers, %d surprising results and %d p value",
										numGooglers, numSurprise, p));
				// Read in the scores
				scores = new ArrayList<Integer>(numGooglers);

				for (int j = 0; j < numGooglers; j++) {
					scores.add(Integer.parseInt(testBound[j + 3]));
				}

				// Determine the tallies
				for (Integer score : scores) {
					if (score < (3 * p - 4) || score < p) {
						continue;
					} else if (score >= (3 * p - 2)) {
						maxGooglers++;
					} else {
						if (numSurprise > 0) {
							maxGooglers++;
							numSurprise--;
						}
					}
				}

				Collections.sort(scores);

				out.write(String.format("Case #%d: %d", i + 1, maxGooglers));
				out.newLine();
			}

			in.close();
			out.flush();
			out.close();
		} catch (FileNotFoundException e) {
			System.err.println("Input file was not found");
		} catch (IOException e) {
			System.err.println("Problem reading from input file");
			e.printStackTrace();
		}
	}
}
