package codeJamB;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class PgmTemplate {

	/**
	 * @param args
	 */
	public static String delims = "[ ]+";
	public static PrintStream ps;
	
	public static void main(String[] args) {

		for (String s : args) {
			System.out.println(s);
		}

		try {
			// Open the file that is the first command line parameter
			FileInputStream fstream = new FileInputStream(args[0]+".txt");
			ps = new PrintStream(args[0]+".out");
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			// Read File Line By Line
			strLine = br.readLine();
			//System.out.println(strLine);
			int numCases = Integer.parseInt(strLine);
			// Read File Line By Line
			for (int i = 0; i < numCases; i++) {
				strLine = br.readLine();
				//System.out.println(i + "  " + strLine);
				doCode(i, strLine);
			}
			// Close the input stream
			in.close();
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}
	
	public static void doCode(int Case, String strLine) {

		String[] tokens = strLine.split(delims);
		int N = Integer.parseInt(tokens[0]);
		int S = Integer.parseInt(tokens[1]);
		int P = Integer.parseInt(tokens[2]);
		int[] T = new int[N];
		
		for (int i=0; i< N; i++) {
			T[i] = Integer.parseInt(tokens[3+i]);
		}
		
		int noSurprise = 0;
		int withSurprise = 0;
		
		for (int i=0; i< N; i++) {
			if (doWithNoSurprise(P, T[i]))
				noSurprise += 1;
			else if (doWithSurprise(P, T[i]))
				withSurprise += 1;
		}
		
		int TotalCount = noSurprise + Math.min(withSurprise, S);
		
		System.out.format("Case #%d: %d\n", Case + 1, TotalCount);
		ps.format("Case #%d: %d\n", Case + 1, TotalCount);
		
		/*System.out.format("  N: %d\n", N);
		System.out.format("  S: %d\n", S);
		System.out.format("  P: %d\n", P);
		for (int i=0; i< N; i++) {
			System.out.format("    T[%d]: %d\n", i, T[i]);
		}*/
		

	}
	
	public static boolean doWithNoSurprise(int P, int T) {
		int score1 = T / 3;
		int score2 = (T - score1) / 2;
		int score3 = T - (score1 + score2);
		
		//System.out.format ("P: %d  T: %d    S1: %d  S2: %d  S3: %d\n", P, T, score1, score2, score3);
		
		if (score3 >= P)
			return true;
		
		return false;
		
	}
	
	public static boolean doWithSurprise(int P, int T) {
		if ((T < 2) || (T>28))
			return false;
		int score1 = T / 3;
		int score2 = (T - score1) / 2;
		int score3 = T - (score1 + score2);
		
		if ((P - score3) > 1)
			return false;
		if ((score3 +1) - (score2 -1) > 2)
			return false;
		if ((score3 +1) - (score1) > 2)
			return false;
		
		//System.out.format ("P: %d  T: %d    S1: %d  S2: %d  S3: %d\n", P, T, score1, score2, score3);
		
		
		return true;
		
	}

}

