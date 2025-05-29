package qualification;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(System.in);
			int lp = scanner.nextInt();
			int c = 0;
			for (int loop = 0; loop < lp; loop++) {
				int N = scanner.nextInt();
				int S = scanner.nextInt();
				int p = scanner.nextInt();
				int ans = 0;
				for (int j = 0; j < N; j++) {
					int t = scanner.nextInt();
					if (t < 2) {
						if (p <= t) {
							ans++;
						}
					}
					if (t == 2) {
						if (p < t) {
							ans++;
						}
						if (p == t && S > 0) {
							ans++;
							S--;
						}
					}
					if (t > 2) {
						if (t / 3 >= p) {
							ans++;
						} else {
							switch (t % 3) {
							case 0:
								if (t / 3 + 1 == p && S > 0) {
									S--;
									ans++;
								}
								break;
							case 1:
								if (t / 3 + 1 == p) {
									ans++;
								}
								break;
							case 2:
								if (t / 3 + 1 == p) {
									ans++;
								} else if (t / 3 + 2 == p && S > 0) {
									ans++;
									S--;
								}
								break;
							}
						}
					}
				}
				c++;
				System.out.println("Case #" + c + ": " + ans);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
