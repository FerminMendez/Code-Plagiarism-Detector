import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	private static final String toRead = "/home/jean/tmp/B-small-attempt3.in";
	private static final String toWrite = "/home/jean/tmp/B-small-attempt3.out";

	public static void main(String[] args) throws IOException {
		// InputStream is = System.in;
		BufferedReader br = new BufferedReader(new FileReader(toRead));
		BufferedWriter bw = new BufferedWriter(new FileWriter(toWrite, false));
		compute(br, bw);

	}

	private static void compute(BufferedReader br, BufferedWriter bw)
			throws IOException {
		Scanner sc = new Scanner(br);

		int t = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < t; ++i) {
			String res = computeOne(sc);
			write(res, i, bw);
		}

		bw.flush();

		if (bw != null) {
			bw.close();
		}

	}

	private static void write(String res, int i, BufferedWriter bw)
			throws IOException {
		StringBuilder sb = new StringBuilder("Case #").append(i + 1)
				.append(": ").append(res);
		bw.write(sb.toString());
		// System.out.println(sb.toString());
		bw.newLine();
	}

	public static String computeOne(Scanner sc) {
		int N = sc.nextInt();
		int S = sc.nextInt();
		int p = sc.nextInt();

		int highestBound;
		int lowestBound;

		if (p == 0) {
			highestBound = 0;
			lowestBound = 0;
		} else if (p == 1) {
			highestBound = 1;
			lowestBound = 1;
		} else {
			highestBound = p + (p - 1) + (p - 1);
			lowestBound = p + (p - 2) + (p - 2);
		}

		long count = 0;

		for (int i = 0; i < N; ++i) {
			int sum = sc.nextInt();
			if (sum >= highestBound) {
				++count;
			} else if (sum >= lowestBound && S > 0) {
				--S;
				++count;
			}
		}

		return Long.toString(count);

	}

}
