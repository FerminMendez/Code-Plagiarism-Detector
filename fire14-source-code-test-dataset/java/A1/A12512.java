/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dancingwithgoogler;

/**
 *
 * @author WC
 */
public class DancingWithGoogler {
	private int numberOfSurprising = 0;
	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		(new DancingWithGoogler()).getMaximumBestResults("B-small-attempt1.in", "B-small-attempt1.out", "\n");
	}
	
	private void getMaximumBestResults(String filename, String outputFilename, String separator) {
		int numOfTestCases = CodeJamFileManager.getIntFromFirstLineOfFile(filename, separator);
		String[] testCases = CodeJamFileManager.getTextLinesOfFile(filename, separator);
		String output = "";
		for (int i = 1; i <= numOfTestCases; i++) {
			output += "Case #" + i + ": " + getMaximumBestResultOccurence(testCases[i]) + (i != numOfTestCases ? separator : "");
		}
		CodeJamFileManager.saveOutputFile(output, outputFilename, separator);
	}
	
	private int getMaximumBestResultOccurence(String testCase) {
		int[] intFigures = getIntArrayFromString(testCase.split(" "));
		int numberOfGooglers = intFigures[0];
		numberOfSurprising = intFigures[1];
		int bestResultOf = intFigures[2];
		int counter = 3;
		int maxBestResultOccurence = 0;
		boolean canBeSurprising = true;
		while (counter < intFigures.length) {
			if (numberOfSurprising == 0)
				canBeSurprising = false;
			if (googlerHasBestResult(intFigures[counter], bestResultOf, canBeSurprising))
				maxBestResultOccurence++;
			counter++;
		}
		return maxBestResultOccurence;
	}
	
	private boolean googlerHasBestResult(int score, int bestScoreToBeat, boolean canBeSurprising) {
		int remainder = score % 3;
		int avgScore = score / 3;
		if (avgScore >= bestScoreToBeat) {
			return true;
		}
		else  if (bestScoreToBeat - avgScore == 1) {
			if (remainder != 0) {
				return true;
			}
			else if (canBeSurprising && avgScore != 0) {
				numberOfSurprising--;
				return true;
			}
		}
		else if (bestScoreToBeat - avgScore == 2) {
			if (remainder == 2 && canBeSurprising) {
				numberOfSurprising--;
				return true;
			}
			return false;
		}
		return false;
	}
	
	private int[] getIntArrayFromString(String[] intStrArray) {
		int[] intArray = new int[intStrArray.length];
		int i = 0;
		for (String intStr : intStrArray) {
			intArray[i++] = Integer.parseInt(intStr);
		}
		return intArray;
	}
}