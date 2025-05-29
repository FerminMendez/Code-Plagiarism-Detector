import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Jelle Prins
 */
public class RecycledNumbers {

	public static void main(String[] args) {
		String input = "input.txt";
		String output = "output.txt";
		if (args.length >= 1) {
			input = args[0];
			if (args.length >= 2) {
				output = args[1];
			}
		}
		new RecycledNumbers(input, output);
	}

	public RecycledNumbers(String inputString, String outputString) {
		init();

		File input = new File(inputString);
		File output = new File(outputString);
		if (!input.isFile()) {
			System.err.println("input file not found");
			System.exit(1);
		}
		if (output.exists()) {
			output.delete();
		}

		try {
			String[] cases = readInput(input);
			String[] results = executeCases(cases);
			writeOutput(output, results);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	private String[] readInput(File file) throws Exception {
		Scanner scanner = new Scanner(file);
		int lines = scanner.nextInt();
		scanner.nextLine();
		String[] cases = new String[lines];
		for (int i = 0; i < lines; i++) {
			cases[i] = scanner.nextLine().trim();
			if (cases[i] == null) {
				throw new Exception("not enough input lines");
			}
		}
		scanner.close();
		return cases;
	}

	private String[] executeCases(String[] cases) {
		String[] output = new String[cases.length];
		for (int i = 0; i < cases.length; i++) {
			output[i] = executeCase(i + 1, cases[i]);
		}
		return output;
	}

	private String parseOutput(int caseID, String answer) {
		String output = "Case #" + caseID + ": " + answer;
		System.out.println(output);
		return output;
	}

	private void writeOutput(File output, String[] results) throws Exception {
		PrintWriter pw = new PrintWriter(new FileWriter(output));
		for (int i = 0; i < results.length; i++) {
			pw.println(results[i]);
		}
		pw.close();
	}

	private void init() {
	}

	private String executeCase(int caseID, String input) {
		String[] split = input.split(" ");
		int start = Integer.parseInt(split[0]);
		int end = Integer.parseInt(split[1]);
		int answer = 0;

		char[] chars;

		for (int n = start; n < end; n++) {
			chars = getNumberChars(n);
			if (chars == null) {
				continue;
			}
			answer += recycle(n, chars, end);
		}

		return parseOutput(caseID, "" + answer);
	}

	/**
	 * Returns null if the number can't be recycled
	 */
	private char[] getNumberChars(int n) {
		if (n < 10) {
			return null;
		}
		char[] chars = Integer.toString(n).toCharArray();
		int validChars = 0;
		for (char c : chars) {
			if (c != '0') {
				validChars++;
			}
		}
		if (validChars < 2) {
			return null;
		}
		return chars;
	}

	private int recycle(int n, char[] chars, int end) {
		char[] recycle = new char[chars.length];
		Set<String> found = new HashSet<String>();
		String str;
		int answer;
		int recycleTimes = 0;
		for (int i = 1; i < chars.length; i++) {
			System.arraycopy(chars, i, recycle, 0, chars.length - i);
			System.arraycopy(chars, 0, recycle, chars.length - i, i);
			str = new String(recycle);
			answer = Integer.parseInt(str);
			if (answer > n && answer <= end) {
				if (found.add(str)) {
					recycleTimes++;
				}
			}
		}
		return recycleTimes;
	}

}
