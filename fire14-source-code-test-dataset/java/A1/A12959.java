import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.*;


public class B {
	Scanner sc;
	PrintStream ps;

	public void solve() {
		int n = sc.nextInt();
		int s = sc.nextInt();
		int p = sc.nextInt();
		
		int nr = 0;
		
		for (int i=0; i<n; i++) {
			int k = sc.nextInt();
			if (p + 2 * Math.max(p-1, 0) <= k) {
				nr++;
			}
			else if ((s > 0) && (p + 2 * Math.max(p-2, 0) <= k)) {
				s--;
				nr++;
			}
		}
		
		ps.println(nr);
	}
	
	
	public void run(String[] args) throws FileNotFoundException {
		sc = new Scanner(new File("B.in"));
		ps = System.out; // new PrintWriter("B.out");
		int num_tests = sc.nextInt();
		sc.nextLine();
		
		for (int test=1; test<=num_tests; test++) {
			ps.print("Case #"+test+": ");
			
			solve();
			
		}
		ps.close();
		
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		B a = new B();
		a.run(args);
	}
}
