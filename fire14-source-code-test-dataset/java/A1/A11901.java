import java.io.*;
import java.util.*;

public class B {
	public static final String INPATH = "input2.in";
	public static final String OUTPATH = "output2.out";

	public static void main (String[] args) throws FileNotFoundException {
		Scanner inscan = new Scanner (new File (INPATH));
 		PrintStream out = new PrintStream (new File (OUTPATH));
		
		int T = inscan.nextInt();
		inscan.nextLine();
		
		for (int i=1; i <= T; i++) {
			int result = compute (inscan.nextLine());
			out.println("Case #" + i + ": " + result);
		}
	}
	
	public static int compute (String line) {
		Scanner linescan = new Scanner (line);
		int N = linescan.nextInt();
		int S = linescan.nextInt();
		int p = linescan.nextInt();
		
		if (p == 0) {
			return N;
		}
		
		int count = 0;
		for (int i=0; i < N; i++) {
			int t = linescan.nextInt();
			
			if (t >= 3*p - 2) {
				count++;
			} else if (3*p - 4 <= t && t <= 3*p - 3 && S > 0 && !(p == 1 && t == 0)) {
				count++;
				S--;
			}
		}
		
		return count;
	}

}