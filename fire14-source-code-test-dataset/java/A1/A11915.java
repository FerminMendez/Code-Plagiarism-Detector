package qual;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Googlers {
	public static void main(String[] args) throws IOException {
		new Googlers().run();
	}
	int solve(int s, int p, int[] scores) {
		Arrays.sort(scores);
		for (int i = 0; i < scores.length / 2; i++) {
			int t = scores[i];
			scores[i] = scores[scores.length - 1 - i];
			scores[scores.length - 1 - i] = t;
		}
		int count = 0;
		for (int i = 0; i < scores.length; i++) {
			int cur = scores[i];
			int a, b, c;
			if (cur % 3 == 0) {
				a = cur / 3;
				b = cur / 3;
				c = cur / 3;
			} else if (cur % 3 == 1) {
				a = cur / 3 + 1;
				b = cur / 3;
				c = cur / 3;
			} else {
				a = cur / 3 + 1;
				b = cur / 3 + 1;
				c = cur / 3;
			}
			
			if (a >= p)
				count++;
			else {
				if (a == b && b > 0 && s > 0) {
					a++;
					b--;
					if (a >= p) {
						count++;
						s--;
					}
				}
			}
		}
		return count;
	}
	public void run() throws IOException {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int testsCount = in.nextInt();
		for (int t = 0; t < testsCount; t++) {
			int n = in.nextInt(), s = in.nextInt(), p = in.nextInt();
			int[] scores = new int[n];
			for (int i = 0; i < n; i++) {
				scores[i] = in.nextInt();
			}
			int ans = solve(s, p, scores);
			out.printf("Case #%d: %d\n", t + 1, ans);
		}
		
		out.close();
	}
}
