import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class ProblemB {

	private void solve() {
		Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        
        int T = in.nextInt();
        for (int i = 1; i <= T; i++) {
        	int N = in.nextInt();
        	int S = in.nextInt();
        	int p = in.nextInt();
        	
        	int r = 0;
        	for (; N > 0; N--) {
        		int k = in.nextInt();
        		if (k + 2 >= 3 * p && k >= p) {
        			r++;
        		} else if (k + 4 >= 3 * p && k >= p && S > 0) {
        			r++;
        			S--;
        		}
        	}
        	out.println("Case #" + i + ": " + r);
        }
        
        
        out.flush();
        out.close();
	}
	
	public static void main(String[] args) throws IOException {
		ProblemB solver = new ProblemB();
        solver.solve();
	}
}
