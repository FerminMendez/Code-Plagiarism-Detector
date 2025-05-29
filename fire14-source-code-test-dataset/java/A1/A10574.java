package CodeJam;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

public class CodeJam {

	public static void main(String[] args) throws IOException {
		 String outputFile = System.getenv("USERPROFILE") +
		 "\\Documents\\B-small.out";
		 String inputFile = System.getenv("USERPROFILE") +
		 "\\Documents\\B-small.in";

		BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
		DataInputStream reader = new DataInputStream(new FileInputStream(
				inputFile));

		int T = Integer.valueOf(reader.readLine());
		for (int k = 1; k <= T; k++) {

			String line = reader.readLine();

			int nbreDancers = Integer.valueOf(line.substring(0,
					line.indexOf(" ")));
			line = line.substring(line.indexOf(" ") + 1);
			int s = Integer.valueOf(line.substring(0, line.indexOf(" ")));
			line = line.substring(line.indexOf(" ") + 1);
			int p = Integer.valueOf(line.substring(0, line.indexOf(" ")));
			line = line.substring(line.indexOf(" ") + 1);
			line += " ";
			int q = 0;
			int n = 0;
			if (3 * p - 4 < 0)
				s = 0;
			for (int j = 0; j < nbreDancers; j++) {
				int sum = Integer.valueOf(line.substring(0, line.indexOf(" ")));
				line = line.substring(line.indexOf(" ") + 1);
				if (sum >= 3 * p - 4) {
					if (((sum == 3 * p - 4) || (sum == 3 * p - 3))) {
						q++;
						if (q <= s) {
							n++;
						}
					} else {
						n++;
					}
				}
			}
			writer.write("Case #" + k + ": " + n);
			writer.newLine();
		}
		writer.close();
	}
}