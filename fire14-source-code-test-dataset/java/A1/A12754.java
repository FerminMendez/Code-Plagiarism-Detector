import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;


public class ProblemB {
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(new File("/Users/phan/Downloads/B-small-attempt0.in"));
		PrintWriter pw = new PrintWriter("/Users/phan/Downloads/output");
		int test = scanner.nextInt();
		
		for (int i = 1; i <= test; i++) {
			int n = scanner.nextInt();
			int s = scanner.nextInt();
			int p = scanner.nextInt();
			int[] scores = new int[n];
			for (int j = 0; j < n; j++)
				scores[j] = scanner.nextInt();
			
			Arrays.sort(scores);
			
			int cnt = 0;
			
			for (int j = n - 1; j >= 0; j--) {
				int[] t = new int[3]; 
				t[0] = scores[j] / 3;
				t[1] = t[0] + (scores[j] % 3) / 2;
				t[2] = t[0] + (scores[j] % 3 + 1) / 2;
				
				//System.out.println(t[0] + " " + t[1] + " " + t[2]);
				
				if (t[2] >= p) {
					cnt++;
				} 
				else {
					if (t[2] == p - 1) {
						if ((t[1] > 0) && (t[1] == t[2])) {
							if (s > 0) {
								cnt++;
								s--;
							}
							else {
								break;
							}
						}
					}
				}
			}
			
						
			pw.println("Case #" + String.valueOf(i) + ": " + String.valueOf(cnt));
		}
		
		scanner.close();
		pw.close();

	}


}
