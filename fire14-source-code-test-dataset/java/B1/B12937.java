import static java.lang.Math.*;
import static java.util.Arrays.*;
import java.io.*;
import java.util.*;

public class C {
	Scanner sc = new Scanner(System.in);
	
	int A, B;
	
	void read() {
		A = sc.nextInt();
		B = sc.nextInt();
	}
	
	void solve() {
		long res = 0;
		for (int i = A; i <= B; i++) {
			int t = i;
			int X = 1;
			while (X * 10 <= i) X *= 10;
			do {
				t = t % 10 * X + t / 10;
				if (i < t && t <= B) res++;
			} while (t != i);
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
			System.setIn(new BufferedInputStream(new FileInputStream(args.length > 0 ? args[0] : (C.class.getName() + ".in"))));
		} catch (Exception e) {
		}
		new C().run();
	}
}
