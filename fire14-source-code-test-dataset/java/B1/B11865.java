import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class c {

	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("c.txt"));
		PrintWriter out = new PrintWriter(new File("c-out.txt"));
		String s = "";
		int t = Integer.parseInt(br.readLine());
		// int t = 105;
		Queue<Integer> q;
		for (int i = 0; i < t; i++) {
			int count = 0;
			s = br.readLine();
			String x[] = s.split(" ");
			int A = Integer.parseInt(x[0]);
			int B = Integer.parseInt(x[1]);

			for (int j = A; j < B; j++) {
				for (int j2 = j + 1; j2 <= B; j2++) {
					q = new LinkedList<Integer>();
					int n = j;
					int m = j2;
					int m2 = m;
					int sumn = 0, summ = 0;
					while (n > 0) {
						q.add(n % 10);

						sumn += (n % 10);
						summ += (m2 % 10);

						m2 = m2 / 10;
						n = n / 10;
					}

					if (summ != sumn)
						continue;

					int len = q.size();
					for (int k = 0; k < len - 1; k++) {
						q.add(q.remove());
						// System.out.println(q);
						int c = 1;
						int nn = 0;
						for (Integer integer : q) {
							nn = nn + (integer * c);
							c *= 10;
						}
						// System.out.println(nn);
						if (m == nn) {
							count++;
							break;
						}
					}

				}
			}
			out.println("Case #" + (i + 1) + ": " + count);
		}
		out.close();
	}

	public static void main(String[] args) throws Exception {
		/*
		 * int n = 12345; Queue<Integer> q = new LinkedList<Integer>(); int m =
		 * 0; while (n > 0) { q.add(n%10); //System.out.print(n % 10);
		 * //System.out.println(m); n = n/10;
		 * 
		 * }
		 * 
		 * int len = q.size(); for (int j = 0; j < len-1; j++) {
		 * q.add(q.remove()); System.out.println(q); int c = 1; int nn =0; for
		 * (Integer integer : q) { nn = nn + (integer*c); c *= 10; }
		 * System.out.println(nn); }
		 * 
		 * //System.out.println(1234568 % 10); String sa = "687248"; //char[]
		 * sac = sa.toCharArray(); //Arrays.sort(sac); //System.out.println(new
		 * String(sac)); BigInteger b = new BigInteger("123");
		 * 
		 * //int n = 16; //System.out.println(n>>3);
		 */
		c.solve();

	}

}
