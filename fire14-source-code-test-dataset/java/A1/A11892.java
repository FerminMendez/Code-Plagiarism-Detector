import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.StringTokenizer;


public class Dancers {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new FileReader(new File("B-small-attempt0.in")));
		BufferedWriter out = new BufferedWriter(new FileWriter(new File("output0")));
		
		String line = in.readLine();
		int T = Integer.parseInt(line);
		
		for(int i = 0; i < T && in.ready(); i++) {
			line = in.readLine();
			
			StringTokenizer tokenizer = new StringTokenizer(line);
			
			int N = Integer.parseInt(tokenizer.nextToken());
			int S = Integer.parseInt(tokenizer.nextToken());
			int p = Integer.parseInt(tokenizer.nextToken());
			
			int numReg = 0;
			int numSurprise = 0;
			
			int min = 3*p - 2;
			int max = 3*p + 2;
			int sMin = min - 2;
			int sMax = max + 2;
			
			for(int j = 0; j < N && tokenizer.hasMoreTokens(); j++) {
				int score = Integer.parseInt(tokenizer.nextToken());
				
				if (score == 0) {
					if (p == 0)
						numReg++;
					continue;
				}
				
				if (score == 1) {
					if (p <= 1)
						numReg++;
					continue;
				}
				
				if (score >= min) {
					numReg++;
					continue;
				}
				
				if (score >= sMin)
					numSurprise++;
			}
			
			numSurprise = Math.min(numSurprise, S);
			int num = numReg + numSurprise;
			
			System.out.println("Case #" + (i+1) + ": " + num + ", reg: " + numReg + ", surp: " + numSurprise);
			
			out.write("Case #" + (i+1) + ": " + num);
			out.newLine();
			
		}
		
		out.close();
	}
}
