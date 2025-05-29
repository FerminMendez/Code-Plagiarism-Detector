import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Recycle {

	public static void main(String[] args) throws IOException {
		long t0 = System.currentTimeMillis();
		BufferedReader in = new BufferedReader(new FileReader("in.txt"));
		PrintWriter out = new PrintWriter("out.txt");
		int t = Integer.parseInt(in.readLine());
		for (int i = 1; i <= t; i++) {
			String[] ss = in.readLine().split(" ");
			int from = Integer.parseInt(ss[0]);
			int to = Integer.parseInt(ss[1]);
			out.println("Case #" + i + ": " + compute(from, to));
			System.out.println("Case #" + i + ": " + compute(from, to));
		}
		out.close();
		System.out.println("time: " + (System.currentTimeMillis() - t0));
	}

	private static int[] maxNum = { 0, 9, 99, 999, 9999, 99999, 999999, 2000000 };
	private static int[] precomputed = { 0, 0, 36, 801, 12060, 161982, 2023578, 299997 };

	private static int compute(int from, int to) {
		int dFrom = from <= 9 ? 1 : from <= 99 ? 2 : from <= 999 ? 3 : from <= 9999 ? 4 : from <= 99999 ? 5 : from <= 999999 ? 6 : 7;
		int dTo = to <= 9 ? 1 : to <= 99 ? 2 : to <= 999 ? 3 : to <= 9999 ? 4 : to <= 99999 ? 5 : to <= 999999 ? 6 : 7;
		int count;
		if (dFrom == dTo) {
			count = compute(from, to, dFrom);
		} else {
			count = 0;
			count += compute(from, maxNum[dFrom], dFrom);
			for (int i = dFrom + 1; i < dTo; i++) {
				// count += compute(maxNum[i - 1] + 1, maxNum[i], i);
				count += precomputed[i];
			}
			count += compute(maxNum[dTo - 1] + 1, to, dTo);
		}
		return count;
	}

	private static int compute(int from, int to, int digits) {
		int count = 0;
		int f = 1;
		for (int d = 1; d < digits; d++) {
			f *= 10;
		}
		List<Integer> recycled = new ArrayList<Integer>();
		for (int n = from; n <= to; n++) {
			recycled.clear();
			int m = n;
			for (int d = 1; d < digits; d++) {
				int r = (m % 10);
				m = (r * f) + (m / 10);
				if (r > 0 && m < n && m >= from && m <= to) {
					if (recycled.contains(m)) {
						// System.out.println("(" + m + "," + n + ")");
					} else {
						recycled.add(m);
						count++;
					}
				}
			}
		}
		return count;
	}

}
