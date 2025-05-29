import java.util.Scanner;

public class Recyclers {

	private static int countRecycled(int a, int b) {
		int recycled = 0;
		for (int i = a; i <= b; i++) {
			String s = new Integer(i).toString();
			for (int j = 0; j < s.length() - 1; j++) {
				String o = s.substring(s.length() - j - 1, s.length()).concat(
						s.substring(0, s.length() - j - 1));
				int n = Integer.valueOf(s);
				int m = Integer.valueOf(o);
				if (n < m && m <= b) {
					recycled++;
				}
			}
		}
		return recycled;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		for (int x = 0; x < cases; x++) {
			sc.nextLine();
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = countRecycled(a, b);
			System.out.println("Case #" + (x + 1) + ": " + c);
		}
	}
}
