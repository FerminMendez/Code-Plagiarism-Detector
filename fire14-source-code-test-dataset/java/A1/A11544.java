package br.com.codejam.qualification;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class DancingWithGooglers {
	public static void main(String[] args) throws IOException {
		String file = "B-small-attempt3";
		Scanner sc = new Scanner(new FileReader(file + ".in"));
		PrintWriter pw = new PrintWriter(new FileWriter(file + ".out"));
		int T = new Integer(sc.nextLine());

		for (int i = 1; i <= T; i++) {
			int result = 0;
			pw.print("Case #" + i + ": ");
			String line = sc.nextLine();
			String[] numbers = line.split(" ");
			int N = new Integer(numbers[0]);
			int S = new Integer(numbers[1]);
			int P = new Integer(numbers[2]);
			for (int j = 0; j < N; j++) {
				int div = new Integer(numbers[j + 3]);
				if(div == 0 && P == 0)
					result++;
				if (div != 0) {
					div = div / 3;
					if (div >= P) {
						result++;
					} else {
						if ((P - div) == 1) {
							if ((new Integer(numbers[j + 3]) % 3) >= 1) {
								result++;
							} else if ((new Integer(numbers[j+3]) % 3) == 0 && S > 0) {
								result++;
								S--;
							}
						} else if ((P - div) == 2) {
							if ((new Integer(numbers[j + 3]) % 3) == 2 && S > 0) {
								result++;
								S--;
							}
						}
					}
				}
			}
			pw.println(result);
		}
		pw.flush();
		pw.close();
		sc.close();
	}

}
