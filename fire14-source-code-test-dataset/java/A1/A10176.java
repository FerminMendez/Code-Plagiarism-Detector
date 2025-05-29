import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GoogleDancers {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int numberOfTestCases = Integer.parseInt(s);

		StringBuffer output = new StringBuffer();
		for (int i = 1; i <= numberOfTestCases; i++) {
			String testCase = br.readLine().trim();
			String[] inputparams = testCase.split(" ");

			long N, S, p;
			long totalPoints[] = new long[110];

			N = Long.parseLong(inputparams[0]);
			S = Long.parseLong(inputparams[1]);
			p = Long.parseLong(inputparams[2]);

			for (int j = 3; j <= N + 2; j++) {
				totalPoints[j - 3] = Long.parseLong(inputparams[j]);
			}

			String outputString = solveTestCase(N, S, p, totalPoints);

			if (i != 1) {
				output.append("\n");
			}

			output.append("Case #" + i + ": ");
			output.append(outputString);
		}

		System.out.println(output);
	}

	private static String solveTestCase(long N, long S, long p, long[] totalPoints) {
		long maxNoOfBest = 0;
		long possibleSuprises = 0;

		for (int i = 0; i < N; i++) {
			int totalPnts = (int) totalPoints[i];
			int oneScore = totalPnts / 3;
			int mod = totalPnts % 3;

			if (mod >= 1) {
				if (oneScore >= p || (oneScore + 1) >= p) {
					maxNoOfBest++;
				} else if (oneScore + mod >= p) {
					possibleSuprises++;
				}
			} else {
				if (oneScore >= p) {
					maxNoOfBest++;
				} else if (oneScore > 0 && oneScore + 1 >= p) {
					possibleSuprises++;
				}
			}
		}

		if (possibleSuprises < S) {
			maxNoOfBest = maxNoOfBest + possibleSuprises;
		} else {
			maxNoOfBest = maxNoOfBest + S;
		}

		return String.valueOf(maxNoOfBest);
	}
}
