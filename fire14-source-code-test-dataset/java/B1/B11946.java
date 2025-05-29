import java.io.*;
import java.util.*;

public class C {
	
	BufferedReader br;
	PrintWriter out;
	StringTokenizer st;
	boolean eof;
	
	enum InputType {
		SAMPLE, SMALL, LARGE;
	}
	
	static final InputType currentInputType = InputType.SMALL;
	static final int attemptNumber = 0; // for small inputs only
	
	int pow10;
	
	void solve() throws IOException {
		int a = nextInt();
		int b = nextInt();
		
		pow10 = 1;
		int cnt = Integer.toString(a).length();
		for (int i = 0; i < cnt - 1; i++)
			pow10 *= 10;
		
		long ans = 0;
		
		for (int i = a; i <= b; i++) {
			for (int j = (i % 10) * pow10 + (i / 10); j != i; j = (j % 10) * pow10 + j / 10)
				if (a <= j && j <= b && j > i)
					ans++;
		}
		
		out.println(ans);
	}
	
	void inp() throws IOException {
		switch (currentInputType) {
		case SAMPLE:
			br = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out);
			break;
		case SMALL:
			String fileName = "C-small-attempt" + attemptNumber;
			br = new BufferedReader(new FileReader(fileName + ".in"));
			out = new PrintWriter(fileName + ".out");
			break;
		case LARGE:
			fileName = "C-large";
			br = new BufferedReader(new FileReader(fileName + ".in"));
			out = new PrintWriter(fileName + ".out");
			break;
		}
		int test = nextInt();
		for (int i = 1; i <= test; i++) {
			System.err.println("Running test " + i);
			out.print("Case #" + i + ": ");
			solve();
		}
		out.close();
	}
	
	public static void main(String[] args) throws IOException {
		new C().inp();
	}
	
	String nextToken() {
		while (st == null || !st.hasMoreTokens()) {
			try {
				st = new StringTokenizer(br.readLine());
			} catch (Exception e) {
				eof = true;
				return null;
			}
		}
		return st.nextToken();
	}
	
	String nextString() {
		try {
			return br.readLine();
		} catch (Exception e) {
			eof = true;
			return null;
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
}
