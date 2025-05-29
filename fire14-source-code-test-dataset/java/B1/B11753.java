import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class QrC {
	private CodeJamTextInputReader input = null;
	private CodeJamTextOutputWriter output = null;

	public static void main(String args[]) {
		// CodeJamUtils.initLineEndings();
		try {
			QrC qrA = new QrC();
			qrA.run(new File(args[0]), new File(args[1]));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidInputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public QrC() {
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
		final int lowerBound = parser.readNextInt();
		final int upperBound = parser.readNextInt();

		int numOfRecycled = 0;

		Set<RecycledPair> alreadyHit = new HashSet<RecycledPair>();

		RecycledPair comparePair = new RecycledPair();
		
		for (int i = lowerBound; i <= upperBound; ++i) {
			int leftMask = getHighestMask(i);
			int rightMask = 10;
			while (leftMask >= 10) {
				int recycled = buildRecycled(i, leftMask, rightMask);
				comparePair.set(i, recycled);
				if (recycled != i && recycled >= lowerBound
						&& recycled <= upperBound
						&& !alreadyHit.contains(comparePair)) {
					alreadyHit.add(new RecycledPair(comparePair));
					++numOfRecycled;
				}
				rightMask = rightMask * 10;
				leftMask = leftMask / 10;
			}
		}

		return Integer.toString(numOfRecycled);
	}

	int buildRecycled(int in, int leftMask, int rightMask) {
		int rightPart = in % rightMask;
		int leftPart = in / rightMask;

		return (rightPart * leftMask) + leftPart;
	}

	int getHighestMask(int in) {
		int mask = 10;
		while (in / mask != 0) {
			mask = mask * 10;
		}
		return mask / 10;
	}

	int getNumOfDigits(int in) {
		int numOfDigits = 1;
		int mask = 10;
		while (in / mask != 0) {
			++numOfDigits;
			mask = mask * 10;
		}
		return numOfDigits;
	}
}
