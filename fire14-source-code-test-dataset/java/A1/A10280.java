import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B {
	static int[][] dp;
	static int[] sum;
	static int p;

	public static int abs(int a) {
		return (a < 0) ? -a : a;
	}

	public static int go(int i, int j) {
		if (j < 0)
			return -1000;
		if (i == sum.length) {
			if (j != 0)
				return -1000;
			else
				return 0;
		}

		else if (dp[i][j] != -1)
			return dp[i][j];
		else {
			int max = 0;
			for (int a = 0; a <= 10; a++)
				for (int b = 0; b <= 10 && a + b <= sum[i]; b++)
					for (int c = 0; c <= 10 && c + a + b <= sum[i]; c++) {
						if (abs(a - b) <= 2 && abs(a - c) <= 2
								&& abs(b - c) <= 2) {
							int cool = 0;
							int awesome = 0;
							if (abs(a - b) == 2 || abs(b - c) == 2
									|| abs(a - c) == 2)
								cool = 1;
							if (a >= p || b >= p || c >= p)
								awesome = 1;
							max = Math.max(max, awesome + go(i + 1, j - cool));
						}
					}
			return dp[i][j] = max;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(
				new FileInputStream("B.in")));
		PrintWriter out = new PrintWriter("B.out");
		int tc = Integer.parseInt(in.readLine());
		for (int cc = 1; cc <= tc; cc++) {
			StringTokenizer strtok = new StringTokenizer(in.readLine(), " ");
			int n = Integer.parseInt(strtok.nextToken());
			int s = Integer.parseInt(strtok.nextToken());
			p = Integer.parseInt(strtok.nextToken());
			dp = new int[n][s + 1];
			for (int[] a : dp)
				Arrays.fill(a, -1);
			sum = new int[n];
			for (int i = 0; i < n; i++)
				sum[i] = Integer.parseInt(strtok.nextToken());
			out.printf("Case #%d: %d\n", cc, go(0, s));
		}
		out.close();
		in.close();
	}
}
