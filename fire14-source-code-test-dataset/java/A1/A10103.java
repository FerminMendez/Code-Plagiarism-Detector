import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Second {

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader(new File(
				"/Users/narok119/Desktop/B-small-attempt1.in")));

		String txt = reader.readLine();
		int caseCount = 1;

		while ((txt = reader.readLine()) != null) {
			// Form the inputs
			String[] info = txt.split(" ", 4);
			int n = Integer.parseInt(info[0]);
			int s = Integer.parseInt(info[1]);
			int p = Integer.parseInt(info[2]);
			String[] input = info[3].split(" ");
			int[] number = new int[n];
			int output = 0;
			for (int i = 0; i < n; i++) {
				number[i] = Integer.parseInt(input[i]);
			}

			// Start calculating output
			for (int i = 0; i < n; i++) {
				if (p * 3 <= number[i]) {
					output++;
				} else if (2 * p + (p - 1) == number[i]) {
					output++;
				} else if (2 * (p - 1) + p == number[i]) {
					output++;
				} else if (s > 0 && p - 2 >= 0
						&& (p - 2) + (p - 1) + p == number[i]) {
					output++;
					s--;
				} else if (s > 0 && p - 2 >= 0 && (p - 2) + 2 * p == number[i]) {
					output++;
					s--;
				} else if (s > 0 && p - 2 >= 0 && 2 * (p - 2) + p == number[i]) {
					output++;
					s--;
				}
			}
			System.out.println("Case #" + caseCount++ + ": " + output);
		}
	}

}
