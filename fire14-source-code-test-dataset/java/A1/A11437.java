package gcj2012;

import java.util.Arrays;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long times = Integer.parseInt(sc.nextLine());
		for (long n = 0; n < times; n++) {
			String b = sc.nextLine();
			String[] bb = b.split(" ");
			int N = Integer.parseInt(bb[0]);
			int S = Integer.parseInt(bb[1]);
			int P = Integer.parseInt(bb[2]);
			Score[] score = new Score[N];
			for (int i = 0; i < N; i++) {
				score[i] = new Score(Integer.parseInt(bb[3 + i]));
			}
			Arrays.sort(score);
			int ret = 0;
			for (int i = 0; i < N; i++) {
				if (score[i].score[0] >= P)
					ret++;
				else {
					if (S > 0) {
						score[i].adjust();
						if (score[i].valid() && score[i].score[0]>=P) {
							ret++;
							S--;
						}

					}
				}
			}
			System.out.println("Case #" + (n + 1) + ": " + ret);
		}
	}
}

class Score implements Comparable<Score> {
	int[] score = new int[3];

	public Score(int s) {
		int q = s / 3;
		int r = s % 3;
		Arrays.fill(score, q);
		for (int i = 0; i < r; i++) {
			score[i] += 1;
		}
	}

	public boolean valid() {
		int max = Math.max(score[0], score[1]);
		max = Math.max(max, score[2]);
		int min = Math.min(score[0], score[1]);
		min = Math.max(min, score[2]);
		return max - min <= 2;
	}

	public void adjust() {
		if (score[0] == 0)
			return;
		if (score[2] > 0) {
			score[0]++;
			score[2]--;
			return;
		}
		if (score[1] > 0) {
			if (score[0] + 1 - score[2] <= 2
					&& score[0] + 1 - (score[1] - 1) <= 2) {
				score[0]++;
				score[1]--;
			}
		}
	}

	@Override
	public int compareTo(Score s1) {
		return s1.score[0] - this.score[0];
	}

}
