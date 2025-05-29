import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DancingGooglers {

	private static String infile = "B-small-attempt1.in";
	private static String outfile = "out.txt";
	private static String encoding = "UTF-8";
	
	public static void main(String[] args) {
		try {
			runTests();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}

	}

	public static void runTests() throws IOException {
		Scanner scanner = new Scanner(new FileInputStream(infile), encoding);
		BufferedWriter writer = new BufferedWriter(new FileWriter(outfile));
		int nCases = Integer.parseInt(scanner.nextLine());

		for (int i = 0; i < nCases; i++) {
			int val = testCase(scanner.nextLine());
			writer.write("Case #" + (i + 1) + ": " + val + "\n");
		}

		writer.close();
	}
	
	public static int testCase(String input) {
		String delimiter = " ";
		String[] inputs = input.split(delimiter);
		int nSurprising = Integer.parseInt(inputs[1]);
		int maxScore = Integer.parseInt(inputs[2]) * 3;
		int nQualifying = 0;
		
		for (int i = 3; i < inputs.length; i++) {
			int score = Integer.parseInt(inputs[i]);

			if (score >= 2 && maxScore >= 6) {
				if (score >= maxScore - 2) {
					nQualifying++;
				} else if (score >= maxScore - 4 && nSurprising > 0) {
					nQualifying++;
					nSurprising--;
				}
			} else if ((maxScore == 0) || (maxScore == 3 && score > 0)) {
				nQualifying++;
			}
		}
		
		return nQualifying;
	}

}
