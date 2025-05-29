import static java.lang.Math.*;
import static java.util.Arrays.*;
import java.io.*;
import java.util.*;

public class B {
	Scanner sc = new Scanner(System.in);
	
	int N, S, p;
	int[] ts;
	
	void read() {
		N = sc.nextInt();
		S = sc.nextInt();
		p = sc.nextInt();
		ts = new int[N];
		for (int i = 0; i < N; i++) ts[i] = sc.nextInt();
	}
	
	void solve() {
		int res = 0;
		for (int i = 0; i < N; i++) {
			if (p * 3 - 2 <= ts[i]) res++;
			else if (p <= ts[i] && p * 3 - 4 <= ts[i] && S-- > 0) res++;
		}
		System.out.println(res);
	}
	
	void run() {
		int caseN = sc.nextInt();
		for (int caseID = 1; caseID <= caseN; caseID++) {
			read();
			System.out.printf("Case #%d: ", caseID);
			solve();
			System.out.flush();
		}
	}
	
	void debug(Object...os) {
		System.err.println(deepToString(os));
	}
	
	public static void main(String[] args) {
		try {
			System.setIn(new BufferedInputStream(new FileInputStream(args.length > 0 ? args[0] : (B.class.getName() + ".in"))));
		} catch (Exception e) {
		}
		new B().run();
	}
}
