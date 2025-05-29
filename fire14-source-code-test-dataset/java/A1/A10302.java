import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;


public class DancingwithGooglers {
	public static void main(String args[]) throws IOException{
		String inputFile  = args[0];
		String outputFile = args[1];
		BufferedReader input  = new BufferedReader(new FileReader(inputFile));
		PrintWriter    output = new PrintWriter(outputFile);
		
		int testcases = Integer.valueOf(input.readLine());
		int testcase = 0;
		while (testcase++ < testcases) {
			int result = 0;
			String newline = input.readLine();
			String[] tokens = newline.split(" ");
			int N = Integer.valueOf(tokens[0]);
			int S = Integer.valueOf(tokens[1]);
			int p = Integer.valueOf(tokens[2]);
			int i;
			for (i = 0; i < N; i++) {
				int score = Integer.valueOf(tokens[i + 3]);
				int highest = (score + 2) / 3;
				int possible = (score + 4) / 3;
				if (highest >= p)
					result++;
				else if (possible >= p && possible <= score && S > 0) {
					result++;
					S--;
				}
			}
			
			output.printf("Case #%d: %d\n", testcase, result);
		}
		
		output.close();
	}
}
