import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Problem2 {
	public static void main(String[] args) throws FileNotFoundException {
				Scanner input = new Scanner(new File("input.txt"));
		PrintStream output = new PrintStream(new FileOutputStream(new File("output.txt")));
		
		int T = input.nextInt();
		input.nextLine();
		
		for(int i=1; i <= T; ++i) {
			Scanner line = new Scanner(input.nextLine());
			int N = line.nextInt();
			int S = line.nextInt();
			int p = line.nextInt();
			
			System.out.printf("Case:%d, N:%d, S:%d, p:%d\n", i,N,S,p);
			
			int result = 0;
			for(int j=0; j < N; ++j) {
				int points = line.nextInt();
				
				int threshold,special_threshold;
				
				if (p==0) {
					threshold = 0;
					special_threshold = 0;
				}
				if (p==1) {
					threshold = 1;
					special_threshold = 1;
				}
				else {
					threshold = 3*p-2;
					special_threshold = 3*p-4;
				}
				
				
				if(points >= threshold) {
					result++;
				}
				else if( (S>0) && (points >= special_threshold)) {
					S--;
					result++;
				}
			}
			
			output.println("Case #" + i + ": " + result);
		}
	}
}
