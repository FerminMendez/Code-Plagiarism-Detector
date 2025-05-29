import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class QrB {
	private CodeJamTextInputReader input = null;
	private CodeJamTextOutputWriter output = null;

	public static void main(String args[]) {
		// CodeJamUtils.initLineEndings();
		try {
			QrB qrA = new QrB();
			qrA.run(new File(args[0]), new File(args[1]));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidInputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public QrB() {
	}

	public void run(File outputFile, File inputFile)
			throws InvalidInputException, IOException {
		try {
			input = new CodeJamTextInputReader(inputFile);
			output = new CodeJamTextOutputWriter(outputFile);

			actualRun();
		} finally {
			if (input != null) {
				input.close();
			}
			if (output != null) {
				output.close();
			}
		}
	}

	private void actualRun() throws IOException {
		while (input.hasNextTestCase()) {
			String in = input.readNextLine();
			final int textCaseNum = input.getLastReadTestCaseNumber();

			output.outputTestCase(textCaseNum, singleTestCase(in));
		}
	}

	private String singleTestCase(String in) {
		CodeJamLineParser parser = new CodeJamLineParser(in);
		final int numOfParticipants = parser.readNextInt();
		final int numOfSurprising = parser.readNextInt();
		final int bestAtLeast = parser.readNextInt();
		final int[] totalScores = parser.readNextIntList(numOfParticipants);

		Arrays.sort(totalScores);

		int surprisingRemaining = numOfSurprising;
		int numOfCountedParticipants = 0;

		// Go from highest to lowest
		for (int i = numOfParticipants - 1; i >= 0; --i) {
			int curTotalScore = totalScores[i];
			if (bestScore(curTotalScore, false) >= bestAtLeast) {
				++numOfCountedParticipants;
			} else if (surprisingRemaining > 0 && canBeSurprising(curTotalScore)
					&& bestScore(curTotalScore, true) >= bestAtLeast) {
				++numOfCountedParticipants;
				--surprisingRemaining;
			}
		}

		return Integer.toString(numOfCountedParticipants);
	}

	boolean canBeSurprising(int totalScore) {
		// 0 and 1 are special cases.
		return totalScore >= 2;
	}
	
	int bestScore(int totalScore, boolean surprising) {
		int mod3 = totalScore % 3;
		int div3 = totalScore / 3;

		if (mod3 == 0) {
			return surprising ? (div3 + 1) : div3;
		} else if (mod3 == 1) {
			return div3 + 1;
		} else {
			return surprising ? (div3 + 2) : (div3 + 1);
		}
	}
}
