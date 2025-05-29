import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class RecycledNumbers {

	public static int[] getM(int n) {
		String s = n + "";
		int M[] = new int[s.length() - 1];
		// System.out.println(M.length);
		for (int i = 1; i < M.length + 1; i++) {
			String temp = "";
			temp = s.substring(s.length() - i, s.length()) + s;

			M[i - 1] = Integer.parseInt(temp.substring(0, s.length()));
			// System.out.println(M[i-1]);
		}
		return M;
	}

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("C-small-attempt0.in"));
//		Scanner in = new Scanner(System.in);
		BufferedWriter out = null;
		try {
			FileWriter fstream = new FileWriter("out.txt");
			out = new BufferedWriter(fstream);
			int cases = in.nextInt();
			int A;
			int B;
			for (int i = 0; i < cases; i++) {
				int result = 0;
				A = in.nextInt();
				B = in.nextInt();
				for (int j = A; j < B + 1; j++) {
					int[] Ms = getM(j);
					for (int k = 0; k < Ms.length; k++) {
						if (Ms[k] > j && Ms[k] <= B) {
//							System.out.println(j + " " + Ms[k]);
							result++;
						}
					}
				}
				// int answer = result + tempo;
				out.write("Case #" + (i + 1) + ": " + result + "\n");
				System.out.println("Case #" + (i + 1) + ": " + result);
			}
			out.close();
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}

	}
}
