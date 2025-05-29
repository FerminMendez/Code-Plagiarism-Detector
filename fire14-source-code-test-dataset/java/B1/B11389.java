import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Solver {
	private static final String SMALL_FILE = "C-small-attempt0";

	// private static final String SMALL_FILE = "C-practice";

	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		String inFileName = SMALL_FILE + ".in";
		String outFileName = SMALL_FILE + ".out";
		String path = new File(".").getAbsoluteFile().getParent();
		if (!path.endsWith(File.separator)) {
			path = path + File.separator;
		}
		path = path + "res";
		path = path + File.separator;
		int dataCount = 0;
		FileReader fileReader = null;
		BufferedReader buffer = null;
		try {
			fileReader = new FileReader(path + inFileName);
			buffer = new BufferedReader(fileReader);
			String count = buffer.readLine();
			if (count == null || !Pattern.matches("^[0-9]+$", count)) {
				buffer.close();
				fileReader.close();
				System.out.println("file invalid1");
				return;
			}
			dataCount = Integer.valueOf(count);
		} catch (IOException ex) {
			System.out.println("file read error1");
			return;
		}

		File file = new File(path + outFileName);
		PrintWriter writer = null;
		FileWriter fileWriter = null;
		BufferedWriter bw = null;
		try {
			fileWriter = new FileWriter(file);
			bw = new BufferedWriter(fileWriter);
			writer = new PrintWriter(bw);
		} catch (IOException ex) {
			System.out.println("file writer error");
			return;
		}

		for (int i = 1; i <= dataCount; i++) {
			try {
				String[] inputs = buffer.readLine().split(" ");

				int result = solve(Integer.valueOf(inputs[0]),
						Integer.valueOf(inputs[1]));

				writer.println(String.format("Case #%d: %d", i, result));
				System.out.println(String.format("%d", result));
			} catch (IOException ex) {
				System.out.println("file read error");
				return;
			}
		}

		try {
			buffer.close();
			writer.close();
			bw.close();
			fileWriter.close();
		} catch (IOException ex) {
		}
		long stop = System.currentTimeMillis();
		System.out.println(String.format("End %dms", stop - start));
	}

	private static int solve(int inputA, int inputB) {
		int count = 0;

		for (int i = inputA; i <= inputB; i++) {
			final String checkStr = String.valueOf(i);
			final int length = checkStr.length();
			ArrayList<String> contain = new ArrayList<String>();
			contain.add(checkStr);
			for (int j = 1; j < length; j++) {
				String reverse = checkStr.substring(length - j)
						+ checkStr.substring(0, length - j);
				if (contain.contains(reverse))
					continue;
				contain.add(reverse);
				int reverseInt = Integer.valueOf(reverse);
				if (reverseInt >= i && reverseInt <= inputB) {
					System.out.println(reverseInt);
					count++;
				}
			}
		}

		return count;
	}

}
