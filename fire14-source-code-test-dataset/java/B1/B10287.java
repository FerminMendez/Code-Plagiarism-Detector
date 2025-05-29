import java.io.*;
import java.util.Scanner;
public class jam3Rec {
	
	public static void main(String args[]) throws java.lang.Exception
	{
		
		int a,b,n,m, cnt=0,len=0;
		//a=1111;b=2222;
		int t,cas=1;
		//System.out.println();
		//Scanner scan=new Scanner(System.in);
    	//Scanner scan=new Scanner(new FileReader("input3" + ".in"));
		Scanner scan=new Scanner(new FileReader("C-small-attempt2" + ".in"));
		
		PrintWriter out=new PrintWriter("SmallOutput5" + ".out");
		//PrintWriter out=new PrintWriter("LocalOutput3" + ".out");
		
		//FileReader("A-small-attempt1" + ".in")
		t=scan.nextInt();
		while(t!=0)
		{
		t--;
		cnt=0;
		a=scan.nextInt();
		b=scan.nextInt();
		
		//a=100;b=500;
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
							//System.out.println(i+"  "+"  "+j+"  "+tstr1);
							cnt++;
						}
						
						
						
					}
					
					
				}
				
				
			}
		}
		//cnt=cnt/2;
	
		System.out.println("Case #"+cas+": "+cnt);
		out.println("Case #"+cas+": "+cnt);
		cas++;
		
		
		}
	
	//in.close();
	out.close();
	}

}
