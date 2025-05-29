import java.util.*;

public class Recycle {
	static boolean[][] recycled = new boolean[10000][10000];

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int T = scan.nextInt();
		for (int i = 0; i < T; i++) {
			int min = scan.nextInt();
			int max = scan.nextInt();

			int count = 0;
			for (int n = min; n < max; n++) {
				int len = len(n);
				for (int m = n + 1; m < Math.min((int)Math.pow(10, len), max + 1); m++) {
					if (recycled[n][m])
						count++;
					else if (isRecycled(n, m)) {
						count++;
						if (m <= recycled.length)
							recycled[n][m] = true;
					}
				}
			}
			System.out.println("Case #" + (i + 1) + ": " + count);
		}
	}

	static int len(int a) {
		int d = 1, len = 0;
		while (a / d > 0) {
			len++;
			d *= 10;
		}
		return len;
	}

	static boolean isRecycled(int n, int m) {
		int l = len(n);
		if (l != len(m))
			return false;

		int d = 10;
		int pow = (int)Math.pow(10, l);
		while (n / d > 0) {
			if ((n % d) * (pow / d) + n / d == m)
				return true;
			d *= 10;
		}
		return false;
	}
}
