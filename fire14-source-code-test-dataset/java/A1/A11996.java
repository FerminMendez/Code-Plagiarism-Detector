import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
	HashMap<Character, Character> map = new HashMap<>();

	Solution() throws Exception {
		setupIO("B-small-attempt0.in");
	}

	String solve() throws Exception {
		int n = in.nextInt();
		int surprising = in.nextInt();
		int p = in.nextInt();
		int[] scores = new int[n];
		for (int i = 0; i < n; i ++)
			scores[i] = in.nextInt();
		in.nextLine();
		
		int numberOfP = 0;
		for (int score : scores) {
			if (noSurprise(score) >= p)
				numberOfP ++;
			else if (surprising > 0 && surprise(score) >= p) {
				surprising --;
				numberOfP ++;
			}
		}
		
		return "" + numberOfP;
	}

	private int surprise(int score) {
		if (score < 2 || score > 28)
			return 0;		
		if (score % 3 == 0)
			return score / 3 + 1;
		if (score % 3 == 1)
			return 0;
		return score / 3  + 2;
	}

	private int noSurprise(int score) {
		if (score % 3 > 0)
			return score / 3 + 1;
		return score / 3;
	}

	void solveAll() throws Exception {
		int cases = in.nextInt();
		in.nextLine();
		for (int i = 1; i <= cases; i++) {
			String solution = "Case #" + i + ": " + solve();
			System.out.println(solution);
			out.println(solution);
		}
		out.flush();
	}

	// -----------------------------------------------------------------------

	static Scanner in;
	static PrintWriter out;

	static void setupIO() {
		in = new Scanner(System.in);
		out = new PrintWriter(System.out);
	}

	static void setupIO(String filename) throws Exception {
		in = new Scanner(new FileReader(filename));
		out = new PrintWriter(new FileWriter(filename + ".out"));
	}

	public static void main(String[] args) throws Exception {
		new Solution().solveAll();
	}
}
