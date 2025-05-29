import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Googlers {

	public static void main(String[] args) throws Exception {
		String srcFile = "C:" + File.separator + "Documents and Settings"
				+ File.separator + "rohit" + File.separator + "My Documents"
				+ File.separator + "Downloads" + File.separator
				+ "A-small-attempt0.in";
		String destFile = "C:" + File.separator + "Documents and Settings"
				+ File.separator + "rohit" + File.separator + "My Documents"
				+ File.separator + "Downloads" + File.separator
				+ "A-small-attempt0.out";
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
				stringBuilder.append("Case #" + i + ": ");
				stringBuilder.append(testMethod(tempString));
				stringBuilder.append("\n");
			}
		}
		if (stringBuilder.length() > 0) {
			stringBuilder.deleteCharAt(stringBuilder.length() - 1);
		}
		return stringBuilder.toString();
	}

	private static List<Integer> probability(int total) {
		List<Integer> val = new ArrayList<Integer>();
		int n1, n2, n3, n;
		n = total / 3;
		n1 = n2 = n3 = n;
		if (n1 + n2 + n3 == total) {
			n1 = n2 = n3 = n;
		}
		if (n1 + n2 + n3 + 1 == total) {
			n1 = n1 + 1;
		}
		if (n1 + n2 + n3 + 2 == total) {
			n1 = n1 + 1;
			n2 = n2 + 1;
		}
		val.add(n1);
		val.add(n2);
		val.add(n3);
		return val;
	}

	private static List<Integer> probabilityWithSurp(int total) {
		List<Integer> val = new ArrayList<Integer>();
		int n1, n2, n3, n;
		n = total / 3;
		n1 = n2 = n3 = n;
		if (total % 3 == 0) {
			n1 = n1 - 1;
			n3 = n3 + 1;
		} else if (total % 3 == 1) {
			n1 = n1 + 1;
			n2 = n2 + 1;
			n3 = n3 - 1;
		} else if (total % 3 == 2) {
			n3 = n3 + 2;
		}
		val.add(n1);
		val.add(n2);
		val.add(n3);
		return val;
	}

	private static String testMethod(String test) {
		String[] testArr = test.split(" ");
		int noOfG = Integer.valueOf(testArr[0]);
		int supR = Integer.valueOf(testArr[1]);
		int freQ = Integer.valueOf(testArr[2]);
		List<Integer> val = new ArrayList<Integer>();
		int count = 0;
		for (int i = 3; i < noOfG + 3; i++) {
			int no = Integer.valueOf(testArr[i]);
			val = probability(no);
			System.out.println(i + " " + val.toString());
			boolean isFreqPresent = testIsPresent(val, freQ);
			if (isFreqPresent) {
				count++;
			} else {
				if (supR > 0 && no >= 2 && no <= 28) {
					val = probabilityWithSurp(no);
					System.out.println(i + " " + val.toString());
					if (testIsPresent(val, freQ)) {
						count++;
						supR--;
					}
				}
			}

		}

		return String.valueOf(count);
	}

	private static boolean testIsPresent(List<Integer> valInsideList, int freQ) {
		boolean isFreq = false;
		for (Integer valInside : valInsideList) {
			if (valInside >= freQ) {
				isFreq = true;
				break;
			}
		}
		return isFreq;
	}
}