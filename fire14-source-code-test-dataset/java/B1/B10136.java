import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Prob2 {

	private static String doAlgorithm(String[] lines) {
		StringBuilder ans = new StringBuilder();
		int numCase = Integer.parseInt(lines[0]);
		for (int i = 0; i < numCase; i++)
			ans.append("Case #" + (i + 1) + ": ")
					.append(doActualAlgorithm(lines[i + 1])).append('\n');
		return ans.toString();
	}

	private static Point createAns(int x, int y) {
		if (x == y)
			throw new IllegalArgumentException();
		int lesser = Math.min(x, y);
		int more = Math.max(x, y);
		return new Point(lesser, more);

	}

	static String doActualAlgorithm(String s) {
		Set<Point> answerPair = new HashSet<Point>();
		String[] separated = s.trim().split(" ");
		int i1 = Integer.parseInt(separated[0]), i2 = Integer
				.parseInt(separated[1]);
		for (int i = i1; i <= i2; i++) {
			String stringForm = i + "";
			for (int j = 0; j < stringForm.length(); j++) {
				String testingString = stringForm.substring(j)
						+ stringForm.substring(0, j);
				if (testingString.charAt(0) == '0')
					continue;
				int testingInt = Integer.parseInt(testingString);
				if (testingInt <= i2 && testingInt >= i1 && testingInt != i)
					answerPair.add(createAns(i, testingInt));
			}
		}
		return answerPair.size() + "";
	}

	private static void initAlgorithm() {

	}

	public static void main(String[] args) throws IOException {
		File inputFile = new File("input.txt");
		File outputFile = new File("output.txt");
		FileReader reader = new FileReader(inputFile);
		BufferedReader br = new BufferedReader(reader);
		String line;
		ArrayList<String> input = new ArrayList<String>();
		while ((line = br.readLine()) != null) {
			input.add(line);
		}
		br.close();
		initAlgorithm();
		String output = doAlgorithm(input.toArray(new String[0]));
		FileWriter writer = new FileWriter(outputFile);
		writer.write(output.trim());
		writer.close();

	}
}
