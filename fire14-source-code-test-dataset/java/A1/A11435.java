import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Qualification_B {
	
	private static final boolean DEBUG = false;

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		List<String> input = readFile(args[0]);
		int testCases = Integer.parseInt(input.get(0));
		String outputFilename = args[0].substring(0, args[0].length() - 2) + "out";
		
		FileOutputStream output = new FileOutputStream(outputFilename);
		
		try {
			for (int i = 1; i <= testCases; i++) {
				
				String[] oneTest = input.get(i).split(" ");
				int noOfGooglers = Integer.parseInt(oneTest[0]);
				int noOfSurprising = Integer.parseInt(oneTest[1]);
				int minPoint = Integer.parseInt(oneTest[2]);
				
				int[] googlerMarks = new int[noOfGooglers];
				for (int j = 0; j < noOfGooglers; j++) {
					googlerMarks[j] = Integer.parseInt(oneTest[3 + j]);
				}

				if (DEBUG) {
					debug("Test Case: " + i);
					debug("===============");
					debug(input.get(i));
				}
				int result = getResult(noOfGooglers, noOfSurprising, minPoint, googlerMarks);

				outputResult(output, i, String.valueOf(result));
			}
		} finally {
			
			if (output != null) {
				output.close();
			}
		}
	}
	
	private static int getResult(final int noOfGooglers,
			final int noOfSurprising, final int minPoint,
			final int[] googlerMarks) {
		
		int result = 0;
		int remainSurprising = noOfSurprising;
		Arrays.sort(googlerMarks);
		int minValue = 0;
		int maxValue = 0;
		int modValue = 0;
		
		for (int i = 0; i < noOfGooglers; i++) {
			minValue = googlerMarks[i] / 3;
			modValue = (minValue == 0)? googlerMarks[i] : googlerMarks[i] % 3;
			if (minValue > 0) {
				maxValue = (modValue == 0)? minValue : minValue + 1;
			} else {
				maxValue = 1;
			}
			
			maxValue = (maxValue > googlerMarks[i])? minValue : maxValue;
			
			if (DEBUG) {
				debug("No: " + noOfGooglers);
				debug("Surprise: " + remainSurprising);
				debug("MinPoint: " + minPoint);
				debug("Mark: " + googlerMarks[i]);
				debug("Min: " + minValue + " - " + "Max: " + maxValue);
				debug("Mod: " + modValue);
			}
				
//			if (maxValue >= minPoint) {
//				debug("Meet: " + googlerMarks[i]);
//				result++;
//			} else {
//				if (remainSurprising > 0 && maxValue < googlerMarks[i]) {
					if (modValue > 0) {
						if (minValue >= minPoint) {
//							debug("Meet: " + googlerMarks[i]);
							result++;
						} else if ((modValue == 1) && (minValue + modValue) == minPoint) {
//							debug("Meet: " + googlerMarks[i]);
							result++;
						} else if ((modValue == 2) && (minValue + 1) >= minPoint) {
//							debug("Meet: " + googlerMarks[i]);
							result++;
						} else if ((remainSurprising > 0) && (minValue + modValue) >= minPoint) {
//							debug("Meet *: " + googlerMarks[i]);
							remainSurprising--;
							result++;
						} else {
//							debug("Does not meet");
//							debug("No: " + noOfGooglers);
//							debug("Surprise: " + remainSurprising);
//							debug("Mark: " + googlerMarks[i]);
//							debug("Min: " + minValue + " - " + "Max: " + maxValue);
						}
					} else {
						if (minValue >= minPoint) {
//							debug("Meet: " + googlerMarks[i]);
							result++;
						} else if (remainSurprising > 0 && minValue > 0 && (minValue + 1) == minPoint) {
//							debug("Meet *: " + googlerMarks[i]);
							remainSurprising--;
							result++;
						} else {
//							debug("Does not meet");
//							debug("No: " + noOfGooglers);
//							debug("Surprise: " + remainSurprising);
//							debug("Mark: " + googlerMarks[i]);
//							debug("Min: " + minValue + " - " + "Max: " + maxValue);
						}
					}
//				}
//			}
		}
		
		return result;
	}

	public static List<String> readFile(String filename) throws IOException {

		List<String> lines = new ArrayList<String>();
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				new FileInputStream(filename)));

		try {
			String data;
			while ((data = reader.readLine()) != null) {
				lines.add(data);
			}
		} finally {
			reader.close();
		}
		
		return lines;
	}
	
	private static void outputResult(FileOutputStream output, int caseNo, String result) throws IOException {
		output.write(String.format("Case #%d: %s\r\n", caseNo, result).getBytes());
//		debug(String.format("Case #%d: %s\r\n", caseNo, result));
	}

	private static void debug(String debug) {
		System.out.print(debug + "\r\n");
	}
}
