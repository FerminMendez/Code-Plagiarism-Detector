package com.gzroger.codejam2012;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class QC {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(args[0]));
			int nCases = Integer.parseInt( reader.readLine() );
			for (int iCases=0; iCases<nCases; iCases++) {
				String stLine = reader.readLine();
				int A, B;
				StringTokenizer st = new StringTokenizer(stLine);
				A = Integer.parseInt( st.nextToken() );
				B = Integer.parseInt( st.nextToken() );
				System.out.println("Case #"+(iCases+1)+": "+ possible(A, B));
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static long possible(int A, int B) {
		int cPos = 0;
		int N = 0;
		int Z = A;
		while (Z>=1) {
			Z = Z/10;
			N++;
		}
		
		for (int n=A; n<=B; n++) {
			Set<Integer> hmInt = new HashSet<Integer>();
			for (int j=1; j<N; j++) {
				int m = n%I[j]*I[N-j] + n/I[j];
				if (n<m && m<=B && !hmInt.contains(m)) {
					cPos ++;
					hmInt.add(m);
				}
			}
		}
		return cPos;
	}

	
	static int[] I = new int[8];
	static {
		int n = 1;
		for (int i=0; i<I.length; i++) {
			I[i] = n;
			n*=10;
		}
	}
}
