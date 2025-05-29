import java.util.*;
public class Main
{
	public static void main(String[]args)
	{
		Scanner in = new Scanner(System.in);
		int inputs = in.nextInt();
		for(int i = 1; i <= inputs; i++)
		{
			int ppls = in.nextInt();
			int sup = in.nextInt();
			int score = in.nextInt();
			int count = 0;
			int scount = 0;
			for(int j = 0; j < ppls; j++)
			{
				int k = in.nextInt();
				if(k >= score + (Math.max(0, score-1)*2)) count++;
				else if(k >= score + (Math.max(0, score-2)*2)) scount++;
			}
			count += Math.min(scount, sup);
			System.out.println("Case #" + i + ": " +count);
		}
	}

}
