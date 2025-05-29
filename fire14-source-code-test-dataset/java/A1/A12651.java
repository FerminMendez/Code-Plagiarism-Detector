import java.util.*;

public class Dancing {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int T = scan.nextInt();
		for (int i = 0; i < T; i++) {
			int n = scan.nextInt();
			int s = scan.nextInt();
			int p = scan.nextInt();

			int count = 0;
			for (int j = 0; j < n; j++) {
				int m = scan.nextInt();

				if (m - p < 0)
					continue;

				if ((m - p) / 2 >= p - 1)
					count++;
				else if ((m - p) / 2 >= p - 2 && s > 0) {
					count++;
					s--;
				}
			}
			System.out.println("Case #" + (i + 1) + ": " + count);
		}
	}
}
