import java.io.*;
import java.util.Scanner;
public class tknowjam3 {
	
	public static void main(String args[]) throws java.lang.Exception
	{
		
		int a,b,n,m, cnt=0,len=0;
		
		int t,cas=1;
		Scanner scan=new Scanner(new FileReader("tknowjam3in" + ".in"));
		PrintWriter out=new PrintWriter("tknowjam3out" + ".out");
		t=scan.nextInt();
		while(t!=0)
		{
		t--;
		cnt=0;
		a=scan.nextInt();
		b=scan.nextInt();
		String str1,tstr1;
		
		for(int i=a;i<=b;i++)
		{
			str1=Integer.toString(i);
			for(int j=a;j<=b;j++)
			{
				if(i!=j && i<j)
				{
					len=str1.length();
					for(int k=1;k<len;k++)
					{
						tstr1=str1.substring(0,len-k);
						tstr1=str1.substring(len-k)+tstr1 ;
						
						if(tstr1.equals(Integer.toString(j)))
						{
							k=len;
							
							cnt++;
						}
						
						
						
					}
					
					
				}
				
				
			}
		}
		
	
		System.out.println("Case #"+cas+": "+cnt);
		out.println("Case #"+cas+": "+cnt);
		cas++;
		
		
		}
	
	
	out.close();
	}

}
