import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {
	static int getGroup(int t, int p) {
		if (t >= 2) {
			if ((t + 1) / 3 + 1 < p) return 0;
			if ((t + 2) / 3 < p) return 1;
			return 2;
		} else if ((t + 2) / 3 >= p) return 3;
		return 4;
	}
	
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(new File("B-small-attempt0.in"));
		PrintWriter out = new PrintWriter(new File("out.txt"));
		int T = in.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			out.print("Case #" + tc + ": ");
			int n = in.nextInt(), s = in.nextInt(), p = in.nextInt();
			int cnt[] = new int[5];
			for (int i = 0; i < n; i++) {
				int t = in.nextInt();
				cnt[getGroup(t, p)]++;
			}
			int ans = cnt[3] + cnt[2] + Math.min(cnt[1], s);
			out.println(ans);
		}
		out.close();
	}

}
