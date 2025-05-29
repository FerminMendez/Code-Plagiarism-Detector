import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.HashSet;

public class ProblemB {
	static HashSet<String> pairs = new HashSet<String>();

	public static void main(String args[]) {
		ReadInFile();
	}

	private static void ReadInFile() {
		try {

			FileWriter ofstream = new FileWriter("c:/cygwin/out.txt");
			BufferedWriter out = new BufferedWriter(ofstream);

			// Open the file that is the first
			// command line parameter
			FileInputStream fstream = new FileInputStream(
					"c:/cygwin/C-small-attempt1.in");
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			// Read File Line By Line
			int i = 0;
			strLine = br.readLine();
			while ((strLine = br.readLine()) != null) {
				pairs.clear();
				// Print the content on the console
				System.out.println(strLine);

				String[] tokens = strLine.split("\\s+");

				System.out.println("Case #"
						+ (++i)
						+ ": "
						+ ReturnCount(Integer.parseInt(tokens[0]),
								Integer.parseInt(tokens[1])));

				out.write("Case #"
						+ (i)
						+ ": "
						+ ReturnCount(Integer.parseInt(tokens[0]),
								Integer.parseInt(tokens[1])) + "\n");

			}
			// Close the input stream
			in.close();
			out.close();

		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}

	static int ReturnCount(int n, int m) {
		HashSet<Integer> cycles = new HashSet();
		for (int i = n; i <= m; i++) {
			// if (!cycles.contains(i))
			cycles.addAll(GetCycles(i, n, m));
		}

		return pairs.size();
	}

	static private HashSet<Integer> GetCycles(int in, int n, int m) {
		String s = String.valueOf(in);
		HashSet<Integer> out = new HashSet<Integer>();
		for (int i = 0; i < s.length(); i++) {
			String sub1 = s.subSequence(0, i + 1).toString();
			String sub2 = s.subSequence(i + 1, s.length()).toString();

			int permutation = Integer.parseInt(sub2 + sub1);
			out.add(permutation);
		}

		for (int i : out)
			if (i >= n && i <= m && i > in) {
				pairs.add(in + "," + i); // return out;
			}

		return out;
	}
}
