package gcj2012qual;

import java.io.*;
import java.util.*;

public class Dancing {

	/**
	 * @param args
	 */

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		Scanner input = new Scanner(new File("B-small-attempt0.in"));
		PrintWriter output = new PrintWriter(new FileWriter("output"));
			
		// Scanner in = new Scanner(System.in);
		int case_num = input.nextInt();
		//String word = in.nextLine();
		
		int[][] surprising = new int[31][11];
		int[][] normal = new int[31][11];
		//int i = 0;
		for(int score = 0; score <= 30; score++)
			for(int s = 0; s <= 10; s++){
				if(s == 0 && score == 0){
					surprising[score][s] = 0;
					normal[score][s] = 1;
					continue;
				}
				if(score == 0){
					surprising[score][s] = 0;
					normal[score][s] = 0;
					continue;
				}
				if(s == 0){
					surprising[score][s] = 0;
					normal[score][s] = 1;
					continue;
				}
				
				if(score < s){
					surprising[score][s] = 0;
					normal[score][s] = 0;
					continue;
				}
				
				if(score >= s * 3){
					surprising[score][s] = 1;
					normal[score][s] = 1;
					continue;
				}
				
				if(s == 1 && score == 1){
					surprising[score][s] = 0;
					normal[score][s] = 1;
					continue;
				}
				
				if(s == 1 && score == 2){
					surprising[score][s] = 1;
					normal[score][s] = 1;
					continue;
				}
				
				if(score >= s + (s - 2) * 2){
					surprising[score][s] = 1;
					if(score > s + (s - 2) * 2 + 1){
						normal[score][s] = 1;
					}else{
						normal[score][s] = 0;
					}
					continue;
				}else{
					surprising[score][s] = 0;
					normal[score][s] = 0;
					continue;
				}
				
			}
		for(int i = 0; i < case_num; i++){
			int n = input.nextInt();
			int s = input.nextInt();
			int p = input.nextInt();
			
			int[] t = new int[n];
			
			int total = 0;
			int only_surprising = 0;
			
			for(int j = 0; j < n; j++){
				t[j] = input.nextInt();
				
				if(surprising[t[j]][p] == 1 || normal[t[j]][p] == 1)
					total = total + 1;
				
				if(surprising[t[j]][p] == 1 && normal[t[j]][p] == 0)
					only_surprising = only_surprising + 1;
			}
			
			output.println("Case #" + (i + 1) + ": " + (total - Math.max(0, (only_surprising - s))));
			
			
		}
		input.close();
		output.flush();
		output.close();
	}

}
