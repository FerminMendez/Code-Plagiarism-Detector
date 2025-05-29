package gcj;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class DancingWithTheGooglers {

	private String solve(Scanner in) {
		int N = in.nextInt();
		int S = in.nextInt();
		int p = in.nextInt();
		
		int p3 = 3*p;
		
		if (p >10) return "" + 0;
		
		int result = 0;
		int strange = 0;

		for (int i=0; i<N; i++) {
			int score = in.nextInt();

			if (p3 <= score) result++;
			else {	
				int diff = p3 - score;
				if (diff <= 2) {
					if (p - 1 >= 0)
						result++;
				}
				else if (diff <= 4) {
					if (p - 2 >= 0) {
						strange++;
						if (strange <= S) result++;
					}
				}
			}
			
		}
		
		return "" + result;
	}
	
	
	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
	    Scanner in = new Scanner(new File("C:\\Users\\User\\Desktop\\dane\\data.in"));
	    PrintWriter out = new PrintWriter("C:\\Users\\User\\Desktop\\dane\\output");
		
	    int T = in.nextInt();
	    in.nextLine();
	
        for (int i = 0; i < T; i++) {
            String s = "Case #" + (i + 1) + ": " + new DancingWithTheGooglers().solve(in);
            out.println(s);
            System.out.println(s);
        }
        out.close();

	}

}
