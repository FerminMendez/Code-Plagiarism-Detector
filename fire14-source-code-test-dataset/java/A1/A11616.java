package qualify;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i=0;i<t;i++) {
			int n = sc.nextInt();
			int s = sc.nextInt();
			int p = sc.nextInt();
			int total = 0;
			for (int j=0;j<n;j++) {
				int score = sc.nextInt();
				if (score >= 3 * p - 2) {
					total++;
				} else if (p >= 2 && score >= 3 * p - 4 && s > 0) {
					total++;
					s--;
				}
			}
			System.out.println("Case #" + (i + 1) + ": " + total);
		}
	}
}
