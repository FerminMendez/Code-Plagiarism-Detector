import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.util.Arrays.fill;

import java.io.*;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class C {
	
	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer tok;
	
	static void solveTest() throws Exception {
		int A = nextInt();
		int B = nextInt();
		int digit = Integer.toString(A).length();
		
		int res = 0;
		for(int n = A;n<=B;n++){
 			Set<Integer> set = new HashSet<Integer>();
			for(int i = 1;i< digit;i++){
				int nshift = shift(n,i);
				if(nshift > n && nshift <= B)
				{
					set.add(nshift);
				}
			}
			res += set.size();
		}
		out.printf("%d\n", res);
	}
	
	static int shift(int N, int idx)
	{
		String bef = Integer.toString(N);
		int n = bef.length();
		String aft = bef.substring(idx,n) + bef.substring(0,idx);
		return Integer.parseInt(aft);
	}
	static void solve() throws Exception {
		int tests = nextInt();
		for (int test = 1; test <= tests; test++) {
			out.print("Case #" + test + ": ");
			solveTest();
		}
	}

	public static void main(String[] args) throws Exception {
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		solve();
		in.close();
		out.close();
	}
	
	static String next() throws IOException {
		while (tok == null || !tok.hasMoreTokens()) {
			tok = new StringTokenizer(in.readLine()," \r\n\t\f");
		}
		return tok.nextToken();
	}
	
	static char nextChar() throws IOException {
		String token = next();
		if (token.length() != 1) {
			throw new IllegalArgumentException("String \"" + token + "\" is not a single character");
		}
		return token.charAt(0);
	}
	
	static int nextInt() throws IOException {
		return parseInt(next());
	}
	
	static long nextLong() throws IOException {
		return parseLong(next());
	}
	
	static BigInteger nextBigInt() throws IOException {
		return new BigInteger(next());
	}
}