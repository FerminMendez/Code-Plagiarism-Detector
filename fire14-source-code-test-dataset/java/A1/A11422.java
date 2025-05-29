import java.io.*;
import java.util.*;
public class Dance {

	public static void main(String[] args)
	{
		Scanner scan = null;
		try
		{
			scan = new Scanner(new FileInputStream("B-small-attempt2.in"));
		}catch (FileNotFoundException e)
		{
			System.out.println("File not found!");
			System.exit(0);
		}
		int lines = scan.nextInt();
		for(int i = 0;i<lines;i++)
		{
			int googler = scan.nextInt();
			int surprise = scan.nextInt();
			int p = scan.nextInt();
			int ans = 0;
			for(int j = 0;j<googler;j++)
			{
				int score = scan.nextInt();
				if((score/3) >= p)
				{
					ans++;
				}
				else if(score >= (3*p-4))
				{
					if((score/3) == (p-1))
					{
						if(p == 1)
						{
							if(score == 0)
								continue;
							else
							{
								ans++;
								continue;
							}
						}
						else if(p == 0)
						{
							ans++;
							continue;
						}
						else if(score >= (3*p-2))
						{
							ans++;
							continue;
						}
						
					}
					if(surprise>0)
					{
						surprise--;
						ans++;
					}
				}
				
			}
			System.out.println("Case #" + (i+1) + ": " + ans);
		
		}
}
}
