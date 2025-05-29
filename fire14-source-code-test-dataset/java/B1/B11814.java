/**
 * Google CodeJam 2012
 * Qualification round - Problem C
 * Recycled Numbers
 * 
 * Solved by Üllar Soon <positivew@gmail.com>
 */
package eu.positivew.codejam.recycled;

import java.io.File;
import java.util.ArrayList;

import eu.positivew.codejam.framework.CodeJamIO;


/**
 * Recycled Numbers main class.
 * 
 * @author Üllar Soon <positivew@gmail.com>
 */
public class RecycledNumbersMain {

	/**
	 * Main controller for RecycledNumbers.
	 * 
	 * @param args 		Command line arguments
	 */
	public static void main(String[] args) {
		// Parse command line arguments
		String inUrl = "input.txt";
		String outUrl = "output.txt";
		if(args.length >= 1)
			inUrl = args[0];
		if(args.length >= 2)
			outUrl = args[1];
		
		
		File inFile = new File(inUrl);
		File outFile = new File(outUrl);
		
		CodeJamIO cio = new CodeJamIO();
		
		cio.inputOpen(inFile);
		cio.outputOpen(outFile);
		
		if(cio.getTestCases() > 0) {
			RecycledNumbersCase inCase;
			int i = 0;
			while(i < cio.getTestCases() && (inCase = (RecycledNumbersCase)cio.inputReadCase(new RecycledNumbersParser())) != null) {
				cio.outputWriteCase("" + countRecycledNumbers(inCase.getA(), inCase.getB()));
				i++;
			}
		}
		
		cio.inputClose();
		cio.outputClose();
	}
	
	/**
	 * Counts the distinct occurring pairs of recycled numbers between A and B (inclusive).
	 * 
	 * @param A		left limiter
	 * @param B		right limiter
	 * @return		number of distinct recycled numbers between A and B
	 */
	private static int countRecycledNumbers(int A, int B) {
		int count = 0;
		ArrayList<IntPair> foundPairs = new ArrayList<IntPair>();
		
		for(int i = A; i <= B; i++) {
			String nStr = "" + i;
			
			for(int j = 1; j < nStr.length(); j++) {
				String mStr = nStr.substring(j) + nStr.substring(0, j);
				
				if(mStr.charAt(0) == '0')
					continue;
				
				try {
					int n = Integer.parseInt(nStr);
					int m = Integer.parseInt(mStr);
					
					if(A <= n && n < m && m <= B) {
						if(!foundPairs.contains(new IntPair(n, m))) {
							foundPairs.add(new IntPair(n, m));
							count++;
						}
					}
				}
				catch(NumberFormatException ex) {
					System.err.println("Number conversion error!");
				}
			}
		}
		
		return count;
	}

}
