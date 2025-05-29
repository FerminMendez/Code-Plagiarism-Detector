import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) throws FileNotFoundException {

		String test = "4\n" + "3 1 5 15 13 11\n" + "3 0 8 23 22 21\n" + "2 1 1 8 0\n"
				+ "6 2 8 29 20 8 18 18 21\n";

		Scanner sc = new Scanner(new File("B-small-attempt1.in"));
		int teller = 0;
		int numLines = 0;
		String out = "";
		String finalOut = "";
		boolean print = false;

		int N = 0;// googlers
		int S = 0;// suprising tripplet
		int P = 0; // min score

		int A = 0;
		String[] split;

		while (true) {
			String line = sc.nextLine();
			if (teller == 0) {
				numLines = Integer.valueOf(line);
			} else {
				print = true;
				split = line.split(" ");
				N = Integer.valueOf(split[0]);
				S = Integer.valueOf(split[1]);
				P = Integer.valueOf(split[2]);

				for (int i = 3; i < split.length; i++) {
					int score = Integer.valueOf(split[i]);

					if (P < 1) {
						A++;
					} else if (S > 0 && score > 0) {
						if (score >= (P + P + P - 2)) {
							A++;
						} else if (score >= (P + P + P - 4)) {
							A++;
							S--;
						}
					} else if (score > 0) {
						if (score >= (P + P + P - 2)) {
							A++;
						}
					}

				}
			}

			if (print) {

				if (teller == numLines) {
					System.out.println("Case #" + teller + ": " + A);
					finalOut += "Case #" + teller + ": " + A;
					break;
				} else {
					System.out.println("Case #" + teller + ": " + A);
					finalOut += "Case #" + teller + ": " + A + "\n";
				}
				A = 0;

			}
			teller++;
		}

		PrintWriter writer = new PrintWriter(new File("out.txt"));

		writer.print(finalOut);
		writer.close();

	}

}
