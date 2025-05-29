import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class DancingWithTheGooglers {

	public static void main(String[] args) throws IOException {
		File input = new File("files/B-small-attempt0.in.txt");
		File output = new File("files/B-small-attempt0.out.txt");
		PrintWriter pw = new PrintWriter(output);
		Scanner sc = new Scanner(input);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int N = sc.nextInt();
			int S = sc.nextInt();
			int p = sc.nextInt();
			int[] t = new int[N];
			for (int j = 0; j < t.length; j++) {
				t[j] = sc.nextInt();
			}
			int answer = solve(N, S, p, t);
			pw.println(String.format("Case #%d: %d", i + 1, answer));
		}
		pw.close();
		sc.close();
	}

	static int solve(int n, int s, int p, int[] t) {
		if (p == 0) {
			return t.length;
		}
		
		int count = 0;
		for (int i = 0; i < t.length; i++) {
			if (t[i] >= (3 * p) - 2) {
				count++;
			} else if (s > 0 && t[i] > 0 && t[i] >= (3 * p) - 4) {
				count++;
				s--;
			}
		}
		return count;
	}
}
