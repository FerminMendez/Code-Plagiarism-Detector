import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ProblemC {

	public static void main(String[] args) throws FileNotFoundException {

		String test = "4\n" + "1 9\n" + "10 40\n" + "100 500\n" + "1111 2222\n";

		Scanner sc = new Scanner(new File("C-small-attempt0.in"));
		int teller = 0;
		int numLines = 0;
		String finalOut = "";
		boolean print = false;

		int n = 0;// smal number
		int m = 0;// big number
		int A = 0; // min number
		int B = 0; // max number

		int S = 0; // answare
		String[] split;

		while (true) {
			String line = sc.nextLine();
			if (teller == 0) {
				numLines = Integer.valueOf(line);
			} else {
				print = true;
				split = line.split(" ");
				A = Integer.valueOf(split[0]);
				B = Integer.valueOf(split[1]);

				for (n = A; n < B; n++) {
					for (m = n + 1; m <= B; m++) {
						S += check(n, m);
					}
				}

			}

			if (print) {

				if (teller == numLines) {
					System.out.println("Case #" + teller + ": " + S);
					finalOut += "Case #" + teller + ": " + S;
					break;
				} else {
					System.out.println("Case #" + teller + ": " + S);
					finalOut += "Case #" + teller + ": " + S + "\n";
				}
				S = 0;

			}
			teller++;
		}

		PrintWriter writer = new PrintWriter(new File("out.txt"));

		writer.print(finalOut);
		writer.close();

	}

	private static int check(int n, int m) {

		String N = "" + n;
		String M = "" + m;
		if (M.length() == 1) {
			return 0;
		}

		for (int i = 1; i < N.length(); i++) {

			String temp = N.substring(N.length() - (i), N.length());
			temp += N.substring(0, N.length() - (i));


			if (temp.equals(M)) {
				return 1;
			}
		}
		return 0;
	}

}
