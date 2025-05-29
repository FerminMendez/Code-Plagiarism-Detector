import java.util.*;

public class DancingWithTheGooglers
{
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args)
	{
		int T = sc.nextInt();
		for(int i=1;i<=T;i++)
		{
			System.out.println("Case #"+i+": "+solveCase());
		}
	}
	static String solveCase()
	{
		int N = sc.nextInt(); int S = sc.nextInt();
		int p = sc.nextInt(), res = 0;
		while (N-->0) {
			int total = sc.nextInt();
			if (total < p)
				continue;
			total -= p;
			if (total/2 + 1 >= p)
				res++;
			else if (total/2 + 2 >= p && S > 0)
			{
				S--;
				res++;
			}
		}
		return ""+res;
	}
}
