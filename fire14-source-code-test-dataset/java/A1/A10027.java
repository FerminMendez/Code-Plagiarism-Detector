package WQ;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Problem_B {

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		String filename = "B-small-attempt0 (1).in";
		Scanner s = new Scanner(new FileReader(filename));
		PrintWriter out = new PrintWriter("out.txt");
		int num = s.nextInt();
		for (int CASE = 1; CASE <= num; CASE++) {
			int n = s.nextInt();
			int sr = s.nextInt();
			int p = s.nextInt();
			int[] compet = new int[n];
			for (int i = 0; i < n; i++) {
				compet[i] = s.nextInt();
			}
			int count = 0;
			for (int i = 0; i < compet.length; i++) {
				int divide = compet[i] / 3;
				int rem = compet[i] % 3;
				if (divide >= p)
					count++;
				else {
					if (rem == 0 && sr > 0 && divide > 0 && divide + 1 >= p) {
						count++;
						sr--;
					} else if (rem == 1 && divide + 1 >= p) {
						count++;
					} else if (rem == 2) {
						if (divide + 1 >= p)
							count++;
						else if (sr > 0 && divide + 2 >= p) {
							count++;
							sr--;
						}
					}
				}
			}
			out.println("Case #" + CASE + ": " + count);
		}
		out.close();
	}
}
