import java.util.Scanner;

/*
 * el resto es 0 --> puede ser caso especial y no
 * 		15 --> 5 5 5 ó 4 5 6
 * el resto es 1 --> puede ser caso especial y no
 * 		16 --> 4 6 6 ó 5 5 6
 * el resto es 2 --> puede ser caso especial y no
 * 		17 --> 5 7 7 ó 5 6 6 
 */

public class B {
	public static void main(String[] args) {
		final int JUDGES = 3;
		final int MINSCORE = 0;
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i = 1; i <= t; i++) {
			int n = in.nextInt();
			int s = in.nextInt();
			int p = in.nextInt();
			int success = 0;
			for (int j = 0; j < n; j++) {
				int totalScores = in.nextInt();
				int score = totalScores / JUDGES;
				int rest = totalScores % JUDGES;
				if (totalScores==MINSCORE) {
					if (p==MINSCORE) { 
						success++;
					}
				} else if (score >= p || (score+1>=p && rest>=1)) {
					success++;
				} else if (score + 1 >= p && rest < 1 && s > 0) {
					success++;
					s--;
				} else if (score + 2 >= p && rest == 2 && s > 0) {
					success++;
					s--;
				}
			}
			System.out.format("Case #%d: %d\n", i, success);
		}
	}
}