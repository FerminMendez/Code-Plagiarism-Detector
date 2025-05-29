package Qualification_2012;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;

public class RecycledNumbers {

	static BufferedReader in;
	static int A, B;
	static boolean[][] v;
	static HashSet<String> hash;

	private static int get(int x) {
		int tmp = x;
		int c = 0;
		HashSet<Integer> hh = new HashSet<Integer>();

		int len = (x + "").length();

		int pow = (int) Math.pow(10, len);

		for (int i = 0; i < len - 1; i++) {
			boolean f = false;
			if (x % 10 == 0)
				f = true;

			x = ((x % 10) * pow + x) / 10;

			if (f)
				continue;
			if (x >= A && x <= B && tmp < x && len == (x + "").length()) {
				if (!hh.contains(x)) {
					hh.add(x);
					c++;
				}
			}
		}
		return c;
	}

	private static String solve() throws IOException {
		hash = new HashSet<String>();
		String s[] = in.readLine().split(" ");
		long ans = 0;
		A = Integer.parseInt(s[0]);
		B = Integer.parseInt(s[1]);
		for (int i = A; i < B; i++)
			ans += get(i);
		return ans + "";
	}

	public static void main(String[] args) throws IOException {

		in = new BufferedReader(new FileReader("in.in"));
		FileWriter out = new FileWriter("out.out");
		int t = Integer.parseInt(in.readLine());
		for (int i = 1; i <= t; i++) {
			out.write("Case #" + i + ": " + solve() + "\n");
		}
		in.close();
		out.close();
	}

}
