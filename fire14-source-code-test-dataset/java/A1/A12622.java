import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class B {
	
	private static final String PROBLEM_NAME = "B-small";

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader r = new BufferedReader(new FileReader(PROBLEM_NAME + ".in"));
		BufferedWriter w = new BufferedWriter(new FileWriter(PROBLEM_NAME + ".out"));
		int testsNumber = Integer.parseInt(r.readLine());
		for (int i = 0; i < testsNumber; ++i) {
			String[] line = r.readLine().split(" ");
			int n = Integer.parseInt(line[0]);
			int s = Integer.parseInt(line[1]);
			int p = Integer.parseInt(line[2]);
			int good = 0;
			int almost = 0;
			for (int j = 0; j < n; ++j) {
				int sum = Integer.parseInt(line[3 + j]);
				if (sum % 3 == 0) {
					if (sum / 3 >= p) {
						++good;
					} else if (sum / 3 > 0 && sum / 3 + 1 >= p) {
						++almost;
					}
					continue;
				}
				if (sum % 3 == 1) {
					if (sum / 3 + 1 >= p) {
						++good;
					}
					continue;
				}
				if (sum % 3 == 2) {
					if (sum / 3 + 1 >= p) {
						++good;
					} else if (sum / 3 + 2 >= p) {
						++almost;
					}
					continue;
				}
			}
			w.write("Case #" + (i + 1) + ": ");
			w.write(good + ((almost < s)? almost: s) + "");
			w.newLine();
		}
		r.close();
		w.close();
	}

}
