package boy0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodeJam_B_Small {
	public static void main(String[] args) throws IOException {
		String strLine;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		CodeJam_B_Small me = new CodeJam_B_Small();

		me.init();

		strLine = br.readLine();
		int T = Integer.parseInt(strLine);
		String[] as;
		int n, s, p, y;
		int t[];
		for (int x = 1; x <= T; x++) {
			strLine = br.readLine();
			as = strLine.split(" ");
			n = Integer.parseInt(as[0]);
			s = Integer.parseInt(as[1]);
			p = Integer.parseInt(as[2]);
			t = new int[n];
			for (int i = 0; i < n; i++) {
				t[i] = Integer.parseInt(as[i + 3]);
			}
			y = me.get_max_over_p(n, s, p, t);
			System.out.println("Case #" + x + ": " + y);
		}
	}

	private int[][] total2best_scores = new int[31][2]; // total 0 ~ 30
	private static final int STANDARD = 0; // standard
	private static final int SURPRISING = 1; // surprising

	public void init() {
		for (int i = 0; i < total2best_scores.length; i++) {
			total2best_scores[i][STANDARD] = (i + 2) / 3;
			total2best_scores[i][SURPRISING] = (i + 4) / 3;
			if (total2best_scores[i][SURPRISING] == 1) {
				total2best_scores[i][SURPRISING] = 0;
			}
		}
	}

	public int get_max_over_p(int n, int s, int p, int[] t) {
		int y = 0;
		for (int i = 0; i < n; i++) {
			if (total2best_scores[t[i]][STANDARD] >= p) {
				y++;
			} else if (total2best_scores[t[i]][SURPRISING] == p) {
				if (s > 0) {
					s--;
					y++;
				}
			}
		}
		return y;
	}
}
