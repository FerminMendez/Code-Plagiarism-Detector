import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Googler implements Runnable {
	int[] isSuprisingMaxScore = new int[31];
	int[] isNotSuprisingMaxScore = new int[31];
	boolean[] canSuprising = new boolean[31];
	private void solve() throws IOException {
		// long time = System.currentTimeMillis();
		int test = nextInt();
		Arrays.fill(canSuprising, true);
		canSuprising[0] = false;
		canSuprising[1] = false;
		for (int i = 4; i <= 30 ; i += 3)
			canSuprising[i] = false;
		int maxScore = 2;
		for (int i = 2; i <= 30; i += 3) {
			for (int j = i ; j <= Math.min(i + 2, 30); j++)
				isSuprisingMaxScore[j] = maxScore;
			maxScore++;
		}
		maxScore = 1;
		for (int i = 1; i <= 30; i += 3) {
			for (int j = i ; j <= Math.min(i + 2, 30); j++)
				isNotSuprisingMaxScore[j] = maxScore;
			maxScore++;
		}
		
		for (int i = 1; i <= test; i++) {
			solveTest(i);
		}
		writer.close();
		// writer.println("Running time: " + (System.currentTimeMillis() -
		// time));
	}

	private void solveTest(int test) throws IOException {
		// TODO Auto-generated method stub
		int n = nextInt();
		int s = nextInt();
		int p = nextInt();
		int[] scores = new int[n+1];
		for (int i = 1; i <= n; i++)
			scores[i] = nextInt();
		int result = 0;
		for (int i = 1; i <= n; i++) {
			if (isNotSuprisingMaxScore[scores[i]] >= p) {
				result++;
				continue;
			}
			if (isSuprisingMaxScore[scores[i]] >= p && s >= 1) {
				result++;
				s--;
			}
		}
		writer.write("Case #" + test + ": "  + result + "\n");
	}

	public static void main(String[] args) {
		new Googler().run();
	}

	BufferedReader reader;
	StringTokenizer tokenizer;
	PrintWriter writer;
	String fileName = "Googler";
	public void run() {
		try {
			reader = new BufferedReader(new FileReader(fileName + ".in"));
			tokenizer = null;
			writer = new PrintWriter(new FileWriter(fileName + ".out"));
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