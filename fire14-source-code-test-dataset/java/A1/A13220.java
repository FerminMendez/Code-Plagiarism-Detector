import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class ProblemB {

	static ArrayList<int[]> triples = new ArrayList<int[]>();
	static int p = 0;
	static int s = 0;
	static int count = 0;

	public static void main(String args[]) {
		ReadInFile();
	}

	private static int parseLine(String str) {

		count = p = s = 0;
		triples.clear();

		String[] tokens = str.split("\\s+");

		int N = Integer.parseInt(tokens[0]);
		s = Integer.parseInt(tokens[1]);
		p = Integer.parseInt(tokens[2]);

		ArrayList<Integer> scores = new ArrayList<Integer>();
		for (int i = 0; i < N; i++)
			scores.add(Integer.parseInt(tokens[i + 3]));

		GenerateTriples(scores, s, p);

		UpdateTriples();

		return count;
	}

	private static void UpdateTriples() {
		for (int[] triple : triples) {
			int maxScore = Math.max(Math.max(triple[0], triple[1]), triple[2]);
			if (maxScore >= p)
				count++;
			else if (maxScore == p - 1 && s > 0 && triple[0] > 0
					&& triple[1] > 0 && triple[2] > 0) {
				count++;
				s--;
			}
		}
	}

	private static void GenerateTriples(ArrayList<Integer> scores, int s, int p) {
		for (int score : scores) {
			int d = score / 3;
			int[] triple = new int[3];
			triple[0] = triple[1] = triple[2] = d;

			if (score % 3 == 1)
				triple[0]++;
			if (score % 3 == 2)
				triple[0] = triple[1] = d + 1;

			triples.add(triple);
		}
	}

	private static void ReadInFile() {
		try {

			FileWriter ofstream = new FileWriter("c:/cygwin/out.txt");
			BufferedWriter out = new BufferedWriter(ofstream);

			// Open the file that is the first
			// command line parameter
			FileInputStream fstream = new FileInputStream("c:/cygwin/B-small-attempt0.in");
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			// Read File Line By Line
			int i = 0;
			strLine = br.readLine();
			while ((strLine = br.readLine()) != null) {
				// Print the content on the console
				System.out.println(strLine);
				System.out.println("Case #" + (++i) + ": " + parseLine(strLine)
						+ "\n");
				out.write("Case #" + (i) + ": " + parseLine(strLine) + "\n");
			}
			// Close the input stream
			in.close();
			out.close();

		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}

}
