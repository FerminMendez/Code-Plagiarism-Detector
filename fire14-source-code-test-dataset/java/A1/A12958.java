import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Scanner;

public class ProblemB {
	public static void main(String[] args) throws IOException {
		new ProblemB();
	}

	private int numOfTest;
	private static final int ATTEMPT_NO = 0;
	private static int SOLVE_HARD = 0;

	int n, s, p;
	int[] a = new int[128];
	int ans;

	public ProblemB() throws IOException {
		// Scanner input = new Scanner(new File("input.txt"));
		Scanner input = new Scanner(new File("B-small-attempt" + ATTEMPT_NO + ".in"));
		Writer output = new FileWriter("B-small-attempt" + ATTEMPT_NO + ".out");
		if (SOLVE_HARD != 0) {
			input = new Scanner(new File("B-large.in"));
			output = new FileWriter("B-large.in");
		}
		//output = new BufferedWriter(new OutputStreamWriter(System.out));

		numOfTest = input.nextInt();
		for (int test = 1; test <= numOfTest; test++) {
			// read from input
			n = input.nextInt();
			s = input.nextInt();
			p = input.nextInt();
			for (int i = 0; i < n; i++) {
				a[i] = input.nextInt();
			}

			process();
			output.write("Case #" + test + ": " + ans + "\n");
		}

		input.close();
		output.flush();
		output.close();
	}

	private void process() {
		Arrays.sort(a, 0, n);
		ans = 0;
		for (int i = n - 1; i >= 0; i--) {
			int k = a[i] / 3;
			int m = k;
			if (k * 3 < a[i]) {
				m++;
			}
			if (m >= p) {
				ans++;
				continue;
			}
			if (s == 0) {
				break;
			}

			if (a[i] <= 1) {
				break;
			}
			k = (a[i] - 2) / 3;
			m = k + 2;
			if (m >= p) {
				ans++;
				s--;
				continue;
			}
			break;
		}
	}
}