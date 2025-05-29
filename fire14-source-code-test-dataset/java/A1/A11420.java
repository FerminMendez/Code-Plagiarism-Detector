import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Triplets {

	public static void main(String[] args) throws IOException {
		new Triplets().run("B-small-attempt0.in");
//		new Triplets().run("problem.txt");
	}

	public void run(String fileName) throws IOException {
		parseFile(fileName);
	}

	private void parseFile(String fileName) throws FileNotFoundException {
		File file = new File(fileName);
		Scanner scanner = new Scanner(file);

		int numTests = Integer.parseInt(scanner.nextLine());
		for (int i = 1; i <= numTests; i++) {
			System.out.println("Case #" + i + ": " + solve(scanner.nextLine()));
		}
		scanner.close();
	}

	public String solve(String line) {
		Scanner ls = new Scanner(line);
		int num = ls.nextInt();
		int suprises = ls.nextInt();
		int p = ls.nextInt();
		int[] tps = new int[num];
		for (int i = 0; i < tps.length; i++) {
			tps[i] = ls.nextInt();
		}

		Solver solver = new Solver(suprises, p, tps);

		return Integer.toString(solver.solve());
	}
}

class Solver {
	private int surprises;
	private final int p;
	private final int[] tps;

	Solver(int suprises, int p, int[] tps) {
		this.surprises = suprises;
		this.p = p;
		this.tps = tps;
	}

	public int solve() {
		int possibles = 0;
		if (p == 0)
			return tps.length;

		for (int tp : tps) {
			if (tp % 3 == 0 && tp != 0) {
				int mp = tp / 3;
				if (mp >= p) {
					possibles++;
				} else if ((mp + 1) >= p && surprises > 0) {
					surprises--;
					possibles++;
				}
			} else if (tp % 3 == 1) {

				int mp = tp / 3 + 1;
				if (mp >= p)
					possibles += 1;

			} else if (tp % 3 == 2) {
				int mp = tp / 3 + 1;
				if (mp >= p) {
					possibles++;
				} else if ((mp + 1) >= p && surprises > 0) {
					surprises--;
					possibles++;
				}
			}
		}

		return possibles;
	}

}
