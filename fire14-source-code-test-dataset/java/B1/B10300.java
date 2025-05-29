import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class C {
	static int[] a = { 1, 10, 100, 1000, 10000, 100000, 1000000, 10000000 };

	static class Pair implements Comparable<Pair> {
		int a, b;

		public Pair(int a, int b) {
			this.a = a;
			this.b = b;
		}

		public int hashCode() {
			return a | b << 22;
		}

		public boolean equals(Object o) {
			Pair p = (Pair) o;
			return p.a == a && p.b == b;
		}

		@Override
		public int compareTo(Pair o) {
			if (a != o.a)
				return a - o.a;
			if (b != o.b)
				return b - o.b;
			return 0;
		}
	}

	public static int digitCount(int i) {
		int c = 0;
		while (i != 0) {
			c++;
			i /= 10;
		}
		return c;
	}

	public static Pair getMin(int i) {
		int nd = digitCount(i);
		int[] arr = new int[nd];
		int l = i;
		for (int j = 0; j < arr.length; j++) {
			arr[j] = l;
			l = l % 10 * a[nd - 1] + l / 10;
		}
		Arrays.sort(arr);
		return new Pair(arr[0], nd);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(
				new FileInputStream("C.in")));
		PrintWriter out = new PrintWriter("C.out");
		int tc = Integer.parseInt(in.readLine());
		for (int cc = 1; cc <= tc; cc++) {
			StringTokenizer strtok = new StringTokenizer(in.readLine(), " ");
			int a = Integer.parseInt(strtok.nextToken());
			int b = Integer.parseInt(strtok.nextToken());
			int[][] count = new int[digitCount(b) + 1][b + 1];
			long res = 0;
			for (int i = a; i <= b; i++) {
				Pair p = getMin(i);
				res += count[p.b][p.a];
				count[p.b][p.a]++;
			}
			out.printf("Case #%d: %d\n", cc, res);
		}
		out.close();
	}
}
