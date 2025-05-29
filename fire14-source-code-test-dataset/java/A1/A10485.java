import java.io.IOException;
import java.util.Scanner;

public class codejam_B_small {

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
		int numOfGoogler = Integer.valueOf(splits[0]);
		int numOfSurpring = Integer.valueOf(splits[1]);
		int bestResult = Integer.valueOf(splits[2]);
		if (numOfGoogler <= 0) {
			return "0";
		}

		// int maxResult = 3 * bestResult;
		int count = 0;
		// check best result
		for (int i = 3; i < splits.length; i++) {
			int point = Integer.valueOf(splits[i]);
			int avg = point / 3;
			int reminder = point % 3;
			int diff = bestResult - avg;
			if (avg >= bestResult || diff == 0) {
				count++;
				continue;
			} else if (point < bestResult) {
				continue;
			}

			if (reminder >= 1 && diff <= 1) {
				count++;
				continue;
			} else if (reminder >= 2 && diff == 2 && numOfSurpring > 0) {
				numOfSurpring--;
				count++;
				continue;
			} else if (reminder == 0 && diff == 1 && numOfSurpring > 0) {
				numOfSurpring--;
				count++;
				continue;
			}
		}
		return String.valueOf(count);
	}

}
