import java.io.*;
import java.util.*;

public class taskB {

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
		int n = nextInt();
		int s = nextInt();
		int p = nextInt();
		int ans = 0;
		for (int i = 0; i < n; i++) {
			int a = nextInt();
			if (p > a)
				continue;
			if (p  * 3 - 2 <= a) {
				ans++;
				continue;
			}
			if (s == 0)
				continue;
			if (p * 3 - 4 <= a) {
				s--;
				ans++;
			}
		}
		out.println(ans);
	}

	public void run() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out);

			br = new BufferedReader(new FileReader("taskB.in"));
			out = new PrintWriter("taskB.out");
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
		new taskB().run();
	}
}
