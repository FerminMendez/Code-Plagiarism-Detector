package codejam;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class RecycledNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {

		String fileName = "RecycledNumbers.small.txt";
		System.setIn(new FileInputStream("data/input/" + fileName));
		System.setOut(new PrintStream(new FileOutputStream("data/output/"
				+ fileName)));
		
		Scanner scanner = new Scanner(System.in);
		int testCases = scanner.nextInt();
		for (int i = 1; i <= testCases; i++) {
			Set<String> result = new HashSet<String>();
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			for (int j = a; j <= b; j++) {
				String n = String.valueOf(j);
				if (n.length() > 0) {
					for (int x = n.length() - 1; x > 0; x--) {
						String m = n.substring(x) + n.substring(0, x);
						if (!m.startsWith("0") && Integer.valueOf(n) >= a
								&& Integer.valueOf(n) < Integer.valueOf(m)
								&& Integer.parseInt(m) <= b) {
							result.add(n + "," + m);
						}
						// System.out.println(n + "," + m + "_countOfResult:"
						// + result.size());
					}
				}
			}
			System.out.println("Case #" + i + ": " + result.size());
		}

	}

}
