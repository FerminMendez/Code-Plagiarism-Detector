import java.util.*;

public class probC
{
	public static int N=2000001, K=0 ;
	
	public static void main (String[] args)
	{
		Scanner scan = new Scanner (System.in) ;
		
		int A[] = new int[N];
		boolean visited[] = new boolean [N];
		
		for (int i=0 ; i<A.length ; i++)
			A[i]=-1;
		
		for (int i=0 ; i<A.length ; i++)
			if (!visited[i])
				rotate(i,A,visited);
		
		int T = scan.nextInt();
		int n1, n2;
		
		for (int t=0 ; t<T ; t++)
		{
			n1 = scan.nextInt();
			n2 = scan.nextInt();
			System.out.printf("Case #%d: %d\n",(t+1),solve(n1,n2,A));
		}
	}
	public static long solve (int n1, int n2, int[] A)
	{
		int[] f = new int[K];
		long cumul[] = new long[N];
		
		int k=0 ;
		
		for (int i=n1 ; i<=n2 ; i++)
		{
			k=A[i];
			if (k!=-1)
			{
				f[k]++;
				cumul[i]=f[k]-1;
			}
			if (i!=0)
				cumul[i]+=cumul[i-1];
		}
		return cumul[n2]-cumul[n1];
	}
	
	public static int choose2 (int n)
	{
		return ((n*(n-1))/2);
	}
	public static void rotate (int n, int[] A, boolean[] visited)
	{
		visited[n]=true;
		String initial = Integer.toString(n);
		String rotated ;
		int newNum=0;
		boolean found=false;
		HashSet<Integer> set = new HashSet ();
		set.add(n); 
		
		for (int off=0  ; off<initial.length() ; off++)
		{
			rotated="";
			for (int i=0 ; i<initial.length() ; i++)
				rotated+=initial.charAt((i+off)%initial.length());
			
			newNum=Integer.valueOf(rotated);
			
			if (!set.contains(newNum) && newNum<A.length && Integer.toString(newNum).length()==initial.length())
			{
				set.add(newNum);
				found=true;
				visited[newNum]=true;
				A[newNum]=K;
				//System.out.println(n+" "+newNum);
			}
		}
		if (found)
		{
			A[n]=K;
			K++;
		}
	}
}
