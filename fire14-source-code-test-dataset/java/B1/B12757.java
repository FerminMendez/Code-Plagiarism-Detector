import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TestGoogle3 {

	public TestGoogle3() {
		try {
			// Open the file that is the first
			// command line parameter
			FileInputStream fstream = new FileInputStream("C-small-attempt0.in");
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

		return getRecycledNumber(n, s);

	}

	public int getRecycledNumber(int low, int high) {

		int counter = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = low; i < high; i++) {
			int li = i;
			// System.out.println("cleared:");

			list.clear();
			while (li > 0) {
				list.add(li % 10);
				li = li / 10;
			}

			int[] temp = new int[list.size()];

			for (int j = 0; j < list.size(); j++) {
				// System.out.println("current number:" + list.get(j));
				for (int k = 0; k < list.size(); k++) {
					temp[k] = (int) (temp[k] + list.get(j)
							* (Math.pow(10, ((k + list.size() + j) % list
									.size()))));
				}
			}

			for (int m = 0; m < list.size(); m++) {

				if (temp[m] > i && temp[m] <= high) {
					boolean flag = false;
					// skip duplicates
					for (int n = 0; n < m; n++) {
						if (temp[m] == temp[n]) {
							System.out.println("i " + i);
							System.out.println("duplicate" + i);
							flag = true;
						}
					}
					if (!flag)
						counter++;

				}
			}
		}
		return counter;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new TestGoogle3();

	}

}
