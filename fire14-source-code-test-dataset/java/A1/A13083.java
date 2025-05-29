import java.util.Scanner;

public class GooglerDance {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int size = in.nextInt();
		int count = 0;
		while (count < size) {
			int maxNum = 0;
			int googlers = in.nextInt();
			int[][] judges = new int[googlers][3];
			int[] scores = new int[googlers];
			boolean[] ishigher = new boolean[googlers];
			int s = in.nextInt();
			int p = in.nextInt();
			for (int i = 0; i < scores.length; i++) {// getting scores
				scores[i] = in.nextInt();
			}
			// computing scores
			for (int i = 0; i < scores.length; i++) {
				int ceil = scores[i] / 3;
				if ((scores[i] % 3) > 0) {
					ceil++;
				}
				if (ceil >= p) {
					ishigher[i] = true;
					maxNum++;
				}
				if ((3 * ceil) == scores[i]) {
					judges[i][0] = ceil;
					judges[i][1] = ceil;
					judges[i][2] = ceil;
					if (!ishigher[i] && (p - ceil) == 1 && s > 0
							&& (ceil - 1) > 0) {
						judges[i][0] = ceil + 1;
						judges[i][1] = ceil;
						judges[i][2] = ceil - 1;
						maxNum++;
						s--;
					}
				} else if ((3 * ceil) == (scores[i] + 1)) {
					judges[i][0] = ceil;
					judges[i][1] = ceil;
					judges[i][2] = ceil - 1;
					if (!ishigher[i] && (p - ceil) == 1 && s > 0
							&& (ceil - 1) > 0) {
						judges[i][0] = ceil + 1;
						judges[i][1] = ceil - 1;
						judges[i][2] = ceil - 1;
						maxNum++;
						s--;
					}
				} else if ((3 * ceil) == (scores[i] + 2)) {
					judges[i][0] = ceil;
					judges[i][1] = ceil - 1;
					judges[i][2] = ceil - 1;

				} else {
					System.out.println("Error in Algorithm");
				}
			}
			System.out.format("Case #%d: %d\n", count + 1, maxNum);
			count++;
		}
	}
}
