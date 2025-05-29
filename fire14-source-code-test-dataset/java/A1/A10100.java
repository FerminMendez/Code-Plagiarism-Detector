import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int k = 0; k < t; k++) {
			int n = sc.nextInt();
			int s = sc.nextInt();
			int p = sc.nextInt();

			int smin = p + (p - 2) + (p - 2);
			int smax = p + (p - 2) + (p - 1);

			smin = smin < 0 ? 0 : smin;
			smax = smax < 0 ? 0 : smax;

			int count = 0;
			int allow = s;
			for (int i = 0; i < n; i++) {
				int v = sc.nextInt();
				if (p == 0) {
					count++;
					continue;
				}
				
				if (v < p)
					continue;

				else if (smin == v || smax == v) {
					if (allow > 0) {
						count++;
						allow--;
					}
				} else if (v > smax) {
					count++;
				}
			}
			System.out.println("Case #" + (k + 1) + ": " + count);
		}

	}
}
