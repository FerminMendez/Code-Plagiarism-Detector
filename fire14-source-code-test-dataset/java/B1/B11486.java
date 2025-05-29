import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Qualification_C {
	
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
				String[] splitted = input.get(i).split(" ");
				int min = Integer.parseInt(splitted[0]);
				int max = Integer.parseInt(splitted[1]);
				
				outputResult(output, i, String.valueOf(getNoOfDistinctPair(min, max)));
			}
		} finally {
			
			if (output != null) {
				output.close();
			}
		}
	}
	
	public static int getNoOfDistinctPair(int min, int max) {
		
		int result = 0;
		int value1 = min;
		int value2 = value1 + 1;
		
		while (value1 != value2 && value1 <= max) {
			String value1Str = String.valueOf(value1);
			value2 = value1 + 1;
			
			while (value2 <= max) {
				String value2Str = String.valueOf(value2);
				StringBuilder compareValue = new StringBuilder(value2Str);
				
				for (int i = 0; i < value2Str.length(); i++) {
//					debug("compare: " + value1Str + " == " + compareValue.toString());
					if (value1Str.equals(compareValue.toString())) {
						debug(value1Str + " == " + value2Str + ": " + value1Str + " = " + compareValue.toString());
						result++;
						break;
					}
					compareValue.append(compareValue.charAt(0));
					compareValue.deleteCharAt(0);
				}
				
				value2++;
			}
			value1++;
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
	}

	private static void debug(String debug) {
		if (DEBUG) {
			System.out.print(debug + "\r\n");
		}
	}
}
