package codejam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class DanceScores {

	public static void main(String[] args) throws Exception {
		new DanceScores().init();
	}

	private void init() throws Exception {

		int counter = 1;
		BufferedReader br = new BufferedReader(new FileReader(
				"C:\\Users\\i053957\\Downloads\\B-small-attempt0.in"));
		String line = br.readLine();
		while ((line = br.readLine()) != null) {
			int belowMin = 0;
			String[] values = line.split("[ ]");
			int[] scores = new int[Integer.parseInt(values[0])];
			int specialCount = Integer.parseInt(values[1]);
			int min = Integer.parseInt(values[2]);
			for (int i = 3; i < values.length; i++) {
				scores[i - 3] = Integer.parseInt(values[i]);
			}

			if (min > 1) {
				Arrays.sort(scores);
				for (int score : scores) {
					if ((min * 3 - score) < 3) {

					} else if ((min * 3 - score) < 5) {
						if (specialCount > 0) {
							specialCount--;
						} else {
							belowMin++;
						}
					} else {
						belowMin++;
					}
				}
			} else if (min == 1) {
				Arrays.sort(scores);
				for (int score : scores) {
					if (score == 0) {
						belowMin++;
					}
				}
			}

			System.out.println("Case #" + counter + ": "
					+ (scores.length - belowMin));
			counter++;
		}

		br.close();
	}
}
