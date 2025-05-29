package com.evolve.codejam2012.qualification;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Dancing {

	private static final String TEST_FILE = "B-small-attempt0.in";
	private PrintWriter pw = null;
	private BufferedReader br = null; 		
	
	Dancing(boolean skip) throws IOException {
		
		
		String outFile = TEST_FILE.replace(".in", ".out");
		System.out.println(outFile);
		this.pw = new PrintWriter(new FileWriter(outFile));
		if (skip)
			return;
		
		File file = new File(TEST_FILE);
		if (file.exists()) {
			br = new BufferedReader(new java.io.FileReader(TEST_FILE));
		} else {
			br = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
		}
	}	
	
	void doit() throws NumberFormatException, IOException {
		int testsNumber = Integer.parseInt(br.readLine());
		
		System.out.println(testsNumber);
		
		for (int i = 1; i <= testsNumber; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			StringBuilder sb = new StringBuilder();

			int N = Integer.parseInt( st.nextToken() ); // number of googlers 1 <= N <= 3.
			int S = Integer.parseInt( st.nextToken() ); // number of surprising triplets of scores  0 <= S <= N.
			int p = Integer.parseInt( st.nextToken() ); // minimal result 0 <= p <= 10.
			
			int[] scores = new int[N];
			for (int j = 0; j < N; j++) {
				scores[j] = Integer.parseInt( st.nextToken() ); // 0 <= ti <= 30.
			}
			
			// non surprising
			boolean[] nonsurpising = new boolean[N];
			int counter = 0;
			for (int score : scores) {
				//nonsurpising[counter] = false;
				
				if (score % 3 == 0) {
					int a = score / 3;
					if (a >= p) {
						nonsurpising[counter] = true;
					}
				} 
				if (score >= 1 && (score-1) % 3 == 0)  {
					int a = (score-1) / 3 + 1;
					if (a >= p) {
						nonsurpising[counter] = true;
					}
				} 
				if (score >= 2 && (score-2) % 3 == 0) {
					int a = (score-2) / 3 + 1;
					if (a >= p) {
						nonsurpising[counter] = true;
					}
				}
				counter++;
			}
			
			// surprising
			boolean[] surpising = new boolean[N];
			if (S > 0) {  // tylko gdy sa jakies
				// zakladamy ze kazdy jest surprising
				
				counter = 0;
				for (int score : scores) {
					//surpising[counter] = false;
					
					if (score >= 3 && (score-3) % 3 == 0) {
						int a = (score-3) / 3 + 2;
						if (a >= p) {
							surpising[counter] = true;
						}
					} 
					
					if (score >= 2 && (score-2) % 3 == 0) {
						int a = (score-2) / 3 + 2;
						if (a >= p) {
							surpising[counter] = true;
						}
					} 

					if (score >= 4 && (score-4) % 3 == 0) {
						int a = (score-4) / 3 + 2;
						if (a >= p) {
							surpising[counter] = true;
						}
					} 
					
					counter++;
				}
			}
			
			System.out.println("nonsurprising: " + Arrays.toString(nonsurpising));
			System.out.println("surprising: " + Arrays.toString(surpising));
			
			int max = 0;
			for (int k = 0; k < N; k++) {
				if (nonsurpising[k]) {
					max++;
				} else if (S > 0 && surpising[k]) {
					max++;
					S--;
				}
			}
			
			pw.println("Case #" + i + ": " + max);
		}
		pw.flush();
		pw.close();
	}	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		new Dancing(false).doit();

	}

}
