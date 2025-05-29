import java.util.Scanner;

public class Dance {

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int linenum = cin.nextInt();
		
		for(int idx = 1; idx < linenum+1; idx++)
		{
			System.out.print("Case #" + idx + ": ");
			int n = cin.nextInt();
			int s = cin.nextInt();
			int p = cin.nextInt();
			
			int ans = 0;
			
			for(int i=0; i < n; i++)
			{
				int score = cin.nextInt();
				
				if(score == 0)
				{
					if(p == 0)
						ans++;
					else
						continue;
				}
				else if(score == p*3 || score == p*3 - 1 ||score == p*3 - 2 || score > p*3)
				{
					ans++;
				}
				else if(score == p*3 - 3 || score == p*3 - 4)
				{
					if(s > 0)
					{
						s--;
						ans++;
					}
					else
					{
						continue;
					}
				}
				else
				{
					continue;
				}
			}
			System.out.println(ans);
		}
	}

}
