package me.stapel.kai.google.codejam2012.quali;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Locale;

public class ProblemB {

	private static final String NL = System.getProperty("line.separator");

	public ProblemB() {
		// nothing to do here yet
	}
	
	public static void main(String[] args) {
		ProblemB problemB = new ProblemB();
		
		
		problemB.processFile("in/B-small-attempt0.in", "out/B-small.txt");
		
	}

	private Object processFile(String inFileName, String outFileName) {
		Object obj = new Object();
		
		File inFile = new File(inFileName);
		File outFile = new File(outFileName);

		String line = "";
		int T = 1;

		OutputStreamWriter output;
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(inFile));
			output = new OutputStreamWriter(new BufferedOutputStream(
					new FileOutputStream(outFile)), "8859_1");

			line = br.readLine();
			
			// skipping first line
			line = br.readLine();

			while (line != null) {
				String[] split = line.split(" ");

				int N = Integer.parseInt(split[0]);
				int S = Integer.parseInt( split[1]);
				int p = Integer.parseInt(split[2]);
				int[] t = new int[N];
				
				for(int i = 0; i<N;i++) {
					t[i] = Integer.parseInt(split[i+3]);
				}
				
				int Gmax = calcGMax(N, S, p, t);
				
				output.write("Case #" + T + ": " + Gmax + NL);
				System.out.println("Case #" + T + ": " + Gmax);
				
				line = br.readLine();
				T++;
			}
			
			
			output.flush();
			output.close();

		} catch (FileNotFoundException e) {
			System.err.println("File " + inFile.getName() + " not found. Nothing processed.");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Error when reading file " + inFile.getName() + " or writing file " + outFile.getName() + ".");
			e.printStackTrace();
		}

		return obj;
	}
	
	private int calcGMax(int N, int S, int p, int[] t) {
		int Gmax1 = 0;
		int Gmax2 = 0;
		
		System.out.println(Arrays.toString(t));
		
		for(int i = 0; i < t.length; i++){
			if(t[i] >= Math.max(3*p-2, p))
				Gmax1++;
			if(t[i] >= Math.max(3*p-4, p)) 
				Gmax2++;
		}
		
		return Math.min(Gmax1+S, Gmax2);
	}

}
