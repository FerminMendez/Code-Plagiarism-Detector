import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(new File("B-small-attempt2.in"));
		FileWriter out = new FileWriter("out.txt");

		int lineNumber = input.nextInt();
		input.nextLine();
		for (int i = 0; i < lineNumber; i++) {
			String solution = "Case #" + (i + 1) + ": ";
			int n = input.nextInt();
			int s = input.nextInt();
			int p = input.nextInt();
			int max = 0;
			int upperLimit = p * 3 - 2;
			int lowerLimit = p * 3 - 4;
			for (int j = 0; j < n; j++) {
				int sum = input.nextInt();
				if (p == 1 && sum >= 1) {
					max++;
				} else if (sum >= upperLimit && sum>p) {
					max++;
				} else if (sum >= lowerLimit && s > 0 && sum>p) {
					s--;
					max++;
				}
			}
			if(p==0)
				max = n;
			solution += max;
			solution += System.getProperty("line.separator");
			;
			out.write(solution);
		}

		out.close();
		input.close();
	}

}
