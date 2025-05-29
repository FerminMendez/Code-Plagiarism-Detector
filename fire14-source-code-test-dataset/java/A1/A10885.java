import java.util.Scanner;


public class B {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int nCases = sc.nextInt();
		for (int i = 1; i <= nCases; i++) {
			int n = sc.nextInt();
			int s = sc.nextInt();
			int p = sc.nextInt();

			int y = 0;

			for (int zz = 0; zz < n; zz++) {
				int cScore = sc.nextInt();
				if (cScore >= (p * 3 - 2)) {
					y++;
				} else if (s > 0 && cScore != 0 && cScore >= (p * 3 - 4)) {
					y++;
					s--;
				}
			}

			System.out.println("Case #" + i + ": " + y);
		}
	}
}
