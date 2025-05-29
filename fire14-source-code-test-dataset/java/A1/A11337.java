import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class B {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner read = new Scanner(new File("B-small-attempt0.in"));
		PrintWriter out = new PrintWriter(new File("b-small.out"));
		int numberOfTests = Integer.parseInt(read.nextLine());
		for (int i = 1; i <= numberOfTests; i++) {
			int result = 0;
			int n = read.nextInt();
			int countSurp = read.nextInt();
			int minScore = read.nextInt();
			int[] totalScores = new int[n];
			for (int j = 0; j < n; j++) {
				totalScores[j] = read.nextInt();
			}
			double[] avg = new double[n];
			for (int j = 0; j < n; j++) {
				avg[j] = totalScores[j] / 3.0;
			}
			for (int j = 0; j < n; j++) {
				if (avg[j] >= minScore) {
					result++;
				} else if (Math.abs(avg[j] - minScore) >= 1.5) {
					continue;
				} else if (Math.abs(avg[j] - Math.round(avg[j])) < 0.3) {
					long t1 = Math.round(avg[j]);
					long t2 = t1;
					long t3 = t2;
					if (countSurp > 0 && t2 >=1) {
						t2--;
						t3++;
						countSurp--;
						result++;
					}
				} else if (avg[j] - Math.round(avg[j]) > 0) {
					long t1 = Math.round(avg[j]);
					long t2 = t1;
					long t3 = t2 + 1;
					if (t3 == minScore) {
						result++;
					}
				} else {
					long t1 = Math.round(avg[j]) - 1;
					long t2 = t1 + 1;
					long t3 = t2;
					if (t3 == minScore) {
						result++;
					} else {
						if (countSurp > 0 && t2 >= 1) {
							countSurp--;
							result++;
							t2--;
							t3++;
						}
					}
				}
			}
			out.println(String.format("Case #%d: %d", i, result));
		}
		out.close();
	}
}
