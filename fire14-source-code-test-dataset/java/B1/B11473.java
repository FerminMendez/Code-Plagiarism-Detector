import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class RecycledTester {

	public static void main(String[] args) throws IOException {
		new RecycledTester().run("C-small-attempt0.in");
//		 new RecycledTester().run("problem.txt");
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

		Solver solver = new Solver(ls.nextInt(), ls.nextInt());

		return Integer.toString(solver.solve());
	}
}

class Solver {

	private final int a;
	private final int b;
	private final int c;
	private final Set<Integer> counted = new HashSet<Integer>();

	Solver(int a, int b) {
		this.a = a;
		this.b = b;
		this.c = Integer.toString(a).length();
	}

	public int solve() {
		if (c == 0)
			return 0;

		int n = 0;

		for (int i = a; i <= b; i++) {
			n += isRecycled(i);
		}
		return n;
	}

	public int isRecycled(int n) {
		String t = Integer.toString(n);
		Set<Integer> pairCandidates = new HashSet<Integer>();
		pairCandidates.add(n);
		for (int i = 0; i < c - 1; i++) {
			t = shift(t);
			
			int m = Integer.valueOf(t);
			if (n != m && a <= m && m <= b && !counted.contains(m)) {
				pairCandidates.add(m);
				counted.add(m);
			}
		}
		counted.add(n);
		return pairCandidates.size() * (pairCandidates.size() - 1) / 2;
	}

	public String shift(String t) {
		return t.substring(1) + t.charAt(0);
	}

}
