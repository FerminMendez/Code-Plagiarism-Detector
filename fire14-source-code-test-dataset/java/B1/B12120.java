import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class RecycledNumbers {
	public static void main(String args[]) throws IOException {
		BufferedReader bfr = new BufferedReader(new FileReader("inputC.txt"));

		Writer output = null;
		File file = new File("outputC.txt");
		output = new BufferedWriter(new FileWriter(file));

		int T = Integer.parseInt(bfr.readLine());
		int i = 0;
		while (i < T) {

			String[] temp = bfr.readLine().split(" ");
			int total = 0;
			int A = Integer.parseInt(temp[0]);
			int B = Integer.parseInt(temp[1]);
			for (int j = A; j <= B; j++) {

				long number = j;
				long start = number;

				int numdigits = (int) Math.log10((double) number);

				int multiplier = (int) Math.pow(10.0, (double) numdigits);

				while (true)

				{

					long r = number % 10;

					// 1234 = 123;

					number = number / 10;

					number = number + multiplier * r;

					if (number == start)
						break;
					if ((int)number >= A && (int)number <= B) {
						total++;
					}

					

				}

			}

			output.write("Case #" + (i + 1) + ": " + (total/2));
			if (i != T - 1) {
				output.write("\n");
			}

			i++;
		}
		output.close();

	}

}
