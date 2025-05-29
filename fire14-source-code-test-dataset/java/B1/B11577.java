package recyclednumbers;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;


public class RN {
	public static void main(String[] args) throws Exception 
	{
		new RN().run();
	}
	
	void run() throws Exception 
	{	
		Scanner sc = new Scanner(new FileReader("C-small-attempt0.in"));
		PrintWriter pw = new PrintWriter(new FileWriter("CSmall.out"));
		
		int ntest = sc.nextInt();
		sc.nextLine();
	
		for(int test=1;test<=ntest;++test) 
		{
			String s = sc.nextLine();			
			String ss[] = s.split(" ");			
			int min = Integer.parseInt(ss[0]);
			int max = Integer.parseInt(ss[1]);	
			int count = num(min);	
			int cres = 1;
			int r = 0;
			String sres = "";
			int flag[] = new int[2000000];			
			for(int i=min;i<=max;i++){
				for(int j = 1; j<count;j++){	
					if(flag[i]==0){							
						sres = reverse(String.valueOf(i),j);	
						if(flag[Integer.parseInt(sres)]!=1 && Integer.parseInt(sres)!=i && min<=Integer.parseInt(sres) && Integer.parseInt(sres)<=max){							
							flag[Integer.parseInt(sres)] = 1;
							cres++;	
						}	
					}
				}
				flag[i]=1;
				r += cres*(cres-1)/2;
				cres = 1;
			}
			pw.print("Case #" + test + ": " + r);			
			pw.println();	
		}
		pw.close();
		sc.close();	
	}
	
	public String reverse(String s, int i){
		String s0 = s.substring(0,i);
		String s1 = s.substring(i,s.length());
		StringBuilder sb0 = new StringBuilder(s0);
		StringBuilder sb1 = new StringBuilder(s1);
		StringBuilder res = new StringBuilder((sb0.reverse().toString()+sb1.reverse().toString()));
		return res.reverse().toString();
	}
	
	public int num(int a){
		int count = 1;
		while(a/10!=0){
			a = a/10;
			count++;
		}
		return count;
	}
	
}
