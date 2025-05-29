import java.util.Scanner;

/*
 */

public class C {
	public static void main(String[] args) {
		String stA, stB;
		int a, b, bb, success = 0;
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i = 1; i <= t; i++) {
			a = in.nextInt();
			b = in.nextInt();
			success = 0;
			for (int j = a; j <= b; j++) {
				stA = Integer.toString(j);
				for (int k = stA.length() - 1; k > 0; k--) {
					stB = stA.substring(k);
					stB = stB + stA.substring(0, k);
					bb = Integer.valueOf(stB);
					if (j < bb && bb <= b) {
						success++;
					}
				}
			}
			System.out.format("Case #%d: %d\n", i, success);
		}
	}
}