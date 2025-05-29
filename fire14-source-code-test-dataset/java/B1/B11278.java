package Numbers;

import java.util.Scanner;

public class CountRecycle {
	public static void main(String[] args)
	{
		Scanner r = new Scanner(System.in);
		int n = r.nextInt();
		
		for(int i = 1; i <= n; i++)
		{
			int x = r.nextInt();
			int y = r.nextInt();
			int f = getAmt(x, y);
			System.out.println("Case #" + i + ": " + f);
		}
	}
	
	public static int getAmt(int x, int y)
	{
		int cnt = 0;
		
		for(int i = x; i <= y; i++)
		{
			for(int j = i; j <= y; j++)
			{
				if(i == j)
				{
					continue;
				}
				
				String ix = Integer.toString(i);
				String jx = Integer.toString(j);
				
				if(ix.length() != jx.length())
				{
					break;
				}
				
				for(int k = 1; k <= ix.length()-1; k++)
				{
					String tst = jx.substring(k) + jx.substring(0, k);
					if(tst.equals(ix))
					{
						cnt++;
						break;
					}
				}
			}
		}
		
		return cnt;
	}
}
