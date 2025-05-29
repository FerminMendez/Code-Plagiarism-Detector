package com.google.codejam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GoogleDance2 {

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(new BufferedReader(new FileReader("/Users/sunny/Desktop/B-small-attempt0.in")));
		PrintWriter out=new PrintWriter(new FileWriter("/Users/sunny/Desktop/B-small.out"));
		int t = in.nextInt(); int n, s, p ; String line;   
		for( int i = 1 ; i <= t ; i++){
			n = in.nextInt() ; s = in.nextInt() ; p = in.nextInt() ;
			int []scores = new int[n];
			for(int j = 0 ; j < n ; j++) {
				scores[j] = in.nextInt() ; 
			}
			line = "Case #"+i+": "+findMax(n, s, p, scores);
			System.out.println(line);
			out.println(line);
		}
		out.close() ;
	}

	private static int findMax(int n, int s, int p, int[] scores) {
		int d ;
		List<Combination> c= new ArrayList<Combination>();
		boolean gp = true, surp = true; 
		for(int i = 0 ; i < n ; i++) {
			d = scores[i]/3 ; 
			switch (scores[i]%3) {
			case 0 : 
				if(d>=p) {
					c.add(new Combination(gp, !surp));
				}
				else if (d+1 >=p && d-1>=0){
					c.add(new Combination(gp, surp));
				}
				else {
					c.add(new Combination(!gp,!surp));
				}
				break ; 
			case 1 :
				c.add(new Combination(d+1>=p, !surp));
				break ; 
			case 2 :
				if(d+1 >=p) {
					c.add(new Combination(gp, !surp));
				}
				else if (d+2 >=p) {
					c.add(new Combination(gp, surp));
				}
				else {
					c.add(new Combination(!gp, !surp));
				}
				break ;
			}
		}
		
		return colAlgo(c, n, s);
	}

	private static int colAlgo(List<Combination> cs, int n, int s) {
		int count = 0 ; 
		Combination c ; 
		for(int i = 0 ; i < n ; i++) {
			c = cs.get(i);
			if(c.gp){
				if(c.sur) {
					if(s>0){
						s--;
						count++ ;						
					}
				}
				else{
					count++ ; 
				} 
			}
		}
		return count;
	}

	private static class Combination {
		public Combination(boolean gp, boolean surp) { 
			this.gp = gp ; 
			this.sur = surp ;			
		}
		boolean sur ; 
		boolean gp ; 
	}
}
