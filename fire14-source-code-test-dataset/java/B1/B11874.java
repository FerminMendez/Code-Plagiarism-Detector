package qualification_2012;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class PC {
	static Scanner sc = new Scanner(System.in);
	static PrintWriter pw = new PrintWriter(System.out);

	public static void main(String[] args) {
		int n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			pw.println("Case #" + i + ": " + calculate(a, b));
		}
		pw.flush();
	}

	static long calculate(int a, int b) {
		long result = 0;

		for (int j = a; j < b; j++) {
			result += count(j, b);
		}
		return result;
	}

	static int count(int n, int max) {
		String str = n + "";
		int m = str.length();
		int result = 0;
		ArrayList<Integer> store = new ArrayList<Integer>();
		for (int i = 1; i < m; i++) {
			int b1 = (int) Math.pow(10, i);
			int b2 = (int) Math.pow(10, m - i);
			int x = (n % b1) * b2 + n / b1;
			if (x > n && x <= max && !store.contains(x)) {
				store.add(x);
				result++;
			}
		}

//		if (result > 0)
//			pw.println(n + " " + result);
		return result;
	}
}
