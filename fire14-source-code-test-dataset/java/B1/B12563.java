import java.io.*;
import java.util.*;
class Replace
{
	public static void main(String args[])throws Exception
	{
		//Scanner sc = new Scanner(System.in);
		// PrintWriter pw = new PrintWriter(System.out);
		Scanner sc = new Scanner(new FileReader("C-small-attempt1.in"));
		//Console console=System.console(new FileReader("B-small-practice-1.in"));
		PrintWriter pw = new PrintWriter(new FileWriter("C-small-attempt1.out"));
		int ntest = sc.nextInt();
		//int a=100;
		//int b=500;
		
		for(int k=1;k<=ntest;k++)
		{
		int sum=0;
		int count=0;
		//int a=Integer.parseInt(sc.next());
		//int b=Integer.parseInt(sc.next());
		int a=sc.nextInt();
		int b=sc.nextInt();
		
		for(int i=a;i<=b;i++)
		{
				if(i>0 && i<100)
				{
					int rem=i%10;
					sum=rem*10+i/10;
					if(sum==i)
					{
					}
					else if(sum>=a && sum<=b)
					{
						count++;
						System.out.println(i);
						//System.out.println("garg");
					}
				}
				if(i>=100 && i<1000)
				{
					int rem=i%100;
					sum=rem*10+i/100;
					//System.out.println(i);
					
					if(sum==i)
					{
					}
					else if (sum>=a && sum<=b)
					{
						count++;
						//System.out.println(i);
					}
					//System.out.println("lucky");
					rem=i%10;
					sum=rem*100+i/10;
					if(sum==i)
					{
					}
					else if(sum>=a && sum<=b)
					{
						count++;
						//System.out.println(i);
						//System.out.println("garg");
					}
				}
					
					
				
		}
		pw.print("Case #" + k + ": ");
		pw.print(count/2);
		pw.println();
		}
		pw.close();
		sc.close();
	}
}