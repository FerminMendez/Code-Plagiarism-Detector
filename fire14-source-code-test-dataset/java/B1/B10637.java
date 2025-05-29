import java.io.File;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;


public final class RecycledNumbersAnalyzer {

	private static boolean isRecycledPair (final int n, final int m) {
		final String nFirstDigit = Character.toString((Integer.toString(n)).charAt(0));
		final String mString = Integer.toString(m);
		final int mLength = mString.length();

		int mIndexSearch = 0;
		int mIndex;
		while ((mIndex = mString.indexOf(nFirstDigit, mIndexSearch)) != -1) {
			final int recycledM = Integer.valueOf(mString.substring(mIndex, mLength) + mString.substring(0, mIndex));
			if (recycledM == n)
				return true;
			//else
			mIndexSearch = mIndex+1;  //increment
		}
		return false;
	}

	public static int findRecycledPairsNumber (final int a, final int b) {
		int recycledPairsNumber = 0;
		for (int n = a; n < (b-1); ++n) {
			for (int m = (n+1); m <= b; ++m) {
				if (isRecycledPair(n, m))
					++recycledPairsNumber;
			}
		}
		return recycledPairsNumber;
	}

	private static final String OUTPUT_FILE_EXTENSION = "out";
	private static final String OUTPUT_LINE_FORMAT = "Case #%d: %s";

	public static void main (final String[] args) throws Exception {
		//input init
		if (args.length < 1)
			throw new IllegalArgumentException();

		final String inputFileName = args[0];
		final int lastDotIndex = inputFileName.lastIndexOf('.');
		final String fileName = (lastDotIndex < 0) ? inputFileName : inputFileName.substring(0, lastDotIndex);
		final String outputFileName = fileName + "." + OUTPUT_FILE_EXTENSION;

		final File inputFile = new File(inputFileName);
		final File outputFile = new File(outputFileName);
		Scanner inputScanner = null;
		PrintWriter outputWriter = null;

		try {
			inputScanner = new Scanner(inputFile);
			outputWriter = new PrintWriter(outputFile);
			final int numberLines = inputScanner.nextInt();
			inputScanner.nextLine();  //go to first text line
			for (int i = 0; i < numberLines; ++i) {
				final int n = inputScanner.nextInt();
				final int m = inputScanner.nextInt();
				final int recycledPairsNumber = findRecycledPairsNumber(n, m);
				outputWriter.println(String.format(OUTPUT_LINE_FORMAT, i+1, recycledPairsNumber));
			}
		} catch (final NoSuchElementException noSuchElementException) {
			System.err.println("invalid input");
			throw noSuchElementException;
		} finally {
			if (inputScanner != null) {
				inputScanner.close();
			}
			if (outputWriter != null) {
				outputWriter.flush();
				outputWriter.close();
			}
		}
	}

}
