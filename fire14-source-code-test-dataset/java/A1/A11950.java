package jam.qualification;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class DancingWithTheGooglers {
	public static void main(String[] args) {
		try {
			BufferedReader in = new BufferedReader(new FileReader("file.in"));
			BufferedWriter out = new BufferedWriter(new FileWriter("file.out"));
			int n = Integer.parseInt(in.readLine());
			for (int i = 1; i <= n; ++i) {
				String[] ints = in.readLine().split(" ");
				int N = Integer.parseInt(ints[0]);
				int S = Integer.parseInt(ints[1]);
				int p = Integer.parseInt(ints[2]);
				int[] ts = new int[N];
				for (int j = 0; j < N; ++j)
					ts[j] = Integer.parseInt(ints[3 + j]);
				int m = 0;
				try {
					m = max(N, S, p, ts);
				}
				catch (Exception e) {
					System.err.println("Unexpected exception, I made a mistake...");
					e.printStackTrace();
					System.exit(1);
				}
				out.write("Case #" + i + ": " + m);
				if (i != n)
					out.newLine();
			}
			out.close();
		}
		catch (Exception e) {
			System.err.println("Unexpected error occured while reading input!");
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	private static int max(int N, int S, int p, int[] ts) {
		if (N > 0) {
			int t = ts[--N];
			int k = t / 3;
			int a, b;
			switch (t % 3) {
				case 0:
					// k k k
					a = (k >= p ? 1 : 0) + max(N, S, p, ts);
					// k-1 k k+1 (*)
					b = (k - 1 >= 0 && k + 1 >= p ? 1 : 0) + max(N, S - 1, p, ts);
					break;
				case 1:
					// k k k+1
					a = (k + 1 >= p ? 1 : 0) + max(N, S, p, ts);
					// k-1 k+1 k+1 (*)
					b = (k - 1 >= 0 && k + 1 >= p ? 1 : 0) + max(N, S - 1, p, ts);
					break;
				case 2:
					// k k+1 k+1
					a = (k + 1 >= p ? 1 : 0) + max(N, S, p, ts);
					// k k k+2 (*)
					b = (k + 2 >= p ? 1 : 0) + max(N, S - 1, p, ts);
					break;
				default:
					return Integer.MIN_VALUE; // never happens.
			}
			return Math.max(a, b);
		}
		return S == 0 ? 0 : Integer.MIN_VALUE;
	}
}
