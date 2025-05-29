import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class B {
	public static void main(String[] args) throws IOException {
		String filename = "B-small-attempt3";
		String inname = filename + ".in";
		String outname = filename + ".out";
		Scanner sc = new Scanner(new File(inname));
		PrintWriter out = new PrintWriter(new FileWriter(outname));

		int N = sc.nextInt();
		for (int t = 1; t <= N; t++) {
			int[] scores = new int[31];
			int numGooglers = sc.nextInt();
			int surprise = sc.nextInt();
			int minPoints = sc.nextInt();
			for (int i = 0; i < numGooglers; i++) {
				scores[sc.nextInt()]++;
			}
			int triple = minPoints * 3;
			int ans = 0;
			int p = 30;
			while (p >= 0) {
				scores[p]--;
				if (scores[p] >= 0) {
					if(p >= triple) {
						ans++;
					} else if(p >= triple - 2 && minPoints >= 1) {
						ans++;
					} else if(p >= triple - 4 && minPoints >= 2 && surprise > 0) {
						ans++;
						surprise--;
					}
				} else {
					p--;
				}
			}
			out.println("Case #" + t + ": " + ans);
			System.out.println("Case #" + t + ": " + ans);
		}
		out.close();
	}
}
