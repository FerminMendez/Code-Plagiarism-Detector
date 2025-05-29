package Solutions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class problemB {
	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new FileReader(new File("smallB.in")));
		BufferedWriter out = new BufferedWriter(new FileWriter(new File("outputB.txt")));

		int numCases = Integer.parseInt(in.readLine());
		for (int i = 0; i < numCases; i++) {
			String google = in.readLine();
			String output = "Case #" + (i + 1) + ": ";

			String[] googlers = google.split(" ");
			int numGooglers = Integer.valueOf(googlers[0]);
			int numSurprising = Integer.valueOf(googlers[1]);
			int best = Integer.valueOf(googlers[2]);

			ArrayList<Integer> scores = new ArrayList<Integer>(numGooglers);
			for (int j = 3; j < googlers.length; j++) {
				scores.add(Integer.valueOf(googlers[j]));
			}
			Collections.sort(scores);
			int count_a = 0;
			int count_b = numSurprising;
			for (int j = scores.size() - 1; j >= 0; j--) {
				int thisscore = scores.get(j);
				if (thisscore>=best && thisscore >= 3 * best - 2) {
					count_a++;
				} else if (thisscore>=best && thisscore >= 3 * best - 4 && count_b > 0) {
					count_a++;
					count_b--;
				} else {
					break;
				}
			}

			output += count_a + "\n";
			out.write(output);

		}
		out.close();
	}
}
