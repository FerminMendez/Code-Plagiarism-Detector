import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.StringTokenizer;


public class Solution implements Runnable {
	
	private BufferedReader in;
	private StringTokenizer st;
	private PrintWriter out;
	
	private void solve() throws IOException {
		int t = nextInt();
		for (int test = 1; test <= t; test++) {
			int answer = readAndSolve();
			out.println("Case #" + test + ": " + answer);
		}
	}
	
	private int readAndSolve() throws IOException {
		int n = nextInt();
		int s = nextInt();
		int p = nextInt();
		int[] t = new int[n];
		for (int i = 0; i < n; i++) {
			t[i] = nextInt();
		}
		int[] maxNorm = calcMaxNormal(t);
		int[] maxStrange = calcMaxStrange(t);
		int[][] a = new int[n + 1][n + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				a[i][j] = -1;
			}
		}
		a[0][0] = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				if (a[i][j] >= 0) {
					int[] d = {maxNorm[i], maxStrange[i]};
					for (int k = 0; k < d.length; k++) {
						if (d[k] >= 0) {
							a[i + 1][j + k] = Math.max(a[i + 1][j + k], a[i][j] + (d[k] >= p ? 1 : 0));
						}
					}
				}
			}
		}
		return a[n][s];
	}

	private int[] calcMaxNormal(int[] t) {
		int[] result = new int[t.length];
		for (int i = 0; i < t.length; i++) {
			result[i] = calcMaxNormal(t[i]);
		}
		return result;
	}

	private int calcMaxNormal(int sum) {
		return (sum + 2) / 3;
	}
	
	private int[] calcMaxStrange(int[] t) {
		int[] result = new int[t.length];
		for (int i = 0; i < t.length; i++) {
			result[i] = calcMaxStrange(t[i]);
		}
		return result;
	}

	private int calcMaxStrange(int sum) {
		int result;
		if (sum % 3 == 2) {
			result = sum / 3 + 2;
		} else {
			result = sum / 3 + 1;
		}
		if (result - 2 < 0 || result > 10) {
			return -1;
		}
		return result;
	}

	@Override
	public void run() {
		try {
			solve();
		} catch (Throwable e) {
			apstenu(e);
		} finally {
			out.close();
		}
	}
	
	private int nextInt() throws IOException {
		return Integer.parseInt(next());
	}
	
	private String next() throws IOException {
		while (!st.hasMoreTokens()) {
			String line = in.readLine();
			if (line == null) {
				return null;
			}
			st = new StringTokenizer(line);
		}
		return st.nextToken();
	}
	
	private void apstenu(Throwable e) {
		e.printStackTrace();
		System.exit(1);
	}
	
	public Solution(String filename) {
		try {
			in = new BufferedReader(new FileReader(filename + ".in"));
			st = new StringTokenizer("");
			out = new PrintWriter(new FileWriter(filename + ".out"));
		} catch (IOException e) {
			apstenu(e);
		}
	}
	
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		new Solution("data").run();
	}
	
}
