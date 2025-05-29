import java.io.*;
import java.util.*;
import java.math.*;
public class scores
{
	static int T=0;
	static int N=0;
	static int S=0;
	static int S2=0;
	static int p=0;
	static int count=0;
	static int ans=0;
	public static void main(String[] args)
	{
		Scanner scan= new Scanner(System.in);
		
		T= Integer.parseInt(scan.nextLine());
		
		for(int i=1; i<=T; i++)
		{
			N=scan.nextInt();
			S=scan.nextInt();
			p=scan.nextInt();
			count=0;
			S2=0;
			ans=0;
			int[] scores= new int[N];
			int x=0;
			for(int j=0; j<N; j++)
			{
				scores[j]= scan.nextInt();
				x=scores[j]/3;
				
				if(3*x==scores[j])
				{
					if(x>0 && x+1>=p && x<p)
						S2++;
					if(x>=p)
						count++;
				}
				if(3*x+1 == scores[j] && x+1>=p)
					count++;
					
				if(3*x+2== scores[j])
				{
					if(x+2>=p && x+1<p)
						S2++;
					if(x+1>=p)
						count++;
				}
			}
			ans=Math.min(S,S2)+count;
			System.out.println("Case #"+i+": "+ans);
		}
	}

}