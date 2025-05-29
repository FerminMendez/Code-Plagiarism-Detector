import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ProblemC {
	public static void main(String[] args) throws IOException {
		new ProblemC();
	}

	private int numOfTest;
	private static final int ATTEMPT_NO = 0;
	private static int SOLVE_HARD = 0;
	int A, B;
	int ans;

	public ProblemC() throws IOException {
		// Scanner input = new Scanner(new File("input.txt"));
		Scanner input = new Scanner(new File("C-small-attempt" + ATTEMPT_NO + ".in"));
		Writer output = new FileWriter("C-small-attempt" + ATTEMPT_NO + ".out");
		if (SOLVE_HARD != 0) {
			input = new Scanner(new File("C-large.in"));
			output = new FileWriter("C-large.in");
		}
		//output = new BufferedWriter(new OutputStreamWriter(System.out));

		numOfTest = input.nextInt();
		for (int test = 1; test <= numOfTest; test++) {
			// read from input
			A = input.nextInt();
			B = input.nextInt();

			process();
			output.write("Case #" + test + ": " + ans + "\n");
		}

		input.close();
		output.flush();
		output.close();
	}

	private void process() {
		ans = 0;
		for (int num = A; num < B; num++) {
			int left = num;
			int right = 0;
			int mul10 = 1;
			Set<Integer> checked = new HashSet<Integer>();
			boolean lastGood = false;
			while (left > 0) {
				if (lastGood) {
					int m = Integer.parseInt(String.valueOf(right) + String.valueOf(left));
					if (m > num && m <= B && !checked.contains(m)) {
						//System.err.println(num + " " + m + " " + ans);
						checked.add(m);
						ans++;
					}
				}
				int lastDigit = left % 10;
				right = lastDigit * mul10 + right;
				left /= 10;
				mul10 *= 10;
				lastGood = (lastDigit != 0);
			}
		}
	}
}