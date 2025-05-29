package qual;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class B {
	
	private Scanner scanner;

	private void solve() throws FileNotFoundException {
		File input = new File("data\\qual\\B-small-attempt0.in");
		scanner = new Scanner(input);

		File test = new File("data\\qual\\B.out");
		PrintStream out = new PrintStream(new FileOutputStream(test));
		System.setOut(out);

		int testCase = scanner.nextInt();
		scanner.nextLine();

		for (int i = 1; i <= testCase; i++) {
			System.out.printf("Case #%d: ", i);
			solveCase();
		}

	}

	private void solveCase() {
		int n = scanner.nextInt();
		int s = scanner.nextInt();
		int p = scanner.nextInt();
		int ans = 0;
		for (int i = 0; i < n; i++) {
			int t = scanner.nextInt();
			int normMax;
			int fuckMax;
			int fuckMin;
			
			if (t % 3 == 0) {
				normMax = t / 3;
				fuckMax = (t + 3) / 3;
				fuckMin = (t - 3) / 3;
			} else if (t % 3 == 1) {
				normMax = (t + 2) / 3;
				fuckMax = (t + 2) / 3;
				fuckMin = (t + 2) / 3;
			} else {
				normMax = (t + 1) / 3;
				fuckMax = (t + 4) / 3;
				fuckMin = (t - 2) / 3;
			}
			
			if (normMax >= p) {
				ans++;
			} else if (s > 0 && fuckMax >= p && fuckMin >= 0) {
				ans++;
				s--;
			}
		}
		System.out.println(ans);
	}

	public static void main(String[] args) throws FileNotFoundException {
		new B().solve();
	}

}
