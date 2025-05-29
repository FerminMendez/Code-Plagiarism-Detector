package Codejam;

import java.util.HashMap;
import java.util.Scanner;

public class CodeJamB {
	public static void main(String args[]){
		
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		int n;
		int s;
		int p;
		int triplet;
		int result;
		int score;

	
		for(int i = 0; i < t; i++){
			n = scn.nextInt();
			s = scn.nextInt();
			p = scn.nextInt();
			triplet = 0;
			result = 0;
			
			for(int j = 0; j < n; j++){
				score = scn.nextInt();
				if(score > ((p * 3) - 3)){
					result ++;
				}else if(score > 2 && score > ((p * 3) - 5) && triplet < s){
					result ++;
					triplet ++;
				}


			}
			
			System.out.println("Case #" + ( i + 1 ) + ": " + result);
			
		}
	}
}
