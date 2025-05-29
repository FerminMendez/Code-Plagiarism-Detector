import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Dancing
{
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		try {
			FileReader fs = new FileReader("/tmp/dancing.in");
			BufferedReader in = new BufferedReader(fs);
			FileWriter fso = new FileWriter("/tmp/dancing.out");
			BufferedWriter out = new BufferedWriter(fso);

			String strLine;
			int i=0;
			int matches;

			while ((strLine = in.readLine()) != null)
			{
				if (i > 0) {
					// parse input line
					String[] strings = strLine.split(" ");
					final int[] ints = new int[strings.length];
					for (int j = 0; j < strings.length; j++) {
						ints[j] = Integer.parseInt(strings[j]);
					}

					matches = findMatches(ints[1], ints[2], Arrays.copyOfRange(ints, 3, 3+ints[0]));

					out.write(new StringBuilder("Case #").append(i)
							.append(": ").append(matches).append("\n")
							.toString());
				}
				i++;
			}

			in.close();
			out.close();
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}

	private static int findMatches(int surprises, int bestResult, int[] ts)
	{
		int matches = 0;

		List<Integer> totalScores = new ArrayList<Integer>(ts.length);
		for (int index = 0; index < ts.length; index++){
			totalScores.add(ts[index]);
	    }
		Collections.sort(totalScores, Collections.reverseOrder());
		System.out.print("Surprises: " + surprises + " Best: " + bestResult + " Scores: " + totalScores);

		for (int totalScore : totalScores)
		{
			int min = totalScore / 3;
			int delta = totalScore % 3;
			int max = min + delta;

			System.out.print(" [Min: " + min + " / Max: " + max + "]");

			if ((max == bestResult) && (delta == 2) && (surprises > 0)) {
				matches++;
				surprises--;
			} else if ((min + 1 == bestResult) && (max + 1 == bestResult) && (min > 0) && (surprises > 0)) {
				matches++;
				surprises--;
			} else if ((min + 1 >= bestResult) && (max >= bestResult)) {
				matches++;
			}
		}

		System.out.println(" Result: " + matches);
		return matches;
	}
}