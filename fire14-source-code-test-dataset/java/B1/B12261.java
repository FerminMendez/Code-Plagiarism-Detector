import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Set;

public class RecycledNumbers {
	private static final String fname = "C-small-attempt0.in";

	public static void main(String[] args) throws Exception {
		new RecycledNumbers().run();
	}
	
	private void run() throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader("./" + fname));
		BufferedWriter writer = new BufferedWriter(new FileWriter("./" + fname
				+ ".out"));
		int T = Integer.parseInt(reader.readLine().trim());
		for (int i = 1; i <= T; i++) {
			String[] line = reader.readLine().trim().split("[ ]");
			int lower = Integer.parseInt(line[0]);
			int upper = Integer.parseInt(line[1]);
			int retval =0;
			for (int j = lower ; j <= upper; j++) {
					Set<Integer> set = new HashSet<Integer>(2);
					int l = length10(j);
					int mult = l/10;
					for (int k = 10; k <= l; k = k*10) {
						int x = (j % k) * mult + (j / k);
						if (x >= lower && x <= upper && x != j && j < x  && !set.contains(x)) {
							set.add(x);
							retval++;
						}
						mult /=10;
					}
			}
			writer.write("Case #" + i + ": " + retval);
			if (i < T) writer.write("\n");
		}
		reader.close();
		writer.close();
	}

	private static int length10(int n) {
		int div = 1;
		while (n / div > 0) {
			div *= 10;
		}
		return div;
	}
}
