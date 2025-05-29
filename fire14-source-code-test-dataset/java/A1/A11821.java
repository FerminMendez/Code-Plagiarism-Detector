import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(new File("c:\\eclipse\\2\\B-small-attempt0.in"));
		int numTc = scanner.nextInt();
		for (int index = 0; index < numTc; index++) {
			int n = scanner.nextInt();
			int s = scanner.nextInt();
			int p = scanner.nextInt();
			int result = 0;
			for (int i = 0; i < n; i++) {
				int ti = scanner.nextInt();
				if (ti == 0 && p != 0) {
					continue;
				}
				int score = ti / 3;
				if (score >= p) {
					result++;
					continue;
				}
				if (score <= (p - 3)) {
					continue;
				}
				int rem = ti - (score * 3);
				if (score == (p - 1)) {
					if (rem > 0) {
						result++;
						continue;
					} else if (s > 0) {
						s--;
						result++;
						continue;
					}
				}
				if (score == (p - 2)) {
					if (rem > 1 && s > 0) {
						s--;
						result++;
						continue;
					}
				}
			}
			System.out.println("Case #" + (index + 1) + ": " + result);
			
		}
	}
}