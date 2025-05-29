import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class C {
	public static void main(String[] args)throws IOException
	{
//		Scanner br=new Scanner(System.in);
		Scanner br=new Scanner(new File("C-small-attempt0.in"));
		PrintWriter out=new PrintWriter(new File("c.out"));
		int cases=br.nextInt();
		for(int c=1;c<=cases;c++)
		{
			int a=br.nextInt();
			int b=br.nextInt();
			int count=0;
			for(int i=a;i<=b;i++)
			{
				for(int j=i+1;j<=b;j++)
				{
					if(recycled(i,j))
					{
						count++;
					}
				}
			}
			out.printf("Case #%d: %d\n",c,count);
		}
		out.close();
	}
	static boolean recycled(int a,int b)
	{
		StringBuilder one=new StringBuilder(Integer.toString(a)),two=new StringBuilder(Integer.toString(b));
		if(one.length()!=two.length())
			return false;
		for(int i=0;i<one.length();i++)
		{
			if(equals(one,two))
				return true;
			char temp=one.charAt(one.length()-1);
			one.deleteCharAt(one.length()-1);
			one.insert(0,temp);
		}
		return false;
	}
	static boolean equals(StringBuilder a,StringBuilder b)
	{
		for(int i=0;i<a.length();i++)
		{
			if(a.charAt(i)!=b.charAt(i))
				return false;
		}
		return true;
	}
}
