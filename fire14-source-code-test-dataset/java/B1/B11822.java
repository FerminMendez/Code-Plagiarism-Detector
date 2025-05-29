import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class RecycledNumbers {

	public static void main(String[] args) throws IOException {

		File file = new File("in.txt");
		Scanner scanner = new Scanner(file);
		FileWriter outFile = new FileWriter("out.txt");
		PrintWriter out = new PrintWriter(outFile);

		int N = scanner.nextInt();
		for (int i = 0; i < N; i++) {

			int A = scanner.nextInt();
			int B = scanner.nextInt();
			Set<String> set = new HashSet<String>();

			for (int n = A; n <= B; n++) {

				char[] c = Integer.toString(n).toCharArray();

				for (int k = 0; k < c.length - 1; k++) {

					char temp = c[c.length - 1];
					for (int l = c.length - 1; l > 0; l--) {
						c[l] = c[l - 1];
					}
					c[0] = temp;

					StringBuilder s = new StringBuilder();
					for (int l = 0; l < c.length; l++) {
						s.append(c[l]);
					}

					String m = s.toString();

					if (A <= Integer.parseInt(m) && Integer.parseInt(m) <= B
							&& n < Integer.parseInt(m)) {
						set.add(Integer.toString(n).concat(m));
					}

				}

			}

			out.println("Case #" + (i + 1) + ": " + set.size());

		}

		out.close();

	}
}
