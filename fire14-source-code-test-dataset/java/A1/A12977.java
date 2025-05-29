import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Problem2 implements Runnable {
	private void solve() throws IOException {
		int ntest = nextInt();
		for (int t = 1; t <= ntest; t++) {
			int n = nextInt();
			int s = nextInt();
			int p = nextInt();
			int[] totalPoint = new int[7];
			for (int i = 0; i <= n - 1; i++)
				totalPoint[i] = nextInt();

			int[] mask = new int[4];
			int res = 0;

			for (mask[0] = 0; mask[0] <= 1; mask[0]++)
				for (mask[1] = 0; mask[1] <= 1; mask[1]++)
					for (mask[2] = 0; mask[2] <= 1; mask[2]++) {
						int sumNMask = 0;
						for (int i = 0; i <= n - 1; i++)
							sumNMask += mask[i];

						if (sumNMask == s) {
							int sumGooglerSatisfied = 0;
							for (int i = 0; i <= n - 1; i++)
								if (satisfy(totalPoint[i], p, mask[i]))
									sumGooglerSatisfied++;
							res = Math.max(res, sumGooglerSatisfied);
						}
					}

			writer.println("Case #" + t + ": " + res);
		}
	}

	private boolean satisfy(int totalPoint, int p, int surprising) {
		for (int first = p; first <= 10; first++)
			for (int second = Math.max(0, first - 2); second <= first; second++)
				for (int third = Math.max(0, first - 2); third <= first; third++) {
					int minVal = Math.min(second, third);
					if (first + second + third == totalPoint){
						if (surprising == 1 && first - minVal == 2) return true;
						if (surprising == 0 && first - minVal <= 1) return true;
					}
				}
		return false;
	}

	public static void main(String[] args) {
		new Problem2().run();
	}

	BufferedReader reader;
	StringTokenizer tokenizer;
	PrintWriter writer;

	public void run() {
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\workspace\\Code Jam 2012\\B0.in")));
			tokenizer = null;
			writer = new PrintWriter(new File("output.txt"));
			solve();
			reader.close();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}

	double nextDouble() throws IOException {
		return Double.parseDouble(nextToken());
	}

	String nextToken() throws IOException {
		while (tokenizer == null || !tokenizer.hasMoreTokens()) {
			tokenizer = new StringTokenizer(reader.readLine());
		}
		return tokenizer.nextToken();
	}
}
