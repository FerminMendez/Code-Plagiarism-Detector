import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B {

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		for (int m = 0; m < n; m++) {
			String[] parts = in.readLine().split(" ");
			int googlers = Integer.parseInt(parts[0]);
			int s = Integer.parseInt(parts[1]);
			int p = Integer.parseInt(parts[2]);

			int[] scores = new int[googlers];
			for (int i = 0; i < googlers; i++) {
				scores[i] = Integer.parseInt(parts[i + 3]);
			}

			Arrays.sort(scores);

			int winners = 0;

			for (int score : scores) {
				int j1 = score / 3 + 1;
				int[] judge = { j1, j1, j1 };
				int sum = j1 * 3;
				for (int i = 0; sum > score; i++) {
					judge[i % 3]--;
					sum--;
				}
				if (judge[2] >= p) {
					winners++;
					continue;
				}
				if (judge[2] == p - 1 && s > 0) {
					if (judge[0] == judge[2] && judge[0] != 0) {
						winners++;
						s--;
						continue;
					}
					if (judge[1] == judge[2] && judge[1] != 0) {
						winners++;
						s--;
						continue;
					}
				}
			}

			System.out.println("Case #" + (m + 1) + ": " + winners);
		}

	}
}