import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;


public class RecycledNumbers {
	static Scanner sc;
	public static void main(String a[]) throws FileNotFoundException
	{
		int n,i;
		int res;
		sc= new Scanner(new FileInputStream("d:\\test\\a.in"));
		PrintStream out=new PrintStream(new FileOutputStream("d:\\test\\a.out"));
		
		n=sc.nextInt();
		sc.nextLine();
		for(i=1;i<=n;i++)
		{
			res=process();
			out.println("Case #"+i+": "+res);
			
		}
	}
	static int process()
	{
		int res=0;
		int low,high,i;
		low=sc.nextInt();
		high=sc.nextInt();
		for(i=low;i<=high;i++)
			res+=value(i,low,high);
		res=res/2;
		return res;
	}
	static int value(int a,int low,int high)
	{
		int i,res=0,n=1,p=10,q,val,prev=0;
		if(a<10) return 0;
		if(a<100)
		{
			n=2;
			q=10;
		}
		else if(a<1000)
		{
			n=3;
			q=100;
		}
		else if(a<10000) 
		{
			n=4;
			q=1000;
		}
		else if(a<100000) 
		{
			n=5;
			q=10000;
		}
		else if(a<1000000) 
		{
			n=6;
			q=100000;
		}
		else  
		{
			n=7;
			q=1000000;
		}
		for(i=1;i<n;i++)
		{
			val = ((a%p)*q)+(a/p);
			if(val>=low && val<=high && val!=a && val!=prev)
			{
				prev=val;
				res++;
			}
			p=p*10;
			q=q/10;
		}
		return res;
	}
}
