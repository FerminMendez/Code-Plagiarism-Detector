package dancing;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Dance {
	public static void main(String[] args) throws Exception 
	{
		new Dance().run();
	}
	
	void run() throws Exception 
	{	
		Scanner sc = new Scanner(new FileReader("2.in"));
		PrintWriter pw = new PrintWriter(new FileWriter("2.out"));
		
		int ntest = sc.nextInt();
		sc.nextLine();
		
		for(int test=1;test<=ntest;++test) 
		{
			String s = sc.nextLine();
			String[] ss = s.split(" ");			
			int res = 0;
			int min = 0;
			if(Integer.parseInt(ss[2])==0) 
				min = 0;
			else if(Integer.parseInt(ss[2])==1) {
				min = 1;
			}
			else{
				min = (Integer.parseInt(ss[2]))*3-4;
			} 
			int bound = (Integer.parseInt(ss[2]))*3-2;
			int count = Integer.parseInt(ss[1]);
			for(int i=3;i<ss.length;i++){				
				if(Integer.parseInt(ss[i])>=bound)
					res++;
				else if(Integer.parseInt(ss[i])>=min&&count>0){
					res++;
					count--;
				}
			}
			pw.print("Case #" + test + ": "+res);			
			pw.println();
		}
		pw.close();
		sc.close();	
	}

}
