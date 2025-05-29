import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;
/* 
 * Problem A. Speaking in Tongues
 */
public class B {
	static BufferedReader _in = new BufferedReader(new InputStreamReader(System.in));
	static String _string;
	static StringTokenizer _stok;
	static String nextLine() throws IOException {
		_string = _in.readLine();
		_stok = new StringTokenizer(_string);
		return _string;}
	static String nextWord()	{return _stok.nextToken();}
	static int nextInt()		{return Integer.parseInt(nextWord());} // 2.1 x 10^9, 
	static long nextLong()		{return Long.parseLong(nextWord());}   // 9.2 x 10^18, 
	static double nextDouble() 	{return Double.parseDouble(nextWord());}
	static BigInteger nextBig()	{return new BigInteger(nextWord());}
	static void Dprintln(Object s) 	{if(debug) System.out.println(s);}
	static void Dprintln() 	{if(debug) System.out.println();}
	static void Dprint(Object s) 	{if(debug) System.out.print(s);}
	static void Dprintf(String s, Object... args) 	{if(debug) System.out.printf(s, args);}
	static void print(Object s) {System.out.print(s);}
	static void println(Object s) {System.out.println(s);}
	static void println() 	{System.out.println();}
	static void printf(String s, Object... args) {System.out.printf(s, args);}
	
	static boolean debug = true;


	static void solve(double T, double S, int p) {
		double avg = T/S;
		int a = (int)Math.floor(avg), b = (int)Math.ceil(avg);
		
	}

	static int best(int x, boolean surp) {
		int v = x/3;
		int r = x%3;
		if (r==0) {
			return v + (surp && v>0 ?1:0);
		}
		else if (r==1) {
			return v+1;
		} else if (r==2) {
			return v+1+ (surp?1:0);
		}
		System.err.println("never reach here");
		return -1;
	}

	public static void main(String[] args) throws Exception {

		nextLine();
		int Cases = nextInt();
		for (int Case=0; Case<Cases; Case++) {

			nextLine();
			int n = nextInt(), s = nextInt(), p = nextInt();
			//int[] scores = new int[n];
			int c = 0;
			for (int i=0; i<n; i++) {
				int sc = nextInt();
				if (best(sc, false) >= p) c++;
				else if (s > 0 && best(sc, true) >= p) {
					c++; s--;
				}
			}
		
			System.out.println("Case #" + (Case+1) + ": " + (c));

		} // end for each case

	} // end main

	static long gcd(long a, long b) {
		if (b > a) return gcd(b,a);
		if (b == 0) return a;
		return gcd(b, a % b);
	}

}
