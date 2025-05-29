import java.util.*;

public class RecycledPair {
	
	public static boolean canRecycle(int a, int b)
	{
		String as ="" + a;
		for(int i = 0; i < as.length(); i++)
		{
			if(b == Integer.parseInt(as.substring(i) + as.substring(0, i)))
			{
				return true;
			}
		}
		return false;
	}
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int nn = sc.nextInt();
		for(int ii = 0; ii < nn; ii++)
		{
			int count = 0;
			int from = sc.nextInt();
			int to = sc.nextInt();
			
			for(int i = from; i <=to; i++)
			{
				for(int j = i+1; j <=to; j++)
				{
					if(canRecycle(i, j))
					{
						count++;
					}
				
				}
			}
			
			System.out.println("Case #" + (ii+1) + ": " + count);
			
			
		}
	}

}
