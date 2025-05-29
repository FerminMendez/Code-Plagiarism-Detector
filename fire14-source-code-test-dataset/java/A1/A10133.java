import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Prob3 {

	private static String doAlgorithm(String[] lines) {
		StringBuilder ans = new StringBuilder();
		int numCase = Integer.parseInt(lines[0]);
		for (int i = 0; i < numCase; i++)
			ans.append("Case #" + (i + 1) + ": ")
					.append(doActualAlgorithm(lines[i + 1])).append('\n');
		return ans.toString();
	}

	static String doActualAlgorithm(String s) {
		String[] separated = s.trim().split(" ");
		int nGoog = Integer.parseInt(separated[0]), nStar = Integer
				.parseInt(separated[1]), treshold = Integer
				.parseInt(separated[2]);
		int[] data = new int[nGoog];
		int couldHaveBeenIncreased = 0;
		int passTreshold = 0;
		for (int i = 0; i < data.length; i++)
			data[i] = Integer.parseInt(separated[i + 3]);
		// start here
		for (int i = 0; i < data.length; i++) {
			int current = data[i];
			int maxValue, maxValueWithStar;
			if (current % 3 == 0) {
				maxValue = current / 3;
				maxValueWithStar = current / 3 + 1;
				if(current==0)
					maxValueWithStar=0;
			} else if (current % 3 == 1) {
				maxValue = current / 3 + 1;
				maxValueWithStar = current / 3 + 1;

			} else {
				maxValue = current / 3 + 1;
				maxValueWithStar = current / 3 + 2;
			}
			if (maxValue >= treshold)
				passTreshold++;
			else if (maxValueWithStar >= treshold)
				couldHaveBeenIncreased++;
		}
		int ans = passTreshold + Math.min(couldHaveBeenIncreased, nStar);
		return ans + "";
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

	enum NullableBoolean {
		TRUE, FALSE, NULL;
	}

	class Triplet {
		final int[] value;

		public Triplet(int x, int y, int z) {
			value = new int[3];
			value[0] = x;
			value[1] = y;
			value[2] = z;
			Arrays.sort(value);
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Triplet) {
				return Arrays.equals(value, ((Triplet) obj).value);
			}
			return super.equals(obj);
		}
	}
}
