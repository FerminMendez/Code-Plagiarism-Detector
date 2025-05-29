import java.io.*;
import java.util.*;

public class DancingWithGooglers implements Runnable {
	public static void main(String[] args) throws IOException {
		new Thread(new DancingWithGooglers()).start();
	}

	public BufferedReader br;

	public StringTokenizer in;

	public PrintWriter out;

	public String nextToken() throws IOException {
		while (in == null || !in.hasMoreTokens()) {
			in = new StringTokenizer(br.readLine());
		}

		return in.nextToken();
	}

	public int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	public void solve() throws IOException {
		int n = nextInt();
		int S = nextInt();
		int p = nextInt();

		int[] t = new int[n];
		for (int i = 0; i < n; i++) {
			t[i] = nextInt();
		}

		Arrays.sort(t);

		int ans = 0;
		for (int i = n - 1; i >= 0; i--) {
			if ((t[i] + 2) / 3 >= p) {
				ans++;
			} else {
				if (((t[i] % 3 == 0 && t[i] / 3 + 1 >= p && t[i] != 0) || (t[i] % 3 == 2 && (t[i] + 1) / 3 + 1 >= p))
						&& S > 0) {
					ans++;
					S--;
				}
			}
		}

		out.println(ans);
	}

	public void run() {
		try {
			br = new BufferedReader(new FileReader("B-small.in"));
			out = new PrintWriter("b.out");

			int t = nextInt();
			for (int i = 0; i < t; i++) {
				out.print("Case #" + (i + 1) + ": ");
				solve();
			}

			out.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
}
