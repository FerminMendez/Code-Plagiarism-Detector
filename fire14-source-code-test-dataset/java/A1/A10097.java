import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		try {
			inputStream = new FileInputStream("a.in");
			outputStream = new FileOutputStream("a.out");
		} catch (FileNotFoundException e) {
			System.err.println("File not found");
			return;
		}
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		Solver solver = new Solver();
		solver.solve(in, out);
		out.close();
	}
}

class Solver {
	public void solve(InputReader in, PrintWriter out) {
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			int n = in.nextInt();
			int s = in.nextInt();
			int p = in.nextInt();
			int ans = 0;
			for (int j = 0; j < n; j++) {
				int a = in.nextInt();
				if (a == 0) {
					if (p == 0)
						ans++;
					continue;
				}
				if ((a + 2) / 3 >= p) {
					ans++;
					continue;
				}
				if (s > 0)
					if (a % 3 != 1 && ((a + 2) / 3 + 1 >= p)) {
						ans++;
						s--;
					}
			}
			out.print("Case #");
			out.print(i + 1);
			out.print(": ");
			out.println(ans);
		}
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

	public long nextLong() {
		return Long.parseLong(next());
	}

	public int nextInt() {
		return Integer.parseInt(next());
	}

	public double nextDouble() {
		return Double.parseDouble(next());
	}
}
