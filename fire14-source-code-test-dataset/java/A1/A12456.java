package at.neiti.codejam2012;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DancingWithTheGooglers {

	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader("B-small-attempt0.in"));
		int n = Integer.parseInt(r.readLine());
	
		StringBuilder output = new StringBuilder();
		for(int i=0; i<n; i++) {
			String line = "Case #" + (i+1) + ": ";
			
			String tokens[] = r.readLine().split(" ");
			int numGooglers = Integer.parseInt(tokens[0]);
			int surprising = Integer.parseInt(tokens[1]);
			int p = Integer.parseInt(tokens[2]);
			
			int googlersGreaterP = 0;
			for(int j=3; j<tokens.length; j++) {
				int total = Integer.parseInt(tokens[j]);
				
				//See if Googler points are > p not surprising
				int bestNotSurprising = total/3 + (total%3 != 0 ? 1 : 0);
				if(bestNotSurprising >= p) {
					googlersGreaterP++;
					continue;
				}
				
				//See if Googler points are > p surprising
				if(surprising > 0) {
					int add = 0;
					if(total%3 == 0) {
						add = 1;
					} else if(total%3 == 2) {
						add = 2;
					}
					int bestSurprising = total == 0 ? 0 : total/3 + add;
					if(bestSurprising >= p) {
						googlersGreaterP++;
						surprising--;
					}
				}
			}
			
			line += googlersGreaterP + "\n";
			output.append(line);
		}
		
		r.close();
		
		FileWriter fw = new FileWriter("output_dancing.txt");
		fw.write(output.toString());
		fw.flush();
		fw.close();
	}
	
}

