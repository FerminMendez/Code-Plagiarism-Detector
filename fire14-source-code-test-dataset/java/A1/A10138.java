package dancingwiththegooglers;

import java.util.Arrays;

import template.Template;

public class DancingWithTheGooglers extends Template {
	public static void main(String[] args) throws Exception {

		init("src/dancingwiththegooglers/B-small-attempt3");
		int lines = readInt();
		for (int i = 1; i <= lines; i++) {
			int[] line = readIntArray();
			int n = line[0];
			int s = line[1];
			int p = line[2];
			int[] t = new int[n];
			int result = 0;
			for (int j = 0; j < n; j++) {
				t[j] = line[j + 3];
				int m = t[j] / 3;
				int r = t[j] % 3 > 0 ? 1 : 0;
				if (m >= p)
					result++;
				else if (m + r >= p
						&& (m - r >= 0 || m + r > 0 && t[j] % 3 == 2))
					result++;
				else if (m + r + 1 >= p && s > 0 && m - r - 1 >= 0
						&& t[j] % 3 != 1) {
					result++;
					s--;
				}

			}

			System.out.println("\n" + Arrays.toString(line));
			write("Case #" + i + ": " + result);
		}
	}
}
