import java.util.*;

public class Dancing {
	private static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int T = s.nextInt();

		for (int t = 0; t < T; t++) {
			int N = s.nextInt();
			int S = s.nextInt();
			int p = s.nextInt();

			int[] sums = new int[N];
			boolean[] satisfied = new boolean[N];

			for (int i = 0; i < N; i++) sums[i] = s.nextInt();

			for (int i = 0; i < N; i++) {
				int low = Math.max(p - 1, 0);
				if (p + low * 2 > sums[i]) continue;
				satisfied[i] = true;
			}

			for (int i = 0; i < N; i++) {
				if (S == 0) break;
				if (satisfied[i]) continue;
				int low = Math.max(p - 2, 0);
				if (p + low * 2 > sums[i]) continue;
				satisfied[i] = true;
				S--;
			}

			int max = 0;
			for (int i = 0; i < N; i++)
				if (satisfied[i])
					max++;

			System.out.printf("Case #%d: %d\n", t + 1, max);
		}
	}
}
