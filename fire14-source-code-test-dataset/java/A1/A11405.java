import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Dancing {
	private int numDancers;
	private int surprising;
	private int minMax;
	private int[] scores;

	private int result;

	/**
	 * Constructor
	 * 
	 * @param N
	 * @param S
	 * @param p
	 */
	public Dancing(int N, int S, int p, int[] data) {
		numDancers = N;
		surprising = S;
		minMax = p;
		scores = data;
		result = 0;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			// Input I/O handler
			File input = new File(args[0]);
			Scanner sc = new Scanner(input);
			int cases = Integer.parseInt(sc.nextLine());

			// Output I/O handler
			FileWriter output = new FileWriter(args[1], true);
			PrintWriter pw = new PrintWriter(output);

			// Process all the cases
			for (int i = 1; i <= cases; i++) {
				// Get the data
				String[] line = sc.nextLine().split(" ");
				int N = Integer.parseInt(line[0]);
				int S = Integer.parseInt(line[1]);
				int p = Integer.parseInt(line[2]);
				;
				int[] scores = new int[line.length - 3];
				for (int k = 0; k < scores.length; k++) {
					scores[k] = Integer.parseInt(line[k + 3]);
				}

				// Solve each test case
				Dancing solver = new Dancing(N, S, p, scores);
				solver.solve();
				pw.println("Case #" + i + ": " + solver.getResult());
				pw.flush();
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Returns the number of maximum number of Googlers who could have had a
	 * best result of greater than or equal to p.
	 * @return result
	 */
	public int getResult() {
		return result;
	}

	/**
	 * Perform the algorithm.
	 */
	private void solve() {
		int currentSurp = 0;
		int guarantee = minMax + Math.max(0, (minMax - 1))
				+ Math.max(0, (minMax - 1));
		int minScore = minMax + Math.max(0, (minMax - 2))
				+ Math.max(0, (minMax - 2));
		for (int i = 0; i < scores.length; i++) {
			if (scores[i] >= guarantee) {
				result++;
			} else if (scores[i] >= minScore) {
				if (currentSurp < surprising) {
					result++;
					currentSurp++;
				}
			}
		}
	}
}
