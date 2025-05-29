import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;

import java.util.Map;
import java.util.HashMap;

public class GCJ_qr_c {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		GCJReader in = new GCJReader(args[0]);
		GCJWriter out = new GCJWriter(args[1]);
		
		int numTestCases = Integer.parseInt(in.readLine());
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i = 1; i <= numTestCases; i+=1) {
			String[] inLine = in.readLine().split(" ");
			
			final int A = Integer.parseInt(inLine[0]);
			final int B = Integer.parseInt(inLine[1]);			
			final int numDigits = inLine[0].length();
			
			int count = 0;
			
			for(int j = A; j <= B; j += 1 ) {
			//start running through the numbers from A to B, looking for recycled numbers
				String n = Integer.toString(j);

				
				//start rearranging blocks of digits
				for(int k = 1; k < numDigits; k+=1) {
					//Get our n, as a String for rearranging
					
					//Get the block of digits to move to the front of n from 
					String nBlock = n.substring(n.length() - k);
					//Get the "remainder" digits, the digits not being moved to the front
					String nFront = n.substring(0, n.length() - k);
					
					//Build m
					String m = nBlock + nFront;
					
					//check if the (n, m) pair is recycled
					int mVal = Integer.parseInt(m);
					int nVal = Integer.parseInt(n);					
					
					if(!(mVal < A || mVal > B || mVal <= nVal || map.containsKey(mVal))) {
						map.put(mVal, nVal);
						count++;
					}
				}
				map.clear();
			}
			
			String outLine = "" + count;
			out.writeLine(String.format("Case #%d: %s", i, outLine));
		}
	}
	
	private static class GCJWriter {
		private String outFile = null;		
		private BufferedWriter out = null;
		
		public GCJWriter(String outFile) {
			this.outFile = outFile; 
			
			try { 
				out = new BufferedWriter(new FileWriter(outFile));
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		
		public void writeLine(String output) {
			try {
				out.write(output + "\n");
				out.flush();				
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}			
	}
	
	private static class GCJReader {
		private String inFile = null;		
		private BufferedReader in = null;
		
		public GCJReader(String inFile) {
			this.inFile = inFile; 
			
			try { 
				in = new BufferedReader(new FileReader(inFile));
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		
		public String readLine() {
			try {
				return in.readLine();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}		
	}	
}