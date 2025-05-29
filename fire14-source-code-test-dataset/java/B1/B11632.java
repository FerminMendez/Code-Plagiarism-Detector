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

public class EagleProblemC {
	public static void main(String args[]) throws IOException {
		BufferedReader bfr = new BufferedReader(new FileReader("inputC.txt"));

		Writer output = null;
		File file = new File("EagleOutputC.txt");
		output = new BufferedWriter(new FileWriter(file));

		int T = Integer.parseInt(bfr.readLine());
		int i = 0;
		while (i < T) {

			String[] tempString = bfr.readLine().split(" ");
			int total = 0;
			int A = Integer.parseInt(tempString[0]);
			int B = Integer.parseInt(tempString[1]);
			for (int j = A; j <= B; j++) {

				long tempNumber = j;
				long tempStart = tempNumber;

				int numdigits = (int) Math.log10((double) tempNumber);

				int multiplier = (int) Math.pow(10.0, (double) numdigits);

				while (true)

				{

					long r = tempNumber % 10;

					// 1234 = 123;

					tempNumber = tempNumber / 10;

					tempNumber = tempNumber + multiplier * r;

					if (tempNumber == tempStart)
						break;
					if ((int)tempNumber >= A && (int)tempNumber <= B) {
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
