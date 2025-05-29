import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class C {
	static int[] tens = { 1, 10, 100, 1000, 10000, 100000, 1000000 };

	static HashSet<Integer> set = new HashSet<Integer>();

	static private int countPairs(int a, int max, int len) {
		int rhs, lhs, num;
		set.clear();
		int res = 0;
		for (int i = 1; i < len; i++) {
			lhs = a % tens[i];
			rhs = a / tens[i];
			if (lhs == 0)
				continue;
			num = lhs * tens[len - i] + rhs;
			if (set.contains(num))
				continue;

			if (a < num && num <= max) {
				res++;
				set.add(num);
			}
		}
		return res;
	}

	static private int numberLength(int n) {
		int len = Arrays.binarySearch(tens, n);
		if (len < 0)
			len = ~len;
		else
			len++;
		return len;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new FileInputStream("C-small-attempt0.in"));
		FileWriter out = new FileWriter(new File("C-small-attempt0.out"));
		int t = in.nextInt(),cnt = 1;
		while (t-->0) {
			int a = in.nextInt(), b = in.nextInt();
			int tmp = 0;
			for (int i = a; i <= b; i++)
				tmp += countPairs(i, b, numberLength(i));
			out.write("Case #" + cnt++ + ": " + tmp+"\n");
		}
		in.close();
		out.close();
	}
}
