import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
import java.lang.StringBuilder;


public class B{
		//STAES3307


	public static void main(String[] args){
		//get the char value of 'a', use that to index into the letters array when replacing characters
		try{
			//BufferedReader reader = new BufferedReader(new FileReader(new File("A-small-attempt0.in")));
			Scanner scan = new Scanner(new File("B-small-attempt0.in"));
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File("B.out")));
			int lines = scan.nextInt();
			for(int i = 0; i < lines; i++){
				//System.out.println("Case " + i);
				int t = scan.nextInt();
				int s = scan.nextInt();
				int s_used = 0;
				int p = scan.nextInt();
				int[] scores = new int[t];
				int count = 0;
				for(int j = 0; j < t; j++){
					scores[j] = scan.nextInt();
				}
				Arrays.sort(scores);
				for(int j = t-1; j >= 0; j--){
					int score = scores[j];
					int maxPos = (int)Math.ceil(score/3) + 2;
					//System.out.println(score + " " + maxPos);
					// cases...list probably doesn't contain everything...
					// not cleanest approach...obviously
					
					
					if(maxPos - 2 >= p){
						if(3*maxPos == score || ((maxPos - 1 >= 0) && ((2*maxPos + (maxPos - 1)) == score || (maxPos + 2*(maxPos - 1)) == score || 3*(maxPos - 1) == score || ((maxPos - 2 >= 0) && ((2*(maxPos - 1) + (maxPos - 2)) == score || ((maxPos - 1) + 2*(maxPos - 2)) == score || 3*(maxPos -2) == score || (2*(maxPos - 2) + (maxPos - 3)) == score))))) count++;
						else if(s_used < s){
							// score can be "surprising"
							if((maxPos - 2 >= 0) && ((maxPos + (maxPos - 1) + (maxPos - 2)) == score || (maxPos + 2*(maxPos - 2)) == score || ((maxPos - 3 >= 0) && (((maxPos - 1) + 2*(maxPos - 3)) == score || (2*(maxPos - 1) + (maxPos - 3)) == score || ((maxPos - 1) + (maxPos - 2) + (maxPos - 3)) == score)))){
								count++;
								s_used++;
							}
						
						}
					}else if(maxPos - 1 >= p){
						if(3*maxPos == score || ((maxPos - 1 >= 0) && ((2*maxPos + (maxPos - 1)) == score || (maxPos + 2*(maxPos - 1)) == score || 3*(maxPos - 1) == score || ((maxPos - 2 >= 0) && ((2*(maxPos - 1) + (maxPos - 2)) == score || ((maxPos - 1) + 2*(maxPos - 2)) == score))))) count++;
						else if(s_used < s){
							// score can be "surprising"
							if((maxPos - 2 >= 0) && ((maxPos + (maxPos - 1) + (maxPos - 2)) == score || (maxPos + 2*(maxPos - 2)) == score || ((maxPos - 3 >= 0) && (((maxPos - 1) + 2*(maxPos - 3)) == score || (2*(maxPos - 1) + (maxPos - 3)) == score || ((maxPos - 1) + (maxPos - 2) + (maxPos - 3)) == score)))){
								count++;
								s_used++;
							}
						
						}
						/*if(3*maxPos == score || (2*maxPos + (maxPos - 1)) == score || (maxPos + 2*(maxPos - 1)) == score || 3*(maxPos - 1) == score || (2*(maxPos - 1) + (maxPos - 2)) == score || ((maxPos - 1) + 2*(maxPos - 2)) == score) count++;
						else if(s_used < s){
							// score can be "surprising"
							if((maxPos + (maxPos - 1) + (maxPos - 2)) == score || (maxPos + 2*(maxPos - 2)) == score || ((maxPos - 1) + 2*(maxPos - 3)) == score || (2*(maxPos - 1) + (maxPos - 3)) == score || ((maxPos - 1) + (maxPos - 2) + (maxPos - 3)) == score){
								count++;
								s_used++;
							}
						
						}*/
					}else if(maxPos >= p){
						if(3*maxPos == score || ((maxPos - 1 >= 0) && ((2*maxPos + (maxPos - 1)) == score || (maxPos + 2*(maxPos - 1)) == score))) count++;
						else if(s_used < s){
							// score can be "surprising"
							if((maxPos - 2 >= 0) && ((maxPos + (maxPos - 1) + (maxPos - 2)) == score || (maxPos + 2*(maxPos - 2)) == score)){
								count++;
								s_used++;
							}
						
						}
						/*if(3*maxPos == score || (2*maxPos + (maxPos - 1)) == score || (maxPos + 2*(maxPos - 1)) == score) count++;
						else if(s_used < s){
							// score can be "surprising"
							if((maxPos + (maxPos - 1) + (maxPos - 2)) == score || (maxPos + 2*(maxPos - 2)) == score){
								count++;
								s_used++;
							}
						
						}*/
					}
					
				}
				writer.write("Case #" + (i+1) + ": " + count + "\n");
					
			}
			writer.close();
		}catch(Exception e){e.printStackTrace();}	


	}


}
