import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Locale;

public class NumberPairs {
	public static void main(String[] args) throws IOException {
		Scanner s = null;

		try {
			s = new Scanner(new BufferedReader(new FileReader("NumberPairs.in")));

			int N = s.nextInt();

			for (int i = 1; i <= N; i++) {
				int a = s.nextInt(), b = s.nextInt();
				System.out.println("Case #" + i + ": " + calculate(a, b));
			}
		} finally {
			if (s != null) {
				s.close();
			}
		}
	}

	static int calculate(int a, int b) {
		int result = 0;
		for (int i = a; i <= b; i++)
			for (int j = i; j <= b; j++)
				if (isPair(i,j)) result++;

		return result;
	}

	static boolean isPair(int x, int y) {
		if (x == y) return false;

		byte[] p1 = ("" + x).getBytes(), p2 = ("" + y).getBytes();
		int size = p1.length;
		
		for (int start = 0; start < size; start++) {
			for (int offset = 0; offset < size; offset++) {
				if (p1[offset] != p2[(start + offset) % size])
					break;

				if (offset == size - 1) {
					// System.out.println("Pair: " + x + " " + y);
					return true;
				}
			}
		}	

		return false;
	}
}
