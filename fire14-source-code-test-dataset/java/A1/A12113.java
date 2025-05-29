import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;


public class B {
	static int[][] memo;
	static int[] nums;
	static int p;
	public static void main(String[] args)throws IOException
	{
		Scanner br=new Scanner(new File("B-small-attempt0.in"));
		PrintWriter out=new PrintWriter(new File("b.out"));
		int cases=br.nextInt();
		for(int c=1;c<=cases;c++)
		{
			int n=br.nextInt(),s=br.nextInt();
			p=br.nextInt();
			nums=new int[n];
			for(int i=0;i<n;i++)
				nums[i]=br.nextInt();
			memo=new int[n][s+1];
			for(int[] a:memo)
				Arrays.fill(a,-1);
			out.printf("Case #%d: %d\n",c,go(0,s));
		}
		out.close();
	}
	public static int go(int index,int s)
	{
		if(index>=nums.length)
			return 0;
		if(memo[index][s]!=-1)
			return memo[index][s];
		int best=0;
		for(int i=0;i<=10;i++)
		{
			int max=i;
			for(int j=0;j<=10;j++)
			{	
				if(Math.abs(i-j)>2)
					continue;
				max=Math.max(i,j);
				thisone:
				for(int k=0;k<=10;k++)
				{
					int ret=0;
					if(Math.abs(i-k)>2||Math.abs(j-k)>2)
						continue;
					max=Math.max(max,k);
					int count=0;
					if(Math.abs(i-k)==2)
						count++;
					if(Math.abs(i-j)==2)
						count++;
					if(Math.abs(j-k)==2)
						count++;
					if(i+j+k==nums[index])
					{
						boolean surp=(count>=1);
						if(surp&&s>0)
						{
							if(max>=p)
								ret++;
							ret+=go(index+1,s-1);
						}
						else if(!surp)
						{
							if(max>=p)
								ret++;
							ret+=go(index+1,s);
						}
						best=Math.max(best,ret);
					}
					else if(i+j+k>nums[index])
						break thisone;
				}
			}
		}
		return memo[index][s]=best;
	}
}
