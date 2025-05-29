import java.util.*;


public class CodeJamB {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for (int i = 1; i <= t; i++) {
			int n = scan.nextInt();
			int s = scan.nextInt();
			int p = scan.nextInt();
			int a = 0;
			int b = 0;
			for (int j = 0; j < n; j++) {
				int x = scan.nextInt();
				if ((x + 2) / 3 >= p)
					a++;
				else if ((x % 3 == 0 && x >= 3 || x % 3 != 0) && (x + 4) / 3 >= p)
					b++;
			}
			System.out.printf("Case #%d: %d%n", i, a + Math.min(b, s));
		}
	}
	
}