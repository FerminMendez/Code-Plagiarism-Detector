package recycledNumbers;

import java.io.*;
import java.util.*;
public class Entry {

	private static ArrayList<Integer> cases=new ArrayList<Integer>();
	
	public static void main(String args[]) throws IOException
	{
		FileReader src=new FileReader("test.txt");
		FileWriter f=new FileWriter("output.txt");
		BufferedWriter out=new BufferedWriter(f);
		Scanner in=new Scanner(src);
		int iterate=in.nextInt();
		int i,j;
		int A,B;
		int n,m;
		
		HashSet<Double> dub=new HashSet<Double>();
		for(i=0;i<iterate;i++)
		{
			A=in.nextInt();
			B=in.nextInt();
			n=A;
			while(n< B)
			{
				for(j=1;j<Integer.toString(n).length();j++)
				{
					m=reverse(n,j);
					if((A<=n)&& (n<m) &&(m<=B) &&(m!=n))
					{
						dub.add((n*Math.pow(10,Integer.toString(n).length()))+m);
					}
				}
				n++;
			}
			cases.add(dub.size());
			dub.clear();
			
		}
		
		int index=1;
		for(int str:cases)
		{
			out.write(("Case #"+index+":\t"+str));
			out.write("\n");
			index++;
		}
		out.close();
		in.close();
	}
	
   
	private static int reverse(int n,int j)
	{
		String str=Integer.toString(n);
		String ans=str.substring(str.length()-j);
		String ans2=str.substring(0,str.length()-j);
		str=ans+ans2;
		int m=Integer.valueOf(str);
		return m;
	}
	
}
