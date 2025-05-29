import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Recycled {
	private int A;
	private int B;
	private int pairs;

	/**
	 * Constructor
	 * 
	 * @param a
	 * @param b
	 */
	public Recycled(int a, int b) {
		A = a;
		B = b;
		pairs = 0;
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
				String[] data = sc.nextLine().split(" ");
				Recycled solver = new Recycled(Integer.parseInt(data[0]),
						Integer.parseInt(data[1]));
				solver.solve();
				pw.println("Case #" + i + ": " + solver.getPairs());
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
	 * Returns the number of recycled number pairs.
	 * @return
	 */
	private int getPairs() {
		return pairs;
	}

	/**
	 * Solves the given test case.
	 */
	private void solve() {
		for (int n = A; n <= B; n++) {
			String written = "" + n;
			for (int k = 1; k < written.length(); k++) {
				String swap= written.substring(k) + written.substring(0,k);
				if (written.charAt(0)=='0'){
					continue;
				}
				Integer m= Integer.parseInt(swap);
				if (n < m && m <= B) {
					System.out.println("" + n + "\t" + m);
					pairs++;
				}
			}
		}
	}
}
