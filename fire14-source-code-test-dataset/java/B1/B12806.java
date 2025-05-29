import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class C {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(new File("d:\\cc.small.in"));// new Scanner(new
																// File("d:\\b.small.in"));
		// in = new Scanner(new File("d:\\Minimum Scalar Product-big.in"));

		int testCases = in.nextInt();
		in.nextLine();
		for (int cas = 1; cas <= testCases; cas++) {
			int ans = 0;
			int A = in.nextInt();
			int B = in.nextInt();
			// in.nextLine();

			Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();

			for (int n = A; n < B; n++) {
				String sn = "" + n;
				int len = sn.length();
				for (int i = 1; i < len; i++) {
					String front = sn.substring(0, i);
					String rear = sn.substring(i, len);
					int m = Integer.parseInt(rear + front);

					if (A <= n && n < m && m <= B) {
						Set<Integer> s = map.get(n);
						if (null == s) {
							ans++;
							s = new HashSet<Integer>();
							s.add(m);
							map.put(n, s);
						} else {
							if (s.add(m))
								ans++;
						}
						// System.err.printf("n:%d,m:%d\n",n,m);
					}
				}
			}

			System.out.printf("Case #%d: %d\n", cas, ans);
		}

	}

}
