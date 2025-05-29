import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Hashtable;

public class TestGoogle2 {

	public TestGoogle2() {
		try {
			// Open the file that is the first
			// command line parameter
			FileInputStream fstream = new FileInputStream("input1.txt");
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			int line = -1;
			int curline = 0;
			// Read File Line By Line
			while ((strLine = br.readLine()) != null) {
				// Print the content on the console
				if (line == -1)
					line = Integer.parseInt(strLine);
				else if (curline < line) {
					System.out.print("Case #" + ++curline + ": ");
					System.out.println(this.calculate(strLine));
				}
			}
			in.close();
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}

	}

	public int calculate(String input) {

		String[] result = input.split("\\s");
		int n = Integer.parseInt(result[0]);
		int s = Integer.parseInt(result[1]);
		int p = Integer.parseInt(result[2]);

		int count = 0;
		for (int x = 3; x < result.length; x++) {
			int temp = Integer.parseInt(result[x]);
			// System.out.println(result[x]);

			if (p == 0) {
				count++;
			} else if (temp > 0 && temp >= (p * 3 - 2)) {
				count++;
			} else if (temp > 0 && (temp == (p * 3 - 3) || temp == (p * 3 - 4))
					&& s > 0) {
				s--;
				count++;
			}
		}
		return count;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new TestGoogle2();

	}

}
