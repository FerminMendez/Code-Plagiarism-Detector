import java.util.*;
import java.math.*;
import java.io.*;
public class Main
	{
	public static void main(String args[])	throws IOException
		{
		Scanner c=new Scanner(System.in);
		int T=c.nextInt();
		for(int i=0;i<T;i++) 
			{
			int ans=0;
			int A=c.nextInt();
			int B=c.nextInt();
			for(int num=A;num<=B;num++) 
				{
				boolean valid=false;
				//System.out.println("for "+num);
				String num_s=Integer.toString(num);
				TreeSet<Integer> Tr=new TreeSet<Integer>();
				for(int j=1;j<num_s.length();j++) 
					{
					String left=num_s.substring(0,j);
					String right=num_s.substring(j,num_s.length());
					int got=Integer.parseInt(right.concat(left));
					if(got>num&&got>=A&&got<=B)
						Tr.add(got);
					}
				ans+=Tr.size();
				}
			System.out.println("Case #1: "+ans);
			}
		}
	
	}

//must declare new classes here