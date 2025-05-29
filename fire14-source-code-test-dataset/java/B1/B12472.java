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
		Scanner input = new Scanner(new File("C-small-attempt0.in"));
		FileWriter out = new FileWriter("out.txt");

		int lineNumber = input.nextInt();
		for (int i = 0; i < lineNumber; i++) {
			int a = input.nextInt();
			int b = input.nextInt();
			int count = 0;
			int div = 1;
			for (int j = a; j < b; j++) {
				for (int k = j + 1; k <= b; k++) {
					div = 1;
					int length = 0;
					while (j / div > 0) {
						length++;
						div *= 10;
					}
					int max = div;
					div = 10;
					if (j == 334 && k == 433)
						System.out.println(length+" "+max);
					for (int velicina = 0; velicina < length; velicina++) {
						if (j == 334 && k == 433) {
							System.out.println("---------");
							System.out.println(j % div + "	" + k / (max / div));
							System.out.println(k % (max / div) + "	" + j / (div));
						}
						if (j % div == k / (max / div)
								&& k % (max / div) == j / div) {
							count++;
							break;
						}
						div*=10;
					}

				}
			}
			String solution = "Case #" + (i + 1) + ": " + count;
			solution += System.getProperty("line.separator");
			out.write(solution);

		}
		out.close();
		input.close();
	}
}
