

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

	private static final String RESULT_PATH = "/home/ypxu/src/codejam/2012";

	
	public static String[] readFile(String filePath) {
		List<String> content = new ArrayList<String>();
		try {
			BufferedReader bis = new BufferedReader(new FileReader(filePath));
			String current = null;
			while ((current = bis.readLine()) != null && current.length() > 0) {
				content.add(current);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return content.toArray(new String[content.size()]);
	}

	public static int getNumOfTestCases(String[] content) {
		// for code jam, it's in first line
		assert content != null;
		String numStr = content[0];
		return Integer.parseInt(numStr);
	}

	public static String[] getAllTestCases(String[] content) {
		assert content != null;
		int len = content.length;
		String[] testCases = new String[len - 1];
		for (int i = 0; i < len - 1; i++) {
			testCases[i] = content[i + 1];
		}
		return testCases;
	}

	public static String formatTestResult(int index, String result) {
		assert result != null;
		return String.format("Case #%1$d: %2$s", index + 1, result);
	}

	public static void writeTestResult(String fileName, String[] results) {
		try {
			FileWriter fstream = new FileWriter(fileName);
			BufferedWriter out = new BufferedWriter(fstream);
			for (String result : results) {
				out.write(result + "\n");
			}
			out.close();
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}

	public static long toNumber(String in) {
		return Long.valueOf(in);
	}

	public static long toNumber(char ch) {
		return toNumber(Character.toString(ch));
	}

	public static char toChar(String in) {
		char[] chars = in.toCharArray();
		if (chars.length <= 0) {
			return 0;
		}
		return chars[0];
	}

	public static boolean isNumber(String in) {
		try {
			Integer.parseInt(in);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static String join(char[] chars, String delimiter) {
		int len = chars.length;
		String[] strArr = new String[len];

		for (int i = 0; i < len; i++) {
			strArr[i] = Character.toString(chars[i]);
		}
		return join(strArr, delimiter);
	}

	public static String join(String[] strs, String delimiter) {
		int len = strs.length;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; i++) {
			if (sb.length() > 0) {
				sb.append(delimiter).append(strs[i]);
			} else {
				sb.append(strs[i]);
			}
		}
		return "[" + sb.toString() + "]";
	}

	public static class Timer {
		private static long timestamp = System.currentTimeMillis();

		public static void start() {
			Timer.timestamp = System.currentTimeMillis();
		}

		public static void stop() {
			long current = System.currentTimeMillis();
			long pass = current - timestamp;
			System.out.println("total: " + pass + " ms");
		}
	}

}
