import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
	Solution() throws Exception {
	}

	String solve() throws Exception {
		int min = in.nextInt();
		int max = in.nextInt();

		return "" + permutations(min, max);
	}

	private int permutations(int min, int max) {
		int digits = Integer.toString(min).length();
		int permutations = 0;
		for (int i = min; i <= max; i++) {
			HashSet<Integer> found = new HashSet<>();
			for (int j = 1; j < digits; j ++) {
				int permutation = permute(i, j, digits);
				if (permutation > i && permutation <= max && permutation >= min) {
					found.add(permutation);
				}
			}
			permutations += found.size();
		}
		return permutations;
	}

	private int permute(int number, int permutation, int digits) {
		int m = (int) Math.pow(10, permutation);
		int back = number % m;
		int front = number / m;
		int m2 = (int) Math.pow(10, digits - permutation);
		return back * m2 + front;
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

	static Scanner in = new Scanner(System.in);
	static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) throws Exception {
		new Solution().solveAll();
	}
}
