import java.io.*;
import java.util.*;

class GoogleDance
{
	public static void main(String[] args)
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		Scanner sc=new Scanner(new InputStreamReader(System.in));
		int t=sc.nextInt();
		String ans[]=new String[t];
		for(int i=0;i<t;i++)
		{
			int n,s,p,b=0;
			n=sc.nextInt();
			s=sc.nextInt();
			p=sc.nextInt();
			
			for(int j=0;j<n;j++)
			{
				int tot=sc.nextInt();
				int quo,rem;
				quo=tot/3;
				rem=tot%3;
				if(rem==0)
				{
					if(quo>=p)
					{
						b++;
						continue;
					}
					else if((quo+1)==p)
					{
						if(s>0)
						{
							if((quo-1)>0)
							{
								s--;
								b++;
								continue;
							}
						}
					}
				}
				else if(rem==1)
				{
					if((quo+1)>=p)
					{
						b++;
						continue;
					}
				}
				else if(rem==2)
				{
					if((quo+1)>=p)
					{
						b++;
						continue;
					}
					else if((quo+2)>=p)
					{
						if(s>0)
						{
							s--;
							b++;
							continue;
						}
					}
				}
			}
			ans[i]="Case #"+(i+1)+": "+b;
		}
		for(int i=0;i<t;i++)
			System.out.println(ans[i]);
	}
}
