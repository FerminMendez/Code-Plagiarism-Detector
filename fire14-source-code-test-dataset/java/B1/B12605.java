import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;


public class c_small
{

		static int u,l,j,n,m=0,k;
		static int arr[];
	
	public static void solve() throws Exception
	{
		PrintWriter out =new PrintWriter(new File("c_small.out"));
		Scanner sc =new Scanner(new File("c_small.in"));
		int testCase=sc.nextInt();
			
		for (int i = 1; i <= testCase; i++)
		{		int p;
				arr=new int[1000];
				
				l=sc.nextInt();
				u=sc.nextInt();
				int res=0,r=0;
				for(j=l;j<=u;j++)	
					{		
					
					String j1=Integer.toString(j);
				//out.println("j "+j1);
				for(int x=((j1.length())-1);x>=1;x--)
					{
					for(p=0;p<1000;p++){
					String c=j1.substring(x,(j1.length()));
					//out.println("c "+c);
					String a=c+(j1.substring(0,x));
					//out.println("a "+a);
					int n=Integer.parseInt(a);
						
					
					for(k=l;k<=u;k++)
					{
					if((k!=j) && (k==n) && (n!=arr[p]))
						{
				
						arr[p]=n;
				
				res=res+1;
						break;
						}	
					
					}
				}	
				
			
			}}
			out.println("Case #"+ i +": "+(res/2000));
		}
			
		out.close();
	}
	
	public static void main(String[] args) throws Exception
	{
		solve();
	}
	
}

