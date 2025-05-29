import java.util.Scanner;


public class DancingWiththeGooglers {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int index = 1; index <= T; index++) {
			int N = in.nextInt();
			int S = in.nextInt();
			int p = in.nextInt();
			int count = 0;
			int matter = 0;
			int notmatter = 0;
			while (N-- > 0) {
				int score = in.nextInt();
				if (score >= 29) { //at least one judge gave 10
					count++;
				} else if (score <= 1) {
					if (score >= p)
						count++;
				} else {
					int div = score / 3;
					int mod = score % 3;
					if (mod == 0) {
						if (div + 1 >= p) {
							if (div + 1 == p)
								matter++;
							else
								notmatter++;
						}
					} else if (mod == 1) {
						if (div + 1 >= p)
							notmatter++;
					} else {
						if (div + 2 >= p) {
							if (div + 2 == p)
								matter++;
							else
								notmatter++;
						}
					}
				}
			}
			count += notmatter + Math.min(S, matter);
			System.out.println("Case #" + index + ": " + count);
		}
	}

}
/*
4
3 1 5 15 13 11
3 0 8 23 22 21
2 1 1 8 0
6 2 8 29 20 8 18 18 21
*/