import java.io.*;
import java.util.*;

public class Main {
	public static void main(String... args) throws Exception {
		int t, a, b, T;
		Scanner in = new Scanner(new File("recycled.in"));
		//PrintStream out = System.out;
		PrintStream out = new PrintStream(new File("recycled.out"));
		T = in.nextInt();
		for (t = 1; t <= T; t++) {
			a = in.nextInt();
			b = in.nextInt();
			int rez = 0;
			int i, j;
			int n = (a + "").length();
			String B = b + "";
			for (i = a; i <= b; i++) {
				String I = i + "";
				Set<String> s = new TreeSet<String>();
				s.add(I);
				for (j = 1; j < n; j++) {
					String x = I.substring(j) + I.substring(0, j);
					if (I.compareTo(x) < 0 && x.compareTo(B) <= 0 && s.add(x)) {
						rez++;
					}
				}
			}
			out.println("Case #" + t + ": " + rez);
		}
	}

}
