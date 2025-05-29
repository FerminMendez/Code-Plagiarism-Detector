import java.util.Scanner;

public class Dancing {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int caseCount = sc.nextInt();
		for (int i = 1; i <= caseCount; i++) {
			int N = sc.nextInt();
			int numSuprise = sc.nextInt();
			int p = sc.nextInt();
			int bestN = 0;
			for (int j = 1; j <= N; j++) {
				int result = getThree(sc.nextInt(), numSuprise, p);
				if (result > 1) {
					result = 1;
					numSuprise--;
				}
				bestN += result;
			}

			System.out.println("Case #" + i + ": " + bestN);
		}
	}

	private static int getThree(int total, int numSuprise, int p) {
		if (total == 0 && p > 0) {
			return 0;
		} else if ((total - p) < (p - 2) * 2) {
			return 0;
		} else if ((total - p) == (p - 2) * 2 || (total - p) == (p * 2 - 3)) {
			if (numSuprise <= 0) {
				return 0;
			} else {
				return 2;
			}
		} else {
			int average = total * 10 / 3;
			if (average % 10 == 0) {
				if (average >= p * 10) {
					return 1;
				} else {
					return 0;
				}
			} else if (average % 10 == 3) {
				if ((average + 7) >= p * 10) {
					return 1;
				} else {
					return 0;
				}
			} else {
				if ((average + 4) >= p * 10) {
					return 1;
				} else {
					return 0;
				}
			}
		}
	}
}
