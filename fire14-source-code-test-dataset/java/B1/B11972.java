import java.util.*;


public class CodeJamC {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for (int i = 1; i <= t; i++) {
			int n = 0;
			int a = scan.nextInt();
			int b = scan.nextInt();
			for (int j = a; j <= b; j++) {
				int x = j;
				int m = 1;
				while (true) {
					x = rotate(x);
					if (x == j) {  // Cycled
						n += m * (m - 1) / 2;
						break;
					} else if (a <= x && x <= b) {
						if (x < j)  // Duplicate
							break;
						else
							m++;
					}
				}
			}
			System.out.printf("Case #%d: %d%n", i, n);
		}
	}
	
	
	private static int rotate(int x) {
		String s = x + "";
		while (true) {
			s = s.substring(1) + s.charAt(0);
			if (s.charAt(0) != '0')
				return Integer.parseInt(s);
		}
	}
	
}