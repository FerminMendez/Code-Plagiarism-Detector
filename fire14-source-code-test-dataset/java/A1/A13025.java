package year2012;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

public class Dancing {

	
	static PrintWriter out;
	
	static int count(int[] scores, int N, int S, int p) {
		int result = 0;
		for (int i = 0; i < N; ++i) {
			if (scores[i] >= p) {
				int rest = scores[i] - p;
				if (rest/2 > (p - 2)) {
					result ++;
				} else if (S > 0 && rest/2 == (p - 2)) {
					result ++;
					S --;
				} else {
					continue;
				}
			}
		}
		return result;
	}
	
	static void deal(String file) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				new FileInputStream(file), "utf8"));
		String line = reader.readLine();
		int T = Integer.parseInt(line);
		for (int no = 1; no <= T; no++) {
			String[] args = reader.readLine().split("\\s");
			int N = Integer.parseInt(args[0]);
			int S = Integer.parseInt(args[1]);
			int p = Integer.parseInt(args[2]);
			int scores[] = new int[N];
			for (int i = 0; i < N; ++i) {
				scores[i] = Integer.parseInt(args[3 + i]);
			}
			out.println("Case #" + no + ": " + count(scores, N, S, p));
		}
	}
	
	public static void main(String[] args) throws Exception {
		out = new PrintWriter(new File("result-out.txt"));
		//deal("B-large.in");
		deal("B-small-attempt1.in");
		out.close();
		
	}

}
