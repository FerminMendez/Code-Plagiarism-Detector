import java.util.*;

public class probB
{
	public static void main (String[] args)
	{
		Scanner scan = new Scanner (System.in) ;
		
		int T = scan.nextInt();
		int A[], S,p;
		
		for (int t=0 ; t<T ; t++)
		{
			A = new int[scan.nextInt()];
			S = scan.nextInt();
			p = scan.nextInt();
			//System.out.printf("s:%d p:%d\n",S,p);
			
			for (int i=0 ; i<A.length ; i++)
				A[i]=scan.nextInt();
							
			System.out.printf("Case #%d: %d\n",(t+1),solve(S,p,A));
			//System.out.println("******************************************");
		}
	}
	public static int solve (int S, int p, int[] A)
	{
		Arrays.sort(A);
		int result=0 ;
		int s=0, n;
		
		for (int i=0 ; i<A.length ; i++)
		{
			n = A[i];
			
			//no surprise
			
			if (n==0)
			{
				if (p==0)
					result++;
			}
					
			else if (n/3>=p || (n%3!=0 && n/3+1>=p))
				result++;
			
			else if (s<S && ((n%3==0 && n/3+1==p) || (n%3==2 && n/3+2==p)))
			{
				s++;
				result++;
			}
			//System.out.println(n+" "+s+" "+result);
		}
		return result ;
	}
}
