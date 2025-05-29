import java.io.*;
import java.util.*;

public class taskC {

	PrintWriter out;
	BufferedReader br;
	StringTokenizer st;

	String nextToken() throws IOException {
		while ((st == null) || (!st.hasMoreTokens()))
			st = new StringTokenizer(br.readLine());
		return st.nextToken();
	}

	public int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	public long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}

	public double nextDouble() throws IOException {
		return Double.parseDouble(nextToken());
	}

	public void solve() throws IOException {
		int a = nextInt();
		int b = nextInt();
		int d = 1;
		int ans = 0;
		for (int i = a; i <= b; i++) {
			int t = i;
			while (t / (d * 10) != 0) {
				d *= 10;
			}
			do {
				t = (t % d) * 10 + (t / d);
				if ((t > i) && (t <= b))
					ans++;
			} while (t != i);
		}
		out.println(ans);
	}

	public void run() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out);

			br = new BufferedReader(new FileReader("taskC.in"));
			out = new PrintWriter("taskC.out");
			int n = nextInt();
			for (int i = 0; i < n; i++) {

				out.print("Case #" + (i + 1) + ": ");
				solve();
			}

			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new taskC().run();
	}
}
