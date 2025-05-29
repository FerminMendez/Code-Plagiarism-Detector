import java.io.*;
import java.util.*;
public class Main
{
	public static void main(String[] args)throws IOException
	{
		new Main().start();
	}
	public void start()throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int test=Integer.parseInt(br.readLine());
		int ind=1;
		
		while(test-->0)
		{
			st=new  StringTokenizer(br.readLine());
			int ans=0;
			int N=Integer.parseInt(st.nextToken());
			int S=Integer.parseInt(st.nextToken());
			int p=Integer.parseInt(st.nextToken());
			int totalScore[]=new int[N];
			for(int i=0;i<N;i++)
			{
				totalScore[i]=Integer.parseInt(st.nextToken());
			}
			if(p==0)
			{
				ans=N;
				System.out.println("Case #"+ind+": "+ans);
				ind++;
				continue;
			}
			if(p==1)
			{
				ans=0;
				for(int i=0;i<N;i++)
					if(totalScore[i]!=0)
						ans++;
				System.out.println("Case #"+ind+": "+ans);
				ind++;
				continue;
			}
			Arrays.sort(totalScore);
			boolean cons[]=new boolean[N];
			int max=3*p-4;
			for(int i=0;i<N && S>0;i++)
			{
				if(totalScore[i]>=max)
				{
					ans++;
					cons[i]=true;
					S--;
				}
			}
			max=3*p-2;
			for(int i=0;i<N;i++)
			{
				if(totalScore[i]>=max && !cons[i])
					ans++;
			}
			System.out.println("Case #"+ind+": "+ans);
			ind++;
		}
	}
}