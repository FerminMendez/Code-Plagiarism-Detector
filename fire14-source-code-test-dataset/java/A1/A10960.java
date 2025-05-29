package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(isr);
		
		StringBuilder output = new StringBuilder();
		
		int T = Integer.parseInt(reader.readLine());
		for (int i=1; i<=T; i++) {
			output.append("Case #").append(i).append(": ");
			String line = reader.readLine();
			String[] tokens = line.split(" ");
			
			int sol = 0;
			
			int N = Integer.parseInt(tokens[0]);
			int S = Integer.parseInt(tokens[1]);
			int p = Integer.parseInt(tokens[2]);
			
			int max = 3 * p;
			for (int j=3; j<tokens.length; j++) {
				int t_i = Integer.parseInt(tokens[j]);
				
				if (t_i >= max-2) {
					sol++;
				} else if (t_i >= max-4 && max - 4>=0) {
					if (S > 0) {
						sol++;
					} 
					S--;
				}
			}
			
			output.append(sol).append("\n");
		}
		System.out.println(output.toString());
	}
}
