package problem_b;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) {
		try {
			processFile("/Users/ibogomolov/Desktop/B-small-attempt0.in", "/Users/ibogomolov/Desktop/out.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}



	private static int process(int n, int s, int p, int[] total) {
		int res = 0;
		for (int i = 0; i < n; i++) {
			int div = total[i]/3;
			int mod = total[i]%3;
			if (div >= p || (div + 1 >= p && mod >= 1)) {
				res++;
			} else if ((div + 2 >= p && mod == 2 && s > 0) || (div + 1 >= p && div >= 1 && mod == 0 && s > 0)) {
				res++;
				s--;
			}
		}
		return res;
	}

	public static void processFile(String in, String out) throws IOException {
		Scanner scanner = new Scanner(new File(in));
		BufferedWriter writer = new BufferedWriter(new FileWriter(out));
		int cases = scanner.nextInt();
		for (int i = 1; i < cases+1; i++) {
			int n = scanner.nextInt();
			int s = scanner.nextInt();
			int p = scanner.nextInt();
			int[] array = new int[n];
			for (int j = 0; j < n; j++) {
				array[j] = scanner.nextInt();
			}
			writer.write("Case #" + i + ": " + process(n, s, p, array) + "\n");
		}

		scanner.close();
		writer.close();
	}
}
