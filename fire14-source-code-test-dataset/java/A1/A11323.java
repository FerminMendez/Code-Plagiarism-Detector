
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		InputStream in = System.in;
		PrintStream out = System.out;
		if (args.length > 0) {
			try {
				in = new FileInputStream(args[0]);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		Scanner scanner = new Scanner(in);
		int cases = scanner.nextInt();
		for (int i = 1; i <= cases; ++i) {
			int n = scanner.nextInt();
			int s = scanner.nextInt();
			int p = scanner.nextInt();
			int good = 0;
			int surprising = 0;
			for (int j = 0; j < n; ++j) {
				int t,q,r;
				t = scanner.nextInt();
				if (t > 0) {
					--t;
					r = t % 3;
					q = t / 3;
					if (q + 1 >= p) {
						++good;
					} else if (r > 0 && q + 2 >= p) {
						++surprising;
					}
				} else if (p == 0) {
					++good;
				}
			}
			
			
			out.format("Case #%d: ",i);
			out.print(good + Math.min(s, surprising));
			out.println();
		}
	}
}