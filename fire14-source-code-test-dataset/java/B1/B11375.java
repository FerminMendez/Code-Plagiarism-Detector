import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class ProblemC {

	private void solve() {
		Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        
        int T = in.nextInt();
        for (int i = 1; i <= T; i++) {
        	long result = 0;
        	int A = in.nextInt();
        	int B = in.nextInt();
        	int digits = digits(A);
        	int m = (int)Math.pow(10, digits-1);
        	for (int k = A; k <= B; k++) {
        		Set<Integer> used  = new HashSet<Integer>();
        		//used.add(k);
        		int kk = k;
        		for (int d = 1; d < digits; d++) {
        			int r = kk % 10;
        			kk /= 10;
        			kk += r * m;
        			if (kk > k && kk <= B && !used.contains(kk)) {
        				result++;
        				used.add(kk);
        			}
        		}
        	}
        	out.println("Case #" + i + ": " + result);
        }
        
        
        out.flush();
        out.close();
	}
	
	private int digits(int a) {
		int d = 0;
		while (a > 0) {
			d++;
			a /= 10;
		}
		return d;
	}

	public static void main(String[] args) throws IOException {
		ProblemC solver = new ProblemC();
        solver.solve();
	}
}
