import java.util.Scanner;

public class RecycledNumbers {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		for (int x = 0; x < t; x++) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			int y = RecycledNumbers.recycledCount(a, b);
			System.out.printf("Case #%d: %d%n", x + 1, y);
		}
		scanner.close();
	}

	public static int recycledCount(int n1, int n2) {
		int recycled = 0;

		for (int x = n1; x <= n2; x++) {
			String s = String.valueOf(x);
			for (int i = 0; i < s.length() - 1; i++) {
				String s2 = s.substring(i + 1) + s.substring(0, i + 1);
				int x2 = Integer.parseInt(s2);
				if (x2 >= n1 && x2 <= n2 && x2 > x) {
					recycled++;
				}
			}
		}
		return recycled;
	}
}
