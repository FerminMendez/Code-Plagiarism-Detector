package uk.ac.cam.rio22.problemB;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

public class ProblemB {
	
	public static void main (String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new FileReader("B-small-attempt0.in"));
		PrintStream out = new PrintStream(new FileOutputStream("outputB.out"));
		int num = Integer.parseInt(br.readLine());
		for(int n=1;n<=num;n++) {
			out.print("Case #" + (n) + ": ");
			String[] line = br.readLine().split(" ");
			int surprise = Integer.parseInt(line[1]);
			int min = 3*Integer.parseInt(line[2]) - 2;
			int count = 0;
			for(int i=3;i<line.length;i++) {
				int score = Integer.parseInt(line[i]);
				if(score>=min) {
					count++;
				}
				else if(surprise>0 & score>=min-2 & score>1) {
					surprise--;
					count++;
				}
			}
			
			out.println(count);
		}
		
	}
	
}
