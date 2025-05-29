package qualification2012;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;

public class Dancing {

	static int bestScoreWithoutSurprise(int t) {
		if(t < 2) return t;
		if(t > 27) return 10;
		return t % 3 == 0 ? t / 3 : t / 3 + 1;
	}
	
	static int bestScoreWithSurprise(int t) {
		if(t < 2) return t;
		if(t > 27) return 10;
		return t % 3 == 2 ? t / 3 + 2 : t / 3 + 1;
	}
	
	static int solve(int[] t, int S, int p) {
		int result = 0;
		for (int i = 0; i < t.length; i++) {
			if(bestScoreWithoutSurprise(t[i]) >= p)
				result++;
			else if(S > 0 && bestScoreWithSurprise(t[i]) >= p) {
				S--;
				result++;
			}
				
		}
		return result;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader(args[0]));
		PrintWriter writer = new PrintWriter(args[1]);
		int ntests = Integer.parseInt(reader.readLine());
		for (int test = 0; test < ntests; test++) {
			String[] fields = reader.readLine().split(" ");
			int N = Integer.parseInt(fields[0]);
			int S = Integer.parseInt(fields[1]);
			int p = Integer.parseInt(fields[2]);
			int[] t = new int[N];
			for (int i = 0; i < N; i++)
				t[i] = Integer.parseInt(fields[i + 3]);
			writer.println("Case #" + (test + 1) + ": " + solve(t, S, p));
		}
		writer.close();
	}
}
