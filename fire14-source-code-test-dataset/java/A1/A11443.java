import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;


public class B {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StreamTokenizer tokenizer = new StreamTokenizer(in);

		int tests;
		
		tokenizer.nextToken();
		tests = (int)tokenizer.nval;
		
		int[] answers = new int[tests];
		
		for (int i = 0;i < tests; ++i) {
			int N, S, p;			
			
			tokenizer.nextToken();
			N = (int)tokenizer.nval;
			
			tokenizer.nextToken();
			S = (int)tokenizer.nval;
			
			tokenizer.nextToken();
			p = (int)tokenizer.nval;
			
			int[] tscores = new int[N];
			
			for (int j = 0;j < N; ++j) {
				tokenizer.nextToken();
				tscores[j] = (int)tokenizer.nval;
			}
			
			int hugeScoresCount = 0;
			int greaterPCount = 0;
			
			for (int j = 0;j < N; ++j) {
				if (Math.ceil((double)tscores[j] / 3) >= p) {
					++hugeScoresCount;
				} else {
					if (tscores[j] % 3 == 0 && tscores[j] / 3 >= p - 1 && tscores[j] != 0) {
						++ greaterPCount;
					}else if (tscores[j] % 3 == 2 && tscores[j] / 3 >= p - 2) {
						++ greaterPCount;
					}
				}
			}
			
			answers[i] = hugeScoresCount + Math.min(S, greaterPCount);
		}
		
		for (int j = 0;j < tests; ++j) {
			System.out.println("Case #" + (j + 1) + ": " + answers[j]);
		}
	}

}
