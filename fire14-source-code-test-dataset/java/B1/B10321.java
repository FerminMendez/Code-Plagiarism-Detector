import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;


public class RecycledNumbers {
	public static void main(String args[]) throws IOException{
		String inputFile = args[0];
		String outputFile = args[1];
		BufferedReader input = new BufferedReader(new FileReader(inputFile));
		PrintWriter   output = new PrintWriter(outputFile);
		
		int testcases = Integer.valueOf(input.readLine());
		int testcase  = 0;
		while (testcase++ < testcases) {
			int result = 0;
			String newline = input.readLine();
			String tokens[] = newline.split(" ");
			long A = Long.valueOf(tokens[0]);
			long B = Long.valueOf(tokens[1]);
			
			int digit = 1;
			long baseAndMask = 10;
			long dummyA = A;
			while ((dummyA = dummyA / 10) > 0) {
				digit++;
				baseAndMask *= 10;
			}
			
			long i;
			for (i = A; i < B; i++) {
				int k = digit;
				long recycled = i * baseAndMask + i;
				while (k-- > 0) {
					long j = recycled % baseAndMask;
					if (j <= B && j > i) {
						result++;
					}
					recycled = recycled / 10;
				}
			}
			
			output.printf("Case #%d: %d\n", testcase, result);
		}
		
		output.close();
	}
}
