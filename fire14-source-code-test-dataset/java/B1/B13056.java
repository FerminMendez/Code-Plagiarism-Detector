package googlejam;

import java.util.Scanner;

public class ProblemC {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numberOfCases = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < numberOfCases; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int sum = 0;
			for (int a = A; a <= B; a++) {
				for (int b = a + 1; b <= B; b++) {
					if (recycled(a, b)) {
						sum++;
					}
				}
			}
			System.out.println(String.format("Case #%d: %d", i + 1, sum));
		}
	}

	private static boolean recycled(int a, int b) {
		String aString = Integer.toString(a);
		String bString = Integer.toString(b);
		if ((aString + aString).contains(bString)) {
			return true;
		}
		return false;
	}
}
