package com.Qualification_2012;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DancingWithGooglers {
	private static int S = 0;
	public static void main(String[] args) {
		try {			
			Scanner sc = new Scanner(new FileReader("D:/Nandan/Project/GoogleCodeJam/Qualification-2012/B-small.in"));
			int T = sc.nextInt();
			for(int t=1; t<=T; t++){
				int N = sc.nextInt();
				S = sc.nextInt();
				int p = sc.nextInt();
				int count = 0;
				for(int i=0; i<N; i++){
					int googlerScore = sc.nextInt();
					if(hasMatches(googlerScore, p)){
						count++;
					}
				}
				System.out.println("Case #"+t+": "+ count);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static boolean hasMatches(int googlerScore, int p) {
		int actualScore = googlerScore;
		int a = googlerScore/3;
		int remainder = googlerScore%3;
		googlerScore = googlerScore-a;
		int b = googlerScore/2;
		int secondRemainder = googlerScore%2;
		int c = googlerScore - b;
		
		if(remainder == 0 && Math.abs(p-a) == 2 && S > 0 && actualScore > 2){
			S--;
			return true;
		}
		
		if(secondRemainder == 0 && Math.abs(p-b) == 1 && S > 0 && actualScore > 2){
			S--;
			return true;
		}
		
		if((a >= p) || (b >= p) || (c >= p)){
			return true;
		}
		return false;
	}
}
