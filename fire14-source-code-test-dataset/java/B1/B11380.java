package codejam2012.r0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * @author julian
 */
public class C {

	public static final void main(String[] args) throws IOException {
		(new C()).run();
	}

	public void run() throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("C-small.in"));
		BufferedWriter out = new BufferedWriter(new FileWriter("C.out"));
		int t = Integer.parseInt(in.readLine());
		for (int i = 0; i < t; i++) {
			StringTokenizer stok = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(stok.nextToken());
			int b = Integer.parseInt(stok.nextToken());
			out.write("Case #" + (i + 1) + ": " + solve(a, b) + "\n");
		}
		in.close();
		out.flush();
		out.close();
	}

	public int solve(int a, int b) {
		int ret = 0;
		for (int n = a; n <= b; n++) {
			String str = "" + n;
			Set<Integer> perm = new HashSet<Integer>();
			int ndig = str.length();
			for (int k = 0; k < ndig - 1; k++) {
				str = str.substring(1) + str.charAt(0);
				int m = Integer.parseInt(str);
				if (n < m && m <= b) {
					perm.add(m);
				}
			}
			ret += perm.size();
		}
		return ret;
	}

}
