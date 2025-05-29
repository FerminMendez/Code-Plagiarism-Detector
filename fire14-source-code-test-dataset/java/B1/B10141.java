import java.io.*;
import java.util.Scanner;
class RecycledNumbers
{
	public static void main(String Args[]) throws Exception
	{
		Scanner s=new Scanner(new FileReader("inputCs.in"));
		BufferedWriter br=new BufferedWriter(new FileWriter("outputCs.txt"));
		int T, a, b,total=0;
		T=s.nextInt();
		String x,y;
		for(int I=0;I<T;I++)
		{
			total=0;
			a=s.nextInt();
			b=s.nextInt();
			for(int i=a;i<=b;i++)
			{
				for(int j=i+1;j<=b;j++)
				{
					x=new String(""+i);
					y=new String(""+j);
					if(recycled(x,y))
					{
						total++;
					}
				}
			}
			br.write("Case #"+(I+1)+": "+total);
			if(I!=T-1)
			br.write("\n");
		}
		s.close();
		br.close();
	}
	
	public static boolean recycled(String a,String b)
	{
		String d;
		char c[]=new char[a.length()];
		for(int i=0;i<a.length();i++)
		{
			c[0]=b.charAt(b.length()-1);
			b.getChars(0,b.length()-1,c,1);
			d=new String(c);
			if(d.contentEquals(a))
			return true;
			else 
			b=d;
		}
		return false;
	}
}