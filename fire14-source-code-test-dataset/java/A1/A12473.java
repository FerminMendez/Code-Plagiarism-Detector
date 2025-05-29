import java.util.Scanner;
import java.util.Arrays;
import java.io.File;

public class Dancing {
	public static void main (String[] args) {
		Scanner sc = null;
		try {
			sc = new Scanner(new File("input.txt"));
		} catch (Exception e) {}
		int N, S, p, result;
		int[] t;
		String out;
		int T = sc.nextInt();
		sc.nextLine();
		for (int i = 1; i <= T; i++) {
			result = 0;
			N = sc.nextInt();
			S = sc.nextInt();
			p = sc.nextInt();
			t = new int[N];
			for (int j = 0; j < N; j++) {
				t[j] = -sc.nextInt();
			}
			out = "Case #" + i + ": ";
			Arrays.sort(t);
			for (int j = 0; j < N; j++) {
				t[j] = -t[j];
				if ((t[j] == 0) && (p != 0)) {
				} else if (t[j] >= 3*p - 2) {
					result++;
				} else if ((t[j] >= 3*p - 4) && (S > 0)) {
					result++;
					S--;
				}
			}
			System.out.print(out + result + ((i < T)? "\n" : ""));
		}
	}
}