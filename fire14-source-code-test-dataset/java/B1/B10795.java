import java.io.*;
import java.util.*;
import java.util.regex.*;

import static java.lang.Math.*;

public class C {
	public static void main(String[] args) throws Exception {

		Scanner in = (args.length > 0) ? new Scanner(new File(args[0]))
				: new Scanner(System.in);
		int T = in.nextInt();
		for (int zz = 1; zz <= T; zz++) {
			System.err.format("#%d\n", zz);
			System.out.format("Case #%d: ", zz);

			int A = in.nextInt();
			int B = in.nextInt();
			int y = 0;

			Set<String> pairs = new HashSet<String>();

			int D = (int) Math.log10(A);
			long p0 = 10;
			long p1 = (long) Math.pow(10, D);

			for (int d = 1; d <= D; d++) {
				for (long n = A; n <= B; n++) {
					long m = ((n % p1) * p0) + (n / p1);
					if (m > n && m <= B && !pairs.contains(n + ":" + m)) {
						y++;
						pairs.add(n + ":" + m);
					}
				}
				p0 *= 10;
				p1 /= 10;
			}

			System.out.format("%d\n", y);
		}
	}
}
