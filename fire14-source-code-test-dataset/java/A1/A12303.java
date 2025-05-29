package com.parijat;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sol2 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("./input.txt")));
		FileOutputStream fos = new FileOutputStream("output.txt");
		int testcases = Integer.parseInt(reader.readLine());
		for(int i=0; i< testcases; i++) {
			String[] temp = reader.readLine().split(" ");
			int dancers = Integer.parseInt(temp[0]);
			int surprises = Integer.parseInt(temp[1]);
			int min_best_score = Integer.parseInt(temp[2]);
			
			int t = min_best_score - 2;
			if(t< 0) {
				t = 0;
			}
			int min_score_with_surprise = min_best_score + 2*t;
			
			t = min_best_score - 1;
			if(t< 0) {
				t = 0;
			}
			int min_score_normal = min_best_score + 2*t;
			
			int success = 0;
			for(int j=3; j<temp.length; j++) {
				int score = Integer.parseInt(temp[j]);
				if(score >= min_score_normal) {
					success++;
				} else if(score >= min_score_with_surprise && surprises > 0) {
					surprises--;
					success++;
				}
			}
			fos.write(("Case #" + (i+1) + ": " + success + "\n").getBytes());
		}
		
	}

}
