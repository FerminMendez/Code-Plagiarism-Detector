package CodeJam;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;

public class C {

	/**
	 * @param args
	 */
	static Scanner scan = new Scanner(System.in);
	static BufferedReader brscan = new BufferedReader(new InputStreamReader(
			System.in));
	static PrintWriter pw;
	static StringBuilder[] permutation = new StringBuilder[2222222];
	static StringBuilder sbuild = new StringBuilder();

	public static void main(String[] args) throws FileNotFoundException {
		pw = new PrintWriter(new File("output-C.txt"));
		// TODO Auto-generated method stub

		GeneratePermutation();

		int tc = scan.nextInt();
		int from, to;

		for (int x = 1; x <= tc; x++) {
			int count = 0;
			from = scan.nextInt();
			to = scan.nextInt();
			for (int n = from; n < to; n++) {

				count += (SameString(permutation[n], n + 1, to));
				
			}
			pw.println("Case #" + x + ": " + count);
		}
		//pw.println(SameStringB(new StringBuilder("2212"), new StringBuilder("2221")));
		pw.flush();
		pw.close();
		
	}

	public static boolean SameStringB(StringBuilder ac, StringBuilder bc) {
		StringBuilder a = new StringBuilder(ac);
		StringBuilder b = new StringBuilder(bc);
		int length = a.length();
		for (int n=0; n<length; n++) {
			if (a.charAt(0)!=0 && a.toString().equals(b.toString())) {
				
				return true;
			} 
			// process //
			char temp = a.charAt(0);
			a.append(temp);
			a.deleteCharAt(0);
		}
		return false;
	}
	
	static HashSet<Integer> hset = new HashSet<Integer>(2000);
	public static int SameString(StringBuilder ac, int min, int max) {
		StringBuilder a = new StringBuilder(ac);
		hset.clear();
		int length = a.length();
		int normal = Integer.parseInt(a.toString());
		
		int count = 0;
		for (int n = 0; n < length-1; n++) {

			a.append(a.charAt(0));
			a.deleteCharAt(0);
			if (a.charAt(0) != '0') {
				int now = Integer.parseInt(a.toString());
				if (now >= min && now <= max && hset.contains(now)==false) {
					hset.add(now);
					
					count++;
				}
			}
		}
		
		
		return count;
	}

	public static void GeneratePermutation() {
		for (int n = 1; n < 2222222; n++) {
			permutation[n] = new StringBuilder(n + "");
		}
	}
}
