package nl.maartenvangrootel.googlecodejam.qualifiers.dancing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

/**
 * Hello world!
 * 
 */
public class DancingScores {
	private File file;

	private static Pattern pattern = Pattern.compile("[\\ ]");

	public DancingScores(String filename) {
		if (filename == null)
			throw new IllegalArgumentException("filename should not be null");

		file = new File(filename);
		if (!(file.exists() && file.isFile()))
			throw new IllegalArgumentException(String.format(
					"'%s' does not exist or is not a file.", filename));

	}

	private BufferedReader getReader() {
		BufferedReader reader = null;
		try {
			FileReader stream = new FileReader(file);
			reader = new BufferedReader(stream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return reader;
	}

	public String calculateResult() {
		BufferedReader reader = getReader();

		StringBuilder builder = new StringBuilder();
		try {
			int T = Integer.parseInt(reader.readLine());
			int i = 1;
			String line;
			while ((line = reader.readLine()) != null) {
				if (i > 1) {
					builder.append("\n");
				}
				builder.append("Case #");
				builder.append(i);
				builder.append(": ");
				builder.append(parseLine(line));
				i++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return builder.toString();
	}

	public static int parseLine(String line) {
		String[] input = pattern.split(line);
		int googlers = Integer.parseInt(input[0]);
		int maxSurprises = Integer.parseInt(input[1]);
		int bestResultGoal = Integer.parseInt(input[2]);

		int[] totalResults = new int[googlers];
		int[] totalResultsMinusGoal = new int[googlers];

		int surpriseOrNot = 0, not = 0, normal = 0, surpriseOrNormal = 0;

		for (int i = 0; i < googlers; i++) {
			// totalResults[i] = Integer.parseInt(input[i + 3]);
			// totalResultsMinusGoal[i] = totalResults[i] - bestResultGoal;
			int result = Integer.parseInt(input[i + 3]);
			int resultMinusGoal = result - bestResultGoal;

			if (resultMinusGoal < 0
					|| resultMinusGoal < (bestResultGoal - 2) * 2) {
				not++;
			} else if (resultMinusGoal < (bestResultGoal + (bestResultGoal - 2))) {
				surpriseOrNot++;
			} else if (resultMinusGoal == (bestResultGoal + (bestResultGoal - 2))) {
				surpriseOrNormal++;
			} else {
				normal++;
			}

		}
		int retVal = 0;
		if (surpriseOrNot == maxSurprises) {
			// exactly enough surpriseOrNot: all surpriseOrNormal are normal
			retVal = normal + surpriseOrNormal + surpriseOrNot;
		} else if (surpriseOrNot > maxSurprises) {
			// too many surpriseOrNot, all surpriseOrNormals are normal, some
			// surpriseOrNot are not.
			retVal = normal + surpriseOrNormal + maxSurprises;
		} else if (surpriseOrNot < maxSurprises) {
			// Too little surprisesOrNot, take them from surpriseOrNormal, the
			// rest is Normal.
			retVal = normal + surpriseOrNot + surpriseOrNormal;
		}
		return retVal;
	}

	public static void main(String[] args) {
		if (args.length > 0) {
			DancingScores starter = new DancingScores(args[0]);
			String result = starter.calculateResult();

			System.out.println(result);

		} else {
			System.err.println("No arguments given.");
		}

	}
}
