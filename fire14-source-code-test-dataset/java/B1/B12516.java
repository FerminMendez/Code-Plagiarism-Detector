package qual;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class C {
	
	private Scanner scanner;

	private void solve() throws FileNotFoundException {
		File input = new File("data\\qual\\C-small-attempt0.in");
		scanner = new Scanner(input);

		File test = new File("data\\qual\\C.out");
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
		int[] p10 = {
				1,
				10,
				100,
				1000,
				10000,
				100000,
				1000000,
				10000000,
				100000000,
				1000000000
		};
		
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int len = (a + "").length();
		Set ans = new HashSet();
		for (int i = 1; i < len; i++) {
			for (int prefix = p10[i - 1]; prefix < p10[i]; prefix++) {
				for (int suffix = p10[len - i - 1]; suffix < p10[len - i]; suffix++) {
					int n = prefix * p10[len - i] + suffix;
					int m = suffix * p10[i] + prefix;
					if (a <= n && n < m && m <= b) {
//						System.out.println(prefix + "-" + suffix + " " + n + " " + m);
						ans.add(n + "#" + m);
					}
				}
			}
		}
		System.out.println(ans.size());
	}

	public static void main(String[] args) throws FileNotFoundException {
		new C().solve();
	}

}
