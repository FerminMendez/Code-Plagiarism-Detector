package com.seol.codejam;


import java.io.File;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Solution for http://code.google.com/codejam/contest/1150485/dashboard#s=p1
 */
public class DancingWithTheGooglers {

	public static int solveCase(int[] scores, int surpriseNum, int neededScore) {
		int len = scores.length;
		int maxWithNeeded = neededScore*3;
		int suprCnt = surpriseNum;
		int res=0;
		for(int i = 0; i < len; i++) {
			if(scores[i] < neededScore) {
				continue;
			}else if(scores[i] >= maxWithNeeded ||  maxWithNeeded - scores[i] <= 2) {
				res++;
			} else if (maxWithNeeded - scores[i] <= 4 && suprCnt > 0){
				suprCnt--;
				res++;
			}
		}
		
		return res;	
	}


	
	public static void main(String[] args) throws Exception {
		
		solveAllCases("D:/worspaces/google_codejam/test_data/dance2");
	}

	public static void solveAllCases(String fileName) throws Exception {
		Scanner sc = new Scanner(new File(fileName));
		int cases = sc.nextInt();
//		String tmp = sc.nextLine();
		for (int i = 0; i < cases; i++) {
			int n = sc.nextInt();
			int surp = sc.nextInt();
			int score = sc.nextInt();
			int[] ar = new int[n];
			for(int q =0; q < n; q++) {
				ar[q] = sc.nextInt();
			}
			int res = solveCase(ar, surp, score);
			
			System.out.println("Case #" + (i + 1) + ": " + res);
			// System.out.printf("Case #%1$d: %2$.7f \n" , (i+1), res);

		}
		// System.out.println("MAX:" + max);
	}

}
