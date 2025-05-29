package google.codejam;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Stark_C {

	/**
	 * @param args
	 */
	public static int getDig(int t1){
		if(t1==0) return 0;
		else if(t1<10) return 1; 
		else if(t1<100) return 2;
		else if(t1<1000) return 3;
		else if(t1<10000) return 4;
		else if(t1<100000) return 5;
		else if(t1<1000000) return 6;
		else return 7;
	}
	
	public static int times(int t){
		
		if(t==0)return 1;
		else	if(t==1)	return 10;
		else	if(t==2) return 100;
		else	if(t==3) return 1000;		
		else	if(t==4) return 10000;
		else	if(t==5) return 100000;		
		else	if(t==6) return 1000000;	
		else	if(t==7) return 10000000;
		else return 100000000;
	
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(new FileReader("C_small.in"));
		PrintWriter pw = new PrintWriter(new FileWriter("C_small.out"));
		
		int total = sc.nextInt();
		
		
		
		for(int i=0; i<total; i++){
			
			pw.print("Case #" + (i + 1) + ": ");
			
			int t1 = sc.nextInt();
			int t2 = sc.nextInt();
			
			//pw.print(t1+"  "+t2+ "  ");
			
			int n=t1;
			int m=t2;
			int ans=0;
			
			while(n<t2){
				
				int te=10;
				while(m!=n){
					int divi = n/te;
					int rem = n%te;
					m = rem*times(getDig(divi))+divi;
					
					//pw.print("n= "+n+",m = "+m+";;;");					
					if(m>t1 && m>n && m<=t2) ans++;
					//pw.print("  ans-->"+ans+"  ");
					te = te*10;
					
				}
				
				
				n++;
			}
			
			
			
			
			pw.println(ans);
			
			
			
		}
		pw.flush();
		pw.close();
		sc.close();
	}
	
	

}
