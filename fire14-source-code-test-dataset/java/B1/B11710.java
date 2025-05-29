import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;

public class C {
	public static void pl(Object O) {System.out.println(O);}
	public static void pl() {System.out.println();}
	public static void pr(Object O) {System.out.print(O);}
	public static void p(Object O) {System.out.print(O);}
	public static void pf(String f, Object...args) {System.out.printf(f,args);}
	
	public static Scanner sc;
	public static String n() {return sc.next();}
	public static String nl() {return sc.nextLine();}
	public static int ni() {return sc.nextInt();}
	public static double nd() {return sc.nextDouble();}
	
	public static void main(String[] args) throws Exception {
		String file = args.length>0?args[0]:"c-sample.in";
		sc = new Scanner(new File(file));
		
		int kk = ni(); nl();
		for (int qq = 0; qq < kk; qq++) {
			System.out.printf("Case #%d: ",qq+1);
			
			int A = ni();
			int B = ni();
			
			int count = 0;
			
			for (int n = A; n < B; n++) {
				for (int m = n+1; m <= B; m++) {
					boolean recycled = isRecycled(n,m);
					if(recycled) {
						count++;
//						System.out.printf("(%d,%d) is recycled\n",n,m);
					}
				}
			}
			
			p(count);
			pl();
		}
	}	
	
	/**
	 * A pair is a recycled pair if you can rotate the digits of n to get m. In
	 * order words, if you let N:=string(n)+string(n) and string(m) is a
	 * substring of N, then the pair (n,m) is a recycled pair.
	 * 
	 * @param n
	 * @param m
	 * @return true if recycled pair
	 */
	public static boolean isRecycled(int n, int m) {
		String N = ""+n+n;
		String M = ""+m;
		
//		System.out.println(N);
//		System.out.println(M);
		
		return N.contains(M);
	}
}
