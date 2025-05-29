package com.google.codejam;

import com.google.codejam.util.CodeJamInputFile;
import com.google.codejam.util.CodeJamOutputFile;

public class Dancer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CodeJamInputFile f = new CodeJamInputFile("in/B-small-attempt0.in");
		
		CodeJamOutputFile fo = new CodeJamOutputFile("out/B-small-attempt0.out");
		
		for(int c = 0; c < f.getCases(); c++){
			int count = 0;
			String line = f.getLine();
			String[] tokens = line.split(" ");
			int goog = Integer.valueOf(tokens[0]);
			int surp = Integer.valueOf(tokens[1]);
			int best = Integer.valueOf(tokens[2]);
			for(int g = 3; g < (goog + 3); g++){
				int tot = Integer.valueOf(tokens[g]);
				System.out.print(tot + " - ");
				if(tot > ((best * 3) - 3)){
					count++;
					continue;
				}
				if((surp > 0) && (tot > ((best * 3) - 5)) && (tot > 2)){
					count++;
					surp--;
				}
			}
			System.out.println(count + "");
			fo.writeCase(c, count + "");
		}
		
		f.close();
		fo.close();
	}

}
