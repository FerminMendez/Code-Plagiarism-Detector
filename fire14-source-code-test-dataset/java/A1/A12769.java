package b;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.AttributedCharacterIterator;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		InputStream inputStream;
		try {
			inputStream = new FileInputStream("input.txt");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		OutputStream outputStream;
		try {
			outputStream = new FileOutputStream("output.txt");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		Dancing solver = new Dancing();
		int testCases = in.nextInt();
		for (int i = 1; i <= testCases; i++)
			solver.solve(i, in, out);

		out.close();
	}
}

class InputReader {
	private BufferedReader reader;
	private StringTokenizer tokenizer;

	public InputReader(InputStream stream) {
		reader = new BufferedReader(new InputStreamReader(stream));
		tokenizer = null;
	}

	public String next() {
		while (tokenizer == null || !tokenizer.hasMoreTokens()) {
			try {
				tokenizer = new StringTokenizer(reader.readLine());
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		return tokenizer.nextToken();
	}

	public boolean haveNextInCurrentLine() {
		return (tokenizer != null && tokenizer.hasMoreTokens());
	}

	public int nextInt() {
		return Integer.parseInt(next());
	}
}

class Dancing {

	static final int IMPOSSIBLE = 0, POSSIBLE = 1, ACHIEVED = 2;

	public void solve(int testCase, InputReader in, PrintWriter out) {
		int n = in.nextInt();
		int s = in.nextInt();
		int p = in.nextInt();
		int[] t = new int[n];
		for (int i = 0; i < n; i++) {
			t[i] = in.nextInt();
		}

		System.out.println("Case #" + testCase + ": " + n + " " + s + " " + p
				+ " " + Arrays.toString(t));

		int result = n;
		if (p > 0) {
			int possible = 0;
			int achieved = 0;

			for (int i = 0; i < n; i++) {
				System.out
						.println("n: " + (i + 1) + " = " + getResult(t[i], p));
				switch (getResult(t[i], p)) {
				case ACHIEVED:
					achieved++;
					break;
				case POSSIBLE:
					possible++;
					break;
				}
			}

			result = achieved + Math.min(possible, s);
		}

		out.println("Case #" + testCase + ": " + result);
		System.out.println("Case #" + testCase + ": " + result);
	}

	private int getResult(int sum, int p) {
		if (sum < p)
			return IMPOSSIBLE;

		int third = sum / 3;
		if (third >= p)
			return ACHIEVED;

		if (sum % 3 == 0) {
			if ((sum - 2) / 3 + 2 >= p)
				return POSSIBLE;
		} else {
			if (third + 1 >= p)
				return ACHIEVED;
			else if ((sum - 2) / 3 + 2 >= p)
				return POSSIBLE;
		}

		return IMPOSSIBLE;
	}
}