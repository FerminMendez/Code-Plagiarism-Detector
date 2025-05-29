import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.util.Arrays.fill;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class B {
	
	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer tok;
	
	static void solveTest() throws Exception {
		int N = nextInt();
		int S = nextInt();
		int p = nextInt();
		
		int res = 0;
		for(int i = 0;i< N;i++){
			int t = nextInt();
			int sho = t / 3;
			int rem = t % 3;
			
			if(t == 30 || t == 0){
				if(sho >= p) res++;
				continue;
			}
			else if( t == 29){
				if(sho + 1 >= p) res++;
				continue;
			}
			
			if( rem == 1){
				if(sho + 1 >= p) res++;
			}
			else
			{
				int border;
				if(rem == 0) border = sho;
				else border = sho + 1;

				if(border >= p) res++;
				else if( border + 1 == p){
					if(S > 0){
						S--;
						res++;
					}
				}
			}
		}
		
		out.printf("%d\n", res);
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