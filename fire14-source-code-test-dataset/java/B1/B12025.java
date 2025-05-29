import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;

public class ProblemC {

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
		long startTime = System.nanoTime();
		new Solution(in, out);
		System.out.println("\n" + (System.nanoTime() - startTime)
				* Math.pow(10, -9) + " seconds");
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
			int a = sc.nextInt();
			int b = sc.nextInt();
			int digits = (a + "").length();
			HashSet<String> answer = new HashSet<String>();
			for (int shiftCount = 1; shiftCount < digits; shiftCount++) {
				for (int n = a; n <= b; n++) {
					String nString = n + "";
					String mString = nString.substring(shiftCount, digits)
							+ nString.substring(0, shiftCount);
					int m = Integer.parseInt(mString);
					if (a <= n && n < m && m <= b) {
						answer.add(nString+mString);
					}
				}
			}

			return answer.size();
		}
	}
}
