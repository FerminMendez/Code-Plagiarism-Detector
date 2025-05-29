import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class ProblemB {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(new File("/Users/phan/Downloads/C-small-attempt0.in"));
		PrintWriter pw = new PrintWriter("/Users/phan/Downloads/output");
		int t = scanner.nextInt();
		
		for (int i = 1; i <= t; i++) {
			int A = scanner.nextInt();
			int B = scanner.nextInt();
			
			int cnt = 0;
			
			for (int n = A; n <= B; n++) {
				int[] digits = new int[7];
				int tmp = n;
				int cntdigit = 0;
				while (tmp > 0) {
					digits[cntdigit++] = tmp % 10;
					tmp = tmp / 10;
				}
				
				int[] mm = new int[cntdigit];
				int cnt2 = 0;
				for (int j = 1; j < cntdigit; j++) {
					int m = 0;
					for (int k = j - 1; k >= 0; k--) 
						m = m * 10 + digits[k];
					for (int k = cntdigit - 1; k >= j; k--) 
						m = m * 10 + digits[k];
					
					if ( (n < m) && (m <= B) ) {
						
						boolean b = true;
					
						for (int l = 0; l < cnt2; l++)
							if (mm[l] == m)
								b = false;
						
						if (b) {
							cnt++;
							mm[cnt2++] = m;
							//System.out.println(n + " " + m);
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
