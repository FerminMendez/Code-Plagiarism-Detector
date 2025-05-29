import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Qual1b {
	static int[] norm = { 0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6,
			6, 7, 7, 7, 8, 8, 8, 9, 9, 9, 10, 10, 10 };
	static int[] weird = { 0, 1, 1, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6,
			7, 7, 7, 8, 8, 8, 9, 9, 9, 10, 10, 10, 10, 10 };

	public static void main(String args[]) {

		try {

			FileWriter fstream = new FileWriter("outBSmall1.txt");
			BufferedWriter out = new BufferedWriter(fstream);

			Scanner scanner = new Scanner(new File("B-small-attempt0.in"));

			int count = scanner.nextInt();
			System.out.println(count);
			for (int i = 1; i <= count; i++) {
				int n = scanner.nextInt();
				int s = scanner.nextInt();
				int p = scanner.nextInt();

				System.out.println("googlees " + n);
				System.out.println("surprising " + s);
				System.out.println("max score " + p);

				int resultMax = 0;
				// ArrayList<Integer> listOfNum = new ArrayList<Integer>();
				for (int j = 0; j < n; j++) {
					int temp = scanner.nextInt();
					if (norm[temp] >= p) {
						resultMax++;
					} else if (weird[temp] >= p && s > 0) {
						resultMax++;
						s--;
					}
				}

				out.write("Case #" + i + ": " + resultMax + "\n");
			}
			out.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
