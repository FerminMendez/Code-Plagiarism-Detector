import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class ReadFile {
	public static void main(String[] args) throws Exception {
		String srcFile = "C:" + File.separator + "Documents and Settings"
				+ File.separator + "rohit" + File.separator + "My Documents"
				+ File.separator + "Downloads" + File.separator
				+ "C-small-attempt1.in.txt";
		String destFile = "C:" + File.separator + "Documents and Settings"
				+ File.separator + "rohit" + File.separator + "My Documents"
				+ File.separator + "Downloads" + File.separator
				+ "C-small-attempt0.out";
		File file = new File(srcFile);
		List<String> readData = new ArrayList<String>();
		FileReader fileInputStream = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileInputStream);
		StringBuilder stringBuilder = new StringBuilder();
		String line = null;
		while ((line = bufferedReader.readLine()) != null) {
			readData.add(line);
		}
		stringBuilder.append(generateOutput(readData));
		File writeFile = new File(destFile);
		if (!writeFile.exists()) {
			writeFile.createNewFile();
		}
		FileWriter fileWriter = new FileWriter(writeFile);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		bufferedWriter.write(stringBuilder.toString());
		bufferedWriter.close();
		System.out.println("output" + stringBuilder);
	}

	/**
	 * @param number
	 * @return
	 */
	private static String generateOutput(List<String> number) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < number.size(); i++) {
			if (i == 0) {
				continue;
			} else {
				String tempString = number.get(i);
				String[] temArr = tempString.split(" ");
				stringBuilder.append("Case #" + i + ": ");
				stringBuilder.append(getRecNumbers(temArr[0], temArr[1]));
				stringBuilder.append("\n");
			}
		}
		if (stringBuilder.length() > 0) {
			stringBuilder.deleteCharAt(stringBuilder.length() - 1);
		}
		return stringBuilder.toString();
	}

	// /* This method accepts method for google code jam */
	// private static String method(String value) {
	// int intValue = Integer.valueOf(value);
	// double givenExpr = 3 + Math.sqrt(5);
	// double num = Math.pow(givenExpr, intValue);
	// String valArr[] = (num + "").split("\\.");
	// int finalVal = Integer.valueOf(valArr[0]) % 1000;
	//
	// return String.format("%1$03d", finalVal);
	//
	// }
	//
	// /* This method accepts method for google code jam */
	// private static String method2(String value) {
	// StringTokenizer st = new StringTokenizer(value, " ");
	// String test[] = value.split(" ");
	// StringBuffer str = new StringBuffer();
	//
	// for (int i = 0; i < test.length; i++) {
	// // test[i]=test[test.length-i-1];
	// str.append(test[test.length - i - 1]);
	// str.append(" ");
	// }
	// str.deleteCharAt(str.length() - 1);
	// String strReversedLine = "";
	//
	// while (st.hasMoreTokens()) {
	// strReversedLine = st.nextToken() + " " + strReversedLine;
	// }
	//
	// return str.toString();
	// }

	private static int getRecNumbers(String no1, String no2) {

		int a = Integer.valueOf(no1);
		int b = Integer.valueOf(no2);
		Set<String> dupC = new HashSet<String>();
		for (int i = a; i <= b; i++) {
			int n = i;
			List<String> value = findPerm(n);
			for (String val : value) {
				if (Integer.valueOf(val) <= b && Integer.valueOf(val) >= a
						&& n < Integer.valueOf(val)) {
					dupC.add(n + "-" + val);
				}
			}
		}
		return dupC.size();
	}

	private static List<String> findPerm(int num) {
		String numString = String.valueOf(num);
		List<String> value = new ArrayList<String>();
		for (int i = 0; i < numString.length(); i++) {
			String temp = charIns(numString, i);
			if (!temp.equalsIgnoreCase(numString)) {
				value.add(charIns(numString, i));
			}
		}
		return value;

	}

	public static String charIns(String str, int j) {
		String begin = str.substring(0, j);
		String end = str.substring(j);
		return end + begin;
	}
}