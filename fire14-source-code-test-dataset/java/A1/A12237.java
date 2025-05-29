import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DancingScores {
	private static final String fname = "B-small-attempt1.in";

	public static void main(String[] args) throws Exception {
		new DancingScores().run();
	}

	private void run() throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader("./" + fname));
		BufferedWriter writer = new BufferedWriter(new FileWriter("./" + fname
				+ ".out"));
		int T = Integer.parseInt(reader.readLine().trim());
		for (int i = 1; i <= T; i++) {
			String[] line = reader.readLine().trim().split("[ ]");
			int N = Integer.parseInt(line[0]);
			int S = Integer.parseInt(line[1]);
			int p = Integer.parseInt(line[2]);
			int[] t = new int[N];
			for (int j = 3; j < line.length; j++) {
				t[j - 3] = Integer.parseInt(line[j]);
			}
			int clear = 0;
			int surprising = 0;
			for (int j = 0; j < N; j++) {
				int score = t[j];
				if (score == 0) {
					if (p == 0) {
						clear++;
					}
				} else if (score >= p) {
					int avg = score / 3;
					if (avg >= p) {
						clear++;
						continue;
					} else {
						int delta = Math.abs(p - ((score - p) / 2));
						if (delta <= 1) {
							clear++;
						} else if (delta <= 2) {
							surprising++;
						}
					}
				}
			}
			clear = clear + Math.min(S, surprising);
			writer.write("Case #" + i + ": " + clear);
			if (i < T)
				writer.write("\n");
		}
		reader.close();
		writer.close();
	}
}
