package com.dennis.codejam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DancingGoogle {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) throws IOException{

		
		BufferedReader fin = new BufferedReader(new FileReader("dancing.in"));
		PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("dancing.out")));

		StringTokenizer stringy;
		
		int times = Integer.parseInt(fin.readLine());
		
		
		for(int x= 0 ; x<times; x++){
			stringy= new StringTokenizer(fin.readLine());
			int numg = Integer.parseInt(stringy.nextToken());
			int surprises = Integer.parseInt(stringy.nextToken());
			int limit  = Integer.parseInt(stringy.nextToken());
			int[] googlers = new int[numg];
			
			for(int a = 0; a<numg; a++){
				googlers[a] = Integer.parseInt(stringy.nextToken());
			}
			
			Arrays.sort(googlers);
			
			int[] less = new int[numg];
			
			
			
			for(int a = 0; a<numg; a++){
				
				if(googlers [a] <= 1){
					if(googlers[a]==1) less[a] = 1;
					if(googlers[a]==0) less[a] = 0;
				}				
				else if(googlers[a]%3 == 0){
					less[a] = googlers[a]/3;  
				}
				else if(googlers[a]%3 == 1){
					less[a] = googlers[a]/3+1;
				}
				else if(googlers[a]%3 == 2){
					less[a] = googlers[a]/3+1;
				}
				
			}

			int[] more = new int[numg];
			for(int a = 0; a<numg; a++){
				
				if(googlers [a] <= 1){
					if(googlers[a]==1) more[a] = 1;
					if(googlers[a]==0) more[a] = 0;
				}				
				else if(googlers[a]%3 == 0){
					more[a] = googlers[a]/3+1;  
				}
				else if(googlers[a]%3 == 1){
					more[a] = googlers[a]/3+1;
				}
				else if(googlers[a]%3 == 2){
					more[a] = googlers[a]/3+2;
				}
				
			}
			
			for(int a= 0 ; a<numg;a++){
				if(surprises==0) break;
				
				if(more[a]!= less[a] && more[a] == limit){
					surprises--;
					less[a] = more[a];
				}
				
				
			}
			
			
			
			
			int count =0;
			for(int c=0; c<numg; c++){
				System.out.println(less[c]);
				if(less[c]>=limit) count++;
			}
			
			fout.println("Case #" + (x+1) + ": " + count);
			
		}
		
		
		
		
		
		fout.close();
		System.exit(0);

	}

}
