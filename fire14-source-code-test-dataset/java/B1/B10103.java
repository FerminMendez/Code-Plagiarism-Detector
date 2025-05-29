import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		try {
			inputStream = new FileInputStream("c.in");
			outputStream = new FileOutputStream("c.out");
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
			int a = in.nextInt();
			int b = in.nextInt();
			int ans = 0;
			for (int j = a; j <= b; ++j) {
				String s = (new Integer(j)).toString();
				TreeSet<Integer> use = new TreeSet<Integer>();
				for (int k = 0; k < s.length() - 1; k++) {
					s = (s.substring(1)).concat(s.substring(0, 1));
					//System.err.println(s);
					if (s.charAt(0) == '0') {
						continue;
					}
					int w = Integer.parseInt(s); 
					if (w > j && w <= b && !use.contains(w)) {
						ans++;
						use.add(w);
					}
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
