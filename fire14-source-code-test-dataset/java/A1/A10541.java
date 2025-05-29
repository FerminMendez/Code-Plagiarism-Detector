import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class B {
	final static String CASE_NO = "Case #";
	final static String SUFFIX = ": ";

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		int total;
		int T; // nuber of test cases
		int N; // number of googlers
		int S; // number of surprising triplets
		int P;

		BufferedReader br = readFile("B-small.txt");

		T = Integer.parseInt(br.readLine());
		total = T;
		while (T > 0) {
			T--;
			String line = br.readLine();
			String[] input = line.split(" ");
			int i = 0;
			N = Integer.parseInt(input[i++]);
			S = Integer.parseInt(input[i++]);
			P = Integer.parseInt(input[i++]);
			int countP = 0;

			while (N > 0) {
				N--;
				int t = Integer.parseInt(input[i++]);
				int mod3 = t % 3;
				int bestResult = 0;
				

				// getting best result from triplet
				if (mod3 == 0) {
					bestResult = t / 3;					
				} else if (mod3 == 1)
					bestResult = ((t + 2) / 3);
				else if (mod3 == 2)
					bestResult = ((t + 1) / 3);
				else {
					throw new Exception("something's wrong with mod3");
				}

				// satisfies P?
				if (bestResult >= P) {
					countP++;
				} else {
					// surprising score allowed?
					if (S > 0 && t > 0 && mod3 != 1) {
						bestResult += 1;

						if (bestResult >= P) {
							countP++;
							S--;
						}

					}
				}

			}
			System.out.println(CASE_NO + (total - T) + SUFFIX + countP);
			// System.out.println(N + " " + S + " " + P);

		}

	}

	private static BufferedReader readFile(String fileName)
			throws FileNotFoundException {

		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		return br;
	}

}
