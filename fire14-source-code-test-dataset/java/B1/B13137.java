import java.io.*;
import java.util.*;
import java.math.*;
public class Qual22C
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader ips=new BufferedReader(new FileReader("C-small-attempt0.in"));
		PrintWriter ops=new PrintWriter(new FileWriter("recno.in"));
		int T=Integer.parseInt(ips.readLine());
		for(int i=0;i<T;i++)
		{
			String line=ips.readLine();
			char[] ca=line.toCharArray();
			int count=0,j=0, t=0, A=0, B=0, rnc=0, n=0, m=0, rev=0, temp=0, tryy=0;
			for(j=ca.length-1; ca[j]!=' '; j--)
			{
				t=ca[j]-'0';
				B=B+(int)(Math.pow(10,count)*t);	
				count++;
			}
			j--;
			count=0;
			for(; j>=0; j--)
			{
				t=ca[j]-'0';
				A=A+(int)(Math.pow(10,count)*t);	
				count++;
			}
			//System.out.println("A: "+A+" B: "+B+" nog: "+count);
			n=A;
			int pw=0;
			for(int k=0; k<=(B-A); k++)
			{
				//n++;
				m=n;
				temp=m;
				rev=0;
				pw=0;
				while(temp!=0)
				{
					t=temp%10;
					rev=(rev*10)+t;
					temp=temp/10;
					pw++;
				}
				//System.out.println(rev);
				t=rev%10;
				tryy=(t*(int)(Math.pow(10,(count-1))));
				m=((m-tryy)*10)+t;
				//System.out.println(n+" : "+m);
				while(m!=n)
				{
					if(n<m && m>=A && m<=B)
						rnc++;
					temp=m;
					rev=0;
					pw=0;
					while(temp!=0)
					{
						t=temp%10;
						rev=(rev*10)+t;
						temp=temp/10;
					}
					//System.out.println(rev);
					t=rev%10;
					tryy=(t*(int)(Math.pow(10,(count-1))));
					//System.out.println(t);
					//System.out.println(tryy);
					if((m-tryy)<0)
						m=(m*10);
					else
						m=((m-tryy)*10)+t;
					//System.out.println("1. "+n+" : "+m);
				}
				n++;
			}
			ops.println("Case #"+(i+1)+": "+rnc);	
				
		}
		ips.close();
		ops.close();
	}
}