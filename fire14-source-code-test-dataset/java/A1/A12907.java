import java.util.Scanner;


public class QualB
{
	public static void main(String args[])
	{
		Scanner kb = new Scanner(System.in);
		
		int ntc = kb.nextInt();
		for(int tc=0;tc<ntc;tc++)
		{
			int n = kb.nextInt();
			int s = kb.nextInt();
			int p = kb.nextInt();
			int ti;
			int sc = 0;
			int y = 0;
			for(int t=0;t<n;t++)
			{
				ti = kb.nextInt();
				if(ti >= 3*p-2)
				{
					y++;
				}
				else if(ti >= 3*p-4 && ti >= p && sc<s)
				{
					y++;
					sc++;
				}
			}
			System.out.println("Case #" + (tc+1) + ": " + y);
		}
	}
}
