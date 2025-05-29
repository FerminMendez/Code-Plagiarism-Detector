package google.codejam;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Stark_B {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(new FileReader("B.in"));
		PrintWriter pw = new PrintWriter(new FileWriter("B.out"));
		
		int total = sc.nextInt();
		
		
		
		for(int i=0; i<total; i++){
			pw.print("Case #" + (i + 1) + ": ");
			
			int cases = sc.nextInt();
			int surprise = sc.nextInt();
			int thold = sc.nextInt();
			
			int done=0;
			int cant=0;
			int mid=0;
			int ans=0;
			
			
			
			for(int j=0; j<cases; j++){
				int temp = sc.nextInt();
				
				int x = temp/3;
				int y = temp%3;
				
				if(x>=thold || (x==(thold-1) && y>0))	done++;
				else	if(((x==(thold-1)&&y==0)||(x==(thold-2) && y==2))&&(x>0))	mid++;
				else	cant++;
				
			}
			
			if(surprise<mid)	ans=done+surprise;
			else	ans = done+mid;
			
			
			pw.println(ans);
		}
			
	
			
			
			
		
		pw.flush();
		pw.close();
		sc.close();
	}
	
	

}
