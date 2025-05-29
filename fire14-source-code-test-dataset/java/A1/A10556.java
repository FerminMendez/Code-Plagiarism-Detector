package com.codejam;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CodeJam1 {
	char map[];

	public static void main(String[] args) {
		Scanner fileIn = null;
		FileWriter fileOut = null;

		try {
			fileIn = new Scanner(new File("input.txt"));
			fileOut = new FileWriter(new File("output.in"));
			int noOfTestCases = Integer.parseInt(fileIn.nextLine());

			int testCase = 0;
			while (fileIn.hasNextLine()) {
				testCase++;
				//fileIn.nextLine();
				int noOfPpl = fileIn.nextInt();
				int s = fileIn.nextInt();
				int p = fileIn.nextInt();
				int input[] = new int[noOfPpl];
				int noOfSurprise=0,count=0;
				for(int i=0;i<noOfPpl;i++){
					input[i] = fileIn.nextInt();
				}
				fileIn.nextLine();
				for(int i=0;i<noOfPpl;i++){
					if(p>input[i]){
						continue;
					}					
					int remainingSum = input[i]-p;
					int q = remainingSum/2;
					if(q>=p){
						count++;
						continue;
					}					
					if((p-q)<2){
						count++;						
					}
					else if((p-q)==2 && noOfSurprise<s){
						noOfSurprise++;
						count++;
						continue;
					}										
				}				
				fileOut.write("Case #" + testCase + ": " + count
						+ "\n");
			}
			fileIn.close();
			fileOut.close();
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
	}

}
