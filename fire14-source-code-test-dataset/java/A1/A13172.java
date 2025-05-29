import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import org.apache.commons.io.IOUtils;

public class Problem2 {
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		// The first line of the input gives the number of test cases, T.
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(args[0]));
			int T = Integer.parseInt(in.readLine());
			for (int i = 1; i <= T; i++) {
				String[] split = in.readLine().split(" ");
				// T test cases follow. Each test case consists of a single line
				// containing integers separated by single spaces. The first
				// integer will be N, the number of Googlers
				int N = Integer.parseInt(split[0]);
				// and the second integer will be S, the number of surprising
				// triplets of
				// scores.

				int S = Integer.parseInt(split[1]);
				// The third integer will be p, as described above.
				int p = Integer.parseInt(split[2]);
				// Next will be N integers ti: the total points of the Googlers.
				int[] ti = new int[N];
				for (int j = 0; j < ti.length; j++)
					ti[j] = Integer.parseInt(split[j + 3]);
//				System.out.println(String.format(
//						"N = %s S = %s p = %s ti = %s ", N, S, p,
//						Arrays.toString(ti)));
				int count = 0;
				for (int j = 0; j < ti.length; j++) {
					int t = ti[j];
					if (t < p)
						continue;
					if (t >= p * 3 - 2)
						count++;
					else if (t >= p * 3 - 4 && --S >= 0)
						count++;
				}
				System.out.println("Case #" + i + ": " + count);
			}
		} finally {
			IOUtils.closeQuietly(in);
		}
	}
}
