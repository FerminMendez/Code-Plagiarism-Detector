import java.io.File;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;


public final class GoogleDanceJudge {

	public static enum TripletType {
		INVALID,
		USUAL,
		SURPRISING
	};

	public static TripletType findResultType (final int resultsSum, final int bestResult) {
		final int meanValue = resultsSum / 3;
		if (meanValue > bestResult)
			return TripletType.USUAL;
		//else
		final int unknownTwoResultsSum = resultsSum - bestResult;  //hypothesing
		if (unknownTwoResultsSum < 0)
			return TripletType.INVALID;
		final int lowestAcceptedResult = unknownTwoResultsSum / 2;
		switch (bestResult - lowestAcceptedResult) {
			case 0:
			case 1:
				return TripletType.USUAL;
			case 2:
				return TripletType.SURPRISING;
			default:
				return TripletType.INVALID;
		}
	}

	private static final String OUTPUT_FILE_EXTENSION = "out";

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
				final int googlersNumber = inputScanner.nextInt();
				final int maxSurprisingTripletsNumber = inputScanner.nextInt();
				final int minimumBestResult = inputScanner.nextInt();
				int possibleResultsNumber = 0;
				int unusualResultsNumber = 0;
				for (int j = 0; j < googlersNumber; ++j) {
					final int result = inputScanner.nextInt();
					final TripletType resultType = findResultType(result, minimumBestResult);
					switch (resultType) {
						case SURPRISING:
							if (unusualResultsNumber >= maxSurprisingTripletsNumber)
								break;  //not acceptable anymore
							++unusualResultsNumber;
							//no break
						case USUAL:
							++ possibleResultsNumber;
							break;
						//invalid, don't count
					}
				}
				outputWriter.println("Case #" + (i+1) + ": " + possibleResultsNumber);
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
