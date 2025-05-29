package me.stapel.kai.google.codejam2012.quali;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.SortedSet;
import java.util.TreeSet;

import me.stapel.kai.google.codejam2012.quali.C.Pair;

public class ProblemC {

	private static final String NL = System.getProperty("line.separator");

	public ProblemC() {
		// nothing to do here yet
	}
	
	public static void main(String[] args) {
		ProblemC problemC = new ProblemC();
		
		problemC.processFile("in/C-small-attempt0.in", "out/C-small.txt");
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

				int A = Integer.parseInt(split[0]);
				int B = Integer.parseInt(split[1]);

				int numPairs = calcNumPairs(A, B);
				
				output.write("Case #" + T + ": " + numPairs + NL);
				System.out.println("Case #" + T + ": " + numPairs);
				
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
	
	private int calcNumPairs(int A, int B) {
		SortedSet<Pair> pairs = new TreeSet<Pair>();
		
		for(int i = A; i <= B; i++){
			int[] n = toArray(i);

			calcRecycledPairs(n, B, pairs);
		}
		
		return pairs.size();
	}

	private int calcRecycledPairs(int[] n, int B, SortedSet<Pair> pairs) {
		int num = 0;
		int[] m = new int[n.length];
		int ni,mi;
		
		for (int i = 1; i < n.length; i++) {
			for(int j = 0; j < n.length-i; j++) {
				m[j+i] = n[j];
			}
			for(int j = n.length-i; j < n.length; j++) {
				m[j-n.length+i] = n[j];
			}
			
			ni = fromArray(n);
			mi = fromArray(m);
			
			if(mi <= B && ni < mi && isValidM(m)) {
				num++;
				pairs.add(new Pair(ni, mi));
//				System.out.println("("+ni+", "+mi+")");
			}
				
		}
		
		return num;
	}

	private boolean isValidN(int[] n) {
		int tmp = n[0];
		for (int i = 1; i < n.length; i++) {
			if(n[i] != tmp)
				return true;
			tmp = n[i];
		}
		return false;
	}

	private boolean isValidM(int[] m) {
		if(fromArray(m) < Math.pow(10,m.length-1))
			return false;
		return true;
	}

	private int[] toArray(int i) {
		int digits = (int)Math.ceil(Math.log10(i+1));
		int[] arr = new int[digits];
		
		for(int c = 1; c<=digits;c++) {
			arr[digits-c] = i % 10;
			i = i/10;
		}
		
		return arr;
	}
	
	private int fromArray(int[] arr) {
		int i = 0;
		for (int j = 0; j < arr.length; j++) {
			i = 10*i+arr[j];
		}
		return i;
	}
}
