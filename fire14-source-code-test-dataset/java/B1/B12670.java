import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;


public class C {
	private static final String PROBLEM_NAME = "C-small";

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader r = new BufferedReader(new FileReader(PROBLEM_NAME + ".in"));
		BufferedWriter w = new BufferedWriter(new FileWriter(PROBLEM_NAME + ".out"));
		int testsNumber = Integer.parseInt(r.readLine());
		for (int i = 0; i < testsNumber; ++i) {
			String[] line = r.readLine().split(" ");
			int a = Integer.parseInt(line[0]);
			int b = Integer.parseInt(line[1]);
			long res = 0L;
			
			int len = 0;
			int tmp = a;
			while (tmp != 0) {
				++len;
				tmp /= 10;
			}
			if (a == 0) {
				len = 1;
			}
			
			int m = 1;
			for (int j = 1; j < len; ++j) {
				m *= 10;
			}
			
			while (a < b) {
				Set<Integer> counted = new HashSet<Integer>();
				int t = a;
				boolean sh = false;
				for (int j = 1; j < len; ++j) {
					int x = t % 10;
					if (x == 0) {
						sh = true;
						t = t / 10;
					} else {
						sh = false;
						t = x * m + t / 10;
					}
					if (!sh && t <= b && t > a && !counted.contains(t)) {
						counted.add(t);
						++res;
					}
				}
				++a;
			}
			
			w.write("Case #" + (i + 1) + ": ");
			w.write(res + "");
			w.newLine();
		}
		r.close();
		w.close();
	}
}
