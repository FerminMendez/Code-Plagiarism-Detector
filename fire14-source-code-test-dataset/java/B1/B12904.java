package com.brianghig.gcj.recyclednumbers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;


public class RecycledNumbers {

	public static void main(String[] args) throws Exception {

		Date start = new Date();
		
		RecycledNumbers rn = new RecycledNumbers();
	
		List<Pair> pairs = rn.readInput();
	
		// TODO Remove
		//rn.printPairs( pairs );
		
		List<Integer> uniqueRecycledNumbers = rn.getCountOfUniqueRecycledNumbers( pairs );
		
		rn.writeOutput( uniqueRecycledNumbers );
		
		System.out.println("Took " + (new Date().getTime() - start.getTime()) + "ms");
	}
	
	private void writeOutput(List<Integer> uniqueRecycledNumbers) throws FileNotFoundException, IOException {
		StringBuffer sb = new StringBuffer();
		
		for( int i=0; i < uniqueRecycledNumbers.size(); i++ ) {
			sb.append("Case #" + (i+1) + ": " + uniqueRecycledNumbers.get(i) + "\n" );
		}
		
		IOUtils.write(sb.toString(), new FileOutputStream("recycledNumbersOutput.txt"), "UTF-8" );
		
	}

	private void printPairs(List<Pair> pairs) {
		for( Pair p : pairs ) {
			System.out.println("n: " + p.getN() + "; m: " + p.getM());
		}
	}

	private List<Integer> getCountOfUniqueRecycledNumbers(List<Pair> pairs) {
		List<Integer> uniqueRecycledNumbers = new ArrayList<Integer>();
		
		for( Pair p : pairs ) {
			uniqueRecycledNumbers.add( getCountOfUniqueRecycledFromPair( p ) );
		}
		
		return uniqueRecycledNumbers;
	}

	private int getCountOfUniqueRecycledFromPair(Pair p) {
		
		assert( p != null );
		
		//TODO
		long n = p.getN();
		long m = p.getM();
		
		if( n == m ) {
			// Quick check to ensure they're not equal. If so, none in between since A <= n < m <= B
			return 0;
		}
		
		String nString = String.valueOf( n );
		String mString = String.valueOf( m );
		
		// ok to use int because 1 <= A <= B <= 2,000,000
		int length = nString.length();
		
		List<Pair> pairs = new ArrayList<Pair>();
		
		System.out.println("Solving for Pair: " + n + " and " + m);
		
		for( long x = n; x < m; x++ ) {
			
			String testString = String.valueOf(x);
			//System.out.println("Testing String: " + testString + " for Pair: " + n + " and " + m);
			
//			char[] ch = new char[ testString.length() ];
			
			for( int i=1; i < length; i++ ) {
				
				String begin = testString.substring(0, length - i);
				String end = testString.substring(length - i, length);
				
				String newnum = (end + begin);
//				System.out.println("Testing " + newnum + " from beginning: " + begin + " and ending: " + end);
				
				Long newlong = Long.valueOf(newnum);
				
				if( x < newlong &&
					//n < newlong &&
					newlong <= m ) {
					
					System.out.println("Pair: " + n + " and " + m + " has new pair: " + x + " and " + newlong + " from " + testString);
					pairs.add( new Pair(x, newlong) );
				}
				
			}
			
		}
		
		System.out.println("Pairs Size Before Parsing: " + pairs.size());
		
		removeDuplicatesFromPairs( pairs );
		
		System.out.println("Pairs Size After Parsing: " + pairs.size());
		
		return pairs.size();
		
	}

	private void removeDuplicatesFromPairs(List<Pair> pairs) {
		
		List<Pair> pairsToRemove = new ArrayList<Pair>();
		
		for( Pair a : pairs ) {
//			System.out.println("Checking for dupes of pair n: " + a.getN() + " and m: " + a.getM() );
			for( Pair b : pairs ) {
				//System.out.println("Comparing pair A: " + a.getN() + "," + a.getM() + " and B: " + b.getN() + "," + b.getM() );
//				System.out.println("Comparing a.n: " + a.getN() + " to b.m: " + b.getM());
				if( a != b && 
					( ( a.getN() == b.getM() && a.getM() == b.getN() ) || 
					( a.getN() == b.getN() && a.getM() == b.getM() )  ) ) {
					
					boolean remove = true;
					for( Pair r1 : pairsToRemove ) {
						if( r1.getN() == b.getN() && r1.getM() == b.getM() ) {
							// Skip removing the second iteration of this pair
							remove = false;
							break;
						}
						
					}
					
					if( remove ) {
						//System.out.println("Removing pair n: " + b.getN() + " and m: " + b.getM());
						System.out.println("Removing duplicate pair A: " + a.getN() + "," + a.getM() + " and B: " + b.getN() + "," + b.getM() );
						pairsToRemove.add(b);
					}
					
					break;
				}
			}
			
		}
		
		for( Pair r : pairsToRemove ) {
			pairs.remove(r);
		}
		
	}

	public List<Pair> readInput() throws FileNotFoundException, IOException {
		
		String inputFile = "recycledNumbersInput.txt";
		
		List<Pair> pairs = new ArrayList<Pair>();
		
		List<String> input = IOUtils.readLines(new FileInputStream( inputFile ));
		
		Long testCases = Long.valueOf( input.get(0) );
		
		// Start at line 1, assuming at least one test case, since 1 ≤ T ≤ 50.
		for( int t=1; t <= testCases; t++ ) {
			
			String pairLine = input.get( t );
			
			String[] pairTokens = StringUtils.split(pairLine, " ");
			
			pairs.add( new Pair( Long.valueOf(pairTokens[0]), Long.valueOf(pairTokens[1]) ) );
			
		}
		
		return pairs;
	}
	
}
