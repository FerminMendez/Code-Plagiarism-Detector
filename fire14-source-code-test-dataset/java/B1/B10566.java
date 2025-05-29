package code;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class C {

	final static String CASE_NO = "Case #";
	final static String SUFFIX = ": ";

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		int total;
		int T; // nuber of test cases

		BufferedReader br = readFile("testC");

		T = Integer.parseInt(br.readLine());
		total = T;

		while (T > 0) {
			T--;
			int pairs = 0;
			String line = br.readLine();
			String[] input = line.split(" ");
			int i = 0;
			int A = Integer.parseInt(input[i++]);
			int B = Integer.parseInt(input[i++]);

			for (int x = A; x < B; x++) {
				int mulFact = getMulFactor(x);

				int num = getPrefix(x, mulFact) + getSuffix(x);

				while (num != x) {
					if (num > x && num <= B) {
						pairs++;

					}
					num = getPrefix(num, mulFact) + getSuffix(num);
				}
			}
			System.out.println(CASE_NO + (total - T) + SUFFIX + pairs);

		}

	}

	private static BufferedReader readFile(String fileName)
			throws FileNotFoundException {

		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		return br;
	}

	private static int getMulFactor(int num) {
		int m = 1;

		while ((num / m) > 9) {
			m = m * 10;
		}
		return m;
	}

	private static int getPrefix(int num, int mul) {
		int i = 10;
		int mod = num % i;
		while (mod == 0) {
			i = i * 10;
			mod = num % i;
			mul = mul / 10;
		}

		return mul * mod;
	}

	private static int getSuffix(int num) {
		int i = 1;
		int mod;

		do {
			i = i * 10;
			mod = num % i;
		} while (mod == 0);

		return num / i;
	}
}
