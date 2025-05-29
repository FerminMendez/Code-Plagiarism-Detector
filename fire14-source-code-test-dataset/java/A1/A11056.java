import java.util.Scanner;

public class GoogleDancers {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		for (int i = 1; i <= n; i++) {
			int N = scan.nextInt();
			int S = scan.nextInt();
			int p = scan.nextInt();
			int count = 0;
			int p2 = (p - 1) + (p - 1) + p;

			int t;
			int t1;
			for (int j = 0; j < N; j++) {
				t = scan.nextInt();
				if (t > 0 || p == 0) {
					if ((t1 = t - p2) >= 0)
						count++;
					else if (t1 + 2 >= 0 && S-- > 0)
						count++;
				}
			}
			System.out.println("Case #" + i + ": " + count);
		}
	}
}
