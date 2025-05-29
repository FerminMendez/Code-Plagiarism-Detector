import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class RecycledNumbers {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("data/C-small-attempt0.in"));
		PrintWriter out = new PrintWriter(new File("data/output.txt"));

		Integer count = sc.nextInt();
		System.out.println(count);

		for (int i = 0; i < count; i++) {
			System.out.println(i);
			out.println("Case #" + (i + 1) + ": "
					+ countRecycled(sc.nextInt(), sc.nextInt()));
		}

		out.close();
	}

	private static int countRecycled(Integer iA, Integer iB) {
		Set<String> recycled = new HashSet<String>();
		if (iA.toString().length() != iB.toString().length()) {
			return 0;
		}

		System.out.println();
		System.out.println(iA + " " + iB);
		System.out.println();
		int sLength = iA.toString().length();

		for (Integer n = iA; n <= iB; n++) {

			for (int c = 1; c <= sLength; c++) {
				String left = n.toString().substring(sLength - c, sLength);
				String right = n.toString().substring(0, sLength - c);
				String newNumber = left + right;
				// System.out.println(left + "-" + right + "-" + newNumber);
				int intNew = Integer.parseInt(newNumber);
				if (!newNumber.startsWith("0") // same length
						&& intNew <= iB // within range
						&& intNew > n // bigger than the other one
				) {
					recycled.add(n.toString() + "," + newNumber);
				}

			}
		}

		return recycled.size();
	}
}
