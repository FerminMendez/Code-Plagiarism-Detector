import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Scanner;

public class DanceWithGoogler {
	public static void main(String[] args) {
		try {

			Scanner sc = new Scanner(new File("Redownload B-small.in.txt"));
			int T = 0;
			FileWriter fw = new FileWriter("output.txt");

			T = Integer.parseInt(sc.nextLine());
			for (int i = 1; i <= T; i++) {

				fw.append("Case #" + i + ": " + hadleCase(i, sc.nextLine())
						+ "\n");

			}
			fw.close();

		} catch (Exception e) {

		}
	}

	private static int hadleCase(int line, String next) {
		String[] param = next.split(" ");
		int N = Integer.parseInt(param[0]);
		int S = Integer.parseInt(param[1]);
		int P = Integer.parseInt(param[2]);

		int y = 0;

		HashMap<Integer, Integer[]> map = new HashMap<Integer, Integer[]>();

		for (int i = 0; i < N; i++) {
			int score_total = Integer.parseInt(param[i + 3]);

			int score_avg = score_total / 3;
			int score_remain = score_total % 3;

			map.put(i, new Integer[] { score_avg, score_remain });

		}

		for (int key : map.keySet()) {
			Integer[] score = map.get(key);

			int score_avg = score[0];
			int score_remain = score[1];

			if (score_avg < P && (score_avg > 0 || score_remain > 0)) {
				if ((score_avg + 1) >= P) {

					int score_total = Integer.parseInt(param[key + 3]);
					int big = score_avg + 1;
					int mid = (score_total - big) / 2;
					int small = score_total - big - mid;

					if (big - small <= 1 && big - mid <= 1) {

						score_avg += 1;

					} else if (S > 0 && big - small <= 2 && big - mid <= 2) {
						score_avg += 1;
						S--;
					}

				} else if (S > 0 && (score_avg + 2) >= P
						&& (score_avg + 2) <= 30) {
					int score_total = Integer.parseInt(param[key + 3]);
					int big = score_avg + 2;
					int mid = (score_total - big) / 2;
					int small = score_total - big - mid;

					if (big - small <= 2 && big - mid <= 2) {

						score_avg += 2;
						S--;
					}
				}
			}

			if (score_avg >= P) {
				y++;
			}

		}
		return y;
	}
}
