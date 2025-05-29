import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Qual1c {
	public static void main(String[] args) {

		try {
			FileWriter fstream = new FileWriter("outcsmall0.txt");
			BufferedWriter out = new BufferedWriter(fstream);
			Scanner scanner = new Scanner(new File("C-small-attempt0.in"));

			int count = scanner.nextInt();

			for (int k = 1; k <= count; k++) {
				int min = scanner.nextInt();
				int max = scanner.nextInt();

				int result;

				int total = 0;

				for (int j = min; j <= max; j++) {
					String input = "" + j;
					for (int i = 0; i <= input.length(); i++) {
						StringBuffer newString = new StringBuffer();
						newString.append(input.substring(i, input.length()));
						newString.append(input.substring(0, i));
						result = Integer.parseInt(newString.toString());

						if (min <= j && j < result && result <= max) {
							total++;
						}
					}
				}
				System.out.println(total);
				out.write("Case #" + k + ": " + total + "\n");
			}
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
