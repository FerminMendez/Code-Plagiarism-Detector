import java.util.*;
import java.io.*;

public class Dancing
{
	static int[] scores;
	static int best,size;

	public static void main(String[] sArgs)throws IOException
	{
		Scanner oScan = new Scanner(new File("dancing.in"));
		PrintWriter out = new PrintWriter("dancing.out");

		int o_0 = oScan.nextInt();oScan.nextLine();
		for(int o_o=1;o_o<=o_0;o_o++)
		{
			int N=oScan.nextInt(),S=oScan.nextInt(),p=oScan.nextInt();
			best=p;
			size=N;
			scores = new int[N];
			for(int i=0;i<N;i++)
				scores[i]=oScan.nextInt();
			if(o_o<o_0-1)oScan.nextLine();
			//doBest(0,S);
			out.println("Case #"+o_o+": "+doBest(0,S));
		}

		out.close();
	}

	static int doBest(int a, int sup)
	{
		if(a==size)return 0;
		int tar = scores[a],max=0;
		for(int i=0;i<11;i++)
			for(int j=i;j<11&&j<i+3;j++)
				for(int k=j;k<11&&k<i+3;k++)
				{
					if(i+j+k!=tar||sup==0&&k==i+2)continue;
					//System.out.println(a+" "+i+" "+j+" "+k);
					int good = k>=best?1:0;
					max = Math.max(max,good+doBest(a+1,sup-(k==i+2?1:0)));
				}
		return max;
	}
}