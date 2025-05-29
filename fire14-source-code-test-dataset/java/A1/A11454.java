import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Problem2 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("B-small.txt"));
		PrintWriter out = new PrintWriter(new File("B-out.txt"));
		int testCases = Integer.parseInt(in.readLine().trim());
		for (int i = 0; i < testCases; i++) {
			String line = in.readLine();
			StringTokenizer tokenizer = new StringTokenizer(line);
			int numDancers = Integer.parseInt(tokenizer.nextToken());
			int S = Integer.parseInt(tokenizer.nextToken());
			int p = Integer.parseInt(tokenizer.nextToken());
			int result = 0;
			for (int j = 0; j < numDancers; j++) {
				int score = Integer.parseInt(tokenizer.nextToken());
				int subScore1 = -1;
				int subScore2 = -1;
				boolean isValid2 = true;
				if (score % 3 == 0) {
					subScore1 = score / 3;
					if (score - 3 < 0) {
						isValid2 = false;
					}
					subScore2 = ((score - 3) / 3) + 2;
				}
				if (score % 3 == 1) {
					if (score - 4 < 0) {
						isValid2 = false;
					}
					subScore1 = ((score - 1) / 3) + 1;
					subScore2 = ((score - 4) / 3) + 2;
				}
				if (score % 3 == 2) {
					if (score - 2 < 0) {
						isValid2 = false;
					}
					subScore1 = ((score - 2) / 3) + 1;
					subScore2 = ((score - 2) / 3) + 2;
				}
				if(subScore2 > 10){
					isValid2 = false;
				}
				if (subScore1 >= p) {
					result++;
				} else if (isValid2) {
					if (subScore2 < p) {
						continue;
					} else {
						if (S != 0) {
							result++;
							S--;
						}
					}
				}
			}
			out.println("Case #" + (i + 1) + ": " + result);
		}
		out.close();
	}
}
