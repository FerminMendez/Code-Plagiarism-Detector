/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package recyclednumbers;

/**
 *
 * @author WC
 */
public class RecycledNumbers {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		(new RecycledNumbers()).findRecycledNumbers("C-small-attempt0.in", "C-small-attempt0.out", "\n");
	}
	
	private void findRecycledNumbers(String filename, String outputFile, String separator) {
		int numberOfTestCases = CodeJamFileManager.getIntFromFirstLineOfFile(filename, separator);
		String[] testCases = CodeJamFileManager.getTextLinesOfFile(filename, separator);
				String output = "";
		for (int i = 1; i <= numberOfTestCases; i++) {
			output += "Case #" + i + ": " + getNumberOfRecycledInts(testCases[i]) + (i != numberOfTestCases ? separator : "");
		}
		CodeJamFileManager.saveOutputFile(output, outputFile, separator);
	}
	
	private int getNumberOfRecycledInts(String testcase) {
		int[] params = getIntArrayFromString(testcase.split(" "));
		int lower = params[0];
		int upper = params[1];
		int currentM = lower + 1;
		int numberOfRecycles = 0;
		while (currentM <= upper) {
			int count = timesRecycled(lower, currentM++);
			numberOfRecycles += count;
		}
		return numberOfRecycles;
	}
	
	private int timesRecycled(int lower, int currentM) {
		String currentMStr = String.valueOf(currentM);
		char[] individualNumbers = currentMStr.toCharArray();
		int timesRecycled = 0;
		for (int i = 1; i < individualNumbers.length; i++) {
			int flip = flip(individualNumbers, i);
			if (flip >= lower && flip < currentM) {
				timesRecycled++;
			}
		}
		return timesRecycled;
	}
	
	private int flip(char[] individualNumbers, int positionsToFlip) {
		char[] flip = new char[individualNumbers.length];
		int startInt = individualNumbers.length - positionsToFlip;
		int flipPos = 0;
		while (startInt < individualNumbers.length) {
			flip[flipPos++] = individualNumbers[startInt++];
		}
		int i = 0;
		while (i < (individualNumbers.length - positionsToFlip)) {
			flip[flipPos++] = individualNumbers[i++];
		}
		return Integer.parseInt(String.valueOf(flip));
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
