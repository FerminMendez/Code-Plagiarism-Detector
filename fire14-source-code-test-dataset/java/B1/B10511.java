import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class codejam_C_small {
	public static void main(String[] args) throws IOException {
		FileUtil.Timer.start();

		Scanner scanner = new Scanner(System.in);
		int numOfTest = scanner.nextInt();
		scanner.nextLine();
		String[] testCases = new String[numOfTest];
		for (int i = 0; i < numOfTest; i++) {
			testCases[i] = scanner.nextLine();
		}

		String[] finalResult = new String[numOfTest];
		for (int i = 0; i < numOfTest; i++) {
			String testCase = testCases[i];
			String result = runTestCase(testCase);
			finalResult[i] = FileUtil.formatTestResult(i, result);
			System.out.println(finalResult[i]);
		}
		FileUtil.Timer.stop();
	}

	private static String runTestCase(String testCase) {
		String[] splits = testCase.split(" ");
		long lowerBound = FileUtil.toNumber(splits[0]);
		long upperBound = FileUtil.toNumber(splits[1]);
		if (lowerBound > upperBound || upperBound < 10) {
			return "0";
		}

		int count = 0;
		// System.out.println("Lower: " + lowerBound + ", Upper: " +upperBound
		// );
		Map<Long, Long> cachedMap = new HashMap<Long, Long>();
		for (long start = lowerBound; start < upperBound; start++) {
			long intermidate = start;
			int numOfShift = String.valueOf(start).length() - 1;
			if (numOfShift < 0) {
				continue;
			}

			for (int i = 0; i < numOfShift; i++) {
				intermidate = shiftLongNumber(intermidate, numOfShift);
				if (intermidate > start && intermidate <= upperBound) {
					if ((cachedMap.containsKey(intermidate) && cachedMap.get(
							intermidate).equals(start))
							|| (cachedMap.containsKey(start) && cachedMap.get(
									intermidate).equals(intermidate))) {
						// System.out.println(start + ", " + intermidate);
					} else {
						cachedMap.put(intermidate, start);
						count++;
					}
				}
			}
		}
		return String.valueOf(count);
	}

	private static long shiftLongNumber(long input, int numOfShift) {
		long lastDigit = input % 10;
		long reminder = input / 10;
		return (long) (Math.pow(10, numOfShift) * lastDigit + reminder);
	}
}
