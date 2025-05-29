/**
 * 
 */
package qualification;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author armin
 *
 */
public class DancingWithTheGooglers {

	static int maxscore(int points, boolean surp){
		if(points >= 29) return 10;
		if(points == 0) return 0;
		int div = points / 3;
		int mod = points % 3;
		
		if(surp){
			switch(mod){
			case 0: return div+1;
			case 1: return div+1;
			case 2: return div+2;
			default: return -1;
			}
		}else{
			return mod==0?div:div+1;
		}
	}
	
	static int min(int a, int b){
		return a<b?a:b;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File in, out;
		Scanner sc;
		PrintWriter pr;
		
		in = new File("material.qualification/B-small-attempt0.in");
		//in = new File("material.qualification/DancingWithTheGooglers.in");
		out = new File("material.qualification/DancingWithTheGooglers.out");
		
		try{
			
			sc = new Scanner(new FileReader(in));
			pr = new PrintWriter(new FileWriter(out));
			
			
			int T = sc.nextInt();
			for(int cas=1;cas<=T;cas++){
				int N = sc.nextInt();
				int S = sc.nextInt();
				int p = sc.nextInt();
				
				int[] scores = new int[N];
				for(int i=0;i<N;i++) scores[i] = sc.nextInt();
				
				
				int ct1 = 0, ct2 = 0;
				int ms, sms;
				
				for(int i=0;i<N;i++){
					ms = maxscore(scores[i],false);
					sms = maxscore(scores[i], true);
					if(ms>=p) ct1+=1;
					if(ms<p && sms==p) ct2+=1;
				}
				
				int sol = ct1 + min(ct2, S);
				pr.println("Case #" + cas + ": " + sol);
				pr.flush();
			}
			
			
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
		

	}

}
