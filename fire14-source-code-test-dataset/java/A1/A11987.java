import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) throws FileNotFoundException {
		start();
	}

	public static void start() throws FileNotFoundException {
		File file = new File("./");
		String name = "";
		for (File f : file.listFiles()) {
			if (f.getName().endsWith(".in")) {
				name = f.getName().replaceFirst("\\.in", "");
				break;
			}
		}
		Scanner in = new Scanner(new File(name + ".in"));
		PrintWriter out = new PrintWriter(new File(name + ".out"));
		new Solution(in, out);
		out.close();
	}

	public static class Solution {

		public Solution(Scanner in, PrintWriter out) {
			int cases = in.nextInt();
			in.nextLine();
			for (int i = 1; i <= cases; i++) {
				String answer = "Case #" + i + ": " + compute(in.nextLine());
				out.println(answer);
				System.out.println(answer);
			}
		}

		private int compute(String s) {
			Scanner sc = new Scanner(s);
			int googlers = sc.nextInt();
			int surprizing = sc.nextInt();
			int points = sc.nextInt();
			int answer = 0;
			for (int i = 0; i < googlers; i++) {
				int thisPoint = sc.nextInt();
				int guaranteedWin = points * 3 - 2;
				int possibleWin = points * 3 - 4;

				if (thisPoint == 0) {
					if (points == 0) {
						answer++;
					}
				} else if (thisPoint == 1) {
					if (points == 0 || points == 1) {
						answer++;
					} else if (points == 2 && surprizing > 0) {
						surprizing--;
						answer++;
					}
				} else if (thisPoint >= guaranteedWin) {
					answer++;
				} else if (thisPoint >= possibleWin && surprizing > 0) {
					surprizing--;
					answer++;
				}
			}
			return answer;
		}
	}
}
