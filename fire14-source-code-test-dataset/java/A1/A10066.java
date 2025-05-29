import java.util.*;
import java.io.*;
public class dancing {

	public static void main(String[] args) throws Exception {
		Scanner sc=new Scanner(new File("input"));
		int size=sc.nextInt();
		int[] gogo=new int[31];
		int[] cap=new int[31];
		for(int x=3;x<31;x++)cap[x]=x-2;
		gogo[0]=0;
		int best=1;
		int c=0;
		for(int x=1;x<31;x++)
		{
			gogo[x]=best;
			c++;
			if(c==3)
			{
				c=0;
				best++;
			}
		}
		//System.out.println(Arrays.toString(gogo));
		
		for(int w=0;w<size;w++)
		{
			int T=sc.nextInt();
			int S=sc.nextInt();
			int p=sc.nextInt();
			int[] arr=new int[T];
			for(int x=0;x<T;x++)arr[x]=sc.nextInt();
			int[] sto=new int[T];
			for(int x=0;x<T;x++)sto[x]=gogo[arr[x]];
			int ans=0;
			for(int x=0;x<T;x++)
			{
				if(sto[x]>=p)ans++;
				else if(S>0)
				{
					boolean pos=arr[x]==0 || (gogo[arr[x]]-1==gogo[arr[x]-1]);
		
					if(sto[x]+1==p && !pos)
					{
						S--;
						ans++;
					}
				}
			}
			System.out.println("Case #"+(w+1)+": "+ans);
			
			
		} 
	}
}
