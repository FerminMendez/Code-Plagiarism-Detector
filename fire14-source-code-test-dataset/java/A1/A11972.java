package com.priyanka;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProblemB {

	public static void main(String[] args) throws IOException {
		BufferedReader inputfile = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		FileOutputStream outresult = new FileOutputStream("output.txt");
		int testcases = Integer.parseInt(inputfile.readLine());
		for(int i=0; i< testcases; i++) {
			String[] temp = inputfile.readLine().split(" ");
			int surprises = Integer.parseInt(temp[1]);
			int best = Integer.parseInt(temp[2]);			
			int t = best - 2;
			if(t< 0) { t = 0; }
			int var1 = best + 2*t;			
			t = best - 1;
			if(t< 0) { t = 0; }
			int min_score_normal = best + 2*t;	
			int count = 0;
			for(int j=3; j<temp.length; j++) {
				int score = Integer.parseInt(temp[j]);
				if(score >= min_score_normal) {
					count++;
				} else if(score >= var1 && surprises > 0) {
					surprises--;
					count++;
				}
			}
			outresult.write(("Case #" + (i+1) + ": " + count + "\n").getBytes());
		}	
	}
}
