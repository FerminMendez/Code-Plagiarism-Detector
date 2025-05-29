import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class DancingWithTheGooglers {
	private static Scanner scan;
	private static PrintWriter writer;
	private static File input = new File("B-small-attempt0.in");
	private static File output = new File("B-small-attempt0.out");

	public static void main(String[] args) throws Exception {
		scan = new Scanner(input);
		writer = new PrintWriter(output);
		int total = scan.nextInt();
		int n, s, p, sum[];
		for (int t = 1; t <= total; t++) {
			n = scan.nextInt();// googler's number
			s = scan.nextInt();// surprising
			p = scan.nextInt();// min_score
			sum = new int[n];
			for (int i = 0; i < sum.length; i++)
				sum[i] = scan.nextInt();
			int maximum = 0;
			for (int score : sum) {
				int part = score / 3;
				switch (score % 3) {
				case 0:
					if (part >= p) {
						maximum++;
					} else if (s > 0 && part > 0 && part + 1 >= p) {
						maximum++;
						s--;
					}
					break;
				case 1:
					if (part >= p || part + 1 >= p) {
						maximum++;
					} else if (s > 0 && part + 1 >= p) {
						maximum++;
						s--;
					}
					break;
				case 2:
					if (part + 1 >= p || part >= p) {
						maximum++;
					} else if (s > 0 && part + 2 >= p) {
						maximum++;
						s--;
					}
					break;
				}
			}
			println(String.format("Case #%d: %d", t, maximum));
		}
		writer.flush();
	}

	public static void println(String p) {
		System.out.println(p);
		writer.println(p);
	}
}
