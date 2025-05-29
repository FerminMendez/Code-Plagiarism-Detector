package googlejam;

import java.util.Scanner;

public class ProblemB {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numberOfCases = sc.nextInt();
		for (int i = 0; i <= numberOfCases; i++) {
			int googlers = sc.nextInt();
			int suprisingTriplets = sc.nextInt();
			int p = sc.nextInt();
			int sum = 0;
			for (int j = 0; j < googlers; j++) {
				int points = sc.nextInt();
				if (p == 0) {
					sum++;
				} else if (p == 1) {
					if (points >= 1)
						sum++;
					else
						continue;
				} else if (points >= p * 3) {
					sum++;
				} else if ((p * 3 - points) <= 2) {
					sum++;
				} else if ((p * 3 - points) <= 4 && suprisingTriplets > 0) {
					sum++;
					suprisingTriplets--;
				}
			}
			System.out.println(String.format("Case #%d: %d", i + 1, sum));
		}
	}
}
