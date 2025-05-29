import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class answer {

	public static int solve(int N, int S, int P, int[] googler) {
		int greater = 0;
		int score;

		for (int i = 0; i < N; i++) {

			score = googler[i];

			if (score / 3 >= P) {
				greater++;
			} else {
				if (score % 3 == 0 && score != 0) {

					if ( score / 3 + 1 >= P && S > 0) {
						S--;
						greater++;
					}
				} else if (score != 0) {
					if ( score / 3 + 1 >= P) {
						greater++;
					} else if ( score / 3 < P && score / 3 + 2 >= P && S > 0) {
						S--;
						greater++;
					}
				} else if (P == 0) {
					greater++;
				}
			}
		}
		return greater;
	}

	public static void main(String[] args) throws Exception {

		Scanner in = new Scanner(new File("B-small-attempt4.in"));
		PrintWriter out = new PrintWriter("output.out");

		int[] googler = new int[100];
		int testCases = Integer.parseInt(in.next());
		int count = 0;
		while (in.hasNext()) {
			count++;
			int N = Integer.parseInt(in.next());
			int S = Integer.parseInt(in.next());
			int P = Integer.parseInt(in.next());

			for (int i = 0; i < N; i++) {
				googler[i] = Integer.parseInt(in.next());
			}
			int greater = solve(N, S, P, googler);
			out.printf("Case #%d: %d\n", count, greater);

		}

		out.close();
		in.close();
	}
}
