package qualification.round.atual;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Googlers {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		File f = new File("B-small-practice.in");
		FileInputStream fis = new FileInputStream(f);
		Scanner scanner = new Scanner(fis);

		File fOut = new File("B-small-practice.out");
		Writer out = new BufferedWriter(new FileWriter(fOut));

		try {
			int t = Integer.parseInt(scanner.nextLine());

			for (int i = 1; i <= t; i++) {
				out.write("Case #" + i + ": "
						+ getNumberOfBestResults(scanner.nextLine()) + "\n");
			}

		} finally {
			scanner.close();
			out.close();
		}

	}

	private static int getNumberOfBestResults(String line) {
		int number = 0;
		String elements[] = line.split(" ");
		int n = Integer.parseInt(elements[0]);
		int s = Integer.parseInt(elements[1]);
		int p = Integer.parseInt(elements[2]);

		int i = 1;
		while (i <= n) {
			int total = Integer.parseInt(elements[i + 2]);
			i++;
			List<String> bests = getBestsGreaterThanP(p, total);
			for (String best : bests) {
				String[] values = best.split(" ");
				int v1 = Integer.parseInt(values[0]);
				int v2 = Integer.parseInt(values[1]);
				int v3 = Integer.parseInt(values[2]);

				if (v1 - v2 <= 1 && v2 - v1 <= 1 && v2 - v3 <= 1
						&& v3 - v2 <= 1 && v1 - v3 <= 1 && v3 - v1 <= 1) {
					number++;
					break;
				} else if (s > 0) {
					s--;
					number++;
					break;
				}
			}
		}

		return number;
	}

	private static List<String> getBestsGreaterThanP(int p, int total) {
		List<String> list = new ArrayList<String>();

		if (total % 3 == 0) {
			int c = total / 3;
			if (c >= p) {
				list.add(c + " " + c + " " + c);
			} else if (c + 1 >= p && c - 1 >= 0 && c + 1 <= 10) {
				list.add((c - 1) + " " + c + " " + (c + 1));
			}
		} else {
			int c = (int) Math.floor(total / 3);

			if (total % 3 == 1) {
				if (c + 1 >= p && c + 1 <= 10) {
					list.add(c + " " + c + " " + (c + 1));
				}
				if (c + 1 >= p && c - 2 >= 0 && c + 1 <= 10) {
					list.add((c - 2) + " " + (c + 1) + " " + (c + 1));
				}
			} else {
				if (c + 1 >= p && c + 1 <= 10) {
					list.add((c + 1) + " " + c + " " + (c + 1));
				}
				if (c + 2 >= p && c + 2 <= 10) {
					list.add(c + " " + c + " " + (c + 2));
				}
			}
		}

		return list;
	}
}