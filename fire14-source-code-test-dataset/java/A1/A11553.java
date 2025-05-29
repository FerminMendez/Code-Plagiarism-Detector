
import java.util.Scanner;

public class B_DancingWithGooglers 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for(int cases=1; cases<=t; cases++)
		{
			int players = sc.nextInt();
			int surprising = sc.nextInt();
			int limit = sc.nextInt();
			
			int count = 0;
			
			for(int i=0; i<players; i++)
			{
				int score = sc.nextInt();
				
				if(score < limit)
				{
					continue;
				}
				
				score = (score - limit) / 2;
				
				if(limit - score <= 1)
				{
					count ++;
				}
				else if(surprising > 0 && limit - score <= 2)
				{
					count ++;
					surprising --;
				}
			}
			
			System.out.println("Case #"+cases+": "+count);
		}
	}
}
