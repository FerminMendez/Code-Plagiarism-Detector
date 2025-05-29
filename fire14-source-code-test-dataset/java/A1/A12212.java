import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class ProbBv3 {

	public static void main(String[] args) throws IOException {
		new ProbBv3().run();
	}

	PrintWriter out;

	void run() throws IOException {

		 out = new PrintWriter(new FileWriter("B-small-attempt2.out"));
//		out = new PrintWriter(new OutputStreamWriter(System.out));
		solve();
		out.flush();
	}

	void solve() throws IOException {
		Scanner sc = new Scanner(new File("B-small-attempt2.in"));

		int T = sc.nextInt();

		for (int q = 0; q < T; q++) {
			int N = sc.nextInt();
			int S = sc.nextInt();
			int p = sc.nextInt();

			out.print("Case #" + (q + 1) + ": ");

			int ans = 0;

			for (int i = 0; i < N; i++) {
				int quotient;
				int remainder;
				int n = sc.nextInt();
					if (n >= (p * 3) - 2) {
						ans++;
//						out.print(n + "A ");
					} else if ((p * 3) - 4 >= 0 && n >= (p * 3) - 4 && S > 0) {
						ans++;
						S--;
//						out.print(n + "B ");
					}
				}	
			out.println(ans);
		}
	}
}
