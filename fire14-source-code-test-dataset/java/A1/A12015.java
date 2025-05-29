import java.util.*;

public class Dance {
	static int s;
	static int go(int sum, int p)
	{
		boolean flag=false;
		for(int x=0; x<11; x++)
		{
			for(int y=0; y<11; y++)
			{
				for(int z=0; z<11; z++)
				{
					if(x+y+z!=sum)
						continue;
					int max=Math.max(Math.max(x,y),z), min=Math.min(Math.min(x,y),z);
					if(max-min>2)
						continue;
					else if(max-min==2&&max>=p)
					{
						if(s>0)
							flag=true;
					}
					else if(max>=p)
					{
						flag=false;
						return 1;
					}
				}
			}
		}
		if(flag)
		{
			s--;
			return 1;
		}
		return 0;
	}
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		int cases=in.nextInt();
		for(int i=1; i<=cases; i++)
		{ 
			int ans=0;
			int n=in.nextInt(); 
			s=in.nextInt();
			int p=in.nextInt();
			for(int j=0; j<n; j++)
			{
				int sum=in.nextInt();
				ans+=go(sum,p);
			}
			System.out.printf("Case #%d: %d%n",i,ans);
		}
	}
}
