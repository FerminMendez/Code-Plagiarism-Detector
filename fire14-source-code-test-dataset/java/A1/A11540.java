import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class ProblemB {
	public static void main(String[] args) {
		String output = "";
		try {
			// Open the file that is the first
			// command line parameter
			FileInputStream fstream = new FileInputStream("input.txt");
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;

			// Read File Line By Line
			strLine = br.readLine();
			int k = 1;
			while ((strLine = br.readLine()) != null) {
				String[] splits = strLine.split(" ");
				int N = Integer.parseInt(splits[0]);
				int S = Integer.parseInt(splits[1]);
				int H = Integer.parseInt(splits[2]);
				int counter = 0;
				int heigh = H + 2 * (H - 1);
				int low = H + 2 * (H - 2);
				if (H < 2) {
					heigh = H;
					low = H;
				}

				for (int i = 3; i < splits.length; i++) {
					int temp = Integer.parseInt(splits[i]);
					if (temp >= heigh)
						counter++;
					else if (temp >= low) {
						if (S > 0) {
							S--;
							counter++;
						}
					}

				}
				output += "Case #" + k++ + ": " + counter + "\n";
			}
			// Close the input stream
			in.close();
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}

		try {
			// Create file
			FileWriter fstream = new FileWriter("out.txt");
			BufferedWriter out = new BufferedWriter(fstream);
			out.write(output);
			// Close the output stream
			out.close();
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}
}
