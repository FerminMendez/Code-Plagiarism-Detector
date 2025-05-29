import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class GCJ2012QB {
	static int[] a = new int[100];

	public static void main(String[] args) throws Exception {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		StringTokenizer st;
		int t = Integer.parseInt(r.readLine());
		int n, s, p, a, result, best;
		for (int i = 1; i <= t; i++) {
			st = new StringTokenizer(r.readLine());
			n = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			p = Integer.parseInt(st.nextToken());
			result = 0;
			for (int j = 0; j < n; j++) {
				a = Integer.parseInt(st.nextToken());
				best = maxBest(a);
				if (best >= p) {
					result++;
				} else {
					if (s > 0) {
						best = maxBestWithSurprise(a);
						if (best >= p) {
							result++;
							s--;
						}
					}
				}
			}
			pw.println("Case #" + i + ": " + result);
		}
		pw.flush();
	}

	private static int maxBestWithSurprise(int a) {
		if (a == 0) {
			return 0;
		} else {
			return (a + 4) / 3;
		}
	}

	private static int maxBest(int a) {
		return (a + 2) / 3;
	}
}
