package com.codejam;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class CodeJam13 {
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
				int count=0;
				
				String sa = fileIn.next();
				int len = sa.length();
				int factor = (int)Math.pow(10,len-1);
				int a = Integer.parseInt(sa);
				int a1=a;
				int b = fileIn.nextInt();
				fileIn.nextLine();
				
				while(a1<=b){
					HashSet set = new HashSet();
					for(int i=0;i<len-1;i++){						
						int newA = (a%10)*factor + a/10;					
						set.add(a1);						
						if(newA<factor){
							
						}
						else if(newA>=a1 && newA<=b){
							if(set.add(newA)){
								count++;
							}
						}						
						a=newA;					
					}
					//System.out.println(a1 + "   " + count);
					a=++a1;
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
