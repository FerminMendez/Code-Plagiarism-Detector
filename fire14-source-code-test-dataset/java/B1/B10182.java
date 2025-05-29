import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class GoogleNumbers {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int numberOfTestCases = Integer.parseInt(s);

		StringBuffer output = new StringBuffer();
		for (int i = 1; i <= numberOfTestCases; i++) {
			String testCase = br.readLine().trim();
			String[] inputparams = testCase.split(" ");

			long A, B;

			A = Long.parseLong(inputparams[0]);
			B = Long.parseLong(inputparams[1]);

			String outputString = solveTestCase(A, B);

			if (i != 1) {
				output.append("\n");
			}

			output.append("Case #" + i + ": ");
			output.append(outputString);
		}

		System.out.println(output);

	}

	private static String solveTestCase(long A, long B) {
		long pairCount = 0;
		int d = String.valueOf(A).length();

		for (long n = A; n <= B; n++) {
			String currentNumber = String.valueOf(n);

			HashMap<String, String> pairedNumbers = new HashMap<String, String>();

			for (int i = 1; i < d; i++) {
				int subIndex = d - i;

				if (currentNumber.charAt(subIndex) == '0') {
					continue;
				}

				String newNumber = currentNumber.substring(subIndex) + currentNumber.substring(0, subIndex);

				if (pairedNumbers.containsKey(newNumber)) {
					continue;
				}

				long m = Long.valueOf(newNumber);
				if (m <= n || m > B) {
					continue;
				}

				pairedNumbers.put(newNumber, "Y");
				pairCount++;
			}

		}

		return String.valueOf(pairCount);
	}
}
