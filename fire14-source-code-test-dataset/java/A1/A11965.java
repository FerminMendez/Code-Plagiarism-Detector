package cj2012;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CJ2012QB {

	public static void main(String[] args) {
		BufferedReader bf = null;
		BufferedWriter bw = null;
		
		try {
			bf = new BufferedReader(new FileReader("./src/cj2012/" + args[0] + ".in"));
			bw = new BufferedWriter(new FileWriter("./src/cj2012/" + args[0] + ".out"));
			
			int N = Integer.valueOf(bf.readLine());

			for (int n=0; n < N; n++) {
				scores(bf, bw, n);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null) bw.close();
				if (bf != null) bf.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * https://code.google.com/codejam/contest/1460488/dashboard#s=p1
	 */
	private static void scores(BufferedReader bf, BufferedWriter bw, int caseNum) throws NumberFormatException, IOException {
		String[] ia = bf.readLine().split(" ");
		
		int N = Integer.valueOf(ia[0]);
		
		int S = Integer.valueOf(ia[1]);
		
		int P = Integer.valueOf(ia[2]);
		
		int result = 0;
		
		int enough = Math.max(((P-1) * 3) + 1, P);
		
		int surprising = Math.max(enough - 2, P);
		
		for (int i=0; i < N; i++) {
			int score = Integer.valueOf(ia[i+3]);
			
			if (score >= enough) {
				result++;
			} else if (score >= surprising && S > 0){
				S--;
				result++;
			} else {
			}
		}
			
		bw.write("Case #" + (caseNum+1) + ": " + result + "\n");
	}
}
