import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;


public class DancingWithTheGooglers {
	static Scanner sc;
	public static void main(String a[]) throws FileNotFoundException
	{
		int n,i,res;
		sc= new Scanner(new FileInputStream("d:\\test\\a.in"));
		PrintStream out=new PrintStream(new FileOutputStream("d:\\test\\a.out"));
		
		n=sc.nextInt();
		for(i=1;i<=n;i++)
		{
			res=process();
			out.println("Case #"+i+": "+res);
			
		}
	}
	static int process()
	{
		int n,s,p,i,val,res=0,limit=1,sLimit=1;
		n=sc.nextInt();
		s=sc.nextInt();
		p=sc.nextInt();
		//if(p==0) return n;
		if(p>0) limit = p+p-1+p-1;
		if(p>1)	sLimit = p+p-2+p-2;
		if(limit<0) limit=0;
		if(sLimit<0) sLimit=0;
		for(i=0;i<n;i++)
		{
			val =sc.nextInt();
			if(val==0) continue;
			if(val>=limit) res++;
			else if(val>=sLimit&&s>0)
			{
				s--;
				res++;
			}
		}
		if(p==0) return n;
		return res;
	}
}
