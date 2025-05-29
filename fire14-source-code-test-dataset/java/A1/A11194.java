package com.gzroger.codejam2012;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class QB {
	public static void main(String[] args) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(args[0]));
			int nCases = Integer.parseInt( reader.readLine() );
			for (int iCases=0; iCases<nCases; iCases++) {
				String stLine = reader.readLine();
				int N, S, p;
				StringTokenizer st = new StringTokenizer(stLine);
				N = Integer.parseInt( st.nextToken() );
				S = Integer.parseInt( st.nextToken() );
				p = Integer.parseInt( st.nextToken() );
				int[] K = new int[N];
				for (int i=0; i<N; i++) {
					K[i] = Integer.parseInt( st.nextToken() );
				}
				System.out.println("Case #"+(iCases+1)+": "+ possible(N, S, p, K));
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

	private static int possible(int N, int S, int p, int[] K) {
		int cPos = 0;
		for (int i=0; i<N; i++) {
			int maxIfS = (int) Math.floor( (K[i]+4) / 3.0d);
			int maxIfNotS = (int) Math.floor( (K[i]+2) / 3.0d );
			if (K[i] == 0)	{
				maxIfS = 0; 
				maxIfNotS = 0;
			} else if (K[i] == 1) {
				maxIfS = 1;
				maxIfNotS = 1;
			} else if (K[i] == 2) {
				maxIfS = 2;
				maxIfNotS = 1;
			} 
				
			
			if ( (maxIfS+maxIfS-2+maxIfS-2) > K[i] ) {
				System.out.println("problem!");
			}

			if ( (maxIfNotS+maxIfNotS-1+maxIfNotS-1) > K[i] ) {
				System.out.println("problem!");
			}
			
			if (maxIfNotS>=p)
				cPos++;
			else if (maxIfS>=p && S>0) {
				cPos++;
				S--;
			}
		}
		return cPos;
	}
}
