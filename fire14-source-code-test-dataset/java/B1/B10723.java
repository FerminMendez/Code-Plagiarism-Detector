package nl.maartenvangrootel.googlecodejam.qualifier.recycling;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

/**
 * Hello world!
 * 
 */
public class Recycling {
	private File file;

	private static Pattern pattern = Pattern.compile("[\\ ]");

	public Recycling(String filename) {
		if (filename == null)
			throw new IllegalArgumentException("filename should not be null");

		file = new File(filename);
		if (!(file.exists() && file.isFile()))
			throw new IllegalArgumentException(String.format(
					"'%s' does not exist or is not a file.", filename));

	}

	private BufferedReader getReader() {
		BufferedReader reader = null;
		try {
			FileReader stream = new FileReader(file);
			reader = new BufferedReader(stream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return reader;
	}

	public String calculateResult() {
		BufferedReader reader = getReader();

		StringBuilder builder = new StringBuilder();
		try {
			int numberOfCases = Integer.parseInt(reader.readLine());
			int i = 1;
			String line;
			while ((line = reader.readLine()) != null) {
				if (i > 1) {
					builder.append("\n");
				}
				builder.append("Case #");
				builder.append(i);
				builder.append(": ");
				builder.append(parseLine2(line));
				i++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return builder.toString();
	}

	public static long parseLine2(String line) {
		String[] input = pattern.split(line);
		int length = input[0].length();
		boolean even = length % 2 == 0;

		long mod = (long) Math.pow(10, (length / 2));

		long A = Integer.parseInt(input[0]);
		long B = Integer.parseInt(input[1]);
		long cnt = 0;
		long compensation = 0;
		for (long n = A; n <= B; n++) {
			String strN = String.valueOf(n);
			for (int i = length - 1; i > 0; i--) {
				for (int j = length; j > i; j--) {
					String deel1 = strN.substring(i, j);
					String deel2 = strN.substring(0, i);
					String strM = deel1 + deel2;
					if ("".equals(strM))
						continue;

					long m = Long.parseLong(strM);

					if (m >= A && m <= B && n < m) {
						if (even && n % mod == n / mod) {
							compensation++;
						}
						cnt++;
					}
				}
			}
		}

		return cnt - compensation / 2;
	}

	public static void main(String[] args) {
		Recycling starter = new Recycling("src/main/resources/small.txt");
		String result = starter.calculateResult();

		System.out.println(result);
	}
}
