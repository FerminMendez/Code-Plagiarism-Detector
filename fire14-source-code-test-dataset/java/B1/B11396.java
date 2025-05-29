/**
 * KSpokas: GCJ 2012 Qualification Round Problem C - Recycled Numbers
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;


public class qualProblemC {
	private final static int EXPECTED_ARG_COUNT = 1;
	
	public static void main(String[] args) {
		if (args.length != EXPECTED_ARG_COUNT) {
			System.err.println("Error: expecting " + EXPECTED_ARG_COUNT);
			return;
		}
		
		String fileName = args[0];
		try {
		    FileInputStream fstream = new FileInputStream(fileName);
		    DataInputStream in = new DataInputStream(fstream);
		    BufferedReader br = new BufferedReader(new InputStreamReader(in));
		    BufferedWriter out = new BufferedWriter(new FileWriter(fileName + ".out"));
		    
		    Integer testCaseCount = Integer.parseInt(br.readLine());
		    
		    for (int i = 0; i < testCaseCount; i++) {
		    	String strLine = br.readLine();
		    	
		    	StringBuilder sb = new StringBuilder("Case #");
		    	sb.append(i + 1).append(": ");
		    	sb.append(calculate(strLine));
		    	out.write(sb.toString());
		    	out.newLine();
		    }
		    in.close();
		    out.close();
	    } catch (Exception e) {
	    	System.err.println("Error: " + e.getMessage());
	    }
	}
	
	private static int calculate(String input) {
		String[] values = input.split(" ");
		Integer min = Integer.parseInt(values[0]);
		Integer max = Integer.parseInt(values[1]);
		
		Set<String> duplicates = new HashSet<String>();
		for (int i = min; i <= max; i++) {
			String num = String.valueOf(i);
			for (int j = 1; j < num.length(); j++) {
				Integer offset = Integer.parseInt(num.substring(j) + num.substring(0, j));
				if (offset != i && offset <= max && offset >= min) {
					duplicates.add(
							(i < offset) 
									? num.toString() + ":" + offset.toString() 
									: offset.toString() + ":" + num.toString());
				}
			}
		}
		
		return duplicates.size();
	}
	
}
