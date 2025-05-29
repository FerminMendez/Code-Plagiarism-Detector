package qualification;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class C {

	static int pow(int b)
	{
		return (int)Math.pow(10,b);
	}
	public static void main(String args[]) throws FileNotFoundException
	{
		Scanner sin=new Scanner(new File("C:\\Users\\DELL\\Desktop\\CodeJam\\C-small-attempt0.in"));
		PrintStream ps=new PrintStream(new File("C:\\Users\\DELL\\Desktop\\CodeJam\\COut.out"));
		
		int cases=sin.nextInt();
		for(int test=1;test<=cases;test++)
		{
			int start=sin.nextInt();
			int stop=sin.nextInt();
			int count=0;
			int max=0;
			
			while(start/pow(max) >0)
				max++;
			max--;
			String s="";
			for(int i=start;i<=stop;i++)
			{
				int temp=max;
				while(temp>0)
				{
					int t=((i%pow(temp))*(pow(max-temp+1)))+i/pow(temp);
					temp--;
					if(t>i && t<=stop)
					{
						if(s.indexOf(i+":"+t+"|")!=-1)
							continue;
						s+=i+":"+t+"|";
						count++;
					}
				}
			}
			
			ps.println("Case #"+test+": "+count);
		}
	}
}
