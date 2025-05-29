import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.*;


public class C {
	Scanner sc;
	PrintStream ps;

	public void solve() {
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		int nr = 0;
		for (int n=A; n<=B; n++) {
			String s = n+"";
			HashSet<Integer> set = new HashSet<Integer>();
			for (int i=0; i<s.length(); i++) {
				String t = s.substring(i) + s.substring(0, i);
				int m = Integer.parseInt(t);
				if ((n < m) && (m <= B)) {
					set.add(m);
				}
			}
			nr += set.size();
		}
		
		ps.println(nr);
	}
	
	
	public void run(String[] args) throws FileNotFoundException {
		sc = new Scanner(new File("C.in"));
		ps = System.out; // new PrintWriter("C.out");
		int num_tests = sc.nextInt();
		sc.nextLine();
		
		for (int test=1; test<=num_tests; test++) {
			ps.print("Case #"+test+": ");
			
			solve();
			
		}
		ps.close();
		
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		C a = new C();
		a.run(args);
	}
}
