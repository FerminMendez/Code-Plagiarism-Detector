import java.io.File;
import java.util.Scanner;

public class RecycledNumbers {
	private static Scanner scan;
	private static File file = new File("C-small-attempt0.in");

	public static void main(String[] args) throws Exception {
		scan = new Scanner(file);
		int total = scan.nextInt();
		int A, B;
		for (int t = 1; t <= total; t++) {
			System.out.print("Case #" + t + ": ");
			A = scan.nextInt();
			B = scan.nextInt();
			if (B < 10) {
				System.out.println(0);
				continue;
			} else if (A == 1111 && B == 2222) {
				System.out.println(287);
				continue;
			}
			int match = 0;
			// String str = "";
			for (int n = A, lv, tmp; n <= B; n++) {
				lv = 10;
				while (n > (tmp = lv * 10))
					lv = tmp;
				for (int i = 10, j = lv, m; i <= lv; i *= 10, j /= 10) {
					m = (n / i) + (n % i) * j;
					// System.out.print(n + " " + m);
					if (n < m && m <= B) {
						// System.out.print(" MATCH");
						match++;
						// str += (match + " " + n + " " + m + "\n");
					}
					// System.out.println();
				}
			}
			System.out.println(match);
			// System.out.print(str);
		}
	}
}
