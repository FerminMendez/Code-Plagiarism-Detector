import java.util.*;

public class Dancers {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int times = sc.nextInt();

		for (int c = 1; c <= times; c++) {
			int players = sc.nextInt();
			int surprises = sc.nextInt();
			int best = sc.nextInt();

			int count = 0;

			int[] scores = new int[] { 0, 0, 0 };

			for (int i = 0; i < players; i++) {

				int score = sc.nextInt();

				scores[0] = scores[1] = scores[2] = score / 3;

				if (score / 3 >= best) {
					count++;
				}

				else {
					int difference = score - scores[0]*3;
					switch (difference) {
					case 0: {
						if (surprises > 0) {
							if (scores[0] > 0 && scores[0] + 1 >= best) {
								count++;
								surprises--;
							}
						}
						break;
					}

					case 1: {
						if (scores[0] + 1 >= best) {
							count++;
						} else if (surprises > 0) {

							if (scores[0] + 1 >= best) {
								count++;
								surprises--;
							}
						}
						break;
					}

					case 2: {
						if (scores[0] + 1 >= best) {
							count++;
						} else if (surprises > 0) {

							if (scores[0] + 2 >= best) {
								count++;
								surprises--;
							}
						}
						break;
					}
					
					default:
						break;
					}
				}

			}

			System.out.println("Case #"+c+": "+count);
		}

	}

}
