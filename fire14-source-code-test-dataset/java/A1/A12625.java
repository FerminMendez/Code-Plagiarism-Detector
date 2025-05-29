import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;


public class B {
	
	public static void main(String[] args) {
		try {
			// so eclipse can read file from system in
			System.setIn(new FileInputStream(new File("small.in")));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		Scanner scanner = new Scanner(System.in);
		long T = scanner.nextLong();
		scanner.nextLine();
		for (int i = 0; i < T; i++) {
			long N = scanner.nextLong();
			long S = scanner.nextLong();
			long p = scanner.nextLong();
			long y = 0;
			for (int j = 0; j < N; j++) {
				long score = scanner.nextLong();
				double mean = (double)score / 3;
				if (mean <= (double)p - 2) {
					continue;
				} else if (mean >= (double)p ) {
					y++;
					continue;
				}
				int result = test(score, p - 1);
				if (result == 0) {
					y++;
				} else if (result == 1 && S > 0) {
					y++;
					S--;
				}
			}
			System.out.printf("Case #%d: %d%n", i + 1, y);
		}
	}
	
	private static int test(long score, long q) {
		int result = -1;
		long from = q - 1;
		if (from < 0) {
			from = 0;
		}
		long to = q + 1;
		if (to > 10) {
			to = 10;
		}
		for (long a = from; a <= to; a++) {
			for (long b = from; b <= to; b++) {
				for (long c = from; c <= to; c++) {
					if (a + b + c == score) {
						if ((a == q + 1) || (b == q + 1 )|| (c == q + 1)) {
							if (Math.abs(a - b) == 2 || Math.abs(a - c) == 2 || Math.abs(b - c) == 2) {
								result = 1;
							} else {
								return 0;
							}
						}
						
					}
				}
			}
		}
		return result;
			
	}

}
