import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DancingWithGooglers {
	public String findMaxGooglers(String line) {
		String[] tokens = line.split(" ");
		int numGooglers = Integer.parseInt(tokens[0]);
		int numSurprising = Integer.parseInt(tokens[1]);
		int threshold = Integer.parseInt(tokens[2]);

		int[] pointsArray = new int[numGooglers];
		for (int i = 0; i < numGooglers; ++i) {
			pointsArray[i] = Integer.parseInt(tokens[3 + i]);
		}

		int maxGooglers = 0;
		int numSurprisingBetter = 0;
		int numSurprisingEqual = 0;
		for (int points : pointsArray) {
			int avg = points / 3;
			int rem = points - 3 * avg;
			if (points >= 2 && points <= 28) {
				if (avg >= threshold) {
					maxGooglers++;
					numSurprisingEqual++;
				} else if (avg == threshold - 1) {
					if (rem == 0) {
						numSurprisingBetter++;
					} else { // rem == 1 || rem == 2
						maxGooglers++;
						numSurprisingEqual++;
					}
				} else if (avg == threshold - 2) {
					if (rem == 2) {
						numSurprisingBetter++;
					} else {
						numSurprisingEqual++;
					}
				} else {
					numSurprisingEqual++;
				}
			} else { // points = 0, 1, 29 or 30
				numSurprisingEqual++;
				if (avg >= threshold) {
					maxGooglers++;
				} else if (avg == threshold - 1 && rem > 0) {
					maxGooglers++;
				}
			}
		}
		System.out.printf("%d, %d\n", numSurprisingBetter, numSurprisingEqual);
		System.out.printf("%d\n", numSurprisingBetter + numSurprisingEqual);
		System.out.printf("Num points: %d\n", pointsArray.length);

		if (numSurprising > 0) {
			int n = Math.min(numSurprisingBetter, numSurprising);
			numSurprising -= n;
			maxGooglers += n;
		}

		if (numSurprising > 0) {
			int n = Math.min(numSurprisingEqual, numSurprising);
			numSurprising -= n;
		}

		assert numSurprising == 0;

		return String.valueOf(maxGooglers);
	}

	public static void main(String[] args) {
		String inputFileName = null;
		if (args.length > 0) {
			inputFileName = args[0];
		} else {
			return;
		}

		File inputFile = new File(inputFileName);
		List<String> outputStringList = new ArrayList<String>();
		try {
			DancingWithGooglers dwg = new DancingWithGooglers();
			BufferedReader reader = new BufferedReader(
					new FileReader(inputFile));
			int numLines = Integer.parseInt(reader.readLine());
			for (int i = 0; i < numLines; ++i) {
				outputStringList.add(dwg.findMaxGooglers(reader.readLine()));
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		File outputFile = new File("dwg.out");
		FileWriter writer;
		try {
			writer = new FileWriter(outputFile);
			for (int i = 0; i < outputStringList.size(); ++i) {
				String s = String.format("Case #%d: %s\n", i + 1,
						outputStringList.get(i));
				System.out.print(s);
				writer.write(s);
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
