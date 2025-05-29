import java.util.LinkedList;


public class Triplet 
{
	public Triplet()
	{
		
	}
	
	public static int triplete(LinkedList<Integer> t_i, int p, int s)
	{
		int res = 0;
		int a,b,c;		
		
		for(Integer i : t_i)
		{
			a = p; b = p-1; c = p-2;
			if(a+b+c < i)
			{
				c++;
			}
			if(a+b+c < i)
			{
				b++;
			}
			if(a+b+c < i)
			{
				c++;
			}
			if(a+b+c > i)
			{
				b--;
			}
			while(a+b+c < i)
			{
				if(a+b+c < i)
				{
					b++;
				}
				if(a+b+c < i)
				{
					c++;
				}
				if(a+b+c < i)
				{
					a++;
				}
			}
			
			int prue = a + b + c;						
			if(a >= 0 && b >= 0 && c >= 0)
			{
				if(prue == i && a <= 10 && b <= 10 && c <= 10 && (a - b != 2 && a - c != 2 && b - c != 2))
				{
					res++;
					
				}
				else if(prue == i &&(a - b == 2 || a - c == 2 || b - c == 2) && s > 0)
				{
					res++;
					s--;
				}
			}
			
			
		}
		
		return res;
	}
}
